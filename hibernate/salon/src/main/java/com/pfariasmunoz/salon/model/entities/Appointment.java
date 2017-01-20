/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.salon.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {
    
    @Id @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long mId;
    
    @Column(name = "date_created", nullable = false)
    private LocalDate mDateCreated;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_created", nullable = false)
    private Employee mEmployeeCreated;

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
    
    
}
