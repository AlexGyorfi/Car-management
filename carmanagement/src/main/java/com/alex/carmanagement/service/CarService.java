package com.alex.carmanagement.service;

import com.alex.carmanagement.datamodel.Car;
import com.alex.carmanagement.datamodel.User;
import com.alex.carmanagement.exceptions.MyException;
import com.alex.carmanagement.repository.CarRepository;
import com.alex.carmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;


    //for admin role
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Car findCarByCarId(Integer carId) {
        return carRepository.findByCarId(carId);
    }

    public Car findCarByLicensePlate(String licensePlate) {
        return carRepository.findCarByLicensePlate(licensePlate);
    }

    //for user roles
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findCarsByUser(User user) {
        List<Car> cars = new ArrayList<>();
        List<Car> carList = findAllCars();
        for (Car car : carList) {
            if (car.getUser().getUserId() == user.getUserId()) {
                cars.add(car);
            }
        }
        return cars;
    }

    public Car saveOrUpdateCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Integer carId) {
        carRepository.deleteById(carId);
    }
}
