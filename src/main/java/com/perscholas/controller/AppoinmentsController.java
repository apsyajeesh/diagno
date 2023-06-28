package com.perscholas.controller;

import com.perscholas.persistence.model.Appoinments;
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
    public Appoinments create(@RequestBody Appoinments appoinments){
        Appoinments appoinments1=appoinmentsService.createAppoinments(appoinments);
        return appoinments1;
    }

    @GetMapping
    public Iterable<Appoinments>findAll(){
        return appoinmentsService.findAll();
    }
    @GetMapping("/{id}")
    public Appoinments findOne(@PathVariable Long id){
        return appoinmentsService.findAppoinments(id);
    }
}
