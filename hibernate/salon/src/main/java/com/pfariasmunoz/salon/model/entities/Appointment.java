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
import java.time.LocalTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
    
    @Column(name = "date_created", nullable = false)
    private LocalDate mDateCreated;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "employee_created", nullable = false)
    private Employee mEmployeeCreated;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "client_id")
    private Client mClient;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "employee_id")
    private Employee mAssingEmployee;
    
    @Column(name = "client_name")
    private String mClientName;
    
    @Column(name = "client_contact")
    private String mClientContact;
    
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
    
    public Appointment() {
        this.mDateCreated = LocalDate.now();
        this.mEmployeeCreated = new Employee();
        this.mClientName = "";
        this.mClientContact = "";
        this.mStartTime = LocalDateTime.now();
        this.mEndTimeExpected = LocalDateTime.now();
        this.mPriceExpected = BigDecimal.ZERO;
        this.mCanceled = false;
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
