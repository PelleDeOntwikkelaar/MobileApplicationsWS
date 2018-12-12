package LegiestReyniers.control.services.impl;

import LegiestReyniers.model.Facebook_user;
import LegiestReyniers.repositories.FacebookUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wouter Legiest on 11/12/2018
 */
@Service
public class FacebookServiceImpl {

    @Resource
    FacebookUserRepository facebookUserRepository;

    public void addFacebook(int id, String name){
        Facebook_user facebook_user = new Facebook_user();
        facebook_user.setId(id);
        facebook_user.setName(name);
        facebookUserRepository.save(facebook_user);
    }

}
