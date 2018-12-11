package LegiestReyniers.support;

import LegiestReyniers.control.services.impl.StationServiceImpl;
import LegiestReyniers.model.DelaySingleRecord;
import LegiestReyniers.model.Station;
import LegiestReyniers.repositories.DelaySingleRecordRepository;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
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

    @Override
    public void run() {
        gson=new Gson();

        while(true){
            try {
                Thread.sleep(300000);
                Iterable<Station> tracked= stationService.findAllTrackedStations();

                for(Station station: tracked){

                    final String uri = station.getUri();

                    RestTemplate restTemplate = new RestTemplate();
                    String result = restTemplate.getForObject(uri, String.class);
                    JSONObject object = new JSONObject(result);
                    JSONArray jsonArray = new JSONArray(object.getJSONArray("@graph"));
                    int delay=0;

                    for (int i =0;i<jsonArray.length();i++){
                        JSONObject o = jsonArray.getJSONObject(i);
                        delay+=o.getInt("delay");
                    }

                    int i = (int) (new Date().getTime()/1000);

                    DelaySingleRecord record = new DelaySingleRecord();
                    record.setStation_uri(station.getUri());
                    record.setTotalDelay(delay);
                    record.setTimestamp(i);

                    delaySingleRecordRepository.save(record);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}