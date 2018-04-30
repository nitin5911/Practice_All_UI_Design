package com.example.reax.ggr.Common_Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.R;


public class Otp_frag extends Fragment implements View.OnClickListener{
    private static final String ARG_PARAM1 = "param1", ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    Button otp_submitid;
    EditText edtotpid;
    LinearLayout otp_containerid;
    private OnFragmentInteractionListener mListener;
    String otpvalue="1234",edittextotp;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    public Otp_frag() {
        // Required empty public constructor
    }
    public static Otp_frag newInstance(String param1, String param2) {
        Otp_frag fragment = new Otp_frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
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
        View otp_view = inflater.inflate(R.layout.fragment_otp, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        //Work on Typecaste
        otp_submitid=otp_view.findViewById(R.id.forgetotp_submitid) ;
        edtotpid=otp_view.findViewById(R.id.edtotpid);
        otp_containerid=otp_view.findViewById(R.id.otp_containerid);
        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(),"forgetfragmentsshow","forget2fragvisible","1");

        otp_submitid.setOnClickListener(this);
        return  otp_view;
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
  //          throw new RuntimeException(context.toString()
  //                  + " must implement OnFragmentInteractionListener");
        } }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forgetotp_submitid:
                ConfpassOtp confpassOtp =new ConfpassOtp();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainloginlayoutid, confpassOtp).addToBackStack(null).commit();

                //matchotp();
        }//end of switch case
    }//end of onClick method

    private void matchotp() {
        edittextotp=edtotpid.getText().toString().trim();
        if(edtotpid.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(edtotpid,"Please enter the OTP");
        else {
            if(edittextotp.equals(otpvalue)){
                basicComponentsReuse_obj.sharedclear_method(getActivity(),"forgetfragmentsshow");
                ConfpassOtp confpassOtp =new ConfpassOtp();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainloginlayoutid, confpassOtp).addToBackStack(null).commit();
            }//end of inner if
            else Snackbar.make(otp_containerid,"Your OTP mismatch", Snackbar.LENGTH_LONG).show();
        }//end of outer else
    }//end of match otp method

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }

}//end of main class