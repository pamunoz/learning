/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.salon.model.entities;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "service_provided")
public class ServiceProvided {
    
    @Id @GeneratedValue
    @Column(name = "id")
    private Long mId;
    
    @Column(name = "price")
    private BigDecimal mPrice;
    
    @ManyToOne
    @JoinColumn(name = "service_id",
            foreignKey = @ForeignKey(name = "SERVICE_ID_FK"))
    private Service mService;
    
    private Appointment mAppointment;

    public ServiceProvided() {
        
    }

    public ServiceProvided(BigDecimal mPrice) {
        this.mPrice = mPrice;
 
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public BigDecimal getmPrice() {
        return mPrice;
    }

    public void setmPrice(BigDecimal mPrice) {
        this.mPrice = mPrice;
    }

    public Service getmService() {
        return mService;
    }

    public void setmService(Service mService) {
        this.mService = mService;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "appointment_id")
    public Appointment getmAppointment() {
        return mAppointment;
    }

    public void setmAppointment(Appointment mAppointment) {
        this.mAppointment = mAppointment;
    }
    
    
        
}
