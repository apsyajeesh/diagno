package com.perscholas.controller;

import com.perscholas.persistence.model.Appointments;
import com.perscholas.service.AppoinmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/appoinments")
public class AppoinmentsController {
    @Autowired
    AppoinmentsService appoinmentsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Appointments create(@RequestBody Appointments appoinments){
        Appointments appoinments1=appoinmentsService.createAppoinments(appoinments);
        return appoinments1;
    }

    @GetMapping
    public Iterable<Appointments>findAll(){
        return appoinmentsService.findAll();
    }
    @GetMapping("/{id}")
    public Appointments findOne(@PathVariable Long id){
        return appoinmentsService.findAppoinments(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        appoinmentsService.deleteAppoinments(id);
    }
    @PutMapping("/{id}")
    public Appointments updateAppoinments(@RequestBody Appointments appoinments, @PathVariable Long id){
        return appoinmentsService.updateAppoinments(appoinments,id);
    }
}
