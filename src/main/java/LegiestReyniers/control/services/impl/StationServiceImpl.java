package LegiestReyniers.control.services.impl;

import LegiestReyniers.model.Station;
import LegiestReyniers.repositories.StationRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StationServiceImpl  {

    @Resource
    private StationRepository stationRepository;

    public Iterable<Station> findAllStations() {
        return stationRepository.findAll();
    }
}
