package LegiestReyniers.support;


import LegiestReyniers.control.services.impl.StationServiceImpl;
import LegiestReyniers.model.Station;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;

@Component
@Scope("prototype")
public class MyThread implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyThread.class);
    private Gson gson;
    @Resource
    private StationServiceImpl stationService;

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
                    for (int i =0;i<jsonArray.length();i++){
                        JSONObject o = jsonArray.getJSONObject(i);
                        //todo : logic for computing total delay and save the record.
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}