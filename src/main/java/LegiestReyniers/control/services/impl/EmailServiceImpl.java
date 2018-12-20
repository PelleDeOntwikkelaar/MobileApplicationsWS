package LegiestReyniers.control.services.impl;

import LegiestReyniers.model.Email_user;
import LegiestReyniers.repositories.EmailUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmailServiceImpl {

    @Resource
    EmailUserRepository emailUserRepository;

    public Email_user addMail(String name, String userCredentials) {

        String[] split = userCredentials.split(":");

        Email_user email_user = new Email_user();

        email_user.setEmail(split[0]);
        email_user.setPassword(split[1]);
        email_user.setName(name);

        emailUserRepository.save(email_user);

        return emailUserRepository.findByEmailAndAndName(split[0],name);

    }




}
