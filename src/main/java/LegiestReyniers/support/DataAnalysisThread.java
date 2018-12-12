package LegiestReyniers.support;

import LegiestReyniers.model.DelaySingleRecord;
import LegiestReyniers.repositories.DelaySingleRecordRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
@Scope("prototype")
public class DataAnalysisThread implements Runnable{

    @Resource
    private DelaySingleRecordRepository delaySingleRecordRepository;

    @Override
    public void run() {

        System.out.println("-----------------TESTING THREAD --------------------------------------------");



        Iterable<DelaySingleRecord> rawData = delaySingleRecordRepository.findAll();

        for(DelaySingleRecord dsr: rawData){
            System.out.println(dsr.getId());
        }








        System.out.println("-----------------Ending THREAD------------------------------------------------");









        //Get all objects from the server
        //Delete al current items
        //Put all the items in R
        //Evaulate
        //



    }
}
