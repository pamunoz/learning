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
@Table(name = "service_booked")
public class ServiceBooked {
    
    @Id @GeneratedValue
    @Column(name = "id")
    private Long mId;
    
    @Column(name = "price", nullable = false)
    private BigDecimal mPrice;
    
    @ManyToOne
    @JoinColumn(name = "service_id",
            foreignKey = @ForeignKey(name = "SERVICE_ID_FK"))
    private Service mService;
    
    
    private Appointment mAppointment;
    
    public ServiceBooked() {
    }

    public ServiceBooked(BigDecimal mPrice) {
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "appointment_id")
    public void setmService(Service mService) {
        this.mService = mService;
    } 

    public Appointment getmAppointment() {
        return mAppointment;
    }

    public void setmAppointment(Appointment mAppointment) {
        this.mAppointment = mAppointment;
    }
    
    
}
