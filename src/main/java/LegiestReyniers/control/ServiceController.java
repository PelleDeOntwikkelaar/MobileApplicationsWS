package LegiestReyniers.control;

import LegiestReyniers.control.services.impl.DayRecordServiceImpl;
import LegiestReyniers.control.services.impl.FacebookServiceImpl;
import LegiestReyniers.control.services.impl.FavoritesServiceImpl;
import LegiestReyniers.control.services.impl.StationServiceImpl;
import LegiestReyniers.control.services.threads.AsynchronousService1;
import LegiestReyniers.control.services.threads.AsynchronousService2;
import LegiestReyniers.model.*;
import LegiestReyniers.repositories.DelayDayRecordRepository;
import LegiestReyniers.repositories.DelaySingleRecordRepository;
import LegiestReyniers.repositories.EmailUserRepository;
import LegiestReyniers.repositories.FavoritRepository;
import LegiestReyniers.support.WGet;
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
    private DayRecordServiceImpl dayRecordService;

    @Resource
    private AsynchronousService1 asynchronousService1;

    @Resource
    private AsynchronousService2 asynchronousService2;

    @Resource
    DelaySingleRecordRepository delaySingleRecordRepository;

    public Iterable<DelaySingleRecord> getData(){
        return delaySingleRecordRepository.findAll();
    }

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

    public void startThread2() {
        asynchronousService2.executeAsynchronously();
    }

    public Email_user loginEmail(String email, String password) {
        return emailUserRepository.findByEmailAndPassword(email,password);
    }

    public void loginFacebook(String name, int id) {
        //Gwn adden naar de db
        facebookService.addFacebook(id,name);
    }

    public Iterable<DelayDayRecord> getData(String stationuri) {
        return dayRecordService.getAllByStationuri(stationuri);
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

    public String getApiData(String stationCode) {
        WGet wGet= new WGet();
        return wGet.getJson(stationCode).toString();
    }
}
