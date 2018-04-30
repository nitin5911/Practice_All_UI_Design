package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amit on 24-01-2018.
 */

public class EmployeerdetailsPOJO {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("organization_name")
    @Expose
    private String organizationName;
    @SerializedName("sector_id")
    @Expose
    private String sectorId;
    @SerializedName("category_of_organization_id")
    @Expose
    private String categoryOfOrganizationId;
    @SerializedName("ownership_type_id")
    @Expose
    private String ownershipTypeId;
    @SerializedName("employee_strength")
    @Expose
    private String employeeStrength;
    @SerializedName("registered_office")
    @Expose
    private String registeredOffice;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("tan_gst_no")
    @Expose
    private String tanGstNo;
    @SerializedName("year_of_incorporation")
    @Expose
    private String yearOfIncorporation;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mobile_number")
    @Expose
    private String mobileNumber;
    @SerializedName("website_url")
    @Expose
    private String websiteUrl;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lan")
    @Expose
    private String lan;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("co_email")
    @Expose
    private String coEmail;
    @SerializedName("logo")
    @Expose
    private Object logo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getSectorId() {
        return sectorId;
    }

    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }

    public String getCategoryOfOrganizationId() {
        return categoryOfOrganizationId;
    }

    public void setCategoryOfOrganizationId(String categoryOfOrganizationId) {
        this.categoryOfOrganizationId = categoryOfOrganizationId;
    }

    public String getOwnershipTypeId() {
        return ownershipTypeId;
    }

    public void setOwnershipTypeId(String ownershipTypeId) {
        this.ownershipTypeId = ownershipTypeId;
    }

    public String getEmployeeStrength() {
        return employeeStrength;
    }

    public void setEmployeeStrength(String employeeStrength) {
        this.employeeStrength = employeeStrength;
    }

    public String getRegisteredOffice() {
        return registeredOffice;
    }

    public void setRegisteredOffice(String registeredOffice) {
        this.registeredOffice = registeredOffice;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getTanGstNo() {
        return tanGstNo;
    }

    public void setTanGstNo(String tanGstNo) {
        this.tanGstNo = tanGstNo;
    }

    public String getYearOfIncorporation() {
        return yearOfIncorporation;
    }

    public void setYearOfIncorporation(String yearOfIncorporation) {
        this.yearOfIncorporation = yearOfIncorporation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCoEmail() {
        return coEmail;
    }

    public void setCoEmail(String coEmail) {
        this.coEmail = coEmail;
    }

    public Object getLogo() {
        return logo;
    }

    public void setLogo(Object logo) {
        this.logo = logo;
    }
}//end of POJO3
