package com.example.reax.ggr.Jobseeker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.MainActivities.Jobseeker_main;
import com.example.reax.ggr.R;

import java.util.ArrayList;

public class Jobprefrence_frag extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
// TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<String> getSector_arraylist= new ArrayList<>();
    ArrayList<String> getSkills_arraylist= new ArrayList<>();

    Button jsjobprefsavebtn_obj;
    Toolbar jobprefrencetool_obj;
    private OnFragmentInteractionListener mListener;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    ImageButton addsctrimgbtn_obj,addskillsimgbtn_obj;
    TextView addsectrtxt_obj,addskillstxt_obj;
    public Jobprefrence_frag() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Jobprefrence_frag newInstance(String param1, String param2) {
        Jobprefrence_frag fragment = new Jobprefrence_frag();
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
        View jobprefrence_view= inflater.inflate(R.layout.fragment_jobprefrence_frag, container, false);
        jobprefrencetool_obj=jobprefrence_view.findViewById(R.id.jobprefrencetoolid);
        addsctrimgbtn_obj=jobprefrence_view.findViewById(R.id.jobprefaddsctrbtnid);
        addsectrtxt_obj=jobprefrence_view.findViewById(R.id.jobprefaddsctrtxtid);
        addskillsimgbtn_obj=jobprefrence_view.findViewById(R.id.addskillsimgbtnid);
        addskillstxt_obj=jobprefrence_view.findViewById(R.id.addskillstxtid);
        jsjobprefsavebtn_obj=jobprefrence_view.findViewById(R.id.jsjobprefsavebtnid);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        jobprefrencetool_obj.setTitle("Job Prefrence");
        jobprefrencetool_obj.setTitleTextColor(Color.WHITE);
        jobprefrencetool_obj.setNavigationIcon(R.drawable.leftarrow);
        jobprefrencetool_obj.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_about = new Intent(getActivity(),Jobseeker_main.class);
                startActivity(intent_about);
                getActivity().finish();
            }
        });
        addsctrimgbtn_obj.setOnClickListener(this);
        addskillsimgbtn_obj.setOnClickListener(this);
        jsjobprefsavebtn_obj.setOnClickListener(this);
     return jobprefrence_view;
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
       //     throw new RuntimeException(context.toString()
       //             + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
    case R.id.jobprefaddsctrbtnid:
        basicComponentsReuse_obj.printToast_method(getActivity(),"plus pressed");
        addsectrlayout_method();
        break;
    case R.id.jsjobprefsavebtnid:
        basicComponentsReuse_obj.printToast_method(getActivity(), "Save pressed");
        Intent intent= new Intent(getActivity(),Jobseeker_main.class);
        startActivity(intent);
        getActivity().finish();
        break;
    case R.id.addskillsimgbtnid:
        addskillslayout_method();
        break;
}
    }

     private void addsectrlayout_method() {
         AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
         builder.setTitle("Choose some Sector");
         builder.setCancelable(true);
         // add a checkbox list
         final String[] sector = {"Sector 1", "Sector 2", "Sector 3", "Sector 4", "Sector 5"};
         final boolean[] checkedItems = {false, false, false, false, false};
         if (getSector_arraylist != null) {
             for (int j = 0; j < getSector_arraylist.size(); j++) {
                 String value=getSector_arraylist.get(j);
                 for(int count=0;count<sector.length;count++) {
                     if (value.equals(sector[count])){
                         checkedItems[count]=true;
                     }//end of if
                 }//end of for
             }//end of outer for
         }//end of outer if
             basicComponentsReuse_obj.printToast_method(getActivity(),"arraylist clear");
             builder.setMultiChoiceItems(sector, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                     // user checked or unchecked a box
//                 switch (which){
//                     case 0:
//                         if (isChecked){
//                            basicComponentsReuse_obj.printToast_method(getActivity(),"1");
//                            getSector=sector[0];
//                         }
//                         break;
//                     case 1:
//                         if (isChecked){
//                             basicComponentsReuse_obj.printToast_method(getActivity(),"2");
//                         }
//                         break;
//                     case 2:
//                         if (isChecked){
//                             basicComponentsReuse_obj.printToast_method(getActivity(),"3");
//                         }
//                         break;
//                     case 3:
//                         if (isChecked){
//                             basicComponentsReuse_obj.printToast_method(getActivity(),"4");
//                         }
//                         break;
//                     case 4:
//                         if (isChecked){
//                             basicComponentsReuse_obj.printToast_method(getActivity(),"5");
//                         }
//                         break;

                     //           }
                     if (isChecked) {
                         getSector_arraylist.add(sector[which]);
                         checkedItems[which] = true;
                     } else {
                         getSector_arraylist.remove(sector[which]);
                         checkedItems[which] = false;
                     }
                     basicComponentsReuse_obj.printToast_method(getActivity(), "" + getSector_arraylist);
                 }
             });

             // add OK and Cancel buttons
             builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     // user clicked OK
                     addsectrtxt_obj.setText(" ");
                     basicComponentsReuse_obj.printToast_method(getActivity(), "Ok pressed");
                     if (getSector_arraylist.size() != 0) {

                         for (int i = 0; i < getSector_arraylist.size(); i++) {
                             addsectrtxt_obj.setText(addsectrtxt_obj.getText() + getSector_arraylist.get(i) + "  ");
                         }
                     }
                 }
             });
             builder.setNegativeButton("Cancel", null);
             // create and show the alert dialog
             AlertDialog dialog = builder.create();
             dialog.show();

     }
    private void addskillslayout_method() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose some Sector");
        builder.setCancelable(true);
        // add a checkbox list
        final String[] sectors = {"Sector 1", "Sector 2", "Sector 3", "Sector 4", "Sector 5"};
        final boolean[] checkedItems = {false, false, false, false, false};
        if (getSkills_arraylist != null) {
            for (int j = 0; j < getSkills_arraylist.size(); j++) {
                String value=getSkills_arraylist.get(j);
                for(int count=0;count<sectors.length;count++) {
                    if (value.equals(sectors[count])){
                        checkedItems[count]=true;
                    }//end of if
                }//end of for
            }//end of outer for
        }//end of outer if
        basicComponentsReuse_obj.printToast_method(getActivity(),"arraylist clear");
        builder.setMultiChoiceItems(sectors, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // user checked or unchecked a box
//                 switch (which){
//                     case 0:
//                         if (isChecked){
//                            basicComponentsReuse_obj.printToast_method(getActivity(),"1");
//                            getSector=sector[0];
//                         }
//                         break;
//                     case 1:
//                         if (isChecked){
//                             basicComponentsReuse_obj.printToast_method(getActivity(),"2");
//                         }
//                         break;
//                     case 2:
//                         if (isChecked){
//                             basicComponentsReuse_obj.printToast_method(getActivity(),"3");
//                         }
//                         break;
//                     case 3:
//                         if (isChecked){
//                             basicComponentsReuse_obj.printToast_method(getActivity(),"4");
//                         }
//                         break;
//                     case 4:
//                         if (isChecked){
//                             basicComponentsReuse_obj.printToast_method(getActivity(),"5");
//                         }
//                         break;

                //           }
                if (isChecked) {
                    getSkills_arraylist.add(sectors[which]);
                    checkedItems[which] = true;
                } else {
                    getSkills_arraylist.remove(sectors[which]);
                    checkedItems[which] = false;
                }
                basicComponentsReuse_obj.printToast_method(getActivity(), "" + getSkills_arraylist);
            }
        });

        // add OK and Cancel buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user clicked OK
                addskillstxt_obj.setText(" ");
                basicComponentsReuse_obj.printToast_method(getActivity(), "Ok pressed");
                if (getSkills_arraylist.size() != 0) {

                    for (int i = 0; i < getSkills_arraylist.size(); i++) {
                        addskillstxt_obj.setText(addskillstxt_obj.getText() + getSkills_arraylist.get(i) + "  ");
                    }
                }
            }
        });
        builder.setNegativeButton("Cancel", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
