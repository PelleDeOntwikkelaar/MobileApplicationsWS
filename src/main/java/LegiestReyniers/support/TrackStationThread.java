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
import java.util.Date;

@Component
@Scope("prototype")
public class TrackStationThread implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrackStationThread.class);
    private Gson gson;
    @Resource
    private StationServiceImpl stationService;

    @Resource
    private DelaySingleRecordRepository delaySingleRecordRepository;

    private int index_id;

    @Override
    public void run() {

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


                    JsonObject jsonGoogle = getJson(uri);

                    JsonArray jsonArray = jsonGoogle.getAsJsonArray("@graph");
                    int delay=0;
                    int n_overtime = 0;
                    int n_ontime=0;

                    for(JsonElement element: jsonArray){
                        JsonObject obj = element.getAsJsonObject();
                        int delay_json = obj.get("delay").getAsInt();



                        if(delay_json != 0)
                            n_overtime++;



                        delay += delay_json;
                    }


                    int i = (int) (new Date().getTime()/1000);

                    DelaySingleRecord record = new DelaySingleRecord();

                    record.setStation_uri(station.getUri());
                    record.setTotaldelay(delay);
                    record.setTimestamp(i);

                    delaySingleRecordRepository.save(record);

                    index_id++;
                    System.out.println("Record gesaved!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public JsonObject getJson(String station){

        String s = null;

        try {

            String cmd = "wget -qO- "+  station +" | python -m json.tool";

            //Process aanmaken waarin we
            ProcessBuilder builder = new ProcessBuilder("/bin/sh","-c"
                    ,"wget -qO- http://irail.be/stations/NMBS/008821006 | python -m json.tool");
            builder.redirectErrorStream(true);
            Process p = null;

            p = builder.start();


            //Reader die de output van het command zal uitlezen
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                if (!line.contains("Columns"))
                    sb.append(line);
            }

            s = sb.toString();


        }catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        JsonElement element = gson.fromJson (s, JsonElement.class);

        return element.getAsJsonObject();

    }

    public void setIndex_id(int index_id) {
        this.index_id = index_id;
    }
}