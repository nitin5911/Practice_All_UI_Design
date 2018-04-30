package com.example.reax.ggr.Common_Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.R;

public class Forget_frag extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    EditText edt_email;
    Button btnforgot;
    LinearLayout forget_containerid,forgetttool_containerid;
    Toolbar forgettoolbar;
    // Retrofitinterfacefile retrofitinterfacefile_obj;
    SharedPreferences.Editor preference;
    String forget_status="0";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog forgetprogressbar;
    String edittextemail,useremail,userid,userotp;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    private OnFragmentInteractionListener mListener;

    public Forget_frag() {
        // Required empty public constructor
    }
    public static Forget_frag newInstance(String param1, String param2) {
        Forget_frag fragment = new Forget_frag();
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
        View forget_view= inflater.inflate(R.layout.fragment_forgot, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        //Type caste work
        forget_containerid= forget_view.findViewById(R.id.forget_containerid);
        forgetttool_containerid= forget_view .findViewById(R.id.forgettool_containerid);
        btnforgot=forget_view.findViewById(R.id.btnforgot);
        edt_email= forget_view. findViewById(R.id.edt_password);

        //Toolbar work
        forgettoolbar=forget_view.findViewById(R.id.forgettoolbarid);
        basicComponentsReuse_obj.signupToolbarShow_method(getActivity(),forgettoolbar,"Forget Password","forgetfragmentsshow");
        btnforgot.setOnClickListener(this);
        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(),"forgetfragmentsshow","forget1fragvisible","1");
    return forget_view;
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
        //    throw new RuntimeException(context.toString()
        //            + " must implement OnFragmentInteractionListener");
        } }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnforgot:
                Otp_frag otpFrag =new Otp_frag();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainloginlayoutid, otpFrag).addToBackStack(null).commit();

               // forgetpass_method();
        }//end of switch case
    }//end of onClick method
    private void forgetpass_method() {
        edittextemail=edt_email.getText().toString().trim();
        if (edittextemail.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(edt_email,"Please enter your Phone number");
        else if (!edittextemail.matches(emailPattern)) basicComponentsReuse_obj.editTextfieldvalidate_method(edt_email,"Please enter Valid email");
        else {
            Otp_frag otpFrag =new Otp_frag();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainloginlayoutid, otpFrag).addToBackStack(null).commit();
            basicComponentsReuse_obj.sharedclear_method(getActivity(),"forgetfragmentsshow");
        }//end of else condition
    }//end of forgetpaa_method
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
