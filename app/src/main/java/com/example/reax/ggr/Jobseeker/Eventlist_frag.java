package com.example.reax.ggr.Jobseeker;

import android.content.Context;
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
import com.example.reax.ggr.POJO_Classes.EventlistPojo1;
import com.example.reax.ggr.POJO_Classes.EventlistPojo2;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Eventlist_frag extends Fragment implements Eventjoblist_frag.OnFragmentInteractionListener {

    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;

    Toolbar eventlisttool_obj;
    RecyclerView eventlistrecycler_obj;
    RecyclerView.LayoutManager eventlist_lmngr;
    public static final int tab_viewtp=2;
    Retrofitinterfacefile retrofitinterfacefile;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    ArrayList<EventlistPojo2> eventlist_arraylist=new ArrayList<>();
    String outsideTokenno="_KDHudbjadguaigwebbHAY3844";

    private OnFragmentInteractionListener mListener;
    public Eventlist_frag() { }
    public static Eventlist_frag newInstance(String param1, String param2) {
        Eventlist_frag fragment = new Eventlist_frag();
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
        View eventlist_view= inflater.inflate(R.layout.fragment_eventlist_frag, container, false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        //Type caste work
        eventlistrecycler_obj=eventlist_view.findViewById(R.id.eventlistreclid);
        //Fragment show back press Sharedpreference work
        basicComponentsReuse_obj.fragmentbackpresspreference_method(getActivity(),"mainActfragmentsshow","jseventlistfrag","1");
        //Toolbar work
        eventlisttool_obj=eventlist_view.findViewById(R.id.eventlisttoolbarid);
        basicComponentsReuse_obj.innerfragToolbarShow_method(getActivity(),eventlisttool_obj,"Events List","mainActfragmentsshow");
        //RecyclerView work
        eventlistrecycler_obj.setHasFixedSize(true);
        eventlist_lmngr=new LinearLayoutManager(getActivity());
        eventlistrecycler_obj.setLayoutManager(eventlist_lmngr);
        //get all jbs jobs API work
        eventlist_method();
        return  eventlist_view;
    }//end of onCreate view method

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);}}
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
        //    throw new RuntimeException(context.toString()
        //            + " must implement OnFragmentInteractionListener");
        }}

        private  void eventlist_method(){
            final Call<EventlistPojo1> eventlist=retrofitinterfacefile.geteventlist_method(outsideTokenno);
            eventlist.enqueue(new Callback<EventlistPojo1>() {
                @Override
                public void onResponse(Call<EventlistPojo1> call, Response<EventlistPojo1> response) {
                    if (response.body()!=null){
                        if (response.body().getStatus().equals(1)){
                            basicComponentsReuse_obj.printToast_method(getActivity(),""+response.body().getData().size());
                            for(int getallval=0;getallval<response.body().getData().size();getallval++) {
                                eventlist_arraylist.add(response.body().getData().get(getallval));
                    }//end of for looop
                        }//end of inner if condition
                        else basicComponentsReuse_obj.printToast_method(getActivity(),"Something went wrong");
                        Recycleradapter recycleradapter =new Recycleradapter(getActivity(),eventlist_arraylist,tab_viewtp);
                        eventlistrecycler_obj.setAdapter(recycleradapter);
                    }//end of outer if condition
                    else basicComponentsReuse_obj.printToast_method(getActivity(),"Something went wrong. Please try again");
                }//end of onResponse
                @Override
                public void onFailure(Call<EventlistPojo1> call, Throwable t) {
                    basicComponentsReuse_obj.printToast_method(getActivity(),"Failure call");
                }//end of onFailure method
            });
        }//end of even list API method

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }
    @Override
    public void onFragmentInteraction(Uri uri) {    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
