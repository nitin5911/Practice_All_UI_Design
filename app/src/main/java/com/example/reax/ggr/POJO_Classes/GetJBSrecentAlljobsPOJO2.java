package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amit on 24-01-2018.
 */

public class GetJBSrecentAlljobsPOJO2 {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("employeer_id")
    @Expose
    private String employeerId;
    @SerializedName("job_title")
    @Expose
    private String jobTitle;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("state_id")
    @Expose
    private String stateId;
    @SerializedName("district_id")
    @Expose
    private String districtId;
    @SerializedName("dated")
    @Expose
    private String dated;
    @SerializedName("last_date")
    @Expose
    private String lastDate;
    @SerializedName("qualification_id")
    @Expose
    private String qualificationId;
    @SerializedName("experience")
    @Expose
    private String experience;
    @SerializedName("job_mode")
    @Expose
    private String jobMode;
    @SerializedName("vacciencies")
    @Expose
    private String vacciencies;
    @SerializedName("max_application")
    @Expose
    private String maxApplication;
    @SerializedName("required_skills")
    @Expose
    private String requiredSkills;
    @SerializedName("salary")
    @Expose
    private String salary;
    @SerializedName("job_description")
    @Expose
    private String jobDescription;
    @SerializedName("contact_person")
    @Expose
    private String contactPerson;
    @SerializedName("contact_email")
    @Expose
    private String contactEmail;
    @SerializedName("contact_phone")
    @Expose
    private String contactPhone;
    @SerializedName("employeer")
    @Expose
    private EmployeerdetailsPOJO employeer;
    @SerializedName("jobType")
    @Expose
    private JobTypePOJO jobType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeerId() {
        return employeerId;
    }

    public void setEmployeerId(String employeerId) {
        this.employeerId = employeerId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(String qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getJobMode() {
        return jobMode;
    }

    public void setJobMode(String jobMode) {
        this.jobMode = jobMode;
    }

    public String getVacciencies() {
        return vacciencies;
    }

    public void setVacciencies(String vacciencies) {
        this.vacciencies = vacciencies;
    }

    public String getMaxApplication() {
        return maxApplication;
    }

    public void setMaxApplication(String maxApplication) {
        this.maxApplication = maxApplication;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public EmployeerdetailsPOJO getEmployeer() {
        return employeer;
    }

    public void setEmployeer(EmployeerdetailsPOJO employeer) {
        this.employeer = employeer;
    }

    public JobTypePOJO getJobType() {
        return jobType;
    }

    public void setJobType(JobTypePOJO jobType) {
        this.jobType = jobType;
    }

}//end of POJO2
