package LegiestReyniers.repositories;

import LegiestReyniers.model.Favorit;
import org.springframework.data.repository.CrudRepository;

public interface FavoritRepository extends CrudRepository<Favorit, Integer> {

    Iterable<Favorit> findByUserId (int id);

}
