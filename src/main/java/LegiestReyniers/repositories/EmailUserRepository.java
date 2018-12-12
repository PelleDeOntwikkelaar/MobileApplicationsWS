package LegiestReyniers.repositories;

import LegiestReyniers.model.Email_user;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Wouter Legiest on 11/12/2018
 */
public interface EmailUserRepository extends CrudRepository<Email_user, Integer> {

    Email_user findByEmailAndPassword(String email, String password);

}
