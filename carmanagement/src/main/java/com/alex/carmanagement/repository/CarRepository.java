package com.alex.carmanagement.repository;

import com.alex.carmanagement.datamodel.Car;
import com.alex.carmanagement.datamodel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> findCarByUser(Optional<User> user);

    public void deleteCarByLicensePlate(Integer licensePlate);

    public Car findCarByLicensePlate(Integer licensePlate);


}
