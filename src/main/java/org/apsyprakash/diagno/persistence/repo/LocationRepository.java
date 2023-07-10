package org.apsyprakash.diagno.persistence.repo;

import org.apsyprakash.diagno.persistence.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location,Long> {
}
