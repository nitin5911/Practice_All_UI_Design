package com.example.reax.ggr.Jobseeker;

import android.annotation.SuppressLint;
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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.POJO_Classes.FetchUserDataPOJO2;
import com.example.reax.ggr.R;

import java.util.ArrayList;

public class Jobseeker_contadd extends Fragment implements AdapterView.OnItemSelectedListener,RadioGroup.OnCheckedChangeListener,
        View.OnClickListener,CompoundButton.OnCheckedChangeListener {

    private static final String ARG_PARAM1 = "param1", ARG_PARAM2 = "param2",ARG_PARAM3="param3";
    private String mParam1,mParam2,mParam3;
    LinearLayout jscontaddlayout_obj,employeditemslayout_obj,noEmployeditemslayout,jsreg3skilllayout;
    String str_upmobile,str_upaddrs,str_pincode,seekemployedarray[]={"Yes","No"},
            str_spinEmpjobtitle="null", str_spinEmpjobsalary="null",
            str_spinEmpjobemployer="null",str_noemplydmeternum="null",str_noemplydmetercnsptn="null",
            str_noemplydmetername="null";
    int state_value,distrct_value,intstate_value=0,intdistrict_value=0,int_noemplydradiovalue=0,intemploye_value,
    intSector_value=0,int_skill=0,int_forgnEmplymnt=0,int_pvtjob=0,int_forgnStudy=0,
    int_govtjob=0,int_selfEmplymnt=0;
    private OnFragmentInteractionListener mListener;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    EditText etxt_upmobile,etxt_upaddrs,etxt_pincode,spinEmpjobtitle,spinEmpjobsalary,
            spinEmpjobemployer,js2edtmeternum,js2edtmeterconsmptn,js2edtmetername;
    Spinner jsupemployedspnr_obj,spin_state,spin_distrct,skilllearnspinr_obj;
    ArrayList<String> getDistrictlist=new ArrayList<>(),getStateList=new ArrayList<>(),ruemployedvalue_list=new ArrayList<>(),
            seekfor_array=new ArrayList<>(),getskillsectorList=new ArrayList<>();
    ArrayList<FetchUserDataPOJO2> usercontact_list=new ArrayList<>();
    RadioGroup radiogroup_obj;
    RadioButton noemplydnoradio_obj,noemplydyesradio_obj;
    Button jsupcontupbtn;
    CheckBox checkBoxskill,checkBoxforeemp,checkBoxpvtjob,checkBoxforestudy,checkBoxgovtjob,checkBoxselfemply;

    @SuppressLint("ValidFragment")
    public Jobseeker_contadd(ArrayList<FetchUserDataPOJO2> updatedatalist_array) {
        usercontact_list=updatedatalist_array;}//end of constructor
    public Jobseeker_contadd() {}//end of constructor

    public static Jobseeker_contadd newInstance(String param1, String param2,ArrayList<FetchUserDataPOJO2> updatedatalist_array) {
        Jobseeker_contadd fragment = new Jobseeker_contadd(updatedatalist_array);
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
            mParam2 = getArguments().getString(ARG_PARAM2); }}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View employercontadd_view= inflater.inflate(R.layout.fragment_jobseeker_contadd, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        //typecaste work
        spin_state=employercontadd_view.findViewById(R.id.jsupstatespinnerid);
        spin_distrct=employercontadd_view.findViewById(R.id.jsupdistrctspinnerid);
        etxt_upmobile=employercontadd_view.findViewById(R.id.jsupdatephoneid);
        etxt_upaddrs=employercontadd_view.findViewById(R.id.jsupdateaddrsid);
        etxt_pincode=employercontadd_view.findViewById(R.id.jsupdatepincodeid);
        employeditemslayout_obj = employercontadd_view.findViewById(R.id.jsupemployeedlayoutid);
        noEmployeditemslayout = employercontadd_view.findViewById(R.id.jsupNoemployeeditemslayoutid);
        jsupemployedspnr_obj=employercontadd_view.findViewById(R.id.jsupemployedspnrid);
        jsupcontupbtn=employercontadd_view.findViewById(R.id.jsupcontupbtnid);
        checkBoxskill=employercontadd_view.findViewById(R.id.jsupcheckboxskillid);
        checkBoxforeemp=employercontadd_view.findViewById(R.id.jsupcheckboxforeempid);
        checkBoxpvtjob=employercontadd_view.findViewById(R.id.jsupcheckboxpvtjobid);
        checkBoxforestudy=employercontadd_view.findViewById(R.id.jsupcheckboxforestudyid);
        checkBoxgovtjob=employercontadd_view.findViewById(R.id.jsupcheckboxgovtjobid);
        checkBoxselfemply=employercontadd_view.findViewById(R.id.jsupcheckboxselfemplyid);
        jsreg3skilllayout=employercontadd_view.findViewById(R.id.jsupskilllayoutid);
        checkBoxskill.setOnCheckedChangeListener(this);
        checkBoxforeemp.setOnCheckedChangeListener(this);
        checkBoxpvtjob.setOnCheckedChangeListener(this);
        checkBoxforestudy.setOnCheckedChangeListener(this);
        checkBoxgovtjob.setOnCheckedChangeListener(this);
        checkBoxselfemply.setOnCheckedChangeListener(this);
        jsupcontupbtn.setOnClickListener(this);
        setcontactData_method();
       return employercontadd_view;
    }//end of onCreate view method

    private void setcontactData_method() {
        if(usercontact_list.size()!=0&& !usercontact_list.equals(null)) {
            etxt_upmobile.setText(usercontact_list.get(0).getMobileNo());
            etxt_upaddrs.setText(usercontact_list.get(0).getAddress());
            etxt_pincode.setText(usercontact_list.get(0).getPincode());
            state_value= Integer.parseInt(usercontact_list.get(0).getState());
            distrct_value= Integer.parseInt(usercontact_list.get(0).getDistrict());

            int_skill= Integer.parseInt(usercontact_list.get(0).getSkillLearning());
            if(int_skill==1){
                checkBoxskill.setChecked(true);
                intSector_value= (int) usercontact_list.get(0).getSectorId();
            }

            int_forgnEmplymnt= Integer.parseInt(usercontact_list.get(0).getForiegnEmployment());
            if(int_forgnEmplymnt==1) checkBoxforeemp.setChecked(true);

            int_forgnStudy= Integer.parseInt(usercontact_list.get(0).getForiegnStudy());
            if(int_forgnStudy==1) checkBoxforestudy.setChecked(true);

            int_govtjob= Integer.parseInt(usercontact_list.get(0).getGovtJob());
            if(int_govtjob==1) checkBoxgovtjob.setChecked(true);

            int_selfEmplymnt= Integer.parseInt(usercontact_list.get(0).getSelfEmployment());
            if(int_selfEmplymnt==1) checkBoxselfemply.setChecked(true);

            int_pvtjob=Integer.parseInt(usercontact_list.get(0).getPvtJob());
            if(int_pvtjob==1) checkBoxpvtjob.setChecked(true);

            intemploye_value= Integer.parseInt(usercontact_list.get(0).getEmployement());
            if(usercontact_list.get(0).getJobTitle().length()!=0) spinEmpjobtitle.setText(usercontact_list.get(0).getJobTitle());
            if(usercontact_list.get(0).getJobSalary().length()!=0) spinEmpjobsalary.setText(usercontact_list.get(0).getJobSalary());
            if(usercontact_list.get(0).getJobEmployer().length()!=0) spinEmpjobemployer.setText(usercontact_list.get(0).getJobEmployer());
            int_noemplydradiovalue= Integer.parseInt(usercontact_list.get(0).getFamilyEmp());
            if(usercontact_list.get(0).getMeterNumber().length()!=0)js2edtmeternum.setText(usercontact_list.get(0).getMeterNumber());
            if(usercontact_list.get(0).getMeterAvg().length()!=0) js2edtmeterconsmptn.setText(usercontact_list.get(0).getMeterAvg());
            if(usercontact_list.get(0).getMeterHolderName().length()!=0) js2edtmetername.setText(usercontact_list.get(0).getMeterHolderName());
            // State spinner work
            getStateList=basicComponentsReuse_obj.showStateSpinner_method(getActivity(),spin_state,state_value);
            spin_state.setOnItemSelectedListener(this);
            // District spinner work
            getDistrictlist=basicComponentsReuse_obj.showDistrictSpinner_method(getActivity(),spin_distrct,distrct_value);
            spin_distrct.setOnItemSelectedListener(this);

            // Work on Employeed spinner
            basicComponentsReuse_obj.showStaticSpinner_method(getActivity(),seekemployedarray,jsupemployedspnr_obj,intemploye_value);
            jsupemployedspnr_obj.setOnItemSelectedListener(this);
        }//end of if condition
        else basicComponentsReuse_obj.printToast_method(getActivity(),"Please check your Internet connection or try again later");
    }//end of set Contact data method

    public void getAllContactData_method(){
        //Work of getting values from edit text
        if(intemploye_value==1){
            str_spinEmpjobtitle=spinEmpjobtitle.getText().toString().trim();
            str_spinEmpjobsalary=spinEmpjobsalary.getText().toString().trim();
            str_spinEmpjobemployer=spinEmpjobemployer.getText().toString().trim();
        }else{
            if(int_noemplydradiovalue==0){
                str_noemplydmeternum=js2edtmeternum.getText().toString().trim();
                str_noemplydmetercnsptn=js2edtmeterconsmptn.getText().toString().trim();
                str_noemplydmetername=js2edtmetername.getText().toString().trim();
            }//end of inner if
        }//end of else

    }//end of get All contact data method

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
            case R.id.jsupemployedspnrid:
                if (i >= 0) {
                    switch (i) {
                        case 0:
                            employeedviewLayout_code(i);
                            showYesemployedbox();
                            break;
                        case 1:
                            employeedviewLayout_code(i);
                            showNoemployedbox();
                            break;
                    }//end of inner switch case
                }else {
                    intemploye_value = 0;
                    ruemployedvalue_list.clear();
                    noEmployeditemslayout.removeAllViews();
                    employeditemslayout_obj.removeAllViews();
                }
                break;
            case R.id.jsupstatespinnerid:
                if (i > 0) {
                    intstate_value = Integer.parseInt(getStateList.get(i));
                } else intstate_value = 0;
                break;
            case R.id.jsupdistrctspinnerid:
                if (i > 0) {
                    intdistrict_value = Integer.parseInt(getDistrictlist.get(i));
                } else intdistrict_value = 0;
                break;
            case R.id.skilllearnspnrid:
                if(i>0){
                    intSector_value= Integer.parseInt(getskillsectorList.get(i));
                }
                break;
        }//end of switch case
    }//end of onItemSelected

    public void employeedviewLayout_code(int i){
        intemploye_value =i;
        ruemployedvalue_list.clear();
        ruemployedvalue_list.add(String.valueOf(intemploye_value));
        noEmployeditemslayout.removeAllViews();
        employeditemslayout_obj.removeAllViews();
    }//end of employeedViewLayout code

    private void showNoemployedbox() {
        LayoutInflater layoutInflater =(LayoutInflater)getActivity(). getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View noemplydview = layoutInflater.inflate(R.layout.noemployeedlayout, null);
        radiogroup_obj=noemplydview.findViewById(R.id.noemplydradiogrpid);
        noemplydnoradio_obj=noemplydview.findViewById(R.id.noemplydnoradiobtnid);
        noemplydyesradio_obj=noemplydview.findViewById(R.id.noemplydyesradiobtnid);
        radiogroup_obj.setOnCheckedChangeListener(this);
        noemplydyesradio_obj.setChecked(true);
        employeditemslayout_obj.removeAllViews();
        employeditemslayout_obj.addView(noemplydview);
    }//end of show No employed box method

    private void showYesemployedbox() {
        LayoutInflater layoutInflater =(LayoutInflater)getActivity(). getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View provideraddView = layoutInflater.inflate(R.layout.filljobdetails, null);
        spinEmpjobtitle=provideraddView.findViewById(R.id.spinjobtitleid);
        spinEmpjobsalary=provideraddView.findViewById(R.id.spinjobsalaryid);
        spinEmpjobemployer=provideraddView.findViewById(R.id.spinjobemployerid);
        employeditemslayout_obj.removeAllViews();
        employeditemslayout_obj.addView(provideraddView);
        employeboxvalue_method();
    }//end of showproviderbox method

    private void employeboxvalue_method() {
        str_spinEmpjobtitle=spinEmpjobtitle.getText().toString().trim();
        str_spinEmpjobsalary=spinEmpjobsalary.getText().toString().trim();
        str_spinEmpjobemployer=spinEmpjobemployer.getText().toString().trim();
        ruemployedvalue_list.add(str_spinEmpjobtitle);
        ruemployedvalue_list.add(str_spinEmpjobsalary);
        ruemployedvalue_list.add(str_spinEmpjobemployer);
        Toast.makeText(getActivity(), "R u employeed array list "+ruemployedvalue_list, Toast.LENGTH_SHORT).show();
    }//end of employe box validate method

    private void noemployeitemsvalue_method() {
        str_noemplydmeternum=js2edtmeternum.getText().toString().trim();
        str_noemplydmetercnsptn=js2edtmeterconsmptn.getText().toString().trim();
        str_noemplydmetername=js2edtmetername.getText().toString().trim();
    }//end of employe box validate method

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (noemplydyesradio_obj.isChecked()) {
            noEmployeditemslayout.removeAllViews();
            int_noemplydradiovalue = 1;
        }
        else if (noemplydnoradio_obj.isChecked()) {
            int_noemplydradiovalue = 0;
            showNoEmployedItemsbox();
        }
        else int_noemplydradiovalue=1;
    }//end of onCheckedChanged method

    private void showNoEmployedItemsbox() {
        LayoutInflater layoutInflater =(LayoutInflater)getActivity(). getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View noemployeditemsView  = layoutInflater.inflate(R.layout.noemployeditemslayout, null);
        js2edtmeternum=noemployeditemsView.findViewById(R.id.noemplyditemsmeternumid);
        js2edtmeterconsmptn=noemployeditemsView.findViewById(R.id.noemplyditemsconsptnid);
        js2edtmetername=noemployeditemsView.findViewById(R.id.noemplyditemsmeternameid);
        noEmployeditemslayout.removeAllViews();
        noEmployeditemslayout.addView(noemployeditemsView);
        noemployeitemsvalue_method();
    }//end of show No employed items box method

    @Override
    public void onClick(View view) {

    }//end of onClick method

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.jsupcheckboxskillid:
                if(isChecked){
                    int_skill=1;
                    checkboxvaluecall(compoundButton);}
                else {
                    jsreg3skilllayout.removeAllViews();
                    int_skill=0;
                    seekfor_array.remove(compoundButton.getText().toString());
                }
                break;
            case R.id.jsupcheckboxforeempid:
                if(isChecked){
                    int_forgnEmplymnt=1;
                    checkboxvaluecall(compoundButton);
                }
                else{
                    int_forgnEmplymnt=0;
                    seekfor_array.remove(compoundButton.getText().toString());
                }
                break;
            case R.id.jsupcheckboxpvtjobid:
                if(isChecked){
                    int_pvtjob=1;
                    checkboxvaluecall(compoundButton);
                }
                else {
                    int_pvtjob=0;
                    seekfor_array.remove(compoundButton.getText().toString());
                }
                break;
            case R.id.jsupcheckboxforestudyid:
                if(isChecked){
                    int_forgnStudy=1;
                    checkboxvaluecall(compoundButton);
                }
                else {
                    int_forgnStudy=0;
                    seekfor_array.remove(compoundButton.getText().toString());}
                break;
            case R.id.jsupcheckboxgovtjobid:
                if(isChecked){
                    int_govtjob=1;
                    checkboxvaluecall(compoundButton);
                }
                else {
                    int_govtjob=0;
                    seekfor_array.remove(compoundButton.getText().toString());
                }
                break;
            case R.id.jsupcheckboxselfemplyid:
                if(isChecked){
                    int_selfEmplymnt=1;
                    checkboxvaluecall(compoundButton);
                }
                else {
                    int_selfEmplymnt=0;
                    seekfor_array.remove(compoundButton.getText().toString());
                }
                break;
        }//end of switch case
    }//end of onChecked Changed method
    public void checkboxvaluecall(CompoundButton compoundButton){
        String str_checkbox =compoundButton.getText().toString();
        if(str_checkbox.equals("Skill Learning")){
            showSkillLayout();
        }
        seekfor_array.add(str_checkbox);
    }//end of checkbox value call method

    private void showSkillLayout() {
        LayoutInflater layoutInflater =(LayoutInflater)getActivity(). getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View skilllay_view = layoutInflater.inflate(R.layout.skilllearninglayout, null);
        skilllearnspinr_obj=skilllay_view.findViewById(R.id.skilllearnspnrid);
        // Skill learning spinner work
        getskillsectorList=basicComponentsReuse_obj.showSkillIsectorSpinner_method(getActivity(),skilllearnspinr_obj,intSector_value);
        skilllearnspinr_obj.setOnItemSelectedListener(this);
        jsreg3skilllayout.removeAllViews();
        jsreg3skilllayout.addView(skilllay_view);
    }//end of show skill layout method


    public interface OnFragmentInteractionListener {void onFragmentInteraction(Uri uri); }
}//end of main class
