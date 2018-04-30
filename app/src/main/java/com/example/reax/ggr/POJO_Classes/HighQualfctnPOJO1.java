package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by reax on 5/2/18.
 */

public class HighQualfctnPOJO1 {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("error_code")
    @Expose
    private Integer errorCode;
    @SerializedName("data")
    @Expose
    private List<HighQualfctnPOJO2> data = null;

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

    public List<HighQualfctnPOJO2> getData() {
        return data;
    }

    public void setData(List<HighQualfctnPOJO2> data) {
        this.data = data;
    }
}//end of POJO1
