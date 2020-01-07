package com.alex.carmanagement.service;

import com.alex.carmanagement.datamodel.Car;
import com.alex.carmanagement.datamodel.Itp;
import com.alex.carmanagement.repository.ItpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ItpService {
    @Autowired
    private ItpRepository itpRepository;

    public List<Itp> findAllItp() {
        return itpRepository.findAll();
    }

    public List<Itp> findItpByCarId(Integer carId) {
        List<Itp> itps = new ArrayList<>();
        List<Itp> itpList = findAllItp();
        for (Itp itp : itpList) {
            if (itp.getCar().getCarId() == carId) {
                itps.add(itp);
            }
        }
        return itps;
    }
    public Itp findItpByCar(Car car){
        Itp itp=itpRepository.findItpByCar(car);
        return itp;
    }

    public Itp addItp(Itp itp) {
        return itpRepository.save(itp);
    }

    public Itp updateItp(Itp itp) {
        return itpRepository.save(itp);
    }


}
