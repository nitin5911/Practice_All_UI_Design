package com.example.reax.ggr.Jobseeker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reax.ggr.Adapter.Recycleradapter;
import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

import java.util.ArrayList;

public class Myinterviews_frag extends Fragment {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;

    Toolbar myinterviewstool_obj;
    RecyclerView myinterviewsrecycler_obj;
    RecyclerView.LayoutManager myinterviews_lmngr;
    public static final int tab_viewtp=5;
    ArrayList<String> myinterviews_arraylist=new ArrayList<>();
    BasicComponentsReuse basicComponentsReuse_obj=null;
    Retrofitinterfacefile retrofitinterfacefile;

    private OnFragmentInteractionListener mListener;
    public Myinterviews_frag() { }
    public static Myinterviews_frag newInstance(String param1, String param2) {
        Myinterviews_frag fragment = new Myinterviews_frag();
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
        View myinterview_view= inflater.inflate(R.layout.fragment_myinterviews_frag, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        //Type caste work
        myinterviewsrecycler_obj=myinterview_view.findViewById(R.id.myinterviewreclid);
        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(),"mainActfragmentsshow","jsmyinterviewfrag","1");
        //Toolbar work
        myinterviewstool_obj=myinterview_view.findViewById(R.id.myinterviewtoolbarid);
        basicComponentsReuse_obj.innerfragToolbarShow_method(getActivity(),myinterviewstool_obj,"My Interviews List","mainActfragmentsshow");
        //RecyclerView work
        myinterviewsrecycler_obj.setHasFixedSize(true);
        myinterviews_lmngr=new LinearLayoutManager(getActivity());
        myinterviewsrecycler_obj.setLayoutManager(myinterviews_lmngr);
        //Recycler View Adapter work
        Recycleradapter recycleradapter =new Recycleradapter(getActivity(),myinterviews_arraylist,tab_viewtp);
        myinterviewsrecycler_obj.setAdapter(recycleradapter);
        myinterviews_arraylist.add("amit");
        return myinterview_view;
    }//end of onCreate view method

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
       //             + " must implement OnFragmentInteractionListener");
        } }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
