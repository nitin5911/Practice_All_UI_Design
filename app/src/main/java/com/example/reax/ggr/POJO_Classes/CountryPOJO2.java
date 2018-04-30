package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amit on 22-01-2018.
 */

public class CountryPOJO2 {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("country_name")
    @Expose
    private String countryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}//end of POJO2
