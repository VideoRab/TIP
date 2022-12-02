package com.example.demo.controllers;

import com.example.demo.models.Passenger;
import com.example.demo.models.Plane;
import com.example.demo.services.IGenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/plane")
@RequiredArgsConstructor
public class PlaneController {
    private final IGenericService<Plane> planeService;

    @GetMapping("/get-planes")
    public ModelAndView getAll() {
        List<Plane> result = planeService.getAll();
        ModelAndView modelAndView = new ModelAndView("plane/getplanes");
        modelAndView.addObject("planes", result);
        return modelAndView;
    }

    @GetMapping("/show-passengers/{id}")
    public ModelAndView getPassengers(@PathVariable Long id) {
        Plane result = planeService.getById(id);
        ModelAndView modelAndView = new ModelAndView("plane/showpassengers");
        modelAndView.addObject("plane", result);
        return modelAndView;
    }

    @GetMapping("/create-plane")
    public String create() {
        return "plane/createplane";
    }

    @PostMapping("/create-plane")
    public String create(@ModelAttribute Plane plane) {
        planeService.create(plane);
        return "redirect:/plane/get-planes";
    }
}
