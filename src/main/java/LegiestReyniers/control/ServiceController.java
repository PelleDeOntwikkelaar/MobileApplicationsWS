package LegiestReyniers.control;

import LegiestReyniers.control.services.impl.FavoritesServiceImpl;
import LegiestReyniers.control.services.impl.StationServiceImpl;
import LegiestReyniers.model.Station;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ServiceController {

    @Resource
    private StationServiceImpl stationService;

    @Resource
    private FavoritesServiceImpl favoritesService;


    public Iterable<Station> findAllStations() {
        return stationService.findAllStations();
    }

    public Iterable<Station> findAllTrackedStations(){
        return stationService.findAllTrackedStations();
    }

    public void addToFavorites(String station_uri, int user_id){
        favoritesService.addToFavorites(station_uri,user_id);
    }
}
