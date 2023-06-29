package com.perscholas.controller;

import com.perscholas.persistence.model.Appointment;
import com.perscholas.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment create(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping
    public Iterable<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public Appointment findOne(@PathVariable Long id) {
        return appointmentService.findAppointment(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@RequestBody Appointment appointment, @PathVariable Long id) {
        return appointmentService.updateAppointment(appointment, id);
    }
}
