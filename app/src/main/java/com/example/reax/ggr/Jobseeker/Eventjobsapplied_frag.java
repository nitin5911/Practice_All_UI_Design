package com.example.reax.ggr.Jobseeker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reax.ggr.Adapter.Recycleradapter;
import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.POJO_Classes.EventparticipatePojo1;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Eventjobsapplied_frag extends Fragment {

    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;

    RecyclerView jobappliedrecycler_obj;
    RecyclerView.LayoutManager eventjobapllied_lmngr;
    public static final int tab_viewtp=4;
    ArrayList<String> eventjobapllied_arraylist=new ArrayList<>();
    int eventno, idno;
    private OnFragmentInteractionListener mListener;
    Retrofitinterfacefile retrofitinterfacefile;
    BasicComponentsReuse basicComponentsReuse_obj=null;

    public Eventjobsapplied_frag() {}
    public static Eventjobsapplied_frag newInstance(String param1, String param2) {
        Eventjobsapplied_frag fragment = new Eventjobsapplied_frag();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View jobapllied_view= inflater.inflate(R.layout.fragment_eventjobsapplied_frag2, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        //Type caste work
        jobappliedrecycler_obj=jobapllied_view.findViewById(R.id.eventjobaplliedreclid);
        //RecyclerView Work
        jobappliedrecycler_obj.setHasFixedSize(true);
        eventjobapllied_lmngr=new LinearLayoutManager(getActivity());
        jobappliedrecycler_obj.setLayoutManager(eventjobapllied_lmngr);
        eventjobapllied_arraylist.add("amit");
        //get all jbs jobs API work
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        jobsapplied_method();
        return jobapllied_view;
    }//end of onCreate method

    private void jobsapplied_method(){
        Call<EventparticipatePojo1> eventparticipate=retrofitinterfacefile.getEventparticipatelist_method(eventno,idno);
        eventparticipate.enqueue(new Callback<EventparticipatePojo1>() {
            @Override
            public void onResponse(Call<EventparticipatePojo1> call, Response<EventparticipatePojo1> response) {
                if (response.body()!=null){
                    if (response.body().getStatus().equals(1)){
                        basicComponentsReuse_obj.printToast_method(getActivity(),""+response.body().getStatus());

                    }// end of inner if
                    else basicComponentsReuse_obj.printToast_method(getActivity(),"Something went wrong. Please try again");

                    //RecyclerView Adapter work
                    Recycleradapter recycleradapter =new Recycleradapter(getActivity(),eventjobapllied_arraylist,tab_viewtp);
                    jobappliedrecycler_obj.setAdapter(recycleradapter);
                }// end of outer if
                else
                    basicComponentsReuse_obj.printToast_method(getActivity(),"Something went wrong");
            }//end of onResponse method
            @Override
            public void onFailure(Call<EventparticipatePojo1> call, Throwable t) {
             basicComponentsReuse_obj.printToast_method(getActivity(),"Failure call");
            }//end of onFailure method
        });
    }// end of jobsapplied method

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri); } }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
//            throw new RuntimeException(context.toString()
  //                  + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
