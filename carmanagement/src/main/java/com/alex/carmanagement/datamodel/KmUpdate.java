package com.alex.carmanagement.datamodel;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "km_update")
public class KmUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer kmUpdateId;
    @Column(name = "km_date")
    private Date kmDate;
    @Column(name = "km_no")
    private Integer kmNo;
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    public KmUpdate() {
    }


    public Integer getKmUpdateId() {
        return kmUpdateId;
    }

    public void setKmUpdateId(int kmUpdateId) {
        this.kmUpdateId = kmUpdateId;
    }

    public Date getKmDate() {
        return kmDate;
    }

    public void setKmDate(Date kmDate) {
        this.kmDate = kmDate;
    }

    public Integer getKmNo() {
        return kmNo;
    }

    public void setKmNo(int kmNo) {
        this.kmNo = kmNo;
    }

}
