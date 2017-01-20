/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.salon.model.entities;

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
@Table(name = "clients")
public class Client {
    
    @Id @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long mId;
    
    @Column(name = "client_name", nullable = false)
    private String mClientName;
    
    @Column(name = "contact_phone", nullable = true)
    private String mContactPhone;

    public List<Appointment> getmAppointmentsList() {
        return mAppointmentsList;
    }

    public void setmAppointmentsList(List<Appointment> mAppointmentsList) {
        this.mAppointmentsList = mAppointmentsList;
    }
    
    @Column(name = "contact_mail", nullable = true)
    private String mContactMail;
    
    @OneToMany(mappedBy = "mClient",cascade = {CascadeType.ALL})
    private List<Appointment> mAppointmentsList;

    public Client() {
    }

    public Client(String mClientName) {
        this.mClientName = mClientName;
    }

    public Client(String mClientName, String mContactPhone, String mContactMail) {
        this.mClientName = mClientName;
        this.mContactPhone = mContactPhone;
        this.mContactMail = mContactMail;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmClientName() {
        return mClientName;
    }

    public void setmClientName(String mClientName) {
        this.mClientName = mClientName;
    }

    public String getmContactPhone() {
        return mContactPhone;
    }

    public void setmContactPhone(String mContactPhone) {
        this.mContactPhone = mContactPhone;
    }

    public String getmContactMail() {
        return mContactMail;
    }

    public void setmContactMail(String mContactMail) {
        this.mContactMail = mContactMail;
    }  
    
}
