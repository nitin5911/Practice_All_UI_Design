package com.example.reax.ggr.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reax.ggr.MainActivities.Jobdescription;
import com.example.reax.ggr.Jobseeker.Eventjoblist_frag;
import com.example.reax.ggr.POJO_Classes.EventjoblistPojo2;
import com.example.reax.ggr.POJO_Classes.EventlistPojo2;
import com.example.reax.ggr.POJO_Classes.EventparticipatePojo1;
import com.example.reax.ggr.POJO_Classes.GetJBSrecentAlljobsPOJO2;
import com.example.reax.ggr.R;

import java.util.ArrayList;

public class Recycleradapter extends RecyclerView.Adapter<Recycleradapter.Viewholderclass> {
    Context context;
    int tab_viewtp;
    ArrayList<GetJBSrecentAlljobsPOJO2> jobseeker_arraylist;
    ArrayList<EventlistPojo2> event_arraylist;
    ArrayList<EventjoblistPojo2> eventjoblist_arraylist;
    ArrayList<EventparticipatePojo1> eventjobapply_arraylist;
    ArrayList<String> jobapplied_arraylist;
    ArrayList<String> myinterview_arraylist;

    public Recycleradapter(Context context, ArrayList arrayList, int tab_viewtp) {
        this.tab_viewtp = tab_viewtp;
        this.context = context;
        this.tab_viewtp = tab_viewtp;
        this.context = context;
        switch (this.tab_viewtp) {
            case 1:
                jobseeker_arraylist = arrayList;
                break;
            case 2:
                event_arraylist = arrayList;
                break;
            case 3:
                eventjoblist_arraylist = arrayList;
                break;
            case 4:
                eventjobapply_arraylist = arrayList;
                break;
            case 5:
                myinterview_arraylist=arrayList;
                break;
            case 6:
                jobapplied_arraylist = arrayList;
                break;
        }//end of switch case
    }//end of Constructor

