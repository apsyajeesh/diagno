package com.perscholas.service;

import com.perscholas.exception.UserIdMismatchException;
import com.perscholas.exception.UserNotFoundException;
import com.perscholas.persistence.model.Appointment;
import com.perscholas.persistence.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment Appointment) {
        return appointmentRepository.save(Appointment);
    }

    public Iterable<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment findAppointment(Long id) throws UserNotFoundException {
        return appointmentRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void deleteAppointment(Long id) throws UserNotFoundException {
        appointmentRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        appointmentRepository.deleteById(id);
    }

    public Appointment updateAppointment(Appointment appointment, Long id) throws UserIdMismatchException, UserNotFoundException {
        if (appointment.getId() != id) {
            throw new UserIdMismatchException();
        }
        appointmentRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return appointmentRepository.save(appointment);
    }
}

