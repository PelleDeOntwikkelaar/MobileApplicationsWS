package LegiestReyniers.support;

import LegiestReyniers.model.DelaySingleRecord;
import LegiestReyniers.model.Tracked_station;
import LegiestReyniers.repositories.DelaySingleRecordRepository;
import LegiestReyniers.repositories.TrackedStationRepository;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.rosuda.JRI.Rengine;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@Component
@Scope("prototype")
public class DataAnalysisThread implements Runnable{

    @Resource
    private DelaySingleRecordRepository delaySingleRecordRepository;

    @Resource
    private TrackedStationRepository trackedStationRepository;

    @Override
    public void run() {

        System.out.println("-----------------TESTING THREAD --------------------------------------------");



        Iterable<Tracked_station> stations = trackedStationRepository.findAll();

        Iterable<DelaySingleRecord> rawData = delaySingleRecordRepository.findAll();


        for(Tracked_station ts: stations){

            JsonObject main = new JsonObject();

            main.addProperty("stationURI", ts.getUri());

            JsonArray avg = new JsonArray();
            JsonArray ontime = new JsonArray();
            JsonArray over = new JsonArray();


            for(DelaySingleRecord dsr: rawData){
                if(ts.getUri().equals(dsr.getStationuri())){
                    ontime.add(dsr.getNontime());
                    over.add(dsr.getNover());

                    int avger = 0;

                    if(dsr.getNdelay() !=0){
                        avger = dsr.getTotaldelay()/dsr.getNdelay();
                    }

                    avg.add(avger);
                }
            }

            main.add("ontime", ontime);
            main.add("over", over);
            main.add("avg", avg);

            try {

                String path = System.getProperty("user.dir") + "\\Json\\" + ts.getUri().substring(32) + ".json";

                FileWriter file = new FileWriter(path);
                file.write(main.toString());
                file.close();

                System.out.println("Geprint");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        String[] my = {"--vanilla"};
        Rengine re = new Rengine(my, false, null);

        File rScript = new File("verwerking.R");
        re.eval("C:\\\\verwerking.R");



        System.out.println("-----------------Ending THREAD------------------------------------------------");









        //Get all objects from the server
        //Delete al current items
        //Put all the items in R
        //Evaulate
        //



    }
}
