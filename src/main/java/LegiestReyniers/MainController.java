package LegiestReyniers;

import LegiestReyniers.control.ServiceController;
import LegiestReyniers.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller                         // This means that this class is a Controller
@RequestMapping(path="/rail4you")   // This means URL's start with /rail4you (after Application path)
public class MainController {

    private final ServiceController service;

    @Autowired
    public MainController(ServiceController service) {
        this.service = service;
    }
    

    @GetMapping(path="/stations")
    public @ResponseBody Iterable<Station> getAllStations() {
                                // This returns a JSON or XML with the users
        return service.findAllStations();
    }

    @GetMapping(path = "addToFavorites")
    public @ResponseBody String addToFavorites(@RequestParam String stationCode
            , @RequestParam String userId){
        service.addToFavorites(stationCode,Integer.parseInt(userId));
        return "succes";
    }
}