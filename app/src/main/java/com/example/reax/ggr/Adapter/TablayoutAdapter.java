package com.example.reax.ggr.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.reax.ggr.Jobseeker.Eventjobsapplied_frag;
import com.example.reax.ggr.Jobseeker.JobseekExperince_frag;
import com.example.reax.ggr.Jobseeker.Jobseeker_contadd;
import com.example.reax.ggr.Jobseeker.Jobseeker_personaldetails;
import com.example.reax.ggr.Jobseeker.Jobseeker_qualificationupdate;
import com.example.reax.ggr.Jobseeker.Jobseekqualification_frag;
import com.example.reax.ggr.Jobseeker.MainJobsapplied_frag;
import com.example.reax.ggr.POJO_Classes.FetchUserDataPOJO2;

import java.util.ArrayList;

public class TablayoutAdapter extends FragmentStatePagerAdapter {
    int tablayoutvalue;
    private int tabCount;
    ArrayList<FetchUserDataPOJO2> updatelist_array;
    private ArrayList<FetchUserDataPOJO2> updatedatalist_array=new ArrayList<>();

    public TablayoutAdapter(FragmentManager fm, int tablayoutvalue, int count){
        super(fm);
        this.tablayoutvalue = tablayoutvalue;
        this.tabCount=count;
    }//end of default constructor
    public TablayoutAdapter(FragmentManager fm, int tablayoutvalue, int count, ArrayList userdetails_list) {
        super(fm);
        this.tablayoutvalue = tablayoutvalue;
        this.tabCount=count;
        updatedatalist_array=userdetails_list;
    }//end of constructor
    public TablayoutAdapter(FragmentManager fm, int tablayoutvalue, int count, FetchUserDataPOJO2[] userdetails_list) {
        super(fm);
        this.tablayoutvalue = tablayoutvalue;
        this.tabCount=count;
      //  updatedatalist_array=userdetails_list;
    }//end of constructor
    @Override
    public Fragment getItem(int position) {
        //Jobseeker update profile
         if (tablayoutvalue==1){
            switch (position) {
                case 0:
                    return new Jobseeker_personaldetails(updatedatalist_array);
                case 1:
                    return new Jobseeker_contadd(updatedatalist_array);
                case 2:
                    return new Jobseeker_qualificationupdate(updatedatalist_array);
            }//end of switch
        }//end of if condition
        //  jobseeker professional summary
        else if (tablayoutvalue==2){
            switch (position){
                case 0:
                    return new JobseekExperince_frag();
                case 1:
                    return new Jobseekqualification_frag();
            }//end of switch
        }//end of else if
         //  jobseeker Applied list
         else if (tablayoutvalue==3){
             switch (position){
                 case 0:
                     return new Eventjobsapplied_frag();
                 case 1:
                     return new MainJobsapplied_frag();
             }//end of switch
         }//end of else if
        return null;
    }//end of getItem method
    @Override
    public int getCount() {
        return tabCount;
    }
}//end of main class
