/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.salon.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "schedules")
public class Schedule implements Serializable {
    
    @Id @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long mId;
    
    @Column(name = "_from", nullable = false)
    private LocalDateTime mFrom;
    
    @Column(name = "_to", nullable = false)
    private LocalDateTime mTo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee mEmployee;

    public Schedule() {
    }

    public Schedule(LocalDateTime mFrom, LocalDateTime mTo) {
        this.mFrom = mFrom;
        this.mTo = mTo;
    }

    public Schedule(LocalDateTime mFrom, LocalDateTime mTo, Employee mEmployee) {
        this.mFrom = mFrom;
        this.mTo = mTo;
        this.mEmployee = mEmployee;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public LocalDateTime getmFrom() {
        return mFrom;
    }

    public void setmFrom(LocalDateTime mFrom) {
        this.mFrom = mFrom;
    }

    public LocalDateTime getmTo() {
        return mTo;
    }

    public void setmTo(LocalDateTime mTo) {
        this.mTo = mTo;
    }

    public Employee getmEmployee() {
        return mEmployee;
    }

    public void setmEmployee(Employee mEmployee) {
        this.mEmployee = mEmployee;
    }
      
}
