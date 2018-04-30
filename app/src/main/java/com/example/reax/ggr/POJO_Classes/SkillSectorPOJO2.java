package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amit on 08-02-2018.
 */

public class SkillSectorPOJO2 {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("sector_name")
    @Expose
    private String sectorName;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSectorName() {
        return sectorName;
    }
    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }
}//end of POJO2
