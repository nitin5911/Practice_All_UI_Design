package com.example.reax.ggr.Common_Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.reax.ggr.Common_Activity.Login;
import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.R;

public class ConfpassOtp extends Fragment implements View.OnClickListener{

    String newpaswd1,confirmpass1;
    ProgressDialog confpassprogressbar;
    private static final String ARG_PARAM1 = "param1", ARG_PARAM2 = "param2";
    Button btnpasssaveid;
    private String mParam1, mParam2;
    EditText newpaswd,confirmpaswd;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    private Otp_frag.OnFragmentInteractionListener mListener;

    public ConfpassOtp() { }
    public static ConfpassOtp newInstance(String param1, String param2) {
        ConfpassOtp fragment = new ConfpassOtp();
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
        View confpass_view = inflater.inflate(R.layout.fragment_conf_pass_otp, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        //Type caste work
        newpaswd=confpass_view.findViewById(R.id.newpasswd);
        confirmpaswd=confpass_view.findViewById(R.id.confirmpass);
        btnpasssaveid=(Button)confpass_view.findViewById(R.id.btnpasssaveid);
        //Onclick listener work
        btnpasssaveid.setOnClickListener(this);

        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(),"forgetfragmentsshow","forget1fragvisible","1");
        return  confpass_view;
    }//end of onCreateView method
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri); }}
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Otp_frag.OnFragmentInteractionListener) {
            mListener = (Otp_frag.OnFragmentInteractionListener) context;
        } else {
      //      throw new RuntimeException(context.toString()
      //              + " must implement OnFragmentInteractionListener");
        } }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnpasssaveid:
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
                getActivity().finish();
                //savepassword();
        }//end of switch case
    }//end of onClick method

    private void savepassword() {
       newpaswd1=newpaswd.getText().toString().trim();
       confirmpass1=confirmpaswd.getText().toString().trim();
        if (newpaswd1.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(newpaswd,"please enter the password");
        else if(confirmpass1.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(confirmpaswd,"please enter the password");
        else if(!(newpaswd1.equals(confirmpass1))) basicComponentsReuse_obj.editTextfieldvalidate_method(confirmpaswd,"Your Password mismatch");
        else passwordchangedAPI();
    }//end of savepassword method

    private void passwordchangedAPI() {
        basicComponentsReuse_obj.sharedclear_method(getActivity(),"forgetfragmentsshow");
        Intent intent = new Intent(getActivity(), Login.class);
        startActivity(intent);
        getActivity().finish();
    }//end of passwordchanged API method
}//end of main class