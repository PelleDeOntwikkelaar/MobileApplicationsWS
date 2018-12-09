package LegiestReyniers.control.services.impl;

import LegiestReyniers.model.Station;
import LegiestReyniers.model.TrackedStation;
import LegiestReyniers.repositories.StationRepository;
import LegiestReyniers.repositories.TrackedStationRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class StationServiceImpl  {

    @Resource
    private StationRepository stationRepository;

    @Resource
    private TrackedStationRepository trackedStationRepository;

    public Iterable<Station> findAllStations() {
        return stationRepository.findAll();
    }


    public Iterable<Station> findAllTrackedStations() {
        Iterable<TrackedStation> trackedStationIterable = trackedStationRepository.findAll();
        ArrayList<Station> stationArrayList =new ArrayList<>();

        for(TrackedStation trackedStation: trackedStationIterable){
            stationArrayList.add(stationRepository.findByUri(trackedStation.getUri()));
        }
        Iterable<Station> output = stationArrayList;
        return output;
    }
}
