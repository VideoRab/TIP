package com.example.demo.controllers;

import com.example.demo.models.Passenger;
import com.example.demo.models.Plane;
import com.example.demo.services.IGenericService;
import com.example.demo.services.IPassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/passenger")
@RequiredArgsConstructor
public class PassengerController {
    private final IPassengerService passengerService;

    @GetMapping("/get-passengers")
    public ModelAndView getAll() {
        List<Passenger> result = passengerService.getAll();
        ModelAndView modelAndView = new ModelAndView("passenger/getpassengers");
        modelAndView.addObject("passengers", result);
        return modelAndView;
    }

    @GetMapping("/create-passenger/{id}")
    public ModelAndView create(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("passenger/createpassenger");
        modelAndView.addObject("planeId", id);
        return modelAndView;
    }

    @PostMapping("/create-passenger/{id}")
    public String create(@ModelAttribute Passenger passenger, @PathVariable Long id) {
        passengerService.create(passenger, id);
        return "redirect:/plane/show-passengers/{id}";
    }

    @GetMapping("/update-passenger/{id}")
    public ModelAndView update(@PathVariable("id") Long id) {
        Passenger result = passengerService.getById(id);
        ModelAndView modelAndView = new ModelAndView("passenger/updatepassenger");
        modelAndView.addObject("passenger", result);
        return modelAndView;
    }

    @PostMapping("/update-passenger/{id}")
    public String update(@ModelAttribute Passenger passenger) {
        passengerService.update(passenger);
        return "redirect:/plane/get-planes";
    }

    @GetMapping("/delete-passenger/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        passengerService.deleteById(id);
        return "redirect:/passenger/get-passengers";
    }
}