/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.ratmanager.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "RAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rat.findAll", query = "SELECT r FROM Rat r")
    , @NamedQuery(name = "Rat.findById", query = "SELECT r FROM Rat r WHERE r.id = :id")
    , @NamedQuery(name = "Rat.findByCode", query = "SELECT r FROM Rat r WHERE r.code = :code")
    , @NamedQuery(name = "Rat.findByWeight", query = "SELECT r FROM Rat r WHERE r.weight = :weight")
    , @NamedQuery(name = "Rat.findByBrainConcentration", query = "SELECT r FROM Rat r WHERE r.brainConcentration = :brainConcentration")})
public class Rat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CODE")
    private String code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "WEIGHT")
    private Double weight;
    @Column(name = "BRAIN_CONCENTRATION")
    private Double brainConcentration;

    public Rat() {
    }

    public Rat(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBrainConcentration() {
        return brainConcentration;
    }

    public void setBrainConcentration(Double brainConcentration) {
        this.brainConcentration = brainConcentration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rat)) {
            return false;
        }
        Rat other = (Rat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pfariasmunoz.ratmanager.model.Rat[ id=" + id + " ]";
    }
    
}
