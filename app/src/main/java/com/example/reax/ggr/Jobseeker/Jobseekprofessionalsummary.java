package com.example.reax.ggr.Jobseeker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reax.ggr.Adapter.TablayoutAdapter;
import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

public class Jobseekprofessionalsummary extends Fragment implements TabLayout.OnTabSelectedListener {

    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    private ViewPager jobseekprofviewPager_obj;
    Toolbar jobseekprofstool_obj;
    TabLayout jobseekproftab_obj;
    public static final int tablayoutvalue=2;
    private OnFragmentInteractionListener mListener;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    Retrofitinterfacefile retrofitinterfacefile;


    public Jobseekprofessionalsummary() {}
    public static Jobseekprofessionalsummary newInstance(String param1, String param2) {
        Jobseekprofessionalsummary fragment = new Jobseekprofessionalsummary();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment; }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2); } }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View jobseekprof_view= inflater.inflate(R.layout.fragment_jobseekprofessionalsummary, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        //Type Caste work
        jobseekprofviewPager_obj=jobseekprof_view.findViewById(R.id.jobseekprofviewpagerid);
        jobseekproftab_obj=jobseekprof_view.findViewById(R.id.jobseekproftabid);
        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(),"mainActfragmentsshow","jsprofsummaryfrag","1");
        //Toolbar work
        jobseekprofstool_obj=jobseekprof_view.findViewById(R.id.jobseekproftoolid);
        basicComponentsReuse_obj.innerfragToolbarShow_method(getActivity(),jobseekprofstool_obj,"Professional Summary","mainActfragmentsshow");
        //Tab layout work
        jobseekproftab_obj.addTab(jobseekproftab_obj.newTab().setText("Experience"));
        jobseekproftab_obj.addTab(jobseekproftab_obj.newTab().setText("Qualification"));
        jobseekproftab_obj.setTabGravity(TabLayout.GRAVITY_CENTER);
        jobseekproftab_obj.setTabMode(TabLayout.MODE_FIXED);
        //Tab Adapter work
        TablayoutAdapter tablayoutAdapter =new TablayoutAdapter(getActivity().getSupportFragmentManager(), tablayoutvalue, jobseekproftab_obj.getTabCount());
        jobseekprofviewPager_obj.setAdapter(tablayoutAdapter);
        jobseekprofviewPager_obj.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(jobseekproftab_obj));
        jobseekproftab_obj.setOnTabSelectedListener(this);
       return jobseekprof_view;
    }//end of onCreateView method

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri); } }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
       //     throw new RuntimeException(context.toString()
      //              + " must implement OnFragmentInteractionListener");
        } }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        jobseekprofviewPager_obj.setCurrentItem(tab.getPosition()); }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) { }
    @Override
    public void onTabReselected(TabLayout.Tab tab) { }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
