package LegiestReyniers.control;

import LegiestReyniers.control.services.impl.FacebookServiceImpl;
import LegiestReyniers.control.services.impl.FavoritesServiceImpl;
import LegiestReyniers.control.services.impl.StationServiceImpl;
import LegiestReyniers.control.services.threads.AsynchronousService1;
import LegiestReyniers.model.DelayDayRecord;
import LegiestReyniers.model.Email_user;
import LegiestReyniers.model.Favorit;
import LegiestReyniers.model.Station;
import LegiestReyniers.repositories.DelayDayRecordRepository;
import LegiestReyniers.repositories.EmailUserRepository;
import LegiestReyniers.repositories.FavoritRepository;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Controller that will command all the different services.
 * It combines the deeper logic and provides everything on one platform for the MainController.
 */
@Controller
public class ServiceController {

    @Resource
    private StationServiceImpl stationService;

    @Resource
    private FavoritRepository favoritRepository;

    @Resource
    private FavoritesServiceImpl favoritesService;

    @Resource
    private EmailUserRepository emailUserRepository;

    @Resource
    private FacebookServiceImpl facebookService;

    @Resource
    private DelayDayRecordRepository delayDayRecordRepository;

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

    public Email_user loginEmail(String email, String password) {
        return emailUserRepository.findByEmailAndPassword(email,password);
    }

    public void loginFacebook(String name, int id) {
        //Gwn adden naar de db
        facebookService.addFacebook(id,name);
    }

    public Iterable<DelayDayRecord> getData(String stationuri) {
        return delayDayRecordRepository.findByStationuri(stationuri);
    }

    public Iterable<Favorit> getFavorites(int userID) {
        return favoritRepository.findByUserid(userID);
    }

    public void addToTracked(String stationID) {
        stationService.addToTracked(stationID);
    }

    public Iterable<Station> getStationsByUri(ArrayList<String> stationUriList) {
        ArrayList<Station> stationArrayList=new ArrayList<>();
        for(String stationUri: stationUriList){
            stationArrayList.add(stationService.findStation(stationUri));
        }
        Iterable<Station> output = stationArrayList;
        return output;

    }
}
