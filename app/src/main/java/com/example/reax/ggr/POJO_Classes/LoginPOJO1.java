package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amit on 24-01-2018.
 */

public class LoginPOJO1 {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private LoginPOJO2 data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LoginPOJO2 getData() {
        return data;
    }

    public void setData(LoginPOJO2 data) {
        this.data = data;
    }
}//end of POJO1
