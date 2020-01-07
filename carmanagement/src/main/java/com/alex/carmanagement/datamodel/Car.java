package com.alex.carmanagement.datamodel;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carId;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private Integer year;
    @Column(name = "license_plate")
    private String licensePlate;
    @Column(name = "motor_cap")
    private Double motorCap;
    @Column(name = "fuel")
    private String fuel;
    @Column(name = "gas")
    private Boolean gas;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Car() {
    }

    @OneToMany(mappedBy = "car")
    private Set<Itp> itpSet;
    @OneToMany(mappedBy = "car")
    private Set<KmUpdate> kmUpdateSet;
    @OneToMany(mappedBy = "car")
    private Set<Rca> rcaSet;
    @OneToMany(mappedBy = "car")
    private Set<Refuel> refuelSet;
    @OneToMany(mappedBy = "car")
    private Set<Rovinieta> rovinietaSet;


    public Integer getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Double getMotorCap() {
        return motorCap;
    }

    public void setMotorCap(Double motorCap) {
        this.motorCap = motorCap;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Boolean isGas() {
        return gas;
    }

    public void setGas(boolean gas) {
        this.gas = gas;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
