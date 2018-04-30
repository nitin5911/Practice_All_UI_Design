package com.example.reax.ggr.Jobseeker;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.reax.ggr.Adapter.SpinnerAdapterfile;
import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Jobseekerreg3 extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    private static final String ARG_PARAM1 = "param1", ARG_PARAM2 = "param2", ARG_PARAM3 = "param3";
    Button jobseekreg3submit_obj;
    private String mParam1, mParam2;
    Spinner jshighqualispnr_obj, jobseekqualispnr_obj, jobseekspeclztionspnr_obj,
            jobseekpercntspnr_obj, jobseekfamilyincomespnr_obj;
    SharedPreferences.Editor aboutfrag_preference;
    String incomearray[] = {"Please Select", "1 lac or less", "2 lac or less", "3 lac or less", "more than 3 lac"},
            str_bankacc="null", str_ifsc="null", str_marks="null",
            percentagearray[] = {"Please Select", "Not Applicable", "CGPA", "Percentage"},
            strfname="null", strMname="null", strlname="null", strfatherfname="null", gender_value="null",
            stremail="null", strnumber="null", spousename_value="null", str_year="null", str_spclztn="null",
            str_modepercntg="null", str_annincome="null", strjobseekreg2add="null", str_spinEmpjobtitle="null",
            str_spinEmpjobsalary="null",str_spinEmpjobemployer="null", str_noemplydmeternum="null",
            str_noemplydmetercnsptn="null",str_noemplydmetername="null", str_dob="null";
    int int_highqualification = 0, int_qualification = 0, int_termsbox = 0, marital_value = 0, category_value = 0,
            strjobseekreg2pincode = 0, intstate_value = 0, intdistrict_value = 0, intemploye_value = 0, intSkillspinr_value=1,
            int_skill = 0, int_forgnEmplymnt = 0, int_pvtjob = 0, int_forgnStudy = 0, int_govtjob = 0,int_selfEmplymnt = 0,
            int_noemplydradiovalue = 0;

    Date dobDate_obj = new Date(), year_obj = new Date();
    SimpleDateFormat dob_format = new SimpleDateFormat("MM-dd-yyyy");
    SimpleDateFormat year_format = new SimpleDateFormat("yyyy");
    ArrayList<String>  incomespinnerlist = new ArrayList<>(),
             regAllData_listobj = new ArrayList<>();
    ArrayList<Integer>
            qualificationspinnerlist = new ArrayList<>(),highqualifnspinnerlist = new ArrayList<>();
    ArrayList<String> specializationspinnerlist = new ArrayList<>();
    Toolbar jobseekerreg3tool_obj;
    BasicComponentsReuse basicComponentsReuse_obj = null;
    private OnFragmentInteractionListener mListener;
    EditText bankacc_edittxt, bankifsc_edttxt, passyear_etxt, marks_etxt;
    TextView qualificationtxtvw, specializationtxtvw, yeartxtvw, annualincometxtvw;
    CheckBox termscheckbox;
    LinearLayout mainlinearLayout_obj;
    Retrofitinterfacefile retrofitinterfacefile;
    ProgressDialog submitprogressbar;


    public Jobseekerreg3() {
    }//end of bydefault constructor

    @SuppressLint("ValidFragment")
    public Jobseekerreg3(ArrayList<String> sendDataArrayList_obj) {
        regAllData_listobj = sendDataArrayList_obj;
    }//end of parameterized constructor

    public static Jobseekerreg3 newInstance(String param1, String param2, ArrayList<String> sendDataArrayList_obj) {
        Jobseekerreg3 fragment = new Jobseekerreg3(sendDataArrayList_obj);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, String.valueOf(sendDataArrayList_obj));
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View jbskrreg3_view = inflater.inflate(R.layout.fragment_jobseek_reg3, container, false);
        basicComponentsReuse_obj = new BasicComponentsReuse();
        //Toolbar work
        jobseekerreg3tool_obj = jbskrreg3_view.findViewById(R.id.jobseekerreg3toolbarid);
        basicComponentsReuse_obj.signupToolbarShow_method(getActivity(), jobseekerreg3tool_obj, "Registration", "regfragmentsshow");
        //Type Cast work
        bankacc_edittxt = jbskrreg3_view.findViewById(R.id.jobseekreg3bnkaccid);
        bankifsc_edttxt = jbskrreg3_view.findViewById(R.id.jobseekreg3bnkifscid);
        annualincometxtvw = jbskrreg3_view.findViewById(R.id.annualincometxtid);
        jobseekfamilyincomespnr_obj = jbskrreg3_view.findViewById(R.id.jobseekreg3fmlyincmspnrid);
        jshighqualispnr_obj = jbskrreg3_view.findViewById(R.id.jobseekreg3highqualfctnspnrid);
        jobseekqualispnr_obj = jbskrreg3_view.findViewById(R.id.jobseekreg3qualfctnspnrid);
        jobseekspeclztionspnr_obj = jbskrreg3_view.findViewById(R.id.jobseekreg3spclztnspnrid);
        passyear_etxt = jbskrreg3_view.findViewById(R.id.jobseekreg3yearid);
        jobseekpercntspnr_obj = jbskrreg3_view.findViewById(R.id.cgpapercntspinid);
        marks_etxt = jbskrreg3_view.findViewById(R.id.obtainedmarksid);
        termscheckbox = jbskrreg3_view.findViewById(R.id.termscheckboxid);
        jobseekreg3submit_obj = jbskrreg3_view.findViewById(R.id.jobseekreg3submitbtnid);
        mainlinearLayout_obj = jbskrreg3_view.findViewById(R.id.jobseekreg3mainlayoutid);

        //Onclick work
        jobseekreg3submit_obj.setOnClickListener(this);
        termscheckbox.setOnCheckedChangeListener(this);
        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(), "regfragmentsshow", "reg3fragvisible", "1");
        //Family Annual Income work
        SpinnerAdapterfile spinnerFincome_obj = new SpinnerAdapterfile(getActivity(), incomearray);
        jobseekfamilyincomespnr_obj.setAdapter(spinnerFincome_obj);
        jobseekfamilyincomespnr_obj.setOnItemSelectedListener(this);

        //Highest Qualification spinner work
        highqualifnspinnerlist = basicComponentsReuse_obj.showHighQualificationSpinner_method(getActivity(), jshighqualispnr_obj, 0);
        jshighqualispnr_obj.setOnItemSelectedListener(this);

        //Percentage Spinner work
        SpinnerAdapterfile spinnerpercnt_obj = new SpinnerAdapterfile(getActivity(), percentagearray);
        jobseekpercntspnr_obj.setAdapter(spinnerpercnt_obj);
        jobseekpercntspnr_obj.setOnItemSelectedListener(this);
        //get all jbs jobs API work
        retrofitinterfacefile = Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        //Progress dialog work
        submitprogressbar = basicComponentsReuse_obj.showProgressBar_method(getActivity(), submitprogressbar);

        return jbskrreg3_view;
    }//end of onCreate View method

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            //      throw new RuntimeException(context.toString()
            //             + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.jobseekreg3submitbtnid:
                submitreg3_method();
                break;
        }//end of switch case
    }//end of onClick method

    @SuppressLint("NewApi")
    private void submitreg3_method() {
        //Work of getting values from edit text
        str_bankacc = bankacc_edittxt.getText().toString().trim();
        str_ifsc = bankifsc_edttxt.getText().toString().trim();
        str_year = passyear_etxt.getText().toString();
        str_marks = marks_etxt.getText().toString().trim();
        if (str_annincome.equals("null"))
            basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj, "Select your Family Annual Income");
        else if (int_highqualification == 0)
            basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj, "Select your Highest Qualification");
        else if (int_qualification == 0)
            basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj, "Select your Qualification ");
        else if (str_spclztn.equals("null"))
            basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj, "Please Select Specialization");
        else if (str_year.equals("null"))
            basicComponentsReuse_obj.editTextfieldvalidate_method(passyear_etxt, "Please select year");
        else if (str_modepercntg.equals("null"))
            basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj, "Please Select CGPA/Percentage");
        else if (str_marks.equals("null") || str_marks.equals(""))
            basicComponentsReuse_obj.editTextfieldvalidate_method(marks_etxt, "Enter your Obtained marks");
        else if (int_termsbox == 0)
            basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj, "Please accept terms and condition");
        else {
            getAllData_method();
        }//end of else condition
    }//end of submit method

    public void getAllData_method() {
        //show progress bar
        submitprogressbar.show();
        //Registration 1 values
        strfname = regAllData_listobj.get(0);
        strMname = regAllData_listobj.get(1);
        strlname = regAllData_listobj.get(2);
        strfatherfname = regAllData_listobj.get(3);
        str_dob = regAllData_listobj.get(4);
        gender_value = regAllData_listobj.get(5);
        marital_value = Integer.parseInt(regAllData_listobj.get(6));
        spousename_value = regAllData_listobj.get(7);
        stremail = regAllData_listobj.get(8);
        strnumber = regAllData_listobj.get(9);
        category_value = Integer.parseInt(regAllData_listobj.get(10));

        //Registration 2 values
        strjobseekreg2add = regAllData_listobj.get(11);
        intstate_value = Integer.parseInt(regAllData_listobj.get(12));
        intdistrict_value = Integer.parseInt(regAllData_listobj.get(13));
        strjobseekreg2pincode = Integer.parseInt(regAllData_listobj.get(14));
        int_skill = Integer.parseInt(regAllData_listobj.get(15));
        intSkillspinr_value = Integer.parseInt(regAllData_listobj.get(16));
        int_forgnEmplymnt = Integer.parseInt(regAllData_listobj.get(17));
        int_pvtjob = Integer.parseInt(regAllData_listobj.get(18));
        int_forgnStudy = Integer.parseInt(regAllData_listobj.get(19));
        int_govtjob = Integer.parseInt(regAllData_listobj.get(20));
        int_selfEmplymnt = Integer.parseInt(regAllData_listobj.get(21));
        intemploye_value = Integer.parseInt(regAllData_listobj.get(22));
        str_spinEmpjobtitle = regAllData_listobj.get(23);
        str_spinEmpjobsalary = regAllData_listobj.get(24);
        str_spinEmpjobemployer = regAllData_listobj.get(25);
        int_noemplydradiovalue = Integer.parseInt(regAllData_listobj.get(26));
        str_noemplydmeternum = regAllData_listobj.get(27);
        str_noemplydmetercnsptn = regAllData_listobj.get(28);
        str_noemplydmetername = regAllData_listobj.get(29);

        //year value
        try {
            year_obj = year_format.parse(str_year);
            dobDate_obj = dob_format.parse(str_dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        submitAllDetailsAPI_method();
    }//end of addAllUserData method

    @SuppressLint("NewApi")
    private void submitAllDetailsAPI_method() {
//        Toast.makeText(getActivity(), "All registration values are: "+regAllData_listobj+" "+str_bankacc+" "+str_ifsc+" "+str_annincome+" "
//                +int_highqualification +" "+int_qualification+" "+str_spclztn+" "+str_year+" "+str_modepercntg+" "+str_marks+" "+int_termsbox, Toast.LENGTH_SHORT).show();
        Call<ResponseBody> submitData = retrofitinterfacefile.submitAllDetails_method(strfname, strMname, strlname,
                gender_value, "1994", marital_value, spousename_value,
                strfatherfname, strnumber, strjobseekreg2add, stremail, intstate_value, intdistrict_value, strjobseekreg2pincode,
                int_qualification,
                str_spclztn, str_modepercntg, str_marks, str_year, int_skill, intSkillspinr_value, int_forgnEmplymnt, int_pvtjob,
                int_forgnStudy,
                int_govtjob, int_selfEmplymnt, category_value, str_bankacc, str_ifsc, str_annincome, intemploye_value, int_noemplydradiovalue,
                str_noemplydmeternum,
                str_noemplydmetercnsptn, str_noemplydmetername, str_spinEmpjobtitle, str_spinEmpjobsalary, str_spinEmpjobemployer );
        submitData.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getInt("status") == 1) {
                            submitprogressbar.dismiss();
                            JSONObject data=jsonObject.getJSONObject("data");
                            String username=data.getString("username");
                            String userpassword=data.getString("password");
                            basicComponentsReuse_obj.printToast_method(getActivity(),"Username is "+username+"Password is "+userpassword);
                            basicComponentsReuse_obj.backPressfragtoLogin_method(getActivity(), "regfragmentsshow");
                            getActivity().finish();
                        }//end of inner if condition
                        else {
                            submitprogressbar.dismiss();
                            basicComponentsReuse_obj.printToast_method(getActivity(), "Something went wrong.");
                            Log.d("Jobseekerreg3", "onResponse: " + Retrofitinstancefile.base_url + "register-jobseeker?" + "firstName=" + strfname + "&"
                                    + "middleName=" + strMname + "&" + "lastName=" + strlname + "&" + "gender=" + gender_value + "&" + "dob=" + dobDate_obj
                                    + "&" + "maritalStatus=" + marital_value + "&" + "spouseName=" + spousename_value + "&" + "fatherFirstName=" + strfatherfname
                                    + "&" + "mobileNo=" + strnumber + "&" + "address=" + strjobseekreg2add + "&" + "emailID=" + stremail + "&" + "state=" + intstate_value
                                    + "&" + "district=" + intdistrict_value + "&" + "pincode=" + strjobseekreg2pincode
                                    + "&" + "qualification=" + int_qualification + "&" + "specialization=" + str_spclztn
                                    + "&" + "mode=" + str_modepercntg + "&" + "marks=" + str_marks
                                    + "&" + "year=" + str_year + "&" + "skillLearning=" + int_skill
                                    + "&" + "sector=" + intSkillspinr_value + "&" + "foreingEmployment=" + int_forgnEmplymnt
                                    + "&" + "pvtJobs=" + int_pvtjob
                                    + "&" + "foreignStudy=" + int_forgnStudy + "&" + "govtJobs=" + int_govtjob + "&"
                                    + "selfEmployment=" + int_selfEmplymnt + "&" + "category=" + category_value + "&" + "bankAccountNo=" + str_bankacc
                                    + "&" + "IFSCcode=" + str_ifsc + "&" + "annualFamilyIncome=" + str_annincome
                                    + "&" + "employement=" + intemploye_value + "&" + "familyEmp=" + int_noemplydradiovalue
                                    + "&" + "meterNumber=" + str_noemplydmeternum + "&" + "avgConsumption=" + str_noemplydmetercnsptn
                                    + "&" + "holderName=" + str_noemplydmetername + "&" + "jobTitle=" + str_spinEmpjobtitle
                                    + "&" + "jobSalary=" + str_spinEmpjobsalary + "&" + "jobEmployer=" + str_spinEmpjobemployer);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }//end of if condition
                else {
                    submitprogressbar.dismiss();
                    Log.d("Jobseekerreg3", "onResponse: " + Retrofitinstancefile.base_url + "register-jobseeker?" + "firstName=" + strfname + "&"
                            + "middleName=" + strMname + "&" + "lastName=" + strlname + "&" + "gender=" + gender_value + "&" + "dob=" + dobDate_obj
                            + "&" + "maritalStatus=" + marital_value + "&" + "spouseName=" + spousename_value + "&" + "fatherFirstName=" + strfatherfname
                            + "&" + "mobileNo=" + strnumber + "&" + "address=" + strjobseekreg2add + "&" + "emailID=" + stremail + "&" + "state=" + intstate_value
                            + "&" + "district=" + intdistrict_value + "&" + "pincode=" + strjobseekreg2pincode
                            + "&" + "qualification=" + int_qualification + "&" + "specialization=" + str_spclztn
                            + "&" + "mode=" + str_modepercntg + "&" + "marks=" + str_marks
                            + "&" + "year=" + str_year + "&" + "skillLearning=" + int_skill
                            + "&" + "sector=" + intSkillspinr_value + "&" + "foreingEmployment=" + int_forgnEmplymnt
                            + "&" + "pvtJobs=" + int_pvtjob
                            + "&" + "foreignStudy=" + int_forgnStudy + "&" + "govtJobs=" + int_govtjob + "&"
                            + "selfEmployment=" + int_selfEmplymnt + "&" + "category=" + category_value + "&" + "bankAccountNo=" + str_bankacc
                            + "&" + "IFSCcode=" + str_ifsc + "&" + "annualFamilyIncome=" + str_annincome
                            + "&" + "employement=" + intemploye_value + "&" + "familyEmp=" + int_noemplydradiovalue
                            + "&" + "meterNumber=" + str_noemplydmeternum + "&" + "avgConsumption=" + str_noemplydmetercnsptn
                            + "&" + "holderName=" + str_noemplydmetername + "&" + "jobTitle=" + str_spinEmpjobtitle
                            + "&" + "jobSalary=" + str_spinEmpjobsalary + "&" + "jobEmployer=" + str_spinEmpjobemployer);
                    basicComponentsReuse_obj.printToast_method(getActivity(), "Something went wrong . Please try again");
                }
            }//end of onResponse method

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                submitprogressbar.dismiss();
                basicComponentsReuse_obj.printToast_method(getActivity(), "Check internet connection or Server Problem");
            }//end of onFailure method
        });
    }//end of All details API hit method

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spinner_obj = (Spinner) adapterView;
        switch (spinner_obj.getId()) {
            case R.id.jobseekreg3highqualfctnspnrid:
                if (i > 0) {
                    int_highqualification = highqualifnspinnerlist.get(i);
                    // Qualification spinner work
                    if (int_highqualification != 0) {
                        jobseekqualispnr_obj.setEnabled(true);
                        jobseekqualispnr_obj.setClickable(true);
                        qualificationspinnerlist = basicComponentsReuse_obj.showQualificationSpinner_method(getActivity(), jobseekqualispnr_obj, int_highqualification);
                        jobseekqualispnr_obj.setSelection(0);
                        jobseekqualispnr_obj.setOnItemSelectedListener(this);
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
            case R.id.jobseekreg3qualfctnspnrid:
                if (i > 0) {
                    int_qualification =qualificationspinnerlist.get(i);
                    if (int_qualification != 0) {
                        jobseekspeclztionspnr_obj.setEnabled(true);
                        jobseekspeclztionspnr_obj.setClickable(true);
                        // Specialization spinner work
                        specializationspinnerlist = basicComponentsReuse_obj.showSpecializationSpinner_method(getActivity(), jobseekspeclztionspnr_obj, int_qualification);
                        jobseekspeclztionspnr_obj.setOnItemSelectedListener(this);
                    }//end of if condition
                } else {
                    jobseekspeclztionspnr_obj.setEnabled(false);
                    jobseekspeclztionspnr_obj.setClickable(false);
                    jobseekspeclztionspnr_obj.setSelection(0);
                    int_qualification = 0;
                }
                break;
            case R.id.jobseekreg3spclztnspnrid:
                if (i > 0) {
                    str_spclztn = String.valueOf(specializationspinnerlist.get(i));
                } else str_spclztn = "null";
                break;
            case R.id.jobseekreg3fmlyincmspnrid:
                if (i > 0) {
                    str_annincome = String.valueOf(i);
                } else str_annincome = "null";
                break;

            case R.id.cgpapercntspinid:
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
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.termscheckboxid:
                if (b) int_termsbox = 1;
                else int_termsbox = 0;
                break;
        }//end of switch case
    }//end of onChecked changed method

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}//end of main class
