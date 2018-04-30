package com.example.reax.ggr.Jobseeker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.POJO_Classes.AddjobseekerExperiencePojo1;
import com.example.reax.ggr.POJO_Classes.DeletejobexpPojo1;
import com.example.reax.ggr.POJO_Classes.GetJobseekExpPojo1;
import com.example.reax.ggr.POJO_Classes.GetJobseekExpPojo2;
import com.example.reax.ggr.POJO_Classes.LoginPOJO2;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobseekExperince_frag extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {
    private static final String ARG_PARAM1 = "param1", ARG_PARAM2 = "param2";
    private String mParam1, mParam2;
    Button jsexpsubmitbtn_obj, addjsexpsubmitbtn_obj;
    ImageButton delete_obj;
    RadioButton experienceradio_obj, fresherradio_obj;
    RadioGroup radiogroup_obj;
    LinearLayout addmorelayout_obj, expfulllayoutbox_obj;
    Spinner district_spin, state_spin, adddistrict_spin, addstate_spin;
    View provideraddView, experince_view;
    ArrayList<String> getDistrictlist = new ArrayList<>(), getStateList = new ArrayList<>();
    ArrayList<GetJobseekExpPojo2> getJobseekexplist = new ArrayList<>();
    String str_expfreshvalue, str_title, str_company, str_profile, str_startdate,
            str_enddate, str_state, str_district, str_jobrespo;
    private OnFragmentInteractionListener mListener;
    TextView expstartdatetxt_obj, expenddatetxt_obj, addexpstartdatetxt_obj, addexpenddatetxt_obj;
    ImageButton expstartdatebtn_obj, expenddatebtn_obj, addmorelayoutimg_obj, deletemorelayout_obj, addStartdatebtn_obj, addEnddatebtn_obj;
    BasicComponentsReuse basicComponentsReuse_obj = null;
    Retrofitinterfacefile retrofitinterfacefile;
    EditText etxt_title, etxt_expcompname, etxt_jobprofile, etxt_jobrespo, addetxt_expsalary, addetxt_expcompname, addetxt_jobprofile, addetxt_jobrespo;
    int id, stateid = 1, districtid = 1, jobseekexpid;
    String strjobseekexpid, tokenvalue = "_KDHudbjadguaigwebbHAY3844";
    LoginPOJO2[] userData_arraylist;
    DateFormat dateformat_obj;
    Date date_obj;
    // Date startdate_obj = new Date(), enddate_obj = new Date();
    //Date date_format = new SimpleDateFormat(" yyyy-MM-dd");

    public JobseekExperince_frag() {}
    public static JobseekExperince_frag newInstance(String param1, String param2) {
        JobseekExperince_frag fragment = new JobseekExperince_frag();
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
            mParam2 = getArguments().getString(ARG_PARAM2); }}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        experince_view = inflater.inflate(R.layout.fragment_jobseek_experince_frag, container, false);
        basicComponentsReuse_obj = new BasicComponentsReuse();
        retrofitinterfacefile = Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);

        //Type Caste work--main UI
        typeCast_method();

        //On click listener work
        setOnclicklistner_method();

        //getting id from the login class
        userData_arraylist = basicComponentsReuse_obj.AppSessionValueGet_method(getActivity());
        id = Integer.parseInt(userData_arraylist[0].getId());

        //spinner work
        // State spinner work
        getStateList = basicComponentsReuse_obj.showStateSpinner_method(getActivity(), state_spin, 0);
        state_spin.setOnItemSelectedListener(this);
        // District spinner work
        getDistrictlist = basicComponentsReuse_obj.showDistrictSpinner_method(getActivity(), district_spin, 0);
        district_spin.setOnItemSelectedListener(this);
        getJobseekExp_method();
        return experince_view;
    }//end of onCreate View method

    public void typeCast_method() {
        etxt_jobrespo = experince_view.findViewById(R.id.jsPSexprncerespoid);
        expfulllayoutbox_obj = experince_view.findViewById(R.id.expfulllayoutboxid);
        addmorelayout_obj = experince_view.findViewById(R.id.addmorelayoutboxid);
        radiogroup_obj = experince_view.findViewById(R.id.radiogrpid);
        experienceradio_obj = experince_view.findViewById(R.id.experinceradiobtnid);
        fresherradio_obj = experince_view.findViewById(R.id.fresherradiobtnid);
        addmorelayoutimg_obj = experince_view.findViewById(R.id.addmorelayoutimgid);
        etxt_title = experince_view.findViewById(R.id.jsPSexprncesalaryid);
        etxt_expcompname = experince_view.findViewById(R.id.jsPSexprncompnameid);
        etxt_jobprofile = experince_view.findViewById(R.id.jsPSexprnprofileid);
        expstartdatetxt_obj = experince_view.findViewById(R.id.startjobdatetxtid);
        expstartdatebtn_obj = experince_view.findViewById(R.id.startjobdateiconid);
        expenddatetxt_obj = experince_view.findViewById(R.id.endjobdatetxtid);
        expenddatebtn_obj = experince_view.findViewById(R.id.endjobdatebtnid);
        state_spin = experince_view.findViewById(R.id.psexprncestatespnrid);
        district_spin = experince_view.findViewById(R.id.psexprncedistrictspnrid);
        etxt_jobprofile = experince_view.findViewById(R.id.jsPSexprncerespoid);
        jsexpsubmitbtn_obj = experince_view.findViewById(R.id.jsexpsubmitbtnid);
    }// end of typeCast method

    public void setOnclicklistner_method() {
        radiogroup_obj.setOnCheckedChangeListener(this);
        addmorelayoutimg_obj.setOnClickListener(this);
        expstartdatebtn_obj.setOnClickListener(this);
        expenddatebtn_obj.setOnClickListener(this);
        state_spin.setOnItemSelectedListener(this);
        district_spin.setOnItemSelectedListener(this);
        jsexpsubmitbtn_obj.setOnClickListener(this);
        experienceradio_obj.setChecked(true);
    }// end of onClicklistener

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }// onButtonPressed

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            //     throw new RuntimeException(context.toString()
            //             + " must implement OnFragmentInteractionListener");
        }
    }// end of onAttach

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startjobdateiconid:
                basicComponentsReuse_obj.datetextviewcalender_method(getActivity(), expstartdatetxt_obj);
                break;
            case R.id.endjobdatebtnid:
                basicComponentsReuse_obj.datetextviewcalender_method(getActivity(), expenddatetxt_obj);
                break;
            case R.id.jsexpsubmitbtnid:
                fillAllfield_method();
                //Write code here for submit API hit
                break;
            case R.id.addmorelayoutimgid:
                addLayoutcard_method();
                break;
            case R.id.addjsexpsubmitbtnid:
                getDatafromnewlayout_method();
                basicComponentsReuse_obj.printToast_method(getActivity(), "Button Press update");
                break;
            case R.id.addstartjobdateiconid:
                basicComponentsReuse_obj.datetextviewcalender_method(getActivity(), addexpstartdatetxt_obj);
                break;
            case R.id.addendjobdatebtnid:
                basicComponentsReuse_obj.datetextviewcalender_method(getActivity(), addexpenddatetxt_obj);
                break;
            case R.id.addpsdeleteiconid:
                deleteJobexp_method();
                break;


        }//end of switch case
    }//end of onClick method

    private void getDatafromnewlayout_method() {
        str_company = addetxt_expcompname.getText().toString().trim();
        str_startdate = addexpstartdatetxt_obj.getText().toString().trim();
        str_enddate = addexpenddatetxt_obj.getText().toString().trim();
        str_jobrespo = addetxt_jobrespo.getText().toString().trim();
        str_title = addetxt_expsalary.getText().toString().trim();
        if (str_title.isEmpty() || str_company.isEmpty() || str_jobrespo.isEmpty()) {
            addExperience_method();
        } else expUpdateDataHitAPI_method();
    }// end of getDatafromnewlayout-method

    private void getJobseekExp_method() {
        final Call<GetJobseekExpPojo1> getJobseekexp_obj = retrofitinterfacefile.getJobseekexp_method(id, tokenvalue);
        getJobseekexp_obj.enqueue(new Callback<GetJobseekExpPojo1>() {
            @Override
            public void onResponse(Call<GetJobseekExpPojo1> call, Response<GetJobseekExpPojo1> response) {
                if (response.body() != null) {
                    if (response.body().getStatus().equals(1)) {
                        Toast.makeText(getActivity(), " " + response.body().getData().size(), Toast.LENGTH_SHORT).show();
                        for (int cardcount = 0; cardcount < response.body().getData().size(); cardcount++) {
                            getJobseekexplist.add(response.body().getData().get(cardcount));
                        }
                        etxt_title.setText(getJobseekexplist.get(0).getJobTitle());
                        etxt_expcompname.setText(getJobseekexplist.get(0).getCompanyName());
                        expstartdatetxt_obj.setText(getJobseekexplist.get(0).getStartDate());
                        expenddatetxt_obj.setText(getJobseekexplist.get(0).getEndDate());
                        etxt_jobrespo.setText(getJobseekexplist.get(0).getResponsibilities());
                        strjobseekexpid = getJobseekexplist.get(0).getId();
                        for (int value = 1; value < getJobseekexplist.size(); value++) {
                            addLayoutcard_method();
                            addetxt_expcompname.setText(getJobseekexplist.get(value).getCompanyName());
                            addexpstartdatetxt_obj.setText(getJobseekexplist.get(value).getStartDate());
                            addexpenddatetxt_obj.setText(getJobseekexplist.get(value).getEndDate());
                            addetxt_jobrespo.setText(getJobseekexplist.get(value).getResponsibilities());
                            addetxt_expsalary.setText(getJobseekexplist.get(value).getJobTitle());
                        }
                    }// end of inner if
                }// end of outer if
                else
                    basicComponentsReuse_obj.printToast_method(getActivity(), "else call");
            } // end of the getJobseekexp_method

            @Override
            public void onFailure(Call<GetJobseekExpPojo1> call, Throwable t) {
                basicComponentsReuse_obj.printToast_method(getActivity(), "failure call");
            }
        });
    }// end of getJobseekExp

    private void fillAllfield_method() {
        str_title = etxt_title.getText().toString().trim();
        str_company = etxt_expcompname.getText().toString().trim();
        str_startdate = expstartdatetxt_obj.getText().toString().trim();
        str_enddate = expenddatetxt_obj.getText().toString().trim();
        str_jobrespo = etxt_jobrespo.getText().toString().trim();
        if (str_title.isEmpty() || str_company.isEmpty() || str_jobrespo.isEmpty()) {
            addExperience_method();
        } else expUpdateDataHitAPI_method();
    }// end of fillAllfield_method


    private void expUpdateDataHitAPI_method() {
        basicComponentsReuse_obj.printToast_method(getActivity(), "update method call");
        jobseekexpid = Integer.parseInt(strjobseekexpid);
        try {
            DateFormat f = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
             date_obj = f.parse(str_startdate);
            dateformat_obj = new SimpleDateFormat("MM/dd/yyyy");
            DateFormat time = new SimpleDateFormat("hh:mm:ss a");
            Toast.makeText(getActivity(), "date value is ", Toast.LENGTH_SHORT).show();
            System.out.println("Date: " + dateformat_obj.format(date_obj));
//            System.out.println("Time: " + time.format(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Toast.makeText(getActivity(), "All values are " + jobseekexpid + " " +
                str_title + " " + str_company + " " + " " + " " + stateid + " " + districtid + " " + str_jobrespo, Toast.LENGTH_SHORT).show();


        Call<ResponseBody> updateJobexp_obj = retrofitinterfacefile.updateJobseekExp_meethod(jobseekexpid,
                str_title, str_company,
               "1994-11-11","1996-11-11",
                stateid, districtid, str_jobrespo);

        updateJobexp_obj.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    Toast.makeText(getActivity(), "response not null is calling", Toast.LENGTH_SHORT).show();
                    String datalatest = null;
                    try {
                        datalatest = String.valueOf(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(datalatest);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String status = null;
                    String msg = null;
                    try {
                        status = String.valueOf(jsonObject.getInt("status"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getActivity(), "status is " + status, Toast.LENGTH_SHORT).show();
                }// end of outer if
                else {
                    Log.d("Jobseekerreg3", "onResponse: " + Retrofitinstancefile.base_url + "update-jobseeker-experience?" + "id=" + jobseekexpid + "&"
                            + "jobtitle=" + str_title + "&" + "companyname=" + str_company + "&" + "startdate=" + str_startdate + "&" + "enddate=" + str_enddate
                            + "&" + "state=" + stateid + "&" + "district=" + districtid + "&" + "responsibilities=" + str_jobrespo
                    );

                    Toast.makeText(getActivity(), "else call", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                basicComponentsReuse_obj.printToast_method(getActivity(), "failure call");
            }
        });
    }//end of update data hit API method

    private void addExperience_method() {
        basicComponentsReuse_obj.printToast_method(getActivity(), " " + str_title + " " + str_company + " " + str_startdate + " " + str_enddate + " " + str_jobrespo + " " + stateid + " " + districtid);
        //  stateid=state_spin.getId();
        //   districtid=district_spin.getId();
        final Call<AddjobseekerExperiencePojo1> addJobseekexp_obj = retrofitinterfacefile.addJobseekExperience_method(id, str_title, str_company, str_startdate, str_enddate, stateid, districtid, str_jobrespo);
        addJobseekexp_obj.enqueue(new Callback<AddjobseekerExperiencePojo1>() {
            @Override
            public void onResponse(Call<AddjobseekerExperiencePojo1> call, Response<AddjobseekerExperiencePojo1> response) {

                if (response.body() != null) {
                    if (response.body().getStatus().equals(1)) {
                        basicComponentsReuse_obj.printToast_method(getActivity(), "Success");
                    }// end of inner if
                }// end of outer if
                else
                    basicComponentsReuse_obj.printToast_method(getActivity(), "something went wrong");
            }// end of onResponse
            @Override
            public void onFailure(Call<AddjobseekerExperiencePojo1> call, Throwable t) {
                Toast.makeText(getActivity(), "Failure call", Toast.LENGTH_SHORT).show();
            }
        });
    }//end of addexperience method

    private void addLayoutcard_method() {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        provideraddView = layoutInflater.inflate(R.layout.jsexprnceaddmorelayout, null);
        final int index = 0;
        delete_obj = provideraddView.findViewById(R.id.addpsdeleteiconid);
        addStartdatebtn_obj = provideraddView.findViewById(R.id.addstartjobdateiconid);
        addEnddatebtn_obj = provideraddView.findViewById(R.id.addendjobdatebtnid);
        addetxt_expsalary = provideraddView.findViewById(R.id.addjsPSaddexprncesalaryid);
        addetxt_expcompname = provideraddView.findViewById(R.id.addjsPSaddexprncompnameid);
        addetxt_jobprofile = provideraddView.findViewById(R.id.addjsPSaddexprnprofileid);
        addexpstartdatetxt_obj = provideraddView.findViewById(R.id.addstartjobdatetxtid);
        addexpenddatetxt_obj = provideraddView.findViewById(R.id.addendjobdatetxtid);
        addetxt_jobrespo = provideraddView.findViewById(R.id.addjsPSexprncerespoid);
        addstate_spin = provideraddView.findViewById(R.id.addpsexprncestatespnrid);
        adddistrict_spin = provideraddView.findViewById(R.id.addpsexprncedistrictspnrid);
        addjsexpsubmitbtn_obj = provideraddView.findViewById(R.id.addjsexpsubmitbtnid);
        addjsexpsubmitbtn_obj.setOnClickListener(this);
        addStartdatebtn_obj.setOnClickListener(this);
        addEnddatebtn_obj.setOnClickListener(this);
        delete_obj.setOnClickListener(this);
//        delete_obj.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                 deleteJobexp_method();
//                 ((LinearLayout) provideraddView.getParent()).removeView(provideraddView);
//            }
//
//        });
        addmorelayout_obj.addView(provideraddView, index);
    }//end of addLayout card method

    private void deleteJobexp_method() {

        jobseekexpid = Integer.parseInt(strjobseekexpid);
        basicComponentsReuse_obj.printToast_method(getActivity(), " " + jobseekexpid + " " + id);
        Call<DeletejobexpPojo1> deletejobseekExp_obj = retrofitinterfacefile.deleteJobseekExp_method(jobseekexpid, id);
        deletejobseekExp_obj.enqueue(new Callback<DeletejobexpPojo1>() {
            @Override
            public void onResponse(Call<DeletejobexpPojo1> call, Response<DeletejobexpPojo1> response) {
                if (response.body() != null) {
                    if (response.body().getStatus().equals(1)) {
                        ((LinearLayout) provideraddView.getParent()).removeView(provideraddView);
                        basicComponentsReuse_obj.printToast_method(getActivity(), " Experience Deleted");
                    }// end of inner if
                }// end of outer if
                else
                    Toast.makeText(getActivity(), "else call", Toast.LENGTH_SHORT).show();
            }// end of onResponse

            @Override
            public void onFailure(Call<DeletejobexpPojo1> call, Throwable t) {
                basicComponentsReuse_obj.printToast_method(getActivity(), "Failure call");
            }
        });
    }//end of deleteJobexp_method

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spinner_obj = (Spinner) adapterView;
        switch (spinner_obj.getId()) {
            case R.id.psexprncestatespnrid:
                if (i > 0) {
                    str_state = getStateList.get(i);
                    Toast.makeText(getActivity(), "state value is " + str_state, Toast.LENGTH_SHORT).show();
                    //   basicComponentsReuse_obj.cleartxtviewerrormsg_method(statetxtvw);
                } else str_state = "null";
                break;
            case R.id.psexprncedistrictspnrid:
                if (i > 0) {
                    str_district = getDistrictlist.get(i);
                    Toast.makeText(getActivity(), "District value is " + str_district, Toast.LENGTH_SHORT).show();
                    // basicComponentsReuse_obj.cleartxtviewerrormsg_method(districttxtvw);
                } else str_district = "null";
                break;
        }//end of switch case
    }//end of onItemSelected method

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (experienceradio_obj.isChecked()) {
            str_expfreshvalue = "1";
            expfulllayoutbox_obj.setVisibility(View.VISIBLE);
        } else if (fresherradio_obj.isChecked()) {
            str_expfreshvalue = "0";
            expfulllayoutbox_obj.setVisibility(View.GONE);
        } else {
            str_expfreshvalue = "1";
            expfulllayoutbox_obj.setVisibility(View.VISIBLE);
        }
    }//end of onChecked changed method

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}//end of main class
