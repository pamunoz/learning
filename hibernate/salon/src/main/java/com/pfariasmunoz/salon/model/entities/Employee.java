/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.salon.model.entities;

import javafx.beans.property.ObjectProperty;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@NamedQuery(name="Employee.findAll", query="SELECT e from Employee e")
public class Employee implements Externalizable{
    
    private static final String DEFAULT_FIRST_NAME = "";
    private static final String DEFAULT_LAST_NAME = "";
    
    
    // ID property
    private ObjectProperty<Long> mId;
    private Long _mId;
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getmId() {
        return (mId != null) ? mId.get() :_mId;
    }
    
    public void setmId(Long id) {
        if (mId != null) {
            mId.set(id);
        } else {
            _mId = id;
        }  
    }
    
    public ObjectProperty<Long> idProperty() {
        if (mId == null) {
            mId = new SimpleObjectProperty<>(this, "mId", _mId);
        }
        return mId;
    }
    
    // First Name property
    private StringProperty mFirstName;
    @Column(name = "first_name", nullable = false)
    public String getmFirstName() {
        return (mFirstName != null) ? mFirstName.get() : DEFAULT_FIRST_NAME;
    }
    
    public void setmFirstName(String firstName) {
        if ((mFirstName != null) || (!Objects.equals(firstName, DEFAULT_FIRST_NAME))) {
            firstNameProperty().setValue(firstName);
        }
    }
    
    public StringProperty firstNameProperty() {
        if (mFirstName == null) {
            mFirstName = new SimpleStringProperty(this, "mFirstName", DEFAULT_FIRST_NAME);
        }
        return mFirstName;
    }
    
    // Last Name property    
    private StringProperty mLastName;
    @Column(name = "last_name", nullable = false)
    public String getmLastName() {
        return (mLastName != null) ? mLastName.get() : DEFAULT_LAST_NAME;
    }
    
    public void setmLastName(String lastName) {
        if ((mLastName != null) || (!Objects.equals(lastName, DEFAULT_LAST_NAME))) {
            lastNameProperty().setValue(lastName);
        }
        
    }
    
    public StringProperty lastNameProperty() {
        if (mLastName == null) {
            mLastName = new SimpleStringProperty(this, "mLastName", DEFAULT_LAST_NAME);
        }
        return mLastName;
    }
    
    
    private ListProperty<Schedule> mScheduleList;
    @OneToMany(mappedBy = "mEmployee", cascade = {CascadeType.ALL})
    public ObservableList<Schedule> getmScheduleList() {
        return (mScheduleList != null) ? mScheduleList.get() : DEFAULT_SCHEDULE_LIST;
    }
    
    
    
    private ListProperty<Appointment> mAppointmentsCreatedList;
    private ListProperty<Appointment> mAppointmentsAssignList;

    public Employee() {
        this.mFirstName = "";
        this.mLastName = "";
    }

    public Employee(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
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

   

    

    

    

    

    

    public void setmScheduleList(List<Schedule> mScheduleList) {
        this.mScheduleList = mScheduleList;
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
