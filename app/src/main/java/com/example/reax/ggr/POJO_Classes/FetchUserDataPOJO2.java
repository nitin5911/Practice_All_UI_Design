package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amit on 26-01-2018.
 */

public class FetchUserDataPOJO2 {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("middle_name")
    @Expose
    private String middleName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("marital_status")
    @Expose
    private String maritalStatus;
    @SerializedName("father_first_name")
    @Expose
    private String fatherFirstName;
    @SerializedName("mobile_no")
    @Expose
    private String mobileNo;
    @SerializedName("spouse_name")
    @Expose
    private String spouseName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("qualification")
    @Expose
    private String qualification;
    @SerializedName("specialization")
    @Expose
    private String specialization;
    @SerializedName("per_type")
    @Expose
    private String perType;
    @SerializedName("total_marks")
    @Expose
    private String totalMarks;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("skill_learning")
    @Expose
    private String skillLearning;
    @SerializedName("sector_id")
    @Expose
    private Object sectorId;
    @SerializedName("foriegn_employment")
    @Expose
    private String foriegnEmployment;
    @SerializedName("pvt_job")
    @Expose
    private String pvtJob;
    @SerializedName("foriegn_study")
    @Expose
    private String foriegnStudy;
    @SerializedName("govt_job")
    @Expose
    private String govtJob;
    @SerializedName("self_employment")
    @Expose
    private String selfEmployment;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("category_type")
    @Expose
    private Object categoryType;
    @SerializedName("bank_account_no")
    @Expose
    private String bankAccountNo;
    @SerializedName("ifsc_code")
    @Expose
    private String ifscCode;
    @SerializedName("annual_family_income")
    @Expose
    private String annualFamilyIncome;
    @SerializedName("employement")
    @Expose
    private String employement;
    @SerializedName("family_emp")
    @Expose
    private String familyEmp;
    @SerializedName("meter_number")
    @Expose
    private String meterNumber;
    @SerializedName("meter_avg")
    @Expose
    private String meterAvg;
    @SerializedName("meter_holder_name")
    @Expose
    private String meterHolderName;
    @SerializedName("job_title")
    @Expose
    private String jobTitle;
    @SerializedName("job_salary")
    @Expose
    private String jobSalary;
    @SerializedName("job_employer")
    @Expose
    private String jobEmployer;
    @SerializedName("summary")
    @Expose
    private Object summary;
    @SerializedName("profile_pic")
    @Expose
    private String profilePic;
    @SerializedName("cv")
    @Expose
    private Object cv;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("qualification0")
    @Expose
    private FetchUserDataPOJO3 qualification0;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getFatherFirstName() {
        return fatherFirstName;
    }

    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPerType() {
        return perType;
    }

    public void setPerType(String perType) {
        this.perType = perType;
    }

    public String getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSkillLearning() {
        return skillLearning;
    }

    public void setSkillLearning(String skillLearning) {
        this.skillLearning = skillLearning;
    }

    public Object getSectorId() {
        return sectorId;
    }

    public void setSectorId(Object sectorId) {
        this.sectorId = sectorId;
    }

    public String getForiegnEmployment() {
        return foriegnEmployment;
    }

    public void setForiegnEmployment(String foriegnEmployment) {
        this.foriegnEmployment = foriegnEmployment;
    }

    public String getPvtJob() {
        return pvtJob;
    }

    public void setPvtJob(String pvtJob) {
        this.pvtJob = pvtJob;
    }

    public String getForiegnStudy() {
        return foriegnStudy;
    }

    public void setForiegnStudy(String foriegnStudy) {
        this.foriegnStudy = foriegnStudy;
    }

    public String getGovtJob() {
        return govtJob;
    }

    public void setGovtJob(String govtJob) {
        this.govtJob = govtJob;
    }

    public String getSelfEmployment() {
        return selfEmployment;
    }

    public void setSelfEmployment(String selfEmployment) {
        this.selfEmployment = selfEmployment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Object getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Object categoryType) {
        this.categoryType = categoryType;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAnnualFamilyIncome() {
        return annualFamilyIncome;
    }

    public void setAnnualFamilyIncome(String annualFamilyIncome) {
        this.annualFamilyIncome = annualFamilyIncome;
    }

    public String getEmployement() {
        return employement;
    }

    public void setEmployement(String employement) {
        this.employement = employement;
    }

    public String getFamilyEmp() {
        return familyEmp;
    }

    public void setFamilyEmp(String familyEmp) {
        this.familyEmp = familyEmp;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getMeterAvg() {
        return meterAvg;
    }

    public void setMeterAvg(String meterAvg) {
        this.meterAvg = meterAvg;
    }

    public String getMeterHolderName() {
        return meterHolderName;
    }

    public void setMeterHolderName(String meterHolderName) {
        this.meterHolderName = meterHolderName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }

    public String getJobEmployer() {
        return jobEmployer;
    }

    public void setJobEmployer(String jobEmployer) {
        this.jobEmployer = jobEmployer;
    }

    public Object getSummary() {
        return summary;
    }

    public void setSummary(Object summary) {
        this.summary = summary;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public Object getCv() {
        return cv;
    }

    public void setCv(Object cv) {
        this.cv = cv;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public FetchUserDataPOJO3 getQualification0() {
        return qualification0;
    }

    public void setQualification0(FetchUserDataPOJO3 qualification0) {
        this.qualification0 = qualification0;
    }


}//end of POJO2
