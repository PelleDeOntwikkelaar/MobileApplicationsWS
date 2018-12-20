package LegiestReyniers;

import LegiestReyniers.control.ServiceController;
import LegiestReyniers.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller                         // This means that this class is a Controller
@RequestMapping(path="/rail4you")   // This means URL's start with /rail4you (after Application path)
public class MainController {

    private final ServiceController service;

    @Autowired
    public MainController(ServiceController service) {
        this.service = service;
        //this.service.startThread1();
        //this.service.startThread2();
        this.service.startThread3();
    }

    @GetMapping(path="/stations")
    public @ResponseBody Iterable<Station> getAllStations() {
        // This returns a JSON or XML with the users
        return service.findAllStations();
    }

    @GetMapping(path = "/addToFavorites")
    public @ResponseBody String addToFavorites(@RequestParam String stationCode, @RequestParam String userId){
        service.addToFavorites(stationCode,Integer.parseInt(userId));
        return "succes";
    }

    @GetMapping(path = "/loginEmail")
    public @ResponseBody Email_user loginEmail(@RequestHeader String userCredentials){
        return service.loginEmail(userCredentials);
    }

    @GetMapping(path = "/loginFacebook")
    public @ResponseBody void loginFacebook(@RequestParam String name, @RequestParam int id){
        service.loginFacebook(name, id);
    }

    @GetMapping(path = "/getData")
    public @ResponseBody Iterable<DelayGlobalRecord> getData (@RequestParam String stationCode){
        return service.getData(stationCode);
    }

    @GetMapping(path = "/getApiData")
    public @ResponseBody String getStationCode (@RequestParam String stationCode){
        return service.getApiData(stationCode);
    }

    @GetMapping(path = "/getStations")
    public @ResponseBody Iterable<Station> getData (@RequestParam ArrayList<String> stationUriList){
        return service.getStationsByUri(stationUriList);
    }

    @GetMapping(path = "/getFavorites")
    public @ResponseBody Iterable<Favorit> getFavorites (@RequestParam int userID){
        return service.getFavorites(userID);
    }

    @GetMapping(path = "/addToTracked")
    public @ResponseBody String addToTracked (@RequestParam String stationID){
        service.addToTracked(stationID);
        return "succes";
    }

    @GetMapping(path = "/getTracked")
    public @ResponseBody Iterable<Station> getTracked (){
        return service.findAllTrackedStations();
    }

    @GetMapping(path = "/addMail")
    public @ResponseBody Email_user addMail (@RequestParam String name, @RequestHeader String userCredentials) {
        return service.addName(name,userCredentials);
    }

}