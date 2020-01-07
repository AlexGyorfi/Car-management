package com.alex.carmanagement.datamodel;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "itp")
public class Itp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itpId;
    @Column(name = "start_date_itp")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startDateItp;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "end_date_itp")
    private Date endDateItp;
    @Column(name = "cost_itp")
    private Double costItp;
    @Column(name = "remaining_days_for_itp")
    private Integer remainingDaysForItp;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    public Itp() {}

    public Integer getItpId() {
        return itpId;
    }

    public void setItpId(int itpId) {
        this.itpId = itpId;
    }

    public Date getStartDateItp() {
        return startDateItp;
    }

    public void setStartDateItp(Date startDateItp) {
        this.startDateItp = startDateItp;
    }

    public Date getEndDateItp() {
        return endDateItp;
    }

    public void setEndDateItp(Date endDateItp) {
        this.endDateItp = endDateItp;
    }

    public Double getCostItp() {
        return costItp;
    }

    public void setCostItp(double costItp) {
        this.costItp = costItp;
    }

    public void setItpId(Integer itpId) {
        this.itpId = itpId;
    }

    public void setCostItp(Double costItp) {
        this.costItp = costItp;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getRemainingDaysForItp(){
        DateTimeFormatter format = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.s");
        LocalDate endDate = LocalDate.parse(endDateItp.toString(), format);
        return Days.daysBetween(LocalDate.now(), endDate).getDays();
    }
}
