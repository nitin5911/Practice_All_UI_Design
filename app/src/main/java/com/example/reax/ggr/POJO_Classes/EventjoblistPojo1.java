package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by reax on 25/1/18.
 */

public class EventjoblistPojo1 {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<EventjoblistPojo2> data = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<EventjoblistPojo2> getData() {
        return data;
    }

    public void setData(List<EventjoblistPojo2> data) {
        this.data = data;
    }
}
