/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.salon.model.entities;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pablo
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "employees")
@NamedQuery(name="Employee.findAll", query="SELECT i from Employee i")
public class Employee implements Externalizable{

    
    private Long mId;

    
    private String mFirstName;

    
    private String mLastName;

   
    private List<Schedule> mScheduleList = new ArrayList<>();

    
    private List<Appointment> mAppointmentsCreatedList = new ArrayList<>();

    
    private List<Appointment> mAppointmentsAssignList = new ArrayList<>();

    public Employee() {
        this.mFirstName = "";
        this.mLastName = "";
    }

    public Employee(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }
    
    @Id @GeneratedValue
    @Column(name = "id")
    public Long getmId() {
        return mId;
    }

    @Column(name = "first_name", nullable = false)
    public String getmFirstName() {
        return mFirstName;
    }
    
    @Column(name = "last_name", nullable = false)
    public String getmLastName() {
        return mLastName;
    }
    
    @OneToMany(mappedBy = "mEmployee", cascade = {CascadeType.ALL})
    public List<Schedule> getmScheduleList() {
        return mScheduleList;
    }
    
    @OneToMany(mappedBy = "mEmployeeCreated", cascade = {CascadeType.ALL})
    public List<Appointment> getmAppointmentsCreatedList() {
        return mAppointmentsCreatedList;
    }
    
    @OneToMany(mappedBy = "mAssingEmployee", cascade = {CascadeType.ALL})
    public List<Appointment> getmAppointmentsAssignList() {
        return mAppointmentsAssignList;
    }

    public void setmAppointmentsCreatedList(List<Appointment> mAppointmentsCreatedList) {
        this.mAppointmentsCreatedList = mAppointmentsCreatedList;
    }

    
    public void addAppointment(Appointment appointment) {
        mAppointmentsCreatedList.add(appointment);
        appointment.setmEmployeeCreated(this);
    }
    
    public void removeAppointment(Appointment appointment) {
        mAppointmentsCreatedList.remove(appointment);
        appointment.setmEmployeeCreated(null);
    }

    public void addSchedule(Schedule schedule) {
        mScheduleList.add(schedule);
        schedule.setmEmployee(this);
    }
    

    public void setmAppointmentsAssignList(List<Appointment> mAppointmentsAssignList) {
        this.mAppointmentsAssignList = mAppointmentsAssignList;
    }

   

    

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    

    public void setmScheduleList(List<Schedule> mScheduleList) {
        this.mScheduleList = mScheduleList;
    }

    

    public void setmId(Long mId) {
        this.mId = mId;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
