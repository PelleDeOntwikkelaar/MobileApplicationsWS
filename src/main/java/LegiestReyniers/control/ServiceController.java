package LegiestReyniers.control;

import LegiestReyniers.control.services.impl.FavoritesServiceImpl;
import LegiestReyniers.control.services.impl.StationServiceImpl;
import LegiestReyniers.control.services.threads.AsynchronousService1;
import LegiestReyniers.model.Station;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Controller that will command all the different services.
 * It combines the deeper logic and provides everything on one platform for the MainController.
 */
@Controller
public class ServiceController {

    @Resource
    private StationServiceImpl stationService;

    @Resource
    private FavoritesServiceImpl favoritesService;

    @Resource
    private AsynchronousService1 asynchronousService1;


    public Iterable<Station> findAllStations() {
        return stationService.findAllStations();
    }

    public Iterable<Station> findAllTrackedStations(){
        return stationService.findAllTrackedStations();
    }

    public void addToFavorites(String station_uri, int user_id){
        favoritesService.addToFavorites(station_uri,user_id);
    }

    public void startThread1(){
        asynchronousService1.executeAsynchronously();
    }
}
