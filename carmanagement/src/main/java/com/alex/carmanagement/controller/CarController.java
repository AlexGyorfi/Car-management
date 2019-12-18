package com.alex.carmanagement.controller;

import com.alex.carmanagement.datamodel.Car;
import com.alex.carmanagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping(value = "/list")
    public String findAllCars(Model model) {
        List<Car> cars = carService.findAllCars();
        model.addAttribute("cars", cars);

        return "listCarsAdminView";
    }

//    @GetMapping(value="/listCarByUser")
//    public String carsList(Model model) {
//        model.addAttribute("usersCars", carsList);
//        return "listCarByUser";
//    }

    //    @PostMapping("/add")
//    public String addCar(@ModelAttribute(name = "car") Car car) {
//        try {
//            carService.saveOrUpdateCar(car);
//        } catch (Exception e) {
//            return "redirect:add?error";
//        }
//        return "redirect:/cars/list?success=true";
//    }
    @GetMapping(value = "/addCar")
    public String addCarSendForm(Model model) {
        model.addAttribute("car",new Car());
        return "addCar";
    }

    @PostMapping(value = "/addCar")
    public String addCarProcessForm(@ModelAttribute(name = "car") Car car) {
        carService.addCar(car);
        return "redirect:/cars/list";
    }

}
