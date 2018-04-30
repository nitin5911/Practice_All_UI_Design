package com.example.reax.ggr.Jobseeker;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.R;

import java.util.ArrayList;

public class Jobseekerreg1 extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    String  mParam1,mParam2,
            meritalspinnerarray[]={"Select","Single","Married"},
            genderspinnerarray[]={"Select","Male","Female","Transgender"},
            generalspinnerarray[]={"Select","General","OBC","SC/ST","Others"},
            strfname="null",strMname="null",strlname="null",strfatherfname="null",gender_value="null",
            stremail="null",strnumber="null",
            str_etxt_OTP,otp_value,
            otp_msg="Your One time password for Mobile number validation is",spousename_value="null",
            emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+",str_dobValue="null";
    int marital_value=0,category_value=0;
    private OnFragmentInteractionListener mListener;
    Button Submit;
    TextView edtdate_obj,gendertextview,resendtxt_otp,maritaltxtview,catgrytxtview,exptimetxt_otp;
    EditText jobseekfname_obj,jobseekmname_obj,
            jobseeklname_obj,jobseekfatherfname_obj,
            jobseekemail_obj,jobseeknumber_obj,etxt_enter_otp,etxtspousename;
    ImageButton calender_obj;
    Spinner jobseek1generalspinner,jobseek1genderspinner,jobseekmaritalspinner;
    Toolbar jobseekerreg1tool_obj;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    LayoutInflater layoutInflater;
    AlertDialog dialog_obj;
    int otpBoxShow=0;
    LinearLayout mainlinearLayout_obj,spouselayout_obj;
    ArrayList<String> regAllData_listobj=new ArrayList<>();

    public Jobseekerreg1() {}
    public static Jobseekerreg1 newInstance(String param1, String param2) {
        Jobseekerreg1 fragment = new Jobseekerreg1();
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
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_jobseekerreg1, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        layoutInflater =(LayoutInflater)getActivity(). getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Toolbar work
        jobseekerreg1tool_obj=view.findViewById(R.id.jobseekerreg1toolbarid);
        basicComponentsReuse_obj.signupToolbarShow_method(getActivity(),jobseekerreg1tool_obj,"Registration","regfragmentsshow");
        //Type caste work
        Submit=view.findViewById(R.id.submitregister1id);
        edtdate_obj=view.findViewById(R.id.txtdateid);
        jobseek1generalspinner=view.findViewById(R.id.jobseek1spinnerid);
        jobseek1genderspinner=view.findViewById(R.id.jobseek1genderspinnerid);
        jobseekmaritalspinner=view.findViewById(R.id.jobseek1maritalspinnerid);
        calender_obj=view.findViewById(R.id.imgcalenderid);
        jobseekfname_obj=view.findViewById(R.id.jobseekfnameid);
        jobseekmname_obj=view.findViewById(R.id.jobseekmnameid);
        jobseekemail_obj=view.findViewById(R.id.jobseekemailid);
        jobseeklname_obj=view.findViewById(R.id.jobseeklnameid);
        jobseekfatherfname_obj=view.findViewById(R.id.jobseekfatherfnameid);
        jobseeknumber_obj=view.findViewById(R.id.jobseekmobileid);
        gendertextview=view.findViewById(R.id.genderspintxtid);
        maritaltxtview=view.findViewById(R.id.maritalspntxtid);
        catgrytxtview=view.findViewById(R.id.categoryspintxtid);
        mainlinearLayout_obj=view.findViewById(R.id.jobseek1layoutid);
        spouselayout_obj=view.findViewById(R.id.spouselayoutid);
        //work of Onclick listener
        Submit.setOnClickListener(this);
        calender_obj.setOnClickListener(this);
        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(),"regfragmentsshow","reg1fragvisible","1");
        //spinner work
        basicComponentsReuse_obj.showStaticSpinner_method(getActivity(),generalspinnerarray,jobseek1generalspinner,0);
        jobseek1generalspinner.setOnItemSelectedListener(this);
        basicComponentsReuse_obj.showStaticSpinner_method(getActivity(),genderspinnerarray,jobseek1genderspinner,0);
        jobseek1genderspinner.setOnItemSelectedListener(this);
        basicComponentsReuse_obj.showStaticSpinner_method(getActivity(),meritalspinnerarray,jobseekmaritalspinner,0);
        jobseekmaritalspinner.setOnItemSelectedListener(this);
        return view;
    }//end of onCreateView method

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);}}
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
//            throw new RuntimeException(context.toString()
         //           + " must implement OnFragmentInteractionListener");
        }}
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;}
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.submitregister1id:
              submitreg1_method();
                break;
            case R.id.imgcalenderid:
                basicComponentsReuse_obj.datetextviewcalender_method(getActivity(),edtdate_obj);
                break;
        }//end of switch case statement
    }//end of onClick method

    private void submitreg1_method(){
        //Work of getting values from edit text
        strfname=jobseekfname_obj.getText().toString().trim();
        strlname=jobseeklname_obj.getText().toString().trim();
        strfatherfname=jobseekfatherfname_obj.getText().toString().trim();
        stremail=jobseekemail_obj.getText().toString().trim();
        strnumber=jobseeknumber_obj.getText().toString().trim();
        str_dobValue=edtdate_obj.getText().toString().trim();
        if(marital_value==2){
            spousename_value=etxtspousename.getText().toString().trim();
        }
        //work of validate fields
    if (strfname.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(jobseekfname_obj,"Enter the first name");
    else if (strlname.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(jobseeklname_obj,"Enter the last name");
   else if(strfatherfname.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(jobseekfatherfname_obj,"Enter father  first name");
   else if (str_dobValue.length()==0) basicComponentsReuse_obj.textviewfieldvalidate_method(edtdate_obj,"Please select the date");
    else if(gender_value.equals("null"))basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj,"Select your gender");
    else if(marital_value==0)basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj,"Select your Marital status");
   else if (stremail.length()!=0&& !stremail.matches(emailPattern)) basicComponentsReuse_obj.editTextfieldvalidate_method(jobseekemail_obj,"Please enter the valid email");
        else if (strnumber.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(jobseeknumber_obj,"Please enter the number");
    else if(category_value==0) basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj,"Select your Category");
    else if (stremail.length()!=0 && stremail.matches(emailPattern) ) {
        otpBoxShow=basicComponentsReuse_obj.isEmailValidApi_method(mainlinearLayout_obj, stremail);
        if(otpBoxShow==1) showOTPAlertbox_method();
    }else showOTPAlertbox_method();
    }//end of submit method

    public void matchOTP_method(){
        //Validate OTP
        str_etxt_OTP = etxt_enter_otp.getText().toString().trim();
        if(str_etxt_OTP.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(etxt_enter_otp,"Enter Your OTP");
        else if (otp_value.equals(str_etxt_OTP)) {
           ArrayList<String> sendDataArrayList_obj= addAllUserData_method();
            dialog_obj.dismiss();
            basicComponentsReuse_obj.sharedclear_method(getActivity(),"regfragmentsshow");
            Jobseekerreg2 jobseekerreg2_obj = new Jobseekerreg2(sendDataArrayList_obj);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainloginlayoutid, jobseekerreg2_obj).addToBackStack(null).commit();
        } else Toast.makeText(getActivity(), "OTP Mismatch ", Toast.LENGTH_SHORT).show();
    }//end of match OTP method

    public void showOTPAlertbox_method(){
        otpBoxShow=0;
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View otp_view = inflater.inflate(R.layout.otpverifyalertbox, null);
        builder.setView(otp_view);
        etxt_enter_otp=otp_view.findViewById(R.id.enterotpetxtid);
        final Button otp_Submit_btn=otp_view.findViewById(R.id.submitotpbutonid);
        exptimetxt_otp=otp_view.findViewById(R.id.exptimeotptxtvwid);
        resendtxt_otp=otp_view.findViewById(R.id.resendotptxtvwid);
        //send OTP work
        otp_value=basicComponentsReuse_obj.sendDataforOTP_method(getActivity(),otp_Submit_btn,exptimetxt_otp,otp_msg,strnumber);
        otp_Submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                matchOTP_method();
            }
        });
        resendtxt_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etxt_enter_otp.getText().clear();
                otp_value=basicComponentsReuse_obj.sendDataforOTP_method(getActivity(), otp_Submit_btn, exptimetxt_otp, otp_msg,strnumber);
            }
        });
        dialog_obj = builder.create();
        dialog_obj.show();
    }//end of show OTP Alert box method

    public ArrayList<String> addAllUserData_method(){
        regAllData_listobj.add(strfname);
        regAllData_listobj.add(strMname);
        regAllData_listobj.add(strlname);
        regAllData_listobj.add(strfatherfname);
        regAllData_listobj.add(str_dobValue);
        regAllData_listobj.add(gender_value);
        regAllData_listobj.add(String.valueOf(marital_value));
        regAllData_listobj.add(spousename_value);
        regAllData_listobj.add(stremail);
        regAllData_listobj.add(strnumber);
        regAllData_listobj.add(String.valueOf(category_value));
        return regAllData_listobj;
    }//end of addAllUserData method

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spinner_obj = (Spinner) adapterView;
        switch (spinner_obj.getId()){
            case R.id.jobseek1genderspinnerid:
                if (i>0) {
                    gender_value = genderspinnerarray[i];
                }//end of if condition
                else gender_value = "null";
                break;
            case R.id.jobseek1maritalspinnerid:
                if (i>0) {
                    marital_value = i;
                    if(meritalspinnerarray[i].equals("Married")){
                        showSpouseLayout();
                    }else spouselayout_obj.removeAllViews();
                }//end of outer if condition
                else {
                    spouselayout_obj.removeAllViews();
                    marital_value=0;
                }
                break;
            case R.id.jobseek1spinnerid:
                if (i>0) {
                    category_value=i;
                    }//end of if condition
                else category_value=0 ;
                break;
        }//end of switch case
    }//end of onItemSelected method

    private void showSpouseLayout() {
        LayoutInflater layoutInflater =(LayoutInflater)getActivity(). getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View spouseView = layoutInflater.inflate(R.layout.spousenamelayout, null);
        etxtspousename=spouseView.findViewById(R.id.spousenameid);
        spouselayout_obj.removeAllViews();
        spouselayout_obj.addView(spouseView);
    }//end of show spouse layout method

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);}
}//End of main class