package com.example.reax.ggr.Retrofit_files;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by reax on 17/1/18.
 */

public class Retrofitinstancefile {
    public static final String base_url="http://acmeinfosystem.in/beta/app/rest/";
    public static final String oTP_base_url="https://msdgweb.mgov.gov.in/";
    public static Retrofit retrofit_obj=null;
    public static Retrofit otp_retrofit_obj=null;

    public static Retrofit retrofit_method(){
        if(retrofit_obj==null){
            retrofit_obj= new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();
        }//end of if
        return retrofit_obj;
    }//end of method

    public static Retrofit otp_retrofit_method(){
        if(otp_retrofit_obj==null){
            otp_retrofit_obj= new Retrofit.Builder().baseUrl(oTP_base_url).addConverterFactory(GsonConverterFactory.create()).build();
        }//end of if
        return otp_retrofit_obj;
    }//end of method
}