    @Override
    public Viewholderclass onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (tab_viewtp) {
            case 1:
                View jobseeker_obj = LayoutInflater.from(parent.getContext()).inflate(R.layout.jobseek_card, parent, false);
                Viewholderclass jobseekerviewholderclass = new Viewholderclass(jobseeker_obj);
                return jobseekerviewholderclass;
            case 2:
                View eventlist_obj = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventlistcard, parent, false);
                Viewholderclass eventlistviewholderclass = new Viewholderclass(eventlist_obj);
                return eventlistviewholderclass;
            case 3:
                View eventjoblist_obj = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventjoblistcard, parent, false);
                Viewholderclass eventjoblistviewholderclass = new Viewholderclass(eventjoblist_obj);
                return eventjoblistviewholderclass;
            case 4:
                View jobapplied_obj = LayoutInflater.from(parent.getContext()).inflate(R.layout.jobappliedcard, parent, false);
                Viewholderclass jobaplliedviewholderclass = new Viewholderclass(jobapplied_obj);
                return jobaplliedviewholderclass;
            case 5:
                View myinterview_obj = LayoutInflater.from(parent.getContext()).inflate(R.layout.myinterviewcard, parent, false);
                Viewholderclass myinterviewviewholderclass = new Viewholderclass(myinterview_obj);
                return myinterviewviewholderclass;
            case 6:
                View eventapproval_obj = LayoutInflater.from(parent.getContext()).inflate(R.layout.jobappliedcard, parent, false);
                Viewholderclass eventapprovalviewholderclass = new Viewholderclass(eventapproval_obj);
                return eventapprovalviewholderclass;

        }//end of switch case
        return null;
    }//end of onCreateViewHolder class

    @Override
    public void onBindViewHolder(Viewholderclass holder, int position) {
        switch (tab_viewtp) {
            case 1:
                for(int jscount=0;jscount<jobseeker_arraylist.size();jscount++){
                    holder.js_compname.setText(jobseeker_arraylist.get(position).getEmployeer().getOrganizationName());
                    holder.js_jobtype.setText(jobseeker_arraylist.get(position).getJobType().getType());
                    holder.js_jobtitle.setText(jobseeker_arraylist.get(position).getJobTitle());
                    holder.js_jobqualfctn.setText(jobseeker_arraylist.get(position).getQualificationId());
                    holder.js_jobctc.setText(jobseeker_arraylist.get(position).getSalary());
                    holder.js_compaddrs.setText(jobseeker_arraylist.get(position).getEmployeer().getRegisteredOffice());
//                    Picasso.with(context).load(jobseeker_arraylist.get(position).getEmployeer().getLogo().toString()).into(holder.js_complogo);
                }//end of for loop
                break;
            case 2:
                for (int jsjoblist=0; jsjoblist<event_arraylist.size();jsjoblist++){
                    holder.el_eventtitle_txt.setText(event_arraylist.get(position).getEventTitle());
                    holder.el_eventtype_txt.setText(event_arraylist.get(position).getEventType());
                    holder.el_eventlocation_txt.setText(event_arraylist.get(position).getLocation());
                    holder.el_eventdate_txt.setText(event_arraylist.get(position).getDate());

                }
                break;
            case 3:
                for (int eljobs=0; eljobs<eventjoblist_arraylist.size();eljobs++){
                    holder.el_jobtitletxt.setText(eventjoblist_arraylist.get(position).getJobTitle());
                    holder.el_companynametxt.setText(eventjoblist_arraylist.get(position).getContactPerson());
                    holder.el_jobtypetxt.setText(eventjoblist_arraylist.get(position).getJobType());
                    holder.el_jobmodetxt.setText(eventjoblist_arraylist.get(position).getJobMode());
                    holder.el_salary.setText(eventjoblist_arraylist.get(position).getSalary());

                }
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }//end of switch case
    }//end of onBindViewHolder method

    @Override
    public int getItemCount() {
        switch (tab_viewtp) {
            case 1:
                return jobseeker_arraylist.size();
            case 2:
                return event_arraylist.size();
            case 3:
                return eventjoblist_arraylist.size();
            case 4:
                return eventjobapply_arraylist.size();
            case 5:
                return myinterview_arraylist.size();
            case 6:
                return jobapplied_arraylist.size();
            default:
                return 0;
        }//end of switch case
    }//end of getItemCount method

    public class Viewholderclass extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView Jobseekercard_obj = null, Eventlistcard_obj = null, Eventjoblistcard_obj = null,Jobappliedcard_obj = null, Eventapllier_obj = null,myinterviewcard=null;
        TextView js_compname,js_jobtitle,js_jobtype,js_jobctc,js_compaddrs,js_jobqualfctn,el_eventtitle_txt,el_eventtype_txt,el_eventlocation_txt,el_eventdate_txt,el_jobtitletxt,el_jobtypetxt,el_jobmodetxt,
                el_companynametxt,el_salary;
        ImageView js_complogo;
        public Viewholderclass(View itemView) {
            super(itemView);
            switch (tab_viewtp) {
                case 1:
                    Jobseekercard_obj = itemView.findViewById(R.id.jobseekcardmainid);
                    js_compname=itemView.findViewById(R.id.jscompanynameid);
                    js_jobtitle=itemView.findViewById(R.id.jsJobTitleid);
                    js_jobtype=itemView.findViewById(R.id.jsjobTypeid);
                    js_jobctc=itemView.findViewById(R.id.jsjobctcid);
                    js_compaddrs=itemView.findViewById(R.id.jscompaddrsid);
                    js_jobqualfctn=itemView.findViewById(R.id.jsqualificationid);
                    js_complogo=itemView.findViewById(R.id.jscomplogoid);
                    Jobseekercard_obj.setOnClickListener(this);
                    break;
                case 2:
                    Eventlistcard_obj = itemView.findViewById(R.id.eventlistcardid);
                    el_eventtitle_txt=itemView.findViewById(R.id.eleventtitletxtid);
                    el_eventtype_txt=itemView.findViewById(R.id.eleventtypetxtid);
                    el_eventlocation_txt=itemView.findViewById(R.id.eleventlocationtxtid);
                    el_eventdate_txt=itemView.findViewById(R.id.eleventdatetxtid);
                    Eventlistcard_obj.setOnClickListener(this);
                    break;
                case 3:
                    Eventjoblistcard_obj = itemView.findViewById(R.id.eventjoblistcardid);
                    el_jobtitletxt=itemView.findViewById(R.id.eljobtitletxtid);
                    el_companynametxt=itemView.findViewById(R.id.elcompanynametxtid);
                    el_jobtypetxt=itemView.findViewById(R.id.eljobtypetxtid);
                    el_jobmodetxt=itemView.findViewById(R.id.eljobmodetxtid);
                    el_salary=itemView.findViewById(R.id.elsalarytxtid);
                    Eventjoblistcard_obj.setOnClickListener(this);
                    break;
                case 4:
                    Eventapllier_obj = itemView.findViewById(R.id.jobappliedcardid);
                    Eventapllier_obj.setOnClickListener(this);
                    break;
                case 5:
                    myinterviewcard = itemView.findViewById(R.id.myinterviewcardid);
                    myinterviewcard.setOnClickListener(this);
                    break;
                case 6:
                    Jobappliedcard_obj = itemView.findViewById(R.id.jobappliedcardid);
                    Jobappliedcard_obj.setOnClickListener(this);
                    break;
            }//end of switch case

        }//end of constructor

        @Override
        public void onClick(View view) {
            switch (tab_viewtp) {
                case 1:
                    switch (view.getId()) {
                        case R.id.jobseekcardmainid:
                            itemView.getContext().startActivity(new Intent(itemView.getContext(),Jobdescription.class));
                            ((AppCompatActivity)context).finish();
                            Toast.makeText(context, "Jobseeker", Toast.LENGTH_SHORT).show();

//                            itemView.getContext().startActivity(new Intent(itemView.getContext(),Jobdescription.class));
//                            ((AppCompatActivity)context).finish();  break;
                    }//end of switch case
                case 2:
                    switch (view.getId()) {
                        case R.id.eventlistcardid:
                            Eventjoblist_frag eventjoblistFrag_obj= new Eventjoblist_frag();
                            ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction().add(R.id.drawerlayoutmainid,eventjoblistFrag_obj).addToBackStack(null).commit();
                            Toast.makeText(context, "Event list", Toast.LENGTH_SHORT).show();
                    }//end of switch case
                    break;
                case 3:
                    switch (view.getId()) {
                        case R.id.eventjoblistcardid:
                            itemView.getContext().startActivity(new Intent(itemView.getContext(),Jobdescription.class));
                            ((AppCompatActivity)context).finish();

                            Toast.makeText(context, "Event joblist", Toast.LENGTH_SHORT).show();
                    }//end of switch case
                    break;
                case 4:
                    switch (view.getId()) {
                        case R.id.jobappliedcardid:
                            itemView.getContext().startActivity(new Intent(itemView.getContext(),Jobdescription.class));
                            ((AppCompatActivity)context).finish();

                            Toast.makeText(context, "Event job apllied", Toast.LENGTH_SHORT).show();
                    }//end of switch case
                    break;
                case 5:
                    switch (view.getId()) {
                        case R.id.myinterviewcardid:
//                            itemView.getContext().startActivity(new Intent(itemView.getContext(), com.example.reax.ggr.Jobseeker.Jobdescription.class));
//                            ((AppCompatActivity)context).finish();
                            Toast.makeText(context, "My Interview card is calling", Toast.LENGTH_SHORT).show();
                    }//end of switch case
                    break;
                case 6:
                    switch (view.getId()) {
                        case R.id.jobappliedcardid:
                            itemView.getContext().startActivity(new Intent(itemView.getContext(),Jobdescription.class));
                            ((AppCompatActivity)context).finish();
                            Toast.makeText(context, "Job apllied", Toast.LENGTH_SHORT).show();

                    }//end of switch case
                    break;
            }//end of outer switch case
        }//end of onCLick method
    }//end of Viewholder class
}//end of main class
