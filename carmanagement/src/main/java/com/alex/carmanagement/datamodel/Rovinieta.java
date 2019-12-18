package com.alex.carmanagement.datamodel;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "rovigneta")
public class Rovinieta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rovId;
    @Column(name = "start_date_rov")
    private Date startDateRov;
    @Column(name = "end_date_rov")
    private Date endDateRov;
    @Column(name = "price_rov")
    private double priceRov;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    public Rovinieta() {
    }

    public Integer getRovId() {
        return rovId;
    }

    public void setRovId(int rovId) {
        this.rovId = rovId;
    }

    public Date getStartDateRov() {
        return startDateRov;
    }

    public void setStartDateRov(Date startDateRov) {
        this.startDateRov = startDateRov;
    }

    public Date getEndDateRov() {
        return endDateRov;
    }

    public void setEndDateRov(Date endDateRov) {
        this.endDateRov = endDateRov;
    }

    public double getPriceRov() {
        return priceRov;
    }

    public void setPriceRov(double priceRov) {
        this.priceRov = priceRov;
    }

}
