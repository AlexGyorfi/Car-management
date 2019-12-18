package com.alex.carmanagement.datamodel;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "itp")
public class Itp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itpId;
    @Column(name = "start_date_itp")
    private Date startDateItp;
    @Column(name = "end_date_itp")
    private Date endDateItp;
    @Column(name = "cost_itp")
    private Double costItp;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    public Itp() {
    }
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

//    public Integer getIdCar() {
//        return idCar;
//    }
//
//    public void setIdCar(int idCar) {
//        this.idCar = idCar;
//    }
}
