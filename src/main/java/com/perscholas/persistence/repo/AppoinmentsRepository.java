package com.perscholas.persistence.repo;

import com.perscholas.persistence.model.Appoinments;
import org.springframework.data.repository.CrudRepository;

public interface AppoinmentsRepository extends CrudRepository<Appoinments,Long> {
}
