package com.perscholas.service;

import com.perscholas.dto.AppointmentDto;
import com.perscholas.exception.DataNotFoundException;
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

    public AppointmentDto editAppointment(Long id) {
        Appointment appointment = findAppointment(id);
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setId(appointment.getId());
        appointmentDto.setTestName(appointment.getTestName());
        appointmentDto.setPatientName(appointment.getPatientName());
        appointmentDto.setLocation(appointment.getLocation());
        appointmentDto.setAppointmentDate(appointment.getAppointmentDate().toLocalDate().toString());
        appointmentDto.setAppointmentTime(appointment.getAppointmentDate().toLocalTime().toString());
        return appointmentDto;
    }

    public List<Appointment> findAppointments(Long userId) {
        return appointmentRepository.findAllByUserId(userId);
    }

    public Iterable<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment findAppointment(Long id) throws DataNotFoundException {
        return appointmentRepository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    public void deleteAppointment(Long id) throws DataNotFoundException {
        appointmentRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
        appointmentRepository.deleteById(id);
    }
}

