package com.pfariasmunoz.salon.model.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "service")
public class Service {
    
    @Id @GeneratedValue
    @Column(name = "id")
    private Long mId = -1L;
    
    @Column(name = "service_name")
    private String mName;
    
    @Column(name = "duration")
    private int mDuration;
    
    @Column(name = "price")
    private BigDecimal mPrice;
    
    public Service() {
        
    }
    
    public Service(String serviceName, int duration, BigDecimal price) {
        this.mName = serviceName;
        this.mDuration = duration;
        this.mPrice = price;
    }
    
    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmDuration() {
        return mDuration;
    }

    public void setmDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    public BigDecimal getmPrice() {
        return mPrice;
    }

    public void setmPrice(BigDecimal mPrice) {
        this.mPrice = mPrice;
    }
    
}
