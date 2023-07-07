package com.perscholas.persistence.repo;

import com.perscholas.persistence.model.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test,Long> {
}
