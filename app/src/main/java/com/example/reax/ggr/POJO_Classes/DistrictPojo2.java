package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by reax on 17/1/18.
 */

public class DistrictPojo2 {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("state_id")
    @Expose
    private String stateId;
    @SerializedName("district_name")
    @Expose
    private String districtName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

}// end of districtpojo1
