package pl.coderslab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
}
