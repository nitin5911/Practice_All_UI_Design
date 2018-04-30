package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Amit on 22-01-2018.
 */

public class QualificationPOJO1 {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("error_code")
    @Expose
    private Integer errorCode;
    @SerializedName("data")
    @Expose
    private List<QualificationPOJO2> data = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public List<QualificationPOJO2> getData() {
        return data;
    }

    public void setData(List<QualificationPOJO2> data) {
        this.data = data;
    }
}//end of POJO1
