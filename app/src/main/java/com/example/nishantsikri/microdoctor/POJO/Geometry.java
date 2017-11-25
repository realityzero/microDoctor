package com.example.nishantsikri.microdoctor.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nishantsikri on 12/11/17.
 */

public class Geometry {

    @SerializedName("location")
    @Expose
    private Location location;

    /**
     *
     * @return
     * The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

}

