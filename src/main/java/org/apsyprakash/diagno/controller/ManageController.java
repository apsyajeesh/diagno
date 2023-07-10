package org.apsyprakash.diagno.controller;

import org.apsyprakash.diagno.dto.LocationDto;
import org.apsyprakash.diagno.dto.TestDto;
import org.apsyprakash.diagno.service.LocationService;
import org.apsyprakash.diagno.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ManageController {

    private final LocationService locationService;
    private final TestService testService;

    public ManageController(LocationService locationService, TestService testService) {
        this.locationService = locationService;
        this.testService = testService;
    }

    @GetMapping("/manage")
    public String showManageForm(Model model) {
        model.addAttribute("page", "manage.html");
        model.addAttribute("location", new LocationDto());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("test", new TestDto());
        model.addAttribute("tests", testService.findAll());
        return "main";
    }

    @PostMapping("/location/save")
    public String create(@Valid @ModelAttribute("location") LocationDto locationDto,
                         BindingResult result,
                         Model model) {
        locationService.create(locationDto);
        return "redirect:/manage?success";
    }

    @PostMapping("/test/save")
    public String create(@Valid @ModelAttribute("test") TestDto testDto,
                         BindingResult result,
                         Model model) {
        testService.create(testDto);
        return "redirect:/manage?success";
    }


    @GetMapping("/location/{id}/delete")
    public String deleteLocation(@PathVariable("id") Long id, Model model) {
        locationService.delete(id);
        return "redirect:/manage?success";
    }

    @GetMapping("/test/{id}/delete")
    public String deleteTest(@PathVariable("id") Long id, Model model) {
        testService.delete(id);
        return "redirect:/manage?success";
    }
}
