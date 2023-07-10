package org.apsyprakash.diagno.persistence.repo;

import org.apsyprakash.diagno.persistence.model.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test,Long> {
}
