package com.alex.carmanagement.controller;

import com.alex.carmanagement.datamodel.Car;
import com.alex.carmanagement.datamodel.Itp;
import com.alex.carmanagement.service.CarService;
import com.alex.carmanagement.service.ItpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/itp")
public class ItpController {
    @Autowired
    private ItpService itpService;
    @Autowired
    private CarService carService;


    @GetMapping(value = "/addItp")
    public String addItpSendForm(Model model, @RequestParam Integer carId) {
        Car c = carService.findCarByCarId(carId);
        Itp itp = new Itp();
        itp.setCar(c);
        model.addAttribute("itp", itp);
        return "addItp";
    }

    @PostMapping(value = "/addItp")
    public String addItpProcessForm(@ModelAttribute(name = "itp") Itp itp) {
        itpService.addItp(itp);
        return "redirect:/cars/details?carId=" + itp.getCar().getCarId();
    }

    @GetMapping(value = "/showAll")
    public String showAllItp(Model model) {
        List<Itp> itpList = itpService.findAllItp();
        model.addAttribute("itpList", itpList);
        return "listAllItp";
    }

    @GetMapping(value = "/show")
    public String showItp(Model model, @RequestParam("carId") Integer carId) {
        List<Itp> itpList = itpService.findItpByCarId(carId);
        model.addAttribute("itpList", itpList);
        return "listAllItp";
    }

    @GetMapping(value = "/update")
    public String updateItpSendForm(Model model, @RequestParam("carId") Integer carId ) {
        List<Itp> itpList = itpService.findItpByCarId(carId);
        model.addAttribute("itp", itpList);
        return "updateItp";
    }
    @PostMapping(value = "/update")
    public String updateCarProcessForm(@ModelAttribute(name = "carId") Integer carId, Model model) {
        Itp itp=itpService.findItpByCar(carService.findCarByCarId(carId));
        model.addAttribute("itp", itp);
        itpService.updateItp(itp);
        return "redirect:/itp/show";
    }

}
