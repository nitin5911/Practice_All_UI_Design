package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by reax on 17/1/18.
 */

public class DistrictPojo1 {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<DistrictPojo2> data = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<DistrictPojo2> getData() {
        return data;
    }

    public void setData(List<DistrictPojo2> data) {
        this.data = data;
    }
}// end of districtpojo1
