package LegiestReyniers.control.services.impl;

import LegiestReyniers.model.DelayDayRecord;
import LegiestReyniers.repositories.DelayDayRecordRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class DelayDayImplementation {

    @Resource
    private DelayDayRecordRepository delayDayRecordRepository;

    public Iterable<DelayDayRecord> findByStationUri (String stationUri){

        Iterable<DelayDayRecord> delayDayRecords = delayDayRecordRepository.findAll();

        ArrayList<DelayDayRecord> correctStation = new ArrayList<>();

        for(DelayDayRecord ddr: delayDayRecords){
            if(ddr.getStation_uri().equals(stationUri)){
                correctStation.add(ddr);
            }
        }

        Iterable<DelayDayRecord> output = correctStation;

        return output;
    }


}
