package com.pfariasmunoz.firsthibernateproj.dto;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@SelectBeforeUpdate
public class UserDetails {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int userId;
       
    private String userName;
    
    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private Collection<Shoe> calzado = new ArrayList<Shoe>();
    
    
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

    public Collection<Shoe> getCalzado() {
        return calzado;
    }

    public void setCalzado(Collection<Shoe> calzado) {
        this.calzado = calzado;
    }
    
    
    
}
