package com.example.reax.ggr.Jobseeker;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.example.reax.ggr.POJO_Classes.FetchUserDataPOJO1;
import com.example.reax.ggr.POJO_Classes.FetchUserDataPOJO2;
import com.example.reax.ggr.POJO_Classes.LoginPOJO2;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Jobseeker_personaldetails extends Fragment implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2",ARG_PARAM3="param3";
    String meritalspinnerarray[]={"Select","Single","Married"},
            genderspinnerarray[]={"Select","Male","Female","Transgender"},
            generalspinnerarray[]={"Select","General","OBC","SC/ST","Others"},
            gender_value="null",str_Fname="null",str_Mname="null",str_spousename,
            str_Lname="null",str_fatherFname="null",str_calender="null",str_marital="null",spousename_value="null",
            strnumber,strjobseekreg2add,str_spclztn, str_modepercntg,str_marks,str_year,
            str_bankacc="null",str_ifsc="SBI7833",str_annincome,str_noemplydmeternum,str_noemplydmetercnsptn,str_noemplydmetername,
            str_spinEmpjobtitle,str_spinEmpjobsalary,str_spinEmpjobemployer;
    private String mParam1,mParam2,mParam3;
    TextView textcalndrdate_obj;
    ImageButton iconcalender_obj;
    EditText etxtspousename,etxt_Fname,etxt_Mname,etxt_Lname,etxt_fatherFname;
    Spinner upjsgeneralspinner,upjsgenderspinner,upjsmaritalspinner;
    ArrayList<FetchUserDataPOJO2> userpersonal_list=new ArrayList<>();
    int marital_value=0,category_value=0,userID,intstate_value,intdistrict_value,int_qualification,
            int_skill,intSkillspinr_value=1,int_forgnEmplymnt,int_pvtjob,int_forgnStudy,int_govtjob,int_selfEmplymnt,
            intemploye_value,int_noemplydradiovalue,intjsuppincode;
    ProgressDialog editprsnlprogressbar;
    LinearLayout spouselayout_obj,jsuplinearrLayout_obj;
    LoginPOJO2[] userData_arraylist;
    Retrofitinterfacefile retrofitinterfacefile;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    int userid;
    String outsideTokenno="_KDHudbjadguaigwebbHAY3844";
    Button prsnldtl_submitbtn;

    private OnFragmentInteractionListener mListener;

    public Jobseeker_personaldetails() {
    }//end of constructor
    @SuppressLint("ValidFragment")
    public Jobseeker_personaldetails(ArrayList<FetchUserDataPOJO2> updatedatalist_array) {
        userpersonal_list=updatedatalist_array;
    }//end of constructor

    public static Jobseeker_personaldetails newInstance(String param1, String param2 ,ArrayList<FetchUserDataPOJO2> updatedatalist_array) {
        Jobseeker_personaldetails fragment = new Jobseeker_personaldetails(updatedatalist_array);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, String.valueOf(updatedatalist_array));
        fragment.setArguments(args);
        return fragment; }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View employerpersonal_view= inflater.inflate(R.layout.fragment_jobseeker_personaldetails, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        //Typecaste work
        textcalndrdate_obj=employerpersonal_view.findViewById(R.id.jsupdatecalendertextid);
        iconcalender_obj=employerpersonal_view.findViewById(R.id.jsupdatecalendericonid);
        etxt_Fname=employerpersonal_view.findViewById(R.id.jsupFnameid);
        etxt_Mname=employerpersonal_view.findViewById(R.id.jsupMnameid);
        etxt_Lname=employerpersonal_view.findViewById(R.id.jsupLnameid);
        etxt_fatherFname=employerpersonal_view.findViewById(R.id.jsupfatherFnameid);
        upjsgenderspinner=employerpersonal_view.findViewById(R.id.jsupgenderspinid);
        upjsmaritalspinner=employerpersonal_view.findViewById(R.id.jsupmaritalspinid);
        upjsgeneralspinner=employerpersonal_view.findViewById(R.id.jsupcategoryspinid);
        prsnldtl_submitbtn=employerpersonal_view.findViewById(R.id.jsupsubmitbtnid);
        spouselayout_obj=employerpersonal_view.findViewById(R.id.updatespouselayoutid);
        jsuplinearrLayout_obj=employerpersonal_view.findViewById(R.id.jsupmainlayoutid);
        prsnldtl_submitbtn.setOnClickListener(this);
        iconcalender_obj.setOnClickListener(this);

        //user id getting work
        userData_arraylist=basicComponentsReuse_obj.AppSessionValueGet_method(getActivity());
        userID= Integer.parseInt(userData_arraylist[0].getId());

        //Progressbar work
        editprsnlprogressbar = new ProgressDialog(getActivity(), android.R.style.Theme_DeviceDefault_Light_Dialog);
        editprsnlprogressbar.setMessage("Please wait");
        editprsnlprogressbar.setCancelable(false);
        editprsnlprogressbar.setCanceledOnTouchOutside(false);
        editprsnlprogressbar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //retrofit API work
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        setPersonalData_method();
        return employerpersonal_view;
    }//end of onCreateView method

    private void setPersonalData_method() {
        if(userpersonal_list.size()!=0) {
            etxt_Fname.setText(userpersonal_list.get(0).getFirstName());
            etxt_Mname.setText(userpersonal_list.get(0).getMiddleName());
            Toast.makeText(getActivity(), "Middle name is "+userpersonal_list.get(0).getMiddleName(), Toast.LENGTH_SHORT).show();
            etxt_Lname.setText(userpersonal_list.get(0).getLastName());
            etxt_fatherFname.setText(userpersonal_list.get(0).getFatherFirstName());
            textcalndrdate_obj.setText(userpersonal_list.get(0).getDob());
            gender_value= userpersonal_list.get(0).getGender().trim();
            marital_value= Integer.parseInt(userpersonal_list.get(0).getMaritalStatus());
            str_spousename=userpersonal_list.get(0).getSpouseName();
            if(str_spousename.length()!=0 && !str_spousename.equalsIgnoreCase("null")) etxtspousename.setText(str_spousename);
            category_value= Integer.parseInt(userpersonal_list.get(0).getCategory());
            //spinner work
            basicComponentsReuse_obj.showStaticSpinner_method(getActivity(),generalspinnerarray,upjsgeneralspinner,category_value);
            upjsgeneralspinner.setOnItemSelectedListener(this);
            int gender_pos=basicComponentsReuse_obj.getPositionFromArrayList(genderspinnerarray,gender_value);
            basicComponentsReuse_obj.showStaticSpinner_method(getActivity(),genderspinnerarray,upjsgenderspinner,gender_pos);
            upjsgenderspinner.setOnItemSelectedListener(this);
            upjsgenderspinner.setPrompt(gender_value);
            basicComponentsReuse_obj.showStaticSpinner_method(getActivity(),meritalspinnerarray,upjsmaritalspinner,marital_value);
            upjsmaritalspinner.setOnItemSelectedListener(this);
        }//end of if condition
        else basicComponentsReuse_obj.printToast_method(getActivity(),"Please check your Internet connection or try again later");
    }//end of set Personal data method

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
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;}

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spinner_obj = (Spinner) adapterView;
        switch (spinner_obj.getId()){
            case R.id.jsupgenderspinid:
                if (i>0) {
                    gender_value = genderspinnerarray[i];
                }//end of if condition
                else gender_value = "null";
                break;
            case R.id.jsupmaritalspinid:
                if (i>0) {
                    marital_value = i;
                    if(meritalspinnerarray[i].equals("Married")) showSpouseLayout();
                    else spouselayout_obj.removeAllViews();
                }//end of outer if condition
                else {
                    spouselayout_obj.removeAllViews();
                    marital_value=0;
                }
                break;
            case R.id.jsupcategoryspinid:
                if (i>0) {
                    category_value=i;
                }//end of if condition
                else category_value=0 ;
                break;
        }//end of switch case
        }//end of onItemSelected method

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jsupdatecalendericonid:
                basicComponentsReuse_obj.datetextviewcalender_method(getActivity(),textcalndrdate_obj);
                break;
            case R.id.jsupsubmitbtnid:
                getUserPersonalDetails_method();
                break;
        }//end of switch case
    }//end of onClick method

    public void getUserPersonalDetails_method(){
        str_Fname=etxt_Fname.getText().toString().trim();
        str_Mname=etxt_Mname.getText().toString().trim();
        str_Lname=etxt_Lname.getText().toString().trim();
        str_fatherFname=etxt_fatherFname.getText().toString().trim();
        str_calender=textcalndrdate_obj.getText().toString().trim();
        if(marital_value==2){
            spousename_value=etxtspousename.getText().toString().trim();
        }
        //work of validate fields
        if (str_Fname.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(etxt_Fname,"first name can not be blank");
        else if (str_Lname.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(etxt_Lname,"last name can not be blank");
        else if(str_fatherFname.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(etxt_fatherFname,"father's name can not be blank");
        else if (str_calender.length()==0) basicComponentsReuse_obj.textviewfieldvalidate_method(textcalndrdate_obj,"date can not be blank");
        else if(gender_value.equals("null"))basicComponentsReuse_obj.printSnackBar_method(jsuplinearrLayout_obj,"gender can not be blank");
        else if(marital_value==0)basicComponentsReuse_obj.printSnackBar_method(jsuplinearrLayout_obj,"Marital status can not be blank");
        else if(category_value==0) basicComponentsReuse_obj.printSnackBar_method(jsuplinearrLayout_obj,"Category can not be blank");
        else personaldetailAPIhit_method();
    }//end of get user data method

    private void personaldetailAPIhit_method() {
        editprsnlprogressbar.show();
        remainingParameters_values();

        Call<ResponseBody> submitData = retrofitinterfacefile.updateUserdata_method(userID,str_Fname,str_Mname, str_Lname,
                gender_value, "1994", marital_value, spousename_value,str_fatherFname,strnumber, strjobseekreg2add,
                intstate_value,intdistrict_value, intjsuppincode,int_qualification,str_spclztn, str_modepercntg,
                str_marks, str_year, int_skill, intSkillspinr_value, int_forgnEmplymnt, int_pvtjob,int_forgnStudy,
                int_govtjob, int_selfEmplymnt, category_value, str_bankacc, str_ifsc, str_annincome, intemploye_value,
                int_noemplydradiovalue,str_noemplydmeternum,str_noemplydmetercnsptn, str_noemplydmetername,
                str_spinEmpjobtitle, str_spinEmpjobsalary, str_spinEmpjobemployer );
        submitData.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getInt("status") == 1) {
                            String update_message=jsonObject.getString("message");
//                            //get User details API work
//                           ArrayList<FetchUserDataPOJO2> userpersonal_list_obj=new ArrayList<>();
//                            userpersonal_list_obj =basicComponentsReuse_obj.getUserProfileAllData_method(getActivity(),userID,editprsnlprogressbar);
                          // userpersonal_list=userpersonal_list_obj;
//                           Toast.makeText(getActivity(), "again user details list first name is "+userpersonal_list_obj.get(0).getFirstName(), Toast.LENGTH_SHORT).show();
                            fetchAllData_method();
                            setPersonalData_method();
                            editprsnlprogressbar.dismiss();
                            Toast.makeText(getActivity(), ""+update_message, Toast.LENGTH_SHORT).show();
//                            Log.d("Jobseekerreg3", "onResponse: " + Retrofitinstancefile.base_url + "update-jobseeker?"+"id="+userID +"&"+ "firstName=" + str_Fname + "&"
//                                    + "middleName=" + str_Mname + "&" + "lastName=" + str_Lname + "&" + "gender=" + gender_value + "&" + "dob=" + str_calender
//                                    + "&" + "maritalStatus=" + marital_value + "&" + "spouseName=" + spousename_value + "&" + "fatherFirstName=" + str_fatherFname
//                                    + "&" + "mobileNo=" + strnumber + "&" + "address=" + strjobseekreg2add + "&" + "&" + "state=" + intstate_value
//                                    + "&" + "district=" + intdistrict_value + "&" + "pincode=" + intjsuppincode
//                                    + "&" + "qualification=" + int_qualification + "&" + "specialization=" + str_spclztn
//                                    + "&" + "mode=" + str_modepercntg + "&" + "marks=" + str_marks
//                                    + "&" + "year=" + str_year + "&" + "skillLearning=" + int_skill
//                                    + "&" + "sector=" + intSkillspinr_value + "&" + "foreingEmployment=" + int_forgnEmplymnt
//                                    + "&" + "pvtJobs=" + int_pvtjob
//                                    + "&" + "foreignStudy=" + int_forgnStudy + "&" + "govtJobs=" + int_govtjob + "&"
//                                    + "selfEmployment=" + int_selfEmplymnt + "&" + "category=" + category_value + "&" + "bankAccountNo=" + str_bankacc
//                                    + "&" + "IFSCcode=" + str_ifsc + "&" + "annualFamilyIncome=" + str_annincome
//                                    + "&" + "employement=" + intemploye_value + "&" + "familyEmp=" + int_noemplydradiovalue
//                                    + "&" + "meterNumber=" + str_noemplydmeternum + "&" + "avgConsumption=" + str_noemplydmetercnsptn
//                                    + "&" + "holderName=" + str_noemplydmetername + "&" + "jobTitle=" + str_spinEmpjobtitle
//                                    + "&" + "jobSalary=" + str_spinEmpjobsalary + "&" + "jobEmployer=" + str_spinEmpjobemployer)
                        }//end of inner if condition
                        else {
                            editprsnlprogressbar.dismiss();
                            basicComponentsReuse_obj.printToast_method(getActivity(), "Already Updated");
//                            Log.d("Jobseekerreg3", "onResponse: " + Retrofitinstancefile.base_url + "update-jobseeker?"+"id="+userID +"&"+ "firstName=" + str_Fname + "&"
//                                    + "middleName=" + str_Mname + "&" + "lastName=" + str_Lname + "&" + "gender=" + gender_value + "&" + "dob=" + str_calender
//                                    + "&" + "maritalStatus=" + marital_value + "&" + "spouseName=" + spousename_value + "&" + "fatherFirstName=" + str_fatherFname
//                                    + "&" + "mobileNo=" + strnumber + "&" + "address=" + strjobseekreg2add + "&" + "&" + "state=" + intstate_value
//                                    + "&" + "district=" + intdistrict_value + "&" + "pincode=" + intjsuppincode
//                                    + "&" + "qualification=" + int_qualification + "&" + "specialization=" + str_spclztn
//                                    + "&" + "mode=" + str_modepercntg + "&" + "marks=" + str_marks
//                                    + "&" + "year=" + str_year + "&" + "skillLearning=" + int_skill
//                                    + "&" + "sector=" + intSkillspinr_value + "&" + "foreingEmployment=" + int_forgnEmplymnt
//                                    + "&" + "pvtJobs=" + int_pvtjob
//                                    + "&" + "foreignStudy=" + int_forgnStudy + "&" + "govtJobs=" + int_govtjob + "&"
//                                    + "selfEmployment=" + int_selfEmplymnt + "&" + "category=" + category_value + "&" + "bankAccountNo=" + str_bankacc
//                                    + "&" + "IFSCcode=" + str_ifsc + "&" + "annualFamilyIncome=" + str_annincome
//                                    + "&" + "employement=" + intemploye_value + "&" + "familyEmp=" + int_noemplydradiovalue
//                                    + "&" + "meterNumber=" + str_noemplydmeternum + "&" + "avgConsumption=" + str_noemplydmetercnsptn
//                                    + "&" + "holderName=" + str_noemplydmetername + "&" + "jobTitle=" + str_spinEmpjobtitle
//                                    + "&" + "jobSalary=" + str_spinEmpjobsalary + "&" + "jobEmployer=" + str_spinEmpjobemployer);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }//end of if condition
                else {
                    editprsnlprogressbar.dismiss();
                    basicComponentsReuse_obj.printToast_method(getActivity(), "Something went wrong . Please try again");
                }
            }//end of onResponse method

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                editprsnlprogressbar.dismiss();
                basicComponentsReuse_obj.printToast_method(getActivity(), "Check internet connection or Server Problem");
            }//end of onFailure method
        });

    }//end of personal details API hit method

    private void fetchAllData_method() {

        Call<FetchUserDataPOJO1> userProfileData=retrofitinterfacefile.getUserProfile_method(outsideTokenno,userid);
        userProfileData.enqueue(new Callback<FetchUserDataPOJO1>() {
            @Override
            public void onResponse(Call<FetchUserDataPOJO1> call, Response<FetchUserDataPOJO1> response) {
                if (response.body()!=null){
                    if (response.body().getStatus().equals(1)){
                        userpersonal_list.add(response.body().getData());
                    }//end of inner if condition
                    else  basicComponentsReuse_obj.printToast_method(getActivity(),"Something went wrong. Please try again");
                }//end of if condition
                else basicComponentsReuse_obj.printToast_method(getActivity(),"Something went wrong. Please try again");
            }//end of onResponse method
            @Override
            public void onFailure(Call<FetchUserDataPOJO1> call, Throwable t) {
                basicComponentsReuse_obj.printToast_method(getActivity(),"Check internet connection or Server Problem");
            }//end of onFailure method
        });

    }//end of fetch All data method

    private void remainingParameters_values() {
        //remaining parameters
        strnumber=userpersonal_list.get(0).getMobileNo();
        strjobseekreg2add=userpersonal_list.get(0).getAddress();
        intstate_value= Integer.parseInt(userpersonal_list.get(0).getState());
        intdistrict_value= Integer.parseInt(userpersonal_list.get(0).getDistrict());
        intjsuppincode= Integer.parseInt(userpersonal_list.get(0).getPincode());
        int_qualification= Integer.parseInt(userpersonal_list.get(0).getQualification0().getId());
        str_spclztn=userpersonal_list.get(0).getSpecialization();
        str_modepercntg=userpersonal_list.get(0).getPerType();
        str_marks=userpersonal_list.get(0).getTotalMarks();
        str_year=userpersonal_list.get(0).getYear();
        int_skill= Integer.parseInt(userpersonal_list.get(0).getSkillLearning());
       // intSkillspinr_value= (int) userpersonal_list.get(0).getSectorId();
        int_forgnEmplymnt= Integer.parseInt(userpersonal_list.get(0).getForiegnEmployment());
        int_pvtjob= Integer.parseInt(userpersonal_list.get(0).getPvtJob());
        int_forgnStudy= Integer.parseInt(userpersonal_list.get(0).getForiegnStudy());
        int_govtjob= Integer.parseInt(userpersonal_list.get(0).getGovtJob());
        int_selfEmplymnt= Integer.parseInt(userpersonal_list.get(0).getSelfEmployment());
        str_bankacc=userpersonal_list.get(0).getBankAccountNo();
        //str_ifsc=userpersonal_list.get(0).getIfscCode();
        str_annincome=userpersonal_list.get(0).getAnnualFamilyIncome();
        intemploye_value= Integer.parseInt(userpersonal_list.get(0).getEmployement());
        int_noemplydradiovalue= Integer.parseInt(userpersonal_list.get(0).getFamilyEmp());
        str_noemplydmeternum=userpersonal_list.get(0).getMeterNumber();
        str_noemplydmetercnsptn=userpersonal_list.get(0).getMeterAvg();
        str_noemplydmetername=userpersonal_list.get(0).getMeterHolderName();
        str_spinEmpjobtitle=userpersonal_list.get(0).getJobTitle();
        str_spinEmpjobsalary=userpersonal_list.get(0).getJobSalary();
        str_spinEmpjobemployer=userpersonal_list.get(0).getJobEmployer();
    }//end of remaining parameters values method

    private void showSpouseLayout() {
        LayoutInflater layoutInflater =(LayoutInflater)getActivity(). getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View spouseView = layoutInflater.inflate(R.layout.spousenamelayout, null);
        etxtspousename=spouseView.findViewById(R.id.spousenameid);
        spouselayout_obj.removeAllViews();
        spouselayout_obj.addView(spouseView);
    }//end of show spouse layout method

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class