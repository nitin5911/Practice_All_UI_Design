package com.example.reax.ggr.Jobseeker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reax.ggr.Adapter.Recycleradapter;
import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.MainActivities.Jobseeker_main;
import com.example.reax.ggr.POJO_Classes.EventjoblistPojo1;
import com.example.reax.ggr.POJO_Classes.EventjoblistPojo2;
import com.example.reax.ggr.POJO_Classes.EventlistPojo2;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Eventjoblist_frag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Toolbar eventjoblisttool_obj;
    RecyclerView eventjoblistrecycler_obj;
    RecyclerView.LayoutManager eventjoblist_lmngr;
    public static final int tab_viewtp=3;
    Retrofitinterfacefile retrofitinterfacefile;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    ArrayList<EventjoblistPojo2> eventjobslist_arraylist=new ArrayList<>();
    String outsideTokenno="_KDHudbjadguaigwebbHAY3844";    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int id=3;
    private OnFragmentInteractionListener mListener;

    public Eventjoblist_frag() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Eventjoblist_frag newInstance(String param1, String param2) {
        Eventjoblist_frag fragment = new Eventjoblist_frag();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View eventjoblist_view= inflater.inflate(R.layout.fragment_eventjoblist_frag2, container, false);
        eventjoblisttool_obj=eventjoblist_view.findViewById(R.id.eventjoblisttoolbarid);
        eventjoblistrecycler_obj=eventjoblist_view.findViewById(R.id.eventjoblistreclid);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);

        eventjoblistrecycler_obj.setHasFixedSize(true);
        eventjoblist_lmngr=new LinearLayoutManager(getActivity());
        eventjoblistrecycler_obj.setLayoutManager(eventjoblist_lmngr);

        eventjoblisttool_obj.setTitle("Events Job List");
        eventjoblisttool_obj.setTitleTextColor(Color.WHITE);
        eventjoblisttool_obj.setNavigationIcon(R.drawable.leftarrow);
        eventjoblisttool_obj.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor aboutus_preference=getActivity().getSharedPreferences("aboutusvisibiltity",Context.MODE_PRIVATE).edit();
                aboutus_preference.clear();
                aboutus_preference.commit();
                Intent intent_about = new Intent(getActivity(),Jobseeker_main.class);
                startActivity(intent_about);
                getActivity().finish();
            }
        });
        eventJobslist_method();
    return eventjoblist_view;
    }

    private void eventJobslist_method(){
        Call<EventjoblistPojo1>eventjobslist_obj=retrofitinterfacefile.getEventjoblist_method(outsideTokenno,id);
        eventjobslist_obj.enqueue(new Callback<EventjoblistPojo1>() {
            @Override
            public void onResponse(Call<EventjoblistPojo1> call, Response<EventjoblistPojo1> response) {
                if (response.body()!=null){
                    if (response.body().getStatus().equals(1)){
                        basicComponentsReuse_obj.printToast_method(getActivity(),""+response.body().getStatus());
                  for (int jlvalue=0; jlvalue<response.body().getData().size();jlvalue++){
                      eventjobslist_arraylist.add(response.body().getData().get(jlvalue));
                  }
                    }//end of inner if
                    Recycleradapter recycleradapter =new Recycleradapter(getActivity(),eventjobslist_arraylist,tab_viewtp);
                    eventjoblistrecycler_obj.setAdapter(recycleradapter);
                }
            }

            @Override
            public void onFailure(Call<EventjoblistPojo1> call, Throwable t) {
               basicComponentsReuse_obj.printToast_method(getActivity(),"failure call");
            }
        });
    }
    // TODO: Rename method, update argument and hook method into UI event
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
        //    throw new RuntimeException(context.toString()
       //             + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
