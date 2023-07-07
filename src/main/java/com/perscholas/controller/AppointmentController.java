package com.perscholas.controller;

import com.perscholas.dto.AppointmentDto;
import com.perscholas.persistence.model.Appointment;
import com.perscholas.persistence.model.User;
import com.perscholas.service.AppointmentService;
import com.perscholas.service.LocationService;
import com.perscholas.service.TestService;
import com.perscholas.service.UserService;
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
    private final LocationService locationService;
    private final UserService userService;
    private final TestService testService;

    public AppointmentController(AppointmentService appointmentService,
                                 LocationService locationService,
                                 UserService userService,
                                 TestService testService) {
        this.appointmentService = appointmentService;
        this.locationService = locationService;
        this.userService = userService;
        this.testService = testService;
    }


    @GetMapping("/appointment/create")
    public String showCreateForm(Model model) {
        model.addAttribute("page", "appointment.html");
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("tests", testService.findAll());
        return "main";
    }

    @PostMapping("/appointment/save")
    public String create(@Valid @ModelAttribute("appointment") AppointmentDto appointmentDto,
                         BindingResult result,
                         Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(authentication.getName());
        appointmentService.createAppointment(user.getId(), appointmentDto);
        return "redirect:/appointment/create?success";
    }

    @GetMapping("/appointment/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("page", "appointment.html");
        model.addAttribute("appointment", appointmentService.editAppointment(id));
        return "main";
    }
    @GetMapping("/appointment/{id}/cancel")
    public String showCancelForm(@PathVariable("id") Long id, Model model) {
        appointmentService.deleteAppointment(id);
        return "redirect:/account?success";
    }
}
