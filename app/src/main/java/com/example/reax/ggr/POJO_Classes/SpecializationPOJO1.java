package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpecializationPOJO1 {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<SpecializationPOJO2> data = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SpecializationPOJO2> getData() {
        return data;
    }

    public void setData(List<SpecializationPOJO2> data) {
        this.data = data;
    }

}//end of POJO1
