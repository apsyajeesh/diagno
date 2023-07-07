package com.perscholas.persistence.repo;

import com.perscholas.persistence.model.Appointment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment,Long> {
    List<Appointment> findAllByUserId(Long userId);
}
