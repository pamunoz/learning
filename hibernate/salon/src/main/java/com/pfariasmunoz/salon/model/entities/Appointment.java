/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.salon.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {
    
    @Id @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long mId = -1L;
     
    /**
     * the date and time when a record was inserted in the table.
     */
    @Column(name = "date_created", nullable = false)
    private LocalDate mDateCreated;
     
    /**
     * the employee who inserted the record.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "employee_created", nullable = false)
    private Employee mEmployeeCreated;
    
    /**
     * This is a reference to the {@link Client} table. Is arbitrary. 
     * We may not know who the client is, e.g. somebody who called 
     * without giving us his name or who walked in and asked for an appointment.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "client_id")
    private Client mClient;
    
    /**
     * This is a reference to the {@link Employee} table. Is arbitrary. 
     * The employee_id attribute refers to the specific employee 
     * requested by the client. Remember, a client may not ask 
     * for any stylist in particular; also, the appointment can 
     * be set so far in advance that the schedule is not yet finalized. 
     * 
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "employee_id")
    private Employee mAssingEmployee;
    
    @Column(name = "client_name")
    private String mClientName = "unknown";
    
    @Column(name = "client_contact")
    private String mClientContact = "unavailable";
    
    @Column(name = "start_time")
    private LocalDateTime mStartTime;
    
    @Column(name = "end_time_expected")
    private LocalDateTime mEndTimeExpected;
    
    @Column(name = "end_time", nullable = true)
    private LocalDateTime mEndTime;
    
    @Column(name = "price_expected")
    private BigDecimal mPriceExpected;
    
    @Column(name = "price_full", nullable = true)
    private BigDecimal mPriceFull;
    
    @Column(name = "discount", nullable = true)
    private BigDecimal mDiscount;
    
    @Column(name = "price_final", nullable = true)
    private BigDecimal mPriceFinal;
    
    @Column(name = "canceled")
    private boolean mCanceled;
    
    @Lob
    @Column(name = "cancellation_reason", nullable = true)
    private String mCancellationReason; 
    
    @OneToMany(mappedBy = "mAppointment", cascade = {CascadeType.ALL})
    private List<ServiceBooked> mServicesBookedList = new ArrayList<>();
    
    @OneToMany(mappedBy = "mAppointment", cascade = {CascadeType.ALL})
    private List<ServiceProvided> mServicesProvidedList = new ArrayList<>();
    
    public Appointment() {
        
    }

    public Appointment(
            LocalDate mDateCreated, Employee mEmployeeCreated, 
            String mClientName, String mClientContact, 
            LocalDateTime mStartTime, LocalDateTime mEndTimeExpected, 
            BigDecimal mPriceExpected, boolean mCanceled) {
        this.mDateCreated = mDateCreated;
        this.mEmployeeCreated = mEmployeeCreated;
        this.mClientName = mClientName;
        this.mClientContact = mClientContact;
        this.mStartTime = mStartTime;
        this.mEndTimeExpected = mEndTimeExpected;
        this.mPriceExpected = mPriceExpected;
        this.mCanceled = mCanceled;
    }
    
    public void addServicesBooked(ServiceBooked serviceBooked) {
        mServicesBookedList.add(serviceBooked);
        serviceBooked.setmAppointment(this);
    }
    
    public void removeServiceBooked(ServiceBooked serviceBooked) {
        mServicesBookedList.remove(serviceBooked);
        serviceBooked.setmAppointment(this);
    }
    
    public void addServicesProvided(ServiceProvided serviceProvided) {
        mServicesProvidedList.add(serviceProvided);
        serviceProvided.setmAppointment(this);
    }
    
    public void removeServicesProvided(ServiceProvided serviceProvided) {
        mServicesProvidedList.remove(serviceProvided);
        serviceProvided.setmAppointment(this);
    }
    

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public LocalDate getmDateCreated() {
        return mDateCreated;
    }

    public void setmDateCreated(LocalDate mDateCreated) {
        this.mDateCreated = mDateCreated;
    }

    public Employee getmEmployeeCreated() {
        return mEmployeeCreated;
    }

    public void setmEmployeeCreated(Employee employeeCreated) {
        this.mEmployeeCreated = employeeCreated;
    }

    public Client getmClient() {
        return mClient;
    }

    public void setmClient(Client mClient) {
        this.mClient = mClient;
    }

    public Employee getmAssingEmployee() {
        return mAssingEmployee;
    }

    public void setmAssingEmployee(Employee mAssingEmployee) {
        this.mAssingEmployee = mAssingEmployee;
    }

    public String getmClientName() {
        return mClientName;
    }

    public void setmClientName(String mClientName) {
        this.mClientName = mClientName;
    }

    public String getmClientContact() {
        return mClientContact;
    }

    public void setmClientContact(String mClientContact) {
        this.mClientContact = mClientContact;
    }

    public LocalDateTime getmStartTime() {
        return mStartTime;
    }

    public void setmStartTime(LocalDateTime mStartTime) {
        this.mStartTime = mStartTime;
    }

    public LocalDateTime getmEndTimeExpected() {
        return mEndTimeExpected;
    }

    public void setmEndTimeExpected(LocalDateTime mEndTimeExpected) {
        this.mEndTimeExpected = mEndTimeExpected;
    }

    public LocalDateTime getmEndTime() {
        return mEndTime;
    }

    public void setmEndTime(LocalDateTime mEndTime) {
        this.mEndTime = mEndTime;
    }

    public BigDecimal getmPriceExpected() {
        return mPriceExpected;
    }

    public void setmPriceExpected(BigDecimal mPriceExpected) {
        this.mPriceExpected = mPriceExpected;
    }

    public BigDecimal getmPriceFull() {
        return mPriceFull;
    }

    public void setmPriceFull(BigDecimal mPriceFull) {
        this.mPriceFull = mPriceFull;
    }

    public BigDecimal getmDiscount() {
        return mDiscount;
    }

    public void setmDiscount(BigDecimal mDiscount) {
        this.mDiscount = mDiscount;
    }

    public BigDecimal getmPriceFinal() {
        return mPriceFinal;
    }

    public void setmPriceFinal(BigDecimal mPriceFinal) {
        this.mPriceFinal = mPriceFinal;
    }

    public boolean ismCanceled() {
        return mCanceled;
    }

    public void setmCanceled(boolean mCanceled) {
        this.mCanceled = mCanceled;
    }

    public String getmCancellationReason() {
        return mCancellationReason;
    }

    public void setmCancellationReason(String mCancellationReason) {
        this.mCancellationReason = mCancellationReason;
    }
    
    
}
