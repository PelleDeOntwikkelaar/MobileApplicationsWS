package LegiestReyniers.control.services.impl;

import LegiestReyniers.model.Favorit;
import LegiestReyniers.model.Station;
import LegiestReyniers.model.Tracked_station;
import LegiestReyniers.repositories.StationRepository;
import LegiestReyniers.repositories.TrackedStationRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sound.midi.Track;
import java.util.ArrayList;

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
        Iterable<Tracked_station> trackedStationIterable = trackedStationRepository.findAll();
        ArrayList<Station> stationArrayList =new ArrayList<>();

        for(Tracked_station trackedStation: trackedStationIterable){
            stationArrayList.add(stationRepository.findByUri(trackedStation.getUri()));
        }
        Iterable<Station> output = stationArrayList;
        return output;
    }

    public void addToTracked(String stationID) {

        Tracked_station tracked_station = new Tracked_station();
        tracked_station.setUri(stationID);

        trackedStationRepository.save(tracked_station);
    }

    public Station findStation(String stationUri){
        return stationRepository.findByUri(stationUri);
    }
}
