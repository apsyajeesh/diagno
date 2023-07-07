package com.perscholas.service;

import com.perscholas.dto.AppointmentDto;
import com.perscholas.exception.UserIdMismatchException;
import com.perscholas.exception.UserNotFoundException;
import com.perscholas.persistence.enums.AppointmentStatus;
import com.perscholas.persistence.model.Appointment;
import com.perscholas.persistence.repo.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void createAppointment(Long userId, AppointmentDto appointmentDto) {
        Appointment appointment= new Appointment();
        appointment.setId(appointmentDto.getId());
        appointment.setUserId(userId);
        appointment.setPatientName(appointmentDto.getPatientName());
        appointment.setTestName(appointmentDto.getTestName());
        appointment.setLocation(appointmentDto.getLocation());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a");
        LocalDateTime appointmentTime = LocalDateTime
                .parse(appointmentDto.getAppointmentDate() + " " +
                        appointmentDto.getAppointmentTime().replace(",", ""), formatter);
        appointment.setAppointmentDate(appointmentTime);
        appointment.setStatus(AppointmentStatus.SCHEDULED.name());
        appointmentRepository.save(appointment);
    }

    public List<Appointment> findAppointments(Long userId) {
        return appointmentRepository.findAllByUserId(userId);
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
}

