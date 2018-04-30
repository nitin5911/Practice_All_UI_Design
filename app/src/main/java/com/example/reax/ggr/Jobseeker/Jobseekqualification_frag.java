package com.example.reax.ggr.Jobseeker;

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
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

import java.util.ArrayList;

public class Jobseekqualification_frag extends Fragment implements View.OnClickListener,AdapterView.OnItemSelectedListener{
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    Retrofitinterfacefile retrofitinterfacefile;
    Spinner qualification_spin,specialization_spin,country_spin,district_spin,state_spin,addqualification_spin,addspecialization_spin,addcountry_spin,adddistrict_spin,addstate_spin;
    EditText txt_pyearshow, etxt_institute,etxt_percentg,addetxt_institute,addetxt_percentg,addetxt_compltyear;

    ImageButton pyearicon_btn,addquallayouticon_btn;
    Button qualiupdate_btn ,addqualiupdate_btn;
    LinearLayout qualAddMore_layout;
    ArrayList<String> getDistrictlist=new ArrayList<>(),getStateList=new ArrayList<>(),
            getCountryList=new ArrayList<>(),getQualification_List=new ArrayList<>(),getSpecialization_List=new ArrayList<>();
    String str_institute,str_percentage,str_passyear,str_qualification="null",str_state="null",str_district="null",str_specialization="null",str_country="null";
ImageButton deletemorelayout_obj;
    private OnFragmentInteractionListener mListener;
    public Jobseekqualification_frag() { }
    public static Jobseekqualification_frag newInstance(String param1, String param2) {
        Jobseekqualification_frag fragment = new Jobseekqualification_frag();
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
       View qualifctn_view=inflater.inflate(R.layout.fragment_jobseekqualification_frag, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        //Type Caste work--main UI
        qualAddMore_layout=qualifctn_view.findViewById(R.id.qualaddmorelayoutcontainerid);
        addquallayouticon_btn=qualifctn_view.findViewById(R.id.addquallayouticonid);
        qualification_spin=qualifctn_view.findViewById(R.id.jsPSqualispnrid);
        specialization_spin=qualifctn_view.findViewById(R.id.jsPSspeclztnspnrid);
        etxt_institute=qualifctn_view.findViewById(R.id.jsPSqualinstid);
        etxt_percentg=qualifctn_view.findViewById(R.id.jsPSqualpercntid);
        country_spin=qualifctn_view.findViewById(R.id.jsPSqualcountryspinid);
        state_spin=qualifctn_view.findViewById(R.id.jsPSqualstatespinid);
        district_spin=qualifctn_view.findViewById(R.id.jsPSqualdistrictspinid);
        txt_pyearshow=qualifctn_view.findViewById(R.id.psqualicyearshowtxtvwid);
        qualiupdate_btn=qualifctn_view.findViewById(R.id.jsPSqualiupdatebtnid);
        //On click listener work
        addquallayouticon_btn.setOnClickListener(this);
        qualiupdate_btn.setOnClickListener(this);
//        //Qualification spinner work
//        getQualification_List=basicComponentsReuse_obj.showQualificationSpinner_method(getActivity(),qualification_spin,0);
//        qualification_spin.setOnItemSelectedListener(this);
//        //Specialization spinner work
//        getSpecialization_List=basicComponentsReuse_obj.showSpecializationSpinner_method(getActivity(),specialization_spin,0);
//        specialization_spin.setOnItemSelectedListener(this);
//        //Country spinner work
//        getCountryList=basicComponentsReuse_obj.showSpecializationSpinner_method(getActivity(),country_spin,0);
//        country_spin.setOnItemSelectedListener(this);
        // State spinner work
        getStateList=basicComponentsReuse_obj.showStateSpinner_method(getActivity(),state_spin,0);
        state_spin.setOnItemSelectedListener(this);
        // District spinner work
        getDistrictlist=basicComponentsReuse_obj.showDistrictSpinner_method(getActivity(),district_spin,0);
        district_spin.setOnItemSelectedListener(this);
        return qualifctn_view;
    }//end of onCreateView method

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri); }   }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
       //     throw new RuntimeException(context.toString()
       //             + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jsPSqualiupdatebtnid:
                //write code here for submit data and Hit API
                break;
            case R.id.addquallayouticonid:
                basicComponentsReuse_obj.printToast_method(getActivity(),"Qualification Layout Add");
                addqualLayoutcard_method();
                break;
            case R.id.addjobseekqualboxupdateid:
                basicComponentsReuse_obj.printToast_method(getActivity(),"button pressed");
                break;
        }//end of switch case
    }//end of onClick method

    private  void addqualLayoutcard_method(){
        LayoutInflater layoutInflater =(LayoutInflater)getActivity(). getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     final View provideraddView = layoutInflater.inflate(R.layout.jsqualificationaddmorelayout, null);
      int index=0;
        deletemorelayout_obj=provideraddView.findViewById(R.id.addpsqualdeleteiconid);
        addcountry_spin=provideraddView.findViewById(R.id.addcountryidspnrid);
        addqualification_spin=provideraddView.findViewById(R.id.addjobseekqualispnrid);
        addspecialization_spin=provideraddView.findViewById(R.id.addjobseekspeclspnrid);
        addstate_spin=provideraddView.findViewById(R.id.addstateidspnrid);
        adddistrict_spin=provideraddView.findViewById(R.id.adddistrictspnrid);
        addetxt_institute=provideraddView.findViewById(R.id.addinstitutetxtid);
        addetxt_percentg=provideraddView.findViewById(R.id.addpercentagetxtid);
        addetxt_compltyear=provideraddView.findViewById(R.id.addpercmpltyeartxtid);
        addqualiupdate_btn=provideraddView.findViewById(R.id.addjobseekqualboxupdateid);
        addqualiupdate_btn.setOnClickListener(this);
        deletemorelayout_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LinearLayout) provideraddView.getParent()).removeView(provideraddView);
            }
        });
        qualAddMore_layout.addView(provideraddView,index);
    }//end of addLayout card method

    public void qualUpdateDataHitAPI_method(){
        str_institute=etxt_institute.getText().toString().trim();
        str_percentage=etxt_percentg.getText().toString().trim();
        str_passyear=txt_pyearshow.getText().toString().trim();
        //Validation work

    }//end of update data hit API method

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spinner_obj = (Spinner) adapterView;
        switch (spinner_obj.getId()) {
            case R.id.jsPSqualispnrid:
                if (i > 0) {
                    str_qualification = getQualification_List.get(i);
                    Toast.makeText(getActivity(), "qualification value is " + str_qualification, Toast.LENGTH_SHORT).show();
                    //   basicComponentsReuse_obj.cleartxtviewerrormsg_method(statetxtvw);
                } else str_qualification = "null";
                break;
            case R.id.jsPSspeclztnspnrid:
                if (i > 0) {
                    str_specialization = getSpecialization_List.get(i);
                    Toast.makeText(getActivity(), "specialization value is " + str_specialization, Toast.LENGTH_SHORT).show();
                    // basicComponentsReuse_obj.cleartxtviewerrormsg_method(districttxtvw);
                } else str_specialization = "null";
                break;
            case R.id.jsPSqualcountryspinid:
                if (i > 0) {
                    str_country = getCountryList.get(i);
                    Toast.makeText(getActivity(), "country value is " + str_country, Toast.LENGTH_SHORT).show();
                    // basicComponentsReuse_obj.cleartxtviewerrormsg_method(districttxtvw);
                } else str_country = "null";
                break;
            case R.id.jsPSqualstatespinid:
                if (i > 0) {
                    str_state = getStateList.get(i);
                    Toast.makeText(getActivity(), "state value is " + str_state, Toast.LENGTH_SHORT).show();
                    // basicComponentsReuse_obj.cleartxtviewerrormsg_method(districttxtvw);
                } else str_state = "null";
                break;
            case R.id.jsPSqualdistrictspinid:
                if (i > 0) {
                    str_district = getDistrictlist.get(i);
                    Toast.makeText(getActivity(), "District value is " + str_district, Toast.LENGTH_SHORT).show();
                    // basicComponentsReuse_obj.cleartxtviewerrormsg_method(districttxtvw);
                } else str_district = "null";
                break;
        }//end of switch case
    }//end of onItemSelected method
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }//end of onNothing selected method
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
