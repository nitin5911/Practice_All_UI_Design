package com.example.reax.ggr.Common_Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

public class Aboutus_frag extends Fragment {

    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;

    WebView aboutus_webview;
    Toolbar aboutustool_obj;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    ProgressDialog aboutusprogressbar;
    Retrofitinterfacefile retrofitinterfacefile;
    String aboutuswebviewurl="http://www.ghargharrozgar.punjab.gov.in/page?title=About+us";


    private OnFragmentInteractionListener mListener;
    public Aboutus_frag() { }
    public static Aboutus_frag newInstance(String param1, String param2) {
        Aboutus_frag fragment = new Aboutus_frag();
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
        View view= inflater.inflate(R.layout.fragment_aboutus_frag, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        setHasOptionsMenu(true);
        //Type caste work
        aboutus_webview=view.findViewById(R.id.jsaboutuswebid);
        aboutustool_obj=view.findViewById(R.id.aboutustoolid);
        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(),"mainActfragmentsshow","jsmainaboutusfrag","1");
        //Toolbar work
        basicComponentsReuse_obj.innerfragToolbarShow_method(getActivity(),aboutustool_obj,"About us","mainActfragmentsshow");
        //WebView Work
        basicComponentsReuse_obj.loadWebView_method(getActivity(),aboutus_webview,aboutusprogressbar,aboutuswebviewurl);
        return  view;
    }//end of onCreateView method

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }//end of option menu method
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
