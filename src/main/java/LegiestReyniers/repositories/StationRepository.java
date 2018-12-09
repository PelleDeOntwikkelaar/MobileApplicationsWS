package LegiestReyniers.repositories;

import LegiestReyniers.model.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Integer> {

    Station findByUri(String uri);

}
