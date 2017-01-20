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

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long mId;

    @Column(name = "first_name", nullable = false)
    private String mFirstName;

    @Column(name = "last_name", nullable = false)
    private String mLastName;

    @OneToMany(mappedBy = "mEmployee", cascade = {CascadeType.ALL})
    private List<Schedule> mScheduleList = new ArrayList<>();

    @OneToMany(mappedBy = "mEmployeeCreated", cascade = {CascadeType.ALL})
    private List<Appointment> mAppointmentsCreatedList = new ArrayList<>();

    @OneToMany(mappedBy = "mAssingEmployee", cascade = {CascadeType.ALL})
    private List<Appointment> mAppointmentsAssignList = new ArrayList<>();

    public Employee() {
        this.mFirstName = "";
        this.mLastName = "";
    }

    public Employee(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public List<Appointment> getmAppointmentsCreatedList() {
        return mAppointmentsCreatedList;
    }

    public void setmAppointmentsCreatedList(List<Appointment> mAppointmentsCreatedList) {
        this.mAppointmentsCreatedList = mAppointmentsCreatedList;
    }

    public List<Appointment> getmAppointmentsAssignList() {
        return mAppointmentsAssignList;
    }

    public void setmAppointmentsAssignList(List<Appointment> mAppointmentsAssignList) {
        this.mAppointmentsAssignList = mAppointmentsAssignList;
    }

    public void addAppointment(Appointment appointment) {
        mAppointmentsCreatedList.add(appointment);
        appointment.setmEmployeeCreated(this);
    }

    public void addSchedule(Schedule schedule) {
        mScheduleList.add(schedule);
        schedule.setmEmployee(this);
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

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }
}
