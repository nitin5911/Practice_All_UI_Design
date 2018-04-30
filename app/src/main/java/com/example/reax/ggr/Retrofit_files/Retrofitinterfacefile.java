package com.example.reax.ggr.Retrofit_files;

import com.example.reax.ggr.POJO_Classes.AddjobseekerExperiencePojo1;
import com.example.reax.ggr.POJO_Classes.CountryPOJO1;
import com.example.reax.ggr.POJO_Classes.DeletejobexpPojo1;
import com.example.reax.ggr.POJO_Classes.DistrictPojo1;
import com.example.reax.ggr.POJO_Classes.EventjoblistPojo1;
import com.example.reax.ggr.POJO_Classes.EventjoblistdetailsPojo1;
import com.example.reax.ggr.POJO_Classes.EventlistPojo1;
import com.example.reax.ggr.POJO_Classes.EventparticipatePojo1;
import com.example.reax.ggr.POJO_Classes.FetchUserDataPOJO1;
import com.example.reax.ggr.POJO_Classes.GetJBSrecentAlljobsPOJO1;
import com.example.reax.ggr.POJO_Classes.GetJobseekExpPojo1;
import com.example.reax.ggr.POJO_Classes.HighQualfctnPOJO1;
import com.example.reax.ggr.POJO_Classes.LoginPOJO1;
import com.example.reax.ggr.POJO_Classes.QualificationPOJO1;
import com.example.reax.ggr.POJO_Classes.SkillSectorPOJO1;
import com.example.reax.ggr.POJO_Classes.SpecializationPOJO1;
import com.example.reax.ggr.POJO_Classes.StatePOJO1;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by reax on 17/1/18.
 */

public interface Retrofitinterfacefile {

    @GET("district")
    Call<DistrictPojo1> getDistrict_method(@Query("token") String tokenno);

    @GET("state")
    Call<StatePOJO1> getState_method(@Query("token") String tokenno);

    @GET("country")
    Call<CountryPOJO1> getCountry_method(@Query("token") String tokenno);

    @GET("highest-qualification")
    Call<HighQualfctnPOJO1> getHighQualification_method(@Query("token") String tokenno);

    @GET("qualification")
    Call<QualificationPOJO1> getQualification_method(@Query("token") String tokenno, @Query("id") int id);

    @GET("get-specialization")
    Call<SpecializationPOJO1> getSpecialization_method(@Query("token") String tokenno, @Query("id") int id);

    @GET("get-events")
    Call<EventlistPojo1> geteventlist_method(@Query("token") String tokenno);

    @GET("get-event-jobs")
    Call<EventjoblistPojo1> getEventjoblist_method(@Query("token") String tokenno,
                                                   @Query("event") int id);

    @GET("get-event-jobs-details")
    Call<EventjoblistdetailsPojo1> getEventjobdetails_method(@Query("token") String tokenno,
                                                             @Query("event") int id,
                                                             @Query("id") int idno);

    @GET("event-participate-jobseeker")
    Call<EventparticipatePojo1> getEventparticipatelist_method(@Query("event") int id,
                                                               @Query("id") int idno);

    @GET("get-recent-all-jobs")
    Call<GetJBSrecentAlljobsPOJO1> getJbsRecentJobs_method(@Query("token") String tokenno, @Query("id") int id);

    @GET("login")
    Call<LoginPOJO1> getlogin_method(@Query("username") String username, @Query("password") String password);

    @GET("get-jobseeker-profile")
    Call<FetchUserDataPOJO1> getUserProfile_method(@Query("token") String tokenno, @Query("id") int id);


    @GET("register-jobseeker")
    Call<ResponseBody> submitAllDetails_method(@Query("firstName") String fname,
                                               @Query("middleName") String mname,
                                               @Query("lastName") String lname,
                                               @Query("gender") String gender,
                                               @Query("dob") String dob,
                                               @Query("maritalStatus") int maritalStatus,
                                               @Query("spouseName") String spouseName,
                                               @Query("fatherFirstName") String fatherFirstName,
                                               @Query("mobileNo") String mobileNo,
                                               @Query("address") String address,
                                               @Query("emailID") String emailID,
                                               @Query("state") int state,
                                               @Query("district") int district,
                                               @Query("pincode") int pincode,
                                               @Query("qualification") int qualification,
                                               @Query("specialization") String specialization,
                                               @Query("mode") String percentage,
                                               @Query("marks") String marks,
                                               @Query("year") String year,
                                               @Query("skillLearning") int skillLearning,
                                               @Query("sector") int sector,
                                               @Query("foreingEmployment") int foreingEmployment,
                                               @Query("pvtJobs") int pvtJobs,
                                               @Query("foreignStudy") int foreignStudy,
                                               @Query("govtJobs") int govtJobs,
                                               @Query("selfEmployment") int selfEmployment,
                                               @Query("category") int category,
                                               @Query("bankAccountNo") String bankAccountNo,
                                               @Query("IFSCcode") String IFSCcode,
                                               @Query("annualFamilyIncome") String annualFamilyIncome,
                                               @Query("employement") int employement,
                                               @Query("familyEmp") int familyEmp,
                                               @Query("meterNumber") String meterNumber,
                                               @Query("avgConsumption") String avgConsumption,
                                               @Query("holderName") String holderName,
                                               @Query("jobTitle") String jobTitle,
                                               @Query("jobSalary") String jobSalary,
                                               @Query("jobEmployer") String jobEmployer );

