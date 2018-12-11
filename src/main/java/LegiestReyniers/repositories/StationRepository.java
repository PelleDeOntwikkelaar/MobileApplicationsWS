package LegiestReyniers.repositories;

import LegiestReyniers.model.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, String> {

    Station findByUri(String uri);


}
