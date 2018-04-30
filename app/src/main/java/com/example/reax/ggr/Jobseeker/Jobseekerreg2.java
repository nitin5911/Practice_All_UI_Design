package com.example.reax.ggr.Jobseeker;

import android.annotation.SuppressLint;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.R;

import java.util.ArrayList;

public class Jobseekerreg2 extends Fragment implements View.OnClickListener,RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener,CompoundButton.OnCheckedChangeListener {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2",ARG_PARAM3="param3";
    private String mParam1,mParam2;
    Button Submit;
    TextView seekjobtextview,statetxtvw,districttxtvw,employeedtxtvw;
    CheckBox checkBoxskill,checkBoxforeemp,checkBoxpvtjob,checkBoxforestudy,checkBoxgovtjob,checkBoxselfemply;
    String strjobseekreg2add,seekemployedarray[]={"Select","Yes","No"},
             str_spinEmpjobtitle="null", str_spinEmpjobsalary="null",
            str_spinEmpjobemployer="null",str_noemplydmeternum="null",str_noemplydmetercnsptn="null",
            str_noemplydmetername="null";
    int intjobseekreg2pincode=0,intstate_value=0,intdistrict_value=0,intemploye_value,intSkillspinr_value=1,
            int_skill=0,int_forgnEmplymnt=0,int_pvtjob=0,int_forgnStudy=0,
            int_govtjob=0,int_selfEmplymnt=0,int_noemplydradiovalue=0;
    LinearLayout employeditemslayout_obj,noEmployeditemslayout,jsreg3skilllayout,mainlinearLayout_obj;
    Spinner jobseekstatespnr_obj,jobseekdistspnr_obj,
            skilllearnspinr_obj,jobseekemployedspnr_obj;
    EditText jobseek2edtaddrs,jobseekreg2pincode,spinEmpjobtitle,spinEmpjobsalary,
            spinEmpjobemployer,js2edtmeternum,js2edtmeterconsmptn,js2edtmetername;
    private OnFragmentInteractionListener mListener;
    Toolbar jobseekerreg2tool_obj;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    ArrayList<String> getDistrictlist=new ArrayList<>(),getStateList=new ArrayList<>(),
            getCountryList=new ArrayList<>(),getskillsectorList=new ArrayList<>();
    ArrayList<String> seekfor_array=new ArrayList<>(),ruemployedvalue_list=new ArrayList<>(),
            regAllData_listobj=new ArrayList<>();
    RadioGroup radiogroup_obj;
    RadioButton noemplydnoradio_obj,noemplydyesradio_obj;

    public Jobseekerreg2(){

    }//end of default constructor

