package com.alex.carmanagement.controller;

import com.alex.carmanagement.datamodel.Car;
import com.alex.carmanagement.datamodel.User;
import com.alex.carmanagement.service.CarService;
import com.alex.carmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(value = "/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public String findCarsByUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User loggedInUser = userService.getUserByUsername(username);
        List<Car> cars = carService.findCarsByUser(loggedInUser);
        model.addAttribute("cars", cars);
        return "listCarByUser";
    }

    @GetMapping(value = "/details")
    public String carDetails(@ModelAttribute(name = "carId") Integer carId, Model model) {
        Car car = carService.findCarByCarId(carId);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        model.addAttribute("cars", cars);
        return "carDetails";
    }

    @GetMapping(value = "/listAllCars")
    public String findAllCars(Model model) {
        List<Car> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
        return "listCarsAdminView";
    }

    @GetMapping(value = "/addCar")
    public String addCarSendForm(Model model) {
        model.addAttribute("car", new Car());
        return "addCar";
    }

    @PostMapping(value = "/addCar")
    public String addCarProcessForm(@ModelAttribute(name = "car") Car car) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User loggedInUser = userService.getUserByUsername(username);
        car.setUser(loggedInUser);
        carService.addCar(car);
        return "redirect:/cars/list";
    }

    @GetMapping(value = "/update")
    public String updateCarSendForm(@RequestParam("carId") Integer carId, Model model) {
        model.addAttribute("car", carService.findCarByCarId(carId));
        return "updateCar";
    }

    @PostMapping(value = "/update")
    public String updateCarProcessForm(@ModelAttribute(name = "car") Car car, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User loggedInUser = userService.getUserByUsername(username);
        car.setUser(loggedInUser);
        model.addAttribute("car", car);
        carService.saveOrUpdateCar(car);
        return "redirect:/cars/list";
    }

    @PostMapping(value = "/delete")
    public String deleteCar(@ModelAttribute(name = "carId") Integer carId, Model model) {
        carService.deleteCar(carId);
        return "redirect:/cars/list";
    }

}
