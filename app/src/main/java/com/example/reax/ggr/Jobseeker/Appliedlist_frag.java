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


public class Appliedlist_frag extends Fragment implements TabLayout.OnTabSelectedListener {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    private ViewPager appliedlistviewPager_obj;
    Toolbar appliedlisttool_obj;
    TabLayout appliedlisttab_obj;
    public static final int tablayoutvalue=3;
    private OnFragmentInteractionListener mListener;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    Retrofitinterfacefile retrofitinterfacefile;

    public Appliedlist_frag() {}
    public static Appliedlist_frag newInstance(String param1, String param2) {
        Appliedlist_frag fragment = new Appliedlist_frag();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View appliedlist_view= inflater.inflate(R.layout.fragment_appliedlist_frag, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        //Type caste work
        appliedlistviewPager_obj=appliedlist_view.findViewById(R.id.appliedlistviewpagerid);
        appliedlisttab_obj=appliedlist_view.findViewById(R.id.appliedlisttabid);
        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(),"mainActfragmentsshow","jsappliedlistfrag","1");
        //Toolbar work
        appliedlisttool_obj=appliedlist_view.findViewById(R.id.appliedlisttoolid);
        basicComponentsReuse_obj.innerfragToolbarShow_method(getActivity(),appliedlisttool_obj,"Jobs Applied List","mainActfragmentsshow");
        //Tab layout work
        appliedlisttab_obj.addTab(appliedlisttab_obj.newTab().setText("Event Jobs"));
        appliedlisttab_obj.addTab(appliedlisttab_obj.newTab().setText("Jobs Apply"));
        //Tab Adapter work
        TablayoutAdapter tablayoutAdapter =new TablayoutAdapter(getActivity().getSupportFragmentManager(), tablayoutvalue, appliedlisttab_obj.getTabCount());
        appliedlistviewPager_obj.setAdapter(tablayoutAdapter);
        appliedlistviewPager_obj.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(appliedlisttab_obj));
        appliedlisttab_obj.setOnTabSelectedListener(this);
        return appliedlist_view;
    }//end of onCreate method

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri); } }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
        //    throw new RuntimeException(context.toString()
        //            + " must implement OnFragmentInteractionListener");
        } }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        appliedlistviewPager_obj.setCurrentItem(tab.getPosition()); }//end of onTabSelected method
    @Override
    public void onTabUnselected(TabLayout.Tab tab) { }
    @Override
    public void onTabReselected(TabLayout.Tab tab) { }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class