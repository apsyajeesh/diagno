package com.perscholas.persistence.repo;

import com.perscholas.persistence.model.Appointments;
import org.springframework.data.repository.CrudRepository;

public interface AppoinmentsRepository extends CrudRepository<Appointments,Long> {
}