    @GET("update-jobseeker")
    Call<ResponseBody> updateUserdata_method(@Query("id") int id,
                                           @Query("firstName") String fname,
                                           @Query("middleName") String mname,
                                           @Query("lastName") String lname,
                                           @Query("gender") String gender,
                                           @Query("dob") String dob,
                                           @Query("maritalStatus") int maritalStatus,
                                           @Query("spouseName") String spouseName,
                                           @Query("fatherFirstName") String fatherFirstName,
                                           @Query("mobileNo") String mobileNo,
                                           @Query("address") String address,
                                           @Query("state") int state,
                                           @Query("district") int district,
                                           @Query("pincode") int pincode,
                                           @Query("qualification") int qualification,
                                           @Query("specialization") String specialization,
                                           @Query("mode") String percentage,
                                           @Query("marks") String marks,
                                           @Query("year") String year,
                                           @Query("skillLearning") int skillLearning,
                                           @Query("sector") int sector,
                                           @Query("foreingEmployment") int foreingEmployment,
                                           @Query("pvtJobs") int pvtJobs,
                                           @Query("foreignStudy") int foreignStudy,
                                           @Query("govtJobs") int govtJobs,
                                           @Query("selfEmployment") int selfEmployment,
                                           @Query("category") int category,
                                           @Query("bankAccountNo") String bankAccountNo,
                                           @Query("IFSCcode") String IFSCcode,
                                           @Query("annualFamilyIncome") String annualFamilyIncome,
                                           @Query("employement") int employement,
                                           @Query("familyEmp") int familyEmp,
                                           @Query("meterNumber") String meterNumber,
                                           @Query("avgConsumption") String avgConsumption,
                                           @Query("holderName") String holderName,
                                           @Query("jobTitle") String jobTitle,
                                           @Query("jobSalary") String jobSalary,
                                           @Query("jobEmployer") String jobEmployer );

    @FormUrlEncoded
    @POST("esms/sendsmsrequest")
    Call<ResponseBody> getOTP_method(@Field("mobileno") String method_number,@Field("senderid") String method_senderid,
                                     @Field("content") String method_content,@Field("smsservicetype") String otpmsgtype,
                                     @Field("username") String method_username,
                                     @Field("password") String method_password,@Field("key") String hashValue);

    @FormUrlEncoded
    @POST("add-jobseeker-experience")
    Call<AddjobseekerExperiencePojo1> addJobseekExperience_method(@Field("id") int id, @Field("jobtitle") String jobtitle,
                                                                  @Field("companyname") String companyname, @Field("startdate") String startdate,
                                                                  @Field("enddate") String enddate, @Field("state") int stateid,
                                                                  @Field("district") int districtid, @Field("responsibilities") String responsibilitis);

    @GET("get-jobseeker-experience")
    Call<GetJobseekExpPojo1> getJobseekexp_method(@Query("id") int id,
                                                  @Query("token") String tokenno);

  /*  @FormUrlEncoded
    @POST("update-jobseeker-experience")
    Call<ResponseBody> updateJobseekExp_meethod(@Field("id") int jobseekid,
                                                @Field("jobtitle") String jobtitle,
                                                @Field("companyname") String companyname,
                                                @Field("startdate") String startdate,
                                                @Field("enddate") String enddate,
                                                @Field("state") int stateid,
                                                @Field("district") int districtid,
                                                @Field("responsibilities") String resposibilities);
                                                */


    @GET("update-jobseeker-experience")
    Call<ResponseBody> updateJobseekExp_meethod(@Query("id") int jobseekid,
                                                @Query("jobtitle") String jobtitle,
                                                @Query("companyname") String companyname,
                                                @Query("startdate") String startdate,
                                                @Query("enddate") String enddate,
                                                @Query("state") int stateid,
                                                @Query("district") int districtid,
                                                @Query("responsibilities") String resposibilities
    );

//end of in


    // @GET("delete-jobseeker-experience")
    Call<DeletejobexpPojo1> deleteJobseekExp_method(@Query("id") int id,
                                                    @Query("seeker") int jobseekerid);

    @GET("validate-email")
    Call<ResponseBody> emailValidate_method(@Query("emailID") String emailID);


    @GET("get-sectors")
    Call<SkillSectorPOJO1> getSkillSectors_method(@Query("token") String token);


}//end of interface
