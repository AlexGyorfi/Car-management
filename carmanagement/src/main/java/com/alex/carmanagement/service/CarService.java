package com.alex.carmanagement.service;

import com.alex.carmanagement.datamodel.Car;
import com.alex.carmanagement.exceptions.MyException;
import com.alex.carmanagement.repository.CarRepository;
import com.alex.carmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;

    //for user and admin roles
    public Optional<Car> findCarByUser(Integer userId) {
        Optional<Car> carList = carRepository.findCarByUser(Optional.of(userRepository.findById(userId).get()));
        if (carList.isPresent()) {
            return carList;
        } else {
            throw new MyException(userId + "Car not found");

        }
    }

    //for admin role
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    //for user and admin roles
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // for user and admin roles
    public void deleteCarByLicensePlate(Integer licensePlate) {
        carRepository.delete(carRepository.findCarByLicensePlate(licensePlate));
    }

    public Car saveOrUpdateCar(Car car) {
        return carRepository.save(car);
    }
}
