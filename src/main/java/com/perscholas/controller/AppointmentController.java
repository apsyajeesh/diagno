package com.perscholas.controller;

import com.perscholas.dto.AppointmentDto;
import com.perscholas.persistence.model.Appointment;
import com.perscholas.persistence.model.User;
import com.perscholas.service.AppointmentService;
import com.perscholas.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final UserService userService;

    public AppointmentController(AppointmentService appointmentService,
                                 UserService userService) {
        this.appointmentService = appointmentService;
        this.userService = userService;
    }

    @GetMapping("/appointment")
    public String appointmentPage(Model model) {
        model.addAttribute("page", "appointment.html");
        model.addAttribute("appointment", new Appointment());
        return "main";
    }

    @PostMapping("/appointment/save")
    public String create(@Valid @ModelAttribute("appointment") AppointmentDto appointmentDto,
                         BindingResult result,
                         Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(authentication.getName());
        appointmentService.createAppointment(user.getId(), appointmentDto);
        return "redirect:/appointment?success";
    }
}
