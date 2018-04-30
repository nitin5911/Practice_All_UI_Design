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
import android.widget.Button;
import android.widget.EditText;

import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

public class Changepass_frag extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    Toolbar changepasstool_obj;
    EditText etxt_oldpass,etxt_newpass,etxt_confpass;
    String str_oldpass,str_newpass,str_confpass;
    Button cp_submitbtn;
    ProgressDialog changepassprogressbar;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    Retrofitinterfacefile retrofitinterfacefile;


    private OnFragmentInteractionListener mListener;
    public Changepass_frag() { }
    public static Changepass_frag newInstance(String param1, String param2) {
        Changepass_frag fragment = new Changepass_frag();
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
        View changepass_view= inflater.inflate(R.layout.fragment_changepass_frag, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        setHasOptionsMenu(true);
        //Type caste work
        changepasstool_obj=changepass_view.findViewById(R.id.jsCPchangepasstoolid);
        etxt_oldpass=changepass_view.findViewById(R.id.jsCPoldpasswordid);
        etxt_newpass=changepass_view.findViewById(R.id.jsCPnewpasswordid);
        etxt_confpass=changepass_view.findViewById(R.id.jsCPconfpasswordid);
        cp_submitbtn=changepass_view.findViewById(R.id.jsCPsubmitid);
        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(),"mainActfragmentsshow","jsmainchangepassfrag","1");
        //Progress dialog work
        changepassprogressbar=basicComponentsReuse_obj.showProgressBar_method(getActivity(),changepassprogressbar);
        //Toolbar work
        basicComponentsReuse_obj.innerfragToolbarShow_method(getActivity(),changepasstool_obj,"Change Your Password","mainActfragmentsshow");
        cp_submitbtn.setOnClickListener(this);
        return changepass_view;
    }//end of onCreate method
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }//end of option menu method

    private void setpassword_method() {
        str_oldpass = etxt_oldpass.getText().toString().trim();
        str_newpass = etxt_newpass.getText().toString().trim();
        str_confpass = etxt_confpass.getText().toString().trim();
        if (str_oldpass.length() == 0) basicComponentsReuse_obj.editTextfieldvalidate_method(etxt_oldpass,"Please enter the old password");
        else if (str_newpass.length() == 0) basicComponentsReuse_obj.editTextfieldvalidate_method(etxt_newpass,"Please enter the new password");
        else if (str_confpass.length() == 0) basicComponentsReuse_obj.editTextfieldvalidate_method(etxt_confpass,"Please enter the confirm password");
        else if (!str_newpass.equals(str_confpass)) basicComponentsReuse_obj.editTextfieldvalidate_method(etxt_newpass,"password did not match");
        else changepassword();
    }//end fo setpassword method

    private void changepassword() {
        //Show Progressbar
        changepassprogressbar.show();
//        Call<Changedpasspojo> changedpasspojoCall_obj=retrofitinterfacefile.changepassword_method(driverid,oldpassstr,newpassstr);
//        changedpasspojoCall_obj.enqueue(new Callback<Changedpasspojo>() {
//            @Override
//            public void onResponse(Call<Changedpasspojo> call, Response<Changedpasspojo> response) {
//                if (response.body()!=null){
//                    if (response.body().getStatus().toString().equals("1")){
//                        changepassprogressbar.dismiss();
//                    }//end of inner if
//                    else {
//                        changepassprogressbar.dismiss();
//                        basicComponentsReuse_obj.printToast_method(getActivity(),"Please check your Old Password");
//                    }//end of inner else
//                }//end of outer if
//                else{
//                    changepassprogressbar.dismiss();
//                    basicComponentsReuse_obj.printToast_method(getActivity(),"Something went wrong please try after some time");
//                }//end of outer else
//            }//end of onResponse method
//            @Override
//            public void onFailure(Call<Changedpasspojo> call, Throwable t) {
//                changepassprogressbar.dismiss();
//                basicComponentsReuse_obj.printToast_method(getActivity(),"Please check your internet connection or server problem");
//            }//end of onFailure method
//        });
    }//end of changepassword API method

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri); }}
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
      //      throw new RuntimeException(context.toString()
        //            + " must implement OnFragmentInteractionListener");
        } }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jsCPsubmitid:
                setpassword_method();
                break;
        }//end of switch case
    }//end of onClick method

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
