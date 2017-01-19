/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.salon.model.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pablo
 */

@Entity
@Table(name = "employees")
public class Employee {
    
    @Id @GeneratedValue
    @Column(name = "id")
    private Long mId;
    
    @Column(name = "first_name")
    private String mFirstName;
    
    @Column(name = "last_name")
    private String mLastName;
    
    @OneToMany(mappedBy = "mEmployee", cascade = {CascadeType.ALL})
    private List<Schedule> mScheduleList = new ArrayList<Schedule>();

    public Employee() {
    }

    public Employee(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public List<Schedule> getmScheduleList() {
        return mScheduleList;
    }

    public void setmScheduleList(List<Schedule> mScheduleList) {
        this.mScheduleList = mScheduleList;
    }
    
    public void addSchedule(Schedule schedule) {
        mScheduleList.add(schedule);
        schedule.setmEmployee(this);
    }
    
}
