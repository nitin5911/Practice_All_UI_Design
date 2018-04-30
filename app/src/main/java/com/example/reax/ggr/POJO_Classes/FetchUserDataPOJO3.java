package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amit on 12-02-2018.
 */

public class FetchUserDataPOJO3 {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("quali_category_id")
    @Expose
    private String qualiCategoryId;
    @SerializedName("qualification_name")
    @Expose
    private String qualificationName;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getQualiCategoryId() {
        return qualiCategoryId;
    }
    public void setQualiCategoryId(String qualiCategoryId) {
        this.qualiCategoryId = qualiCategoryId;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }
}//end of POJO3
