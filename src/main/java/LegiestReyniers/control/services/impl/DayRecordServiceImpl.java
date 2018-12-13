package LegiestReyniers.control.services.impl;

import LegiestReyniers.model.DelayDayRecord;
import LegiestReyniers.repositories.DelayDayRecordRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wouter Legiest on 13/12/2018
 */
@Service
public class DayRecordServiceImpl {

    @Resource
    DelayDayRecordRepository delayDayRecordRepository;


    public Iterable<DelayDayRecord> getAllByStationuri(String stationuri){

        String uri = stationuri.substring(32).concat("_proc.json");

        return delayDayRecordRepository.findByStationuri(uri);

    }

}
