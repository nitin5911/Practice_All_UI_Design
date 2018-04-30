package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Amit on 24-01-2018.
 */

public class GetJBSrecentAlljobsPOJO1 {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<GetJBSrecentAlljobsPOJO2> data = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<GetJBSrecentAlljobsPOJO2> getData() {
        return data;
    }

    public void setData(List<GetJBSrecentAlljobsPOJO2> data) {
        this.data = data;
    }
}//end of POJO1
