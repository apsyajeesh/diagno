package com.perscholas.persistence.repo;

import com.perscholas.persistence.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment,Long> {
}