    @SuppressLint("ValidFragment")
    public Jobseekerreg2(ArrayList<String> sendDataArrayList_obj) {
        regAllData_listobj=sendDataArrayList_obj;
    }//end of parameterized constructor
    public static Jobseekerreg2 newInstance(String param1, String param2,ArrayList<String> sendDataArrayList_obj) {
        Jobseekerreg2 fragment = new Jobseekerreg2(sendDataArrayList_obj);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, String.valueOf(sendDataArrayList_obj));
        fragment.setArguments(args);
        return fragment; }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2); }}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jobseekerreg2, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        Toast.makeText(getActivity(), "Registartion 1 array list values are : "+regAllData_listobj, Toast.LENGTH_SHORT).show();
        //Type Caste work
        Submit = view.findViewById(R.id.reg2submitbtnid);
        seekjobtextview=view.findViewById(R.id.jobreg2seekforjobid);
        statetxtvw=view.findViewById(R.id.statetextviewid);
        districttxtvw=view.findViewById(R.id.districttxtid);
        employeedtxtvw=view.findViewById(R.id.isemployedtxtid);
        jobseekreg2pincode=view.findViewById(R.id.jobseekreg2pinid);
        employeditemslayout_obj = view.findViewById(R.id.jobseek2employeedlayoutid);
        noEmployeditemslayout = view.findViewById(R.id.js2Noemployeeditemslayoutid);
        jobseekemployedspnr_obj=view.findViewById(R.id.jobseekemployedspnrid);
        jobseekdistspnr_obj=view.findViewById(R.id.jobseekreg2distspnrid);
        jobseekstatespnr_obj=view.findViewById(R.id.jobseekreg2statespnrid);
        jobseek2edtaddrs=view.findViewById(R.id.jobseekreg2addrsid);
        checkBoxskill=view.findViewById(R.id.checkboxskillid);
        checkBoxforeemp=view.findViewById(R.id.checkboxforeempid);
        checkBoxpvtjob=view.findViewById(R.id.checkboxpvtjobid);
        checkBoxforestudy=view.findViewById(R.id.checkboxforestudyid);
        checkBoxgovtjob=view.findViewById(R.id.checkboxgovtjobid);
        checkBoxselfemply=view.findViewById(R.id.checkboxselfemplyid);
        jsreg3skilllayout=view.findViewById(R.id.jsreg3skilllayoutid);
        mainlinearLayout_obj=view.findViewById(R.id.jobseekreg2mainlayoutid);
        checkBoxskill.setOnCheckedChangeListener(this);
        checkBoxforeemp.setOnCheckedChangeListener(this);
        checkBoxpvtjob.setOnCheckedChangeListener(this);
        checkBoxforestudy.setOnCheckedChangeListener(this);
        checkBoxgovtjob.setOnCheckedChangeListener(this);
        checkBoxselfemply.setOnCheckedChangeListener(this);

        //Toolbar work
        jobseekerreg2tool_obj=view.findViewById(R.id.jobseekerreg2toolbarid);
        basicComponentsReuse_obj.signupToolbarShow_method(getActivity(),jobseekerreg2tool_obj,"Registration","regfragmentsshow");
         //Onclick listener work
        Submit.setOnClickListener(this);
        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(),"regfragmentsshow","reg2fragvisible","1");

        // State spinner work
        getStateList=basicComponentsReuse_obj.showStateSpinner_method(getActivity(),jobseekstatespnr_obj,0);
        jobseekstatespnr_obj.setOnItemSelectedListener(this);
        // District spinner work
        getDistrictlist=basicComponentsReuse_obj.showDistrictSpinner_method(getActivity(),jobseekdistspnr_obj,0);
        jobseekdistspnr_obj.setOnItemSelectedListener(this);
        //Work on Employeed spinner
        basicComponentsReuse_obj.showStaticSpinner_method(getActivity(),seekemployedarray,jobseekemployedspnr_obj,0);
        jobseekemployedspnr_obj.setOnItemSelectedListener(this);

        return view;
    }//end of onCreateView class

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {mListener.onFragmentInteraction(uri);}}
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
        //    throw new RuntimeException(context.toString()
        //            + " must implement OnFragmentInteractionListener");
        }}

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;}
        @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.reg2submitbtnid:
                submitreg2_method();
                 break;
        }//end of switch case
    }//end of onClick method

   private void submitreg2_method(){
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

       strjobseekreg2add=jobseek2edtaddrs.getText().toString().trim();
       intjobseekreg2pincode= Integer.parseInt(jobseekreg2pincode.getText().toString());
       if (strjobseekreg2add.length()==0) basicComponentsReuse_obj.editTextfieldvalidate_method(jobseek2edtaddrs,"Enter the Address");
       else if(intstate_value==0)basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj,"Select your State");
       else if(intdistrict_value==0) basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj,"Select your District");
       else if (intjobseekreg2pincode==0) basicComponentsReuse_obj.editTextfieldvalidate_method(jobseekreg2pincode,"Please enter the Pincode");
       else if (seekfor_array.size()==0) basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj,"Please Select atleast one Seeking for field");
       else if(intemploye_value==0) basicComponentsReuse_obj.printSnackBar_method(mainlinearLayout_obj,"Please Select are you Employeed or not");
       else {
           ArrayList<String> sendDataArrayList_obj= addAllUserData_method();
           basicComponentsReuse_obj.sharedclear_method(getActivity(),"regfragmentsshow");
           Jobseekerreg3 jobseekerreg3_obj = new Jobseekerreg3(sendDataArrayList_obj);
           getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainloginlayoutid, jobseekerreg3_obj).addToBackStack(null).commit();
       }//end of else condition
   }//end of submit method

    public ArrayList<String> addAllUserData_method(){
        regAllData_listobj.add(strjobseekreg2add);
        regAllData_listobj.add(String.valueOf(intstate_value));
        regAllData_listobj.add(String.valueOf(intdistrict_value));
        regAllData_listobj.add(String.valueOf(intjobseekreg2pincode));
        regAllData_listobj.add(String.valueOf(int_skill));
        regAllData_listobj.add(String.valueOf(intSkillspinr_value));
        regAllData_listobj.add(String.valueOf(int_forgnEmplymnt));
        regAllData_listobj.add(String.valueOf(int_pvtjob));
        regAllData_listobj.add(String.valueOf(int_forgnStudy));
        regAllData_listobj.add(String.valueOf(int_govtjob));
        regAllData_listobj.add(String.valueOf(int_selfEmplymnt));
        regAllData_listobj.add(String.valueOf(intemploye_value));
        regAllData_listobj.add(str_spinEmpjobtitle);
        regAllData_listobj.add(str_spinEmpjobsalary);
        regAllData_listobj.add(str_spinEmpjobemployer);
        regAllData_listobj.add(String.valueOf(int_noemplydradiovalue));
        regAllData_listobj.add(str_noemplydmeternum);
        regAllData_listobj.add(str_noemplydmetercnsptn);
        regAllData_listobj.add(str_noemplydmetername);
        return regAllData_listobj;
    }//end of addAllUserData method

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spinner_obj = (Spinner) adapterView;
            switch (spinner_obj.getId()) {
            case R.id.jobseekemployedspnrid:
                if (i > 0) {
                    switch (i) {
                        case 1:
                            employeedviewLayout_code(i);
                            showYesemployedbox();
                            break;
                        case 2:
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
                case R.id.jobseekreg2statespnrid:
                    if (i > 0) {
                        intstate_value = Integer.parseInt(getStateList.get(i));
                    }else intstate_value = 0;
                    break;
                case R.id.jobseekreg2distspnrid:
                    if (i > 0) {
                        intdistrict_value= Integer.parseInt(getDistrictlist.get(i));
                    }else intdistrict_value = 0;
                    break;
                case R.id.skilllearnspnrid:
                    if(i>0){
                        intSkillspinr_value= Integer.parseInt(getskillsectorList.get(i));
                    }
                    break;
        }//end of switch case
    }//end of onItemSelected method

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
    public void onNothingSelected(AdapterView<?> adapterView) {}
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
           switch (compoundButton.getId()) {
               case R.id.checkboxskillid:
                   if(isChecked){
                       int_skill=1;
                       checkboxvaluecall(compoundButton);}
                   else {
                       jsreg3skilllayout.removeAllViews();
                       int_skill=0;
                       seekfor_array.remove(compoundButton.getText().toString());
                   }
                   break;
               case R.id.checkboxforeempid:
                   if(isChecked){
                       int_forgnEmplymnt=1;
                       checkboxvaluecall(compoundButton);
                   }
                   else{
                       int_forgnEmplymnt=0;
                       seekfor_array.remove(compoundButton.getText().toString());
                   }
                   break;
               case R.id.checkboxpvtjobid:
                   if(isChecked){
                       int_pvtjob=1;
                       checkboxvaluecall(compoundButton);
                   }
                   else {
                       int_pvtjob=0;
                       seekfor_array.remove(compoundButton.getText().toString());
                   }
                   break;
               case R.id.checkboxforestudyid:
                   if(isChecked){
                       int_forgnStudy=1;
                       checkboxvaluecall(compoundButton);
                   }
                   else {
                       int_forgnStudy=0;
                       seekfor_array.remove(compoundButton.getText().toString());}
                   break;
               case R.id.checkboxgovtjobid:
                   if(isChecked){
                       int_govtjob=1;
                       checkboxvaluecall(compoundButton);
                   }
                   else {
                       int_govtjob=0;
                       seekfor_array.remove(compoundButton.getText().toString());
                   }
                   break;
               case R.id.checkboxselfemplyid:
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
           Toast.makeText(getActivity(), "check box values are "+seekfor_array, Toast.LENGTH_SHORT).show();
    }//end of onCheckedChanged method

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
        getskillsectorList=basicComponentsReuse_obj.showSkillIsectorSpinner_method(getActivity(),skilllearnspinr_obj,0);
        skilllearnspinr_obj.setOnItemSelectedListener(this);
        jsreg3skilllayout.removeAllViews();
        jsreg3skilllayout.addView(skilllay_view);
    }//end of show skill layout method

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (noemplydyesradio_obj.isChecked()) {
            noEmployeditemslayout.removeAllViews();
            int_noemplydradiovalue = 1;
        }
        else if (noemplydnoradio_obj.isChecked()) {
            int_noemplydradiovalue = 0;
            showNoEmployedItemsbox();
        }
        else
            int_noemplydradiovalue=1;
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

    interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//End of main class
