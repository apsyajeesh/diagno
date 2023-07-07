package com.perscholas.persistence.repo;

import com.perscholas.persistence.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location,Long> {
}
