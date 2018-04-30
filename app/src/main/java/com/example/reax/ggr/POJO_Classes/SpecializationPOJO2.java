package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amit on 22-01-2018.
 */

public class SpecializationPOJO2 {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("qualification_id")
    @Expose
    private String qualificationId;
    @SerializedName("specialization_name")
    @Expose
    private String specializationName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(String qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

}//end of POJO2
