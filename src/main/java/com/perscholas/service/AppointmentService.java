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
import java.util.stream.Collectors;

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
        appointment.setStatus(appointmentDto.getStatus());
        appointmentRepository.save(appointment);
    }

    public AppointmentDto editAppointment(Long id) {
        Appointment appointment = findAppointment(id);
        if (appointment == null) {
            return null;
        }
        return convert(appointment);
    }

    private AppointmentDto convert(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setId(appointment.getId());
        appointmentDto.setUserId(appointment.getUserId());
        appointmentDto.setTestName(appointment.getTestName());
        appointmentDto.setPatientName(appointment.getPatientName());
        appointmentDto.setLocation(appointment.getLocation());
        appointmentDto.setAppointmentDate(appointment.getAppointmentDate().toLocalDate().toString());
        appointmentDto.setAppointmentTime(appointment.getAppointmentDate().format(DateTimeFormatter.ofPattern("hh:mm a")));
        appointmentDto.setStatus(appointment.getStatus());
        return appointmentDto;
    }

    public List<AppointmentDto> findAppointments(Long userId) {
        return appointmentRepository.findAllByUserId(userId)
                .stream().map(this::convert).collect(Collectors.toList());
    }

    public Iterable<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment findAppointment(Long id) throws DataNotFoundException {
        return appointmentRepository.findById(id).
                orElse(null);
    }

    public void deleteAppointment(Long id) throws DataNotFoundException {
        appointmentRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
        appointmentRepository.deleteById(id);
    }
}

