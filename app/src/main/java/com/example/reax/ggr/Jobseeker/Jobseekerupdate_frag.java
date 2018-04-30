package com.example.reax.ggr.Jobseeker;

import android.app.ProgressDialog;
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
import com.example.reax.ggr.POJO_Classes.FetchUserDataPOJO1;
import com.example.reax.ggr.POJO_Classes.FetchUserDataPOJO2;
import com.example.reax.ggr.POJO_Classes.LoginPOJO2;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Jobseekerupdate_frag extends Fragment implements TabLayout.OnTabSelectedListener ,Jobseeker_personaldetails.OnFragmentInteractionListener,Jobseeker_qualificationupdate.OnFragmentInteractionListener,Jobseeker_contadd.OnFragmentInteractionListener{
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    Toolbar employerupdatetool_obj;
    TabLayout jsupdatetab_obj;
    private ViewPager employerupdateviewPager_obj;
    public static final int tablayoutvalue=1;
    private OnFragmentInteractionListener mListener;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    LoginPOJO2[] userData_arraylist;
    ArrayList<FetchUserDataPOJO2> userdetails_list=new ArrayList<>();
    int userid;
    ProgressDialog jsupprogressbar;
    String outsideTokenno="_KDHudbjadguaigwebbHAY3844";
    Retrofitinterfacefile retrofitinterfacefile;

    public Jobseekerupdate_frag() { }
    public static Jobseekerupdate_frag newInstance(String param1, String param2) {
        Jobseekerupdate_frag fragment = new Jobseekerupdate_frag();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View employerupdate_view=inflater.inflate(R.layout.fragment_jobseekerupdate_frag, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        //Typecaste work
        employerupdateviewPager_obj = employerupdate_view.findViewById(R.id.employerupdateviewpagerid);
        jsupdatetab_obj = employerupdate_view.findViewById(R.id.employerupdatetabid);
        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(),"mainActfragmentsshow","jsupdateprofilefrag","1");
        //Toolbar work
        employerupdatetool_obj = employerupdate_view.findViewById(R.id.employerupdatetoolid);
        basicComponentsReuse_obj.innerfragToolbarShow_method(getActivity(),employerupdatetool_obj,"Update Details","mainActfragmentsshow");
        //get User ID work
        userData_arraylist=basicComponentsReuse_obj.AppSessionValueGet_method(getActivity());
        userid= Integer.parseInt(userData_arraylist[0].getId());
        //Progress dialog work
        jsupprogressbar=basicComponentsReuse_obj.showProgressBar_method(getActivity(),jsupprogressbar);

        //Tab layout work
        jsupdatetab_obj.addTab(jsupdatetab_obj.newTab().setText("Personal"));
        jsupdatetab_obj.addTab(jsupdatetab_obj.newTab().setText("Contact & Address"));
        jsupdatetab_obj.addTab(jsupdatetab_obj.newTab().setText("Qualification"));
        //get User details API work
        getUserProfileData_method();
        employerupdateviewPager_obj.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(jsupdatetab_obj));
        jsupdatetab_obj.setOnTabSelectedListener(this);
        return employerupdate_view;
    }//end of onCreateView method

    public void getUserProfileData_method(){
        //show Progress bar
        jsupprogressbar.show();
        Call<FetchUserDataPOJO1> userProfileData=retrofitinterfacefile.getUserProfile_method(outsideTokenno,userid);
        userProfileData.enqueue(new Callback<FetchUserDataPOJO1>() {
            @Override
            public void onResponse(Call<FetchUserDataPOJO1> call, Response<FetchUserDataPOJO1> response) {
                if (response.body()!=null){
                    if (response.body().getStatus().equals(1)){
                        userdetails_list.add(response.body().getData());
                        if(userdetails_list.size()!=0 && !userdetails_list.equals(null)){
                            TablayoutAdapter tablayoutAdapter =new TablayoutAdapter(getActivity().getSupportFragmentManager(),tablayoutvalue,jsupdatetab_obj.getTabCount(),userdetails_list);
                            employerupdateviewPager_obj.setAdapter(tablayoutAdapter);
                            jsupprogressbar.dismiss();
                        }//end of inner if condition
                        else{
                            jsupprogressbar.dismiss();
                            basicComponentsReuse_obj.printToast_method(getActivity(),"Something went wrong. Please try again");
                        }
                    }//end of inner if condition
                    else{
                        jsupprogressbar.dismiss();
                        basicComponentsReuse_obj.printToast_method(getActivity(),"Something went wrong. Please try again");
                    }
                }//end of if condition
                else {
                    jsupprogressbar.dismiss();
                    basicComponentsReuse_obj.printToast_method(getActivity(),"Something went wrong. Please try again");
                }
            }//end of onResponse method
            @Override
            public void onFailure(Call<FetchUserDataPOJO1> call, Throwable t) {
                jsupprogressbar.dismiss();
                basicComponentsReuse_obj.printToast_method(getActivity(),"Check internet connection or Server Problem");
            }//end of onFailure method
        });
    }//end of get User Profile data method

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
         //           + " must implement OnFragmentInteractionListener");
        } }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        employerupdateviewPager_obj.setCurrentItem(tab.getPosition()); }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) { }

    @Override
    public void onTabReselected(TabLayout.Tab tab) { }

    @Override
    public void onFragmentInteraction(Uri uri) { }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
