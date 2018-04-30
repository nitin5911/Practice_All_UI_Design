package com.example.reax.ggr.Jobseeker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reax.ggr.Adapter.Recycleradapter;
import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

import java.util.ArrayList;


public class MainJobsapplied_frag extends Fragment {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;

    RecyclerView jobappliedrecycler_obj;
    RecyclerView.LayoutManager jobapllied_lmngr;
    public static final int tab_viewtp=6;
    ArrayList<String> jobapllied_arraylist=new ArrayList<>();
    Retrofitinterfacefile retrofitinterfacefile;
    BasicComponentsReuse basicComponentsReuse_obj=null;

    private OnFragmentInteractionListener mListener;
    public MainJobsapplied_frag() { }
    public static MainJobsapplied_frag newInstance(String param1, String param2) {
        MainJobsapplied_frag fragment = new MainJobsapplied_frag();
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
            mParam2 = getArguments().getString(ARG_PARAM2); }}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View jobapplied_view= inflater.inflate(R.layout.fragment_mainjobsapplied_frag, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        //Type caste work
        jobappliedrecycler_obj=jobapplied_view.findViewById(R.id.jobaplliedreclid);
        //RecyclerView Work
        jobappliedrecycler_obj.setHasFixedSize(true);
        jobapllied_lmngr=new LinearLayoutManager(getActivity());
        jobappliedrecycler_obj.setLayoutManager(jobapllied_lmngr);
        jobapllied_arraylist.add("amit");
        //RecyclerView Adapter work
        Recycleradapter recycleradapter =new Recycleradapter(getActivity(),jobapllied_arraylist,tab_viewtp);
        jobappliedrecycler_obj.setAdapter(recycleradapter);
        return jobapplied_view;
    }//end of onCreate View method

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
        //            + " must implement OnFragmentInteractionListener");
        } }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
