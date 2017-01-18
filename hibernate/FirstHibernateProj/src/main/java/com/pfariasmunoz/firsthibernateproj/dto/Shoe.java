package com.pfariasmunoz.firsthibernateproj.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Shoe {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "owner")
    private UserDetails owner;
    
    public UserDetails getOwner() {
        return owner;
    }

    public void setOwner(UserDetails owner) {
        this.owner = owner;
    }
    
    
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
