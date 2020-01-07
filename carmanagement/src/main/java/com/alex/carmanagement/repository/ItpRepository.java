package com.alex.carmanagement.repository;

import com.alex.carmanagement.datamodel.Car;
import com.alex.carmanagement.datamodel.Itp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItpRepository extends JpaRepository<Itp, Integer> {
    public Itp findItpByCar(Car car);

}
