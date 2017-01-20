package com.pfariasmunoz.salon.model.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "service_booked")
public class ServiceBooked {
    
    @Id
    @Column(name = "id")
    private Long mId;
    
    @Column(name = "price")
    private BigDecimal mPrice;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service mService;
    
    public ServiceBooked() {
        this.mPrice = BigDecimal.ZERO;
        this.mService = new Service();
    }

    public ServiceBooked(BigDecimal mPrice, Service mService) {
        this.mPrice = mPrice;
        this.mService = mService;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public BigDecimal getmPrice() {
        return mPrice;
    }

    public void setmPrice(BigDecimal mPrice) {
        this.mPrice = mPrice;
    }

    public Service getmService() {
        return mService;
    }

    public void setmService(Service mService) {
        this.mService = mService;
    }
    
    
    
}
