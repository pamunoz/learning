package com.pfariasmunoz.firsthibernateproj.dto;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int userId;
       
    private String userName;
    
    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable (name = "USER_ADRESS",
            joinColumns = @JoinColumn(name = "USER_ID"))
    private Collection<Address> listOfAddresses = new ArrayList<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }
    
}
