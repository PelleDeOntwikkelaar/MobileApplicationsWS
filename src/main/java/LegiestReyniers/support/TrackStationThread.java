package LegiestReyniers.support;

import LegiestReyniers.control.services.impl.StationServiceImpl;
import LegiestReyniers.model.DelaySingleRecord;
import LegiestReyniers.model.Station;
import LegiestReyniers.repositories.DelaySingleRecordRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Scope("prototype")
@SuppressWarnings("Duplicates")
public class TrackStationThread implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackStationThread.class);
    private Gson gson;
    private WGet wget;

    @Resource
    private StationServiceImpl stationService;

    @Resource
    private DelaySingleRecordRepository delaySingleRecordRepository;

    private int index_id;

    @Override
    public void run() {

        wget=new WGet();

        delaySingleRecordRepository.deleteAll();

        gson=new Gson();

        //We moeten onze eigen id bijhouden, want er triggeren anders een bug in Java
        index_id = 0;

        while(true){
            try {
                Thread.sleep(1000);

                Iterable<Station> tracked= stationService.findAllTrackedStations();

                for(Station station: tracked){

                    final String uri = station.getUri();


                    JsonObject jsonGoogle = wget.getJson(uri);

                    JsonArray jsonArray = jsonGoogle.getAsJsonArray("@graph");
                    int delay=0;
                    int n_overtime = 0;
                    int n_ontime=0;
                    int n_delay=0;

                    for(JsonElement element: jsonArray){
                        JsonObject obj = element.getAsJsonObject();

                        int delay_json = obj.get("delay").getAsInt();
                        String dateString = obj.get("scheduledDepartureTime").getAsString();

                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
                        Date date = dateFormat.parse(dateString);
                        long epochTime = date.getTime();

                        long now = System.currentTimeMillis();

                        if(epochTime < (now + 300000) && delay_json==0 ){
                            n_ontime++;
                        }

                        if(delay_json > 1800)
                            n_overtime++;

                        if(delay_json!=0)
                            n_delay++;


                        delay += delay_json;
                    }


                    int i = (int) (new Date().getTime()/1000);

                    DelaySingleRecord record = new DelaySingleRecord();

                    record.setId(index_id);
                    record.setStationuri(station.getUri());
                    record.setTotaldelay(delay);
                    record.setTimestamp(i);
                    record.setNover(n_overtime);
                    record.setNontime(n_ontime);
                    record.setNdelay(n_delay);

                    delaySingleRecordRepository.save(record);

                    index_id++;
                    System.out.println("Record gesaved!");
                }
            } catch (InterruptedException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void setIndex_id(int index_id) {
        this.index_id = index_id;
    }
}