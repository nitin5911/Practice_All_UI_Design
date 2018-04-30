package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by reax on 25/1/18.
 */

public class EventjoblistdetailsPojo1 {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private EventjoblistdetailsPojo2 data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public EventjoblistdetailsPojo2 getData() {
        return data;
    }

    public void setData(EventjoblistdetailsPojo2 data) {
        this.data = data;
    }
}
