package com.alex.carmanagement.datamodel;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "rca")
public class Rca {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rcaId;
    @Column(name = "start_date_rca")
    private Date startDateRca;
    @Column(name = "end_date_rca")
    private Date endDateRca;
    @Column(name = "price_rca")
    private double priceRca;
    @Column(name = "company")
    private String company;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    public Rca() {
    }


    public Integer getRcaId() {
        return rcaId;
    }

    public void setRcaId(int rcaId) {
        this.rcaId = rcaId;
    }

    public Date getStartDateRca() {
        return startDateRca;
    }

    public void setStartDateRca(Date startDateRca) {
        this.startDateRca = startDateRca;
    }

    public Date getEndDateRca() {
        return endDateRca;
    }

    public void setEndDateRca(Date endDateRca) {
        this.endDateRca = endDateRca;
    }

    public double getPriceRca() {
        return priceRca;
    }

    public void setPriceRca(double priceRca) {
        this.priceRca = priceRca;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
