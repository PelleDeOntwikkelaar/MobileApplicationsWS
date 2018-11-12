package LegiestReyniers.control.services;

import LegiestReyniers.model.User;
import LegiestReyniers.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;


    public void addNewUser(String name, String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }
}
