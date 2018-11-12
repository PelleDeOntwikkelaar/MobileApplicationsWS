package LegiestReyniers.control;

import LegiestReyniers.control.services.GameService;
import LegiestReyniers.control.services.UserService;
import LegiestReyniers.model.User;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ServiceController {

    @Resource
    private UserService userService;

    @Resource
    private GameService gameService;


    public void addNewUser(String name, String email) {
        userService.addNewUser(name,email);
    }


    public Iterable<User> findAllUsers() {
        return userService.findAllUsers();
    }
}
