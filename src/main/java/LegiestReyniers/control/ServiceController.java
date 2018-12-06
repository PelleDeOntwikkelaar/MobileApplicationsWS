package LegiestReyniers.control;

import LegiestReyniers.control.services.impl.StationServiceImpl;
import LegiestReyniers.model.Station;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ServiceController {

    @Resource
    private StationServiceImpl stationService;


    public Iterable<Station> findAllStations() {
        return stationService.findAllStations();
    }
}
