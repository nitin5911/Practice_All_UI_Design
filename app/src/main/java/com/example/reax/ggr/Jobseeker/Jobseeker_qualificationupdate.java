package com.example.reax.ggr.Jobseeker;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.POJO_Classes.FetchUserDataPOJO2;
import com.example.reax.ggr.R;

import java.util.ArrayList;


public class Jobseeker_qualificationupdate extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2",ARG_PARAM3="param3";
    private String mParam1,mParam2,mParam3;
    ImageButton seekforimg_obj;
    TextView jobseektxt_obj;
    Button jsupqualupbtn;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6;
    AlertDialog dialog_obj;
    Spinner jobseekupdatequalyspinner_obj,jobseekupdatespeclspnr_obj,jobseekupdatefmlyspnr_obj,jshighqualispnr_obj,
            jobseekqualispnr_obj,jobseekspeclztionspnr_obj,jobseekpercntspnr_obj,jobseekupdateempspnr_obj;
    private OnFragmentInteractionListener mListener;
    String incomearray[] = {"Please Select", "1 lac or less", "2 lac or less", "3 lac or less", "more than 3 lac"},
            str_bankacc="null", str_ifsc="null", str_marks="null",
            percentagearray[] = {"Please Select", "Not Applicable", "CGPA", "Percentage"},familyinc_value, str_spclztn="null",
            str_modepercntg="null", str_annincome="null";
    ArrayList<FetchUserDataPOJO2> userqualification_list=new ArrayList<>();
    ArrayList<Integer> highqualifnspinnerlist = new ArrayList<>(),qualificationspinnerlist = new ArrayList<>();
    ArrayList<String> specializationspinnerlist = new ArrayList<>();
    BasicComponentsReuse basicComponentsReuse_obj=null;
    int spclindex_value,qualindex_value,int_highqualification = 0,int_qualification = 0,int_familyincome=0,int_prcntvalue=0;
    String str_speciliztion,jobseekpercnt_value ;
    EditText etxt_bankacc,etxt_bankifsc,passyear_etxt,marks_etxt;


    @SuppressLint("ValidFragment")
    public Jobseeker_qualificationupdate(ArrayList<FetchUserDataPOJO2> updatedatalist_array) {
        userqualification_list=updatedatalist_array;
    }//end of constructor
    public Jobseeker_qualificationupdate() {}//end of constructor
    public static Jobseeker_qualificationupdate newInstance(String param1, String param2,ArrayList<FetchUserDataPOJO2> updatedatalist_array) {
        Jobseeker_qualificationupdate fragment = new Jobseeker_qualificationupdate(updatedatalist_array);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, String.valueOf(updatedatalist_array));
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View employerqualification_view= inflater.inflate(R.layout.fragment_jobseeker_qualificationupdate, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();

        //type caste work
        etxt_bankacc = employerqualification_view.findViewById(R.id.jsupbnkaccid);
        etxt_bankifsc = employerqualification_view.findViewById(R.id.jsupbnkifscid);
        jobseekupdatefmlyspnr_obj = employerqualification_view.findViewById(R.id.jsupfmlyincmspnrid);
        jshighqualispnr_obj = employerqualification_view.findViewById(R.id.jsuphighqualfctnspnrid);
        jobseekqualispnr_obj = employerqualification_view.findViewById(R.id.jsupqualfctnspnrid);
        jobseekspeclztionspnr_obj = employerqualification_view.findViewById(R.id.jsupspclztnspnrid);
        passyear_etxt = employerqualification_view.findViewById(R.id.jsupyearid);
        jobseekpercntspnr_obj = employerqualification_view.findViewById(R.id.jsupcgpapercntspinid);
        marks_etxt = employerqualification_view.findViewById(R.id.jsupobtainedmarksid);
        jsupqualupbtn = employerqualification_view.findViewById(R.id.jsupqualupbtnid);
        jsupqualupbtn.setOnClickListener(this);
        setqualifctnData_method();
        return employerqualification_view;
    }//end of onCreate View method

    private void setqualifctnData_method() {
        if(userqualification_list.size()!=0&& !userqualification_list.equals(null)) {
            etxt_bankacc.setText(userqualification_list.get(0).getBankAccountNo());
            etxt_bankifsc.setText(userqualification_list.get(0).getIfscCode());

            //Family Annual Income work
            familyinc_value= userqualification_list.get(0).getAnnualFamilyIncome();
            int_familyincome=basicComponentsReuse_obj.getPositionFromArrayList(incomearray,familyinc_value);
            //Family Annual Income work
//            SpinnerAdapterfile spinnerFincome_obj = new SpinnerAdapterfile(getActivity(), incomearray);
//            jobseekupdatefmlyspnr_obj.setAdapter(spinnerFincome_obj);
//            jobseekupdatefmlyspnr_obj.setOnItemSelectedListener(this);
            Toast.makeText(getActivity(), "family income index value is "+int_familyincome, Toast.LENGTH_SHORT).show();
            basicComponentsReuse_obj.showStaticSpinner_method(getActivity(),incomearray,jobseekupdatefmlyspnr_obj,int_familyincome+1);
            jobseekupdatefmlyspnr_obj.setOnItemSelectedListener(this);


            int_highqualification= Integer.parseInt(userqualification_list.get(0).getQualification0().getQualiCategoryId());
            int_qualification= Integer.parseInt(userqualification_list.get(0).getQualification0().getId());
            str_speciliztion=userqualification_list.get(0).getSpecialization();
            //Highest Qualification spinner work
            highqualifnspinnerlist = basicComponentsReuse_obj.showHighQualificationSpinner_method(getActivity(), jshighqualispnr_obj, int_highqualification);
            jshighqualispnr_obj.setOnItemSelectedListener(this);
            //Qualification Spinner work
            qualificationspinnerlist = basicComponentsReuse_obj.showQualificationSpinner_method(getActivity(), jobseekqualispnr_obj, int_highqualification);
            qualindex_value=basicComponentsReuse_obj.getPositionFromIntArrayList(qualificationspinnerlist,int_qualification);
            jobseekqualispnr_obj.setOnItemSelectedListener(this);
            // Specialization spinner work
            specializationspinnerlist = basicComponentsReuse_obj.showSpecializationSpinner_method(getActivity(), jobseekspeclztionspnr_obj, int_qualification);
            spclindex_value=basicComponentsReuse_obj.getPositionFromArrayList(specializationspinnerlist,str_speciliztion);
            jobseekspeclztionspnr_obj.setOnItemSelectedListener(this);

            passyear_etxt.setText(userqualification_list.get(0).getYear());
            //Percentage Spinner work
            jobseekpercnt_value=userqualification_list.get(0).getPerType();
            int_prcntvalue=basicComponentsReuse_obj.getPositionFromArrayList(percentagearray,jobseekpercnt_value);
            basicComponentsReuse_obj.showStaticSpinner_method(getActivity(),percentagearray,jobseekpercntspnr_obj,int_prcntvalue);
            jobseekpercntspnr_obj.setOnItemSelectedListener(this);

            marks_etxt.setText(userqualification_list.get(0).getTotalMarks());

//            SpinnerAdapterfile spinnerpercnt_obj = new SpinnerAdapterfile(getActivity(), percentagearray);
//            jobseekpercntspnr_obj.setAdapter(spinnerpercnt_obj);
//            jobseekpercntspnr_obj.setPrompt(jobseekpercnt_value);
//            jobseekpercntspnr_obj.setOnItemSelectedListener(this);
        }//end of if condition
        else basicComponentsReuse_obj.printToast_method(getActivity(),"Please check your Internet connection or try again later");
    }//end of set Personal data method
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri); }}

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
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spinner_obj = (Spinner) adapterView;
        switch (spinner_obj.getId()) {
            case R.id.jsuphighqualfctnspnrid:
                if (i > 0) {
                    Toast.makeText(getActivity(), "High qualification greater i is 0 is calling", Toast.LENGTH_SHORT).show();
                    int_highqualification = highqualifnspinnerlist.get(i);
                    // Qualification spinner work
                    if (int_highqualification != 0) {
                        jobseekqualispnr_obj.setEnabled(true);
                        jobseekqualispnr_obj.setClickable(true);
                        jobseekqualispnr_obj.setSelection(qualindex_value+1);
                    }//end of if condition
                } else {
                    jobseekqualispnr_obj.setEnabled(false);
                    jobseekqualispnr_obj.setClickable(false);
                    jobseekqualispnr_obj.setSelection(0);
                    jobseekspeclztionspnr_obj.setEnabled(false);
                    jobseekspeclztionspnr_obj.setClickable(false);
                    jobseekspeclztionspnr_obj.setSelection(0);
                    int_highqualification = 0;
                }//end of else condition
                break;
            case R.id.jsupqualfctnspnrid:
                if (i > 0) {
                    Toast.makeText(getActivity(), "Qualification greater i is 0 is calling", Toast.LENGTH_SHORT).show();
                    int_qualification =qualificationspinnerlist.get(i);
                    if (int_qualification != 0) {
                        jobseekspeclztionspnr_obj.setEnabled(true);
                        jobseekspeclztionspnr_obj.setClickable(true);
                        jobseekspeclztionspnr_obj.setSelection(spclindex_value+1);
                    }//end of if condition
                } else {
                    jobseekspeclztionspnr_obj.setEnabled(false);
                    jobseekspeclztionspnr_obj.setClickable(false);
                    jobseekspeclztionspnr_obj.setSelection(0);
                    int_qualification = 0;
                }
                break;
            case R.id.jsupspclztnspnrid:
                if (i > 0) {
                    str_spclztn = String.valueOf(specializationspinnerlist.get(i));
                } else str_spclztn = "null";
                break;
            case R.id.jsupfmlyincmspnrid:
                if (i > 0) {
                    str_annincome = String.valueOf(i);
                } else{
                    str_annincome = "null";
                }
                break;

            case R.id.jsupcgpapercntspinid:
                if (i > 0) {
                    str_modepercntg = String.valueOf(i);
                } else str_modepercntg = "null";
                break;
        }//end of switch case
    }//end of onItemSelected method

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.jobseekforid:
//                Toast.makeText(getActivity(), "press", Toast.LENGTH_SHORT).show();
//                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
//                builder.setTitle("Please choose atleast one");
//                builder.setCancelable(false);
//
//                LayoutInflater inflater = getActivity().getLayoutInflater();
//                View view1 = inflater.inflate(R.layout.seekingfordesign, null);
//                builder.setView(view1);
//                cancel=view1.findViewById(R.id.seekingdesigncancelbtnid);
//                submit =view1.findViewById(R.id.seekingdesignsubmitbtnid);
//                checkBox1=view1.findViewById(R.id.checkbox1id);
//                checkBox2=view1.findViewById(R.id.checkbox2id);
//                checkBox3=view1.findViewById(R.id.checkbox3id);
//                checkBox4=view1.findViewById(R.id.checkbox4id);
//                checkBox5=view1.findViewById(R.id.checkbox5id);
//                checkBox6=view1.findViewById(R.id.checkbox6id);
//                cancel.setOnClickListener(this);
//                submit.setOnClickListener(this);
//                dialog_obj = builder.create();
//                dialog_obj.show();
//
//                break;
//            case R.id.seekingdesigncancelbtnid:
//                dialog_obj.dismiss();
//                break;
//            case R.id.seekingdesignsubmitbtnid:
//                seekingdetails();
//                dialog_obj.dismiss();
//                break;
//        }
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
