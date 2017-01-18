package com.pfariasmunoz.firsthibernateproj.dto;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle implements Serializable {
    
    private String mSteeringHandle;

    public String getmSteeringHandle() {
        return mSteeringHandle;
    }

    public void setmSteeringHandle(String mSteeringHandle) {
        this.mSteeringHandle = mSteeringHandle;
    }

}
