package LegiestReyniers.support;

import LegiestReyniers.model.DelayDayRecord;
import LegiestReyniers.model.DelayGlobalRecord;
import LegiestReyniers.repositories.DelayDayRecordRepository;
import LegiestReyniers.repositories.DelayGlobalRecordRepository;
import LegiestReyniers.repositories.DelaySingleRecordRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("prototype")
@SuppressWarnings("Duplicates")
public class AddDataThread implements Runnable {


    @Resource
    private DelayGlobalRecordRepository delayGlobalRecordRepository;

    @Resource
    private DelayDayRecordRepository delayDayRecordRepository;

    @Override
    public void run() {

        Iterable<DelayDayRecord> days = delayDayRecordRepository.findAll();
        Iterable<DelayGlobalRecord> all = delayGlobalRecordRepository.findAll();

        delayGlobalRecordRepository.deleteAll();

        for (DelayGlobalRecord dgr: all){

            for (DelayDayRecord ddr: days){
                if(dgr.getStationuri().equals(ddr.getStationuri())){

                    dgr.addTotal(ddr.getTotal_delay());
                    dgr.addAvg(ddr.getAverage_delay());
                    dgr.addMin(ddr.getMin_delay());
                    dgr.addMax(ddr.getMax_delay());
                    dgr.addOver(ddr.getN_over30min());
                    dgr.addOn(ddr.getN_ontime());

                }
            }
            delayGlobalRecordRepository.save(dgr);
        }
    }
}
