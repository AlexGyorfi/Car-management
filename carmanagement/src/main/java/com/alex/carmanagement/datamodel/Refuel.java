package com.alex.carmanagement.datamodel;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "refuel")
public class Refuel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer refuelId;
    @Column(name = "refuel_date")
    private Date refuelDate;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "price_liter")
    private double priceLiter;
    @Column(name = "index_km")
    private Integer indexKm;
    @Column(name = "is_full_tank")
    private boolean isFullTank;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    public Refuel() {
    }


    public Integer getRefuelId() {
        return refuelId;
    }

    public void setRefuelId(Integer refuelId) {
        this.refuelId = refuelId;
    }

    public Date getRefuelDate() {
        return refuelDate;
    }

    public void setRefuelDate(Date refuelDate) {
        this.refuelDate = refuelDate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPriceLiter() {
        return priceLiter;
    }

    public void setPriceLiter(double priceLiter) {
        this.priceLiter = priceLiter;
    }

    public Integer getIndexKm() {
        return indexKm;
    }

    public void setIndexKm(Integer indexKm) {
        this.indexKm = indexKm;
    }

    public boolean isFullTank() {
        return isFullTank;
    }

    public void setFullTank(boolean fullTank) {
        isFullTank = fullTank;
    }


}
