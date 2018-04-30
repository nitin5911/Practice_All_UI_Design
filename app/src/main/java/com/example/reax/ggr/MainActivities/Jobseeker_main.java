package com.example.reax.ggr.MainActivities;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reax.ggr.Adapter.Jobseekeradapter;
import com.example.reax.ggr.Adapter.Recycleradapter;
import com.example.reax.ggr.Common_Activity.Login;
import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.Common_Fragments.Aboutus_frag;
import com.example.reax.ggr.Common_Fragments.Changepass_frag;
import com.example.reax.ggr.Common_Fragments.Termscondition_frag;
import com.example.reax.ggr.Jobseeker.Appliedlist_frag;
import com.example.reax.ggr.Jobseeker.Eventlist_frag;
import com.example.reax.ggr.Jobseeker.Jobprefrence_frag;
import com.example.reax.ggr.Jobseeker.Jobseekerupdate_frag;
import com.example.reax.ggr.Jobseeker.Jobseekprofessionalsummary;
import com.example.reax.ggr.Jobseeker.Myinterviews_frag;
import com.example.reax.ggr.POJO_Classes.GetJBSrecentAlljobsPOJO1;
import com.example.reax.ggr.POJO_Classes.GetJBSrecentAlljobsPOJO2;
import com.example.reax.ggr.POJO_Classes.LoginPOJO2;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Jobseeker_main extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener {
    Toolbar toolbar_obj;
    DrawerLayout drawerLayout_obj;
    public LinearLayout full_layout;
    ActionBarDrawerToggle actionBarDrawerToggle_obj;
    TextView navusername;
    ListView listView_obj;
    RecyclerView jobseekmainrecycler_obj;
    RecyclerView.LayoutManager jobseekmain_lmngr;
    ArrayList<GetJBSrecentAlljobsPOJO2> jobseekmain_arraylist=new ArrayList<>();
    LoginPOJO2[] userData_arraylist;
    public static final int tab_viewtp=1;
    String updateshow_status,profsumryshow_status,appliedlistshow_status,
            myinterviewsshow_status,eventlistshow_status,
            jsaboutus_status,jsterms_status,jschangepass_status;
    boolean doublebackpressed=false;
    android.os.Handler handler_obj=new android.os.Handler();
    CircleImageView navphoto;

    String outsideTokenno="_KDHudbjadguaigwebbHAY3844",authkey="null";
    int jobseekerid=0;
    Retrofitinterfacefile retrofitinterfacefile;
    BasicComponentsReuse basicComponentsReuse_obj=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobseekermain);
        //Type Caste Work
        toolbar_obj=findViewById(R.id.jobseekermaintoolbarid);
        full_layout=findViewById(R.id.fulllayoutid);
        drawerLayout_obj=findViewById(R.id.drawerlayoutmainid);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        //RecyclerView work
        jobseekmainrecycler_obj=findViewById(R.id.jobseekmainreclid);
        jobseekmainrecycler_obj.setHasFixedSize(true);
        jobseekmain_lmngr=new LinearLayoutManager(getApplicationContext());
        jobseekmainrecycler_obj.setLayoutManager(jobseekmain_lmngr);
        userData_arraylist=basicComponentsReuse_obj.AppSessionValueGet_method(getApplicationContext());
        authkey=userData_arraylist[0].getAuthKey();
        jobseekerid= Integer.parseInt(userData_arraylist[0].getId());

        //Drawer Toggle Button Coding
        actionBarDrawerToggle_obj=new ActionBarDrawerToggle(this,drawerLayout_obj,toolbar_obj,R.string.opendrawer,R.string.closedrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        //Toolbar coding
        setSupportActionBar(toolbar_obj);
        getSupportActionBar().setTitle("Ghar Ghar Rozgar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //Drawer Toggle Button Coding
        actionBarDrawerToggle_obj=new ActionBarDrawerToggle(this,drawerLayout_obj,toolbar_obj,R.string.opendrawer,R.string.closedrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout_obj.addDrawerListener(actionBarDrawerToggle_obj);

        //Jobseeker_main Menu Item in Grid View Format
        navusername=findViewById(R.id.navusernameid);
        navphoto=findViewById(R.id.navphotoid);
        listView_obj=findViewById(R.id.navlistviewid);
        Jobseekeradapter gridvAdapter=new Jobseekeradapter(getApplicationContext());
        listView_obj.setAdapter(gridvAdapter);
        toolbar_obj.setTitleTextColor(Color.WHITE);
        toolbar_obj.setNavigationIcon(R.drawable.togglebutton);
        drawerLayout_obj.addDrawerListener(actionBarDrawerToggle_obj);
        listView_obj.setOnItemClickListener(this);

        //get all jbs jobs API work
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
        getAllJbsJobs_method();
    }//end of onCreate method

    private void getAllJbsJobs_method() {
        Call<GetJBSrecentAlljobsPOJO1> districtData=retrofitinterfacefile.getJbsRecentJobs_method(authkey,jobseekerid);
        districtData.enqueue(new Callback<GetJBSrecentAlljobsPOJO1>() {
            @Override
            public void onResponse(Call<GetJBSrecentAlljobsPOJO1> call, Response<GetJBSrecentAlljobsPOJO1> response) {
                if (response.body()!=null){
                    if (response.body().getStatus().equals(1)){
                        for(int getallval=0;getallval<response.body().getData().size();getallval++) {
                            jobseekmain_arraylist.add(response.body().getData().get(getallval));
                        }//end of for loop
                         }//end of inner if condition
                    else basicComponentsReuse_obj.printToast_method(getApplicationContext(),"Something went wrong.");
                    Recycleradapter recycleradapter =new Recycleradapter(Jobseeker_main.this,jobseekmain_arraylist,tab_viewtp);
                    jobseekmainrecycler_obj.setAdapter(recycleradapter);
                }//end of if condition
                else basicComponentsReuse_obj.printToast_method(getApplicationContext(),"Something went wrong . Please try again");
            }//end of onResponse method
            @Override
            public void onFailure(Call<GetJBSrecentAlljobsPOJO1> call, Throwable t) {
                basicComponentsReuse_obj.printToast_method(getApplicationContext(),"Check internet connection or Server Problem");
            }//end of onFailure method
        });
    }//end of get all jobs API hit method

    @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                Jobseekerupdate_frag jobseekerupdateFrag_obj = new Jobseekerupdate_frag();
                moveToFragCode_method(jobseekerupdateFrag_obj);
                break;
            case 1:
                Jobseekprofessionalsummary jobseekprofessionalsummary_obj = new Jobseekprofessionalsummary();
                moveToFragCode_method(jobseekprofessionalsummary_obj);
                break;
            case 2:
                Appliedlist_frag jobappliedFrag_obj= new Appliedlist_frag();
                moveToFragCode_method(jobappliedFrag_obj);
                break;
            case 3:
                Myinterviews_frag myinterviewFrag_obj = new Myinterviews_frag();
                moveToFragCode_method(myinterviewFrag_obj);
                break;
            case 4:
                Jobprefrence_frag jobprefrenceFrag_obj= new Jobprefrence_frag();
                moveToFragCode_method(jobprefrenceFrag_obj);
                break;
            case 5:
                Eventlist_frag eventlistFrag_obj= new Eventlist_frag();
                moveToFragCode_method(eventlistFrag_obj);
                break;
            case 6:
                Toast.makeText(this, "Feedback On Local Services", Toast.LENGTH_SHORT).show();
                break;
            case 7:
//                JobSeekerMap jobSeekerMap_obj = new JobSeekerMap();
//                moveToFragCode_method(jobSeekerMap_obj);
                break;
        }//end of switch case
    }//end of onItemClick method

    public void moveToFragCode_method(Fragment fragmentname_obj){
        drawerLayout_obj.closeDrawers();
        full_layout.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction().replace(R.id.drawerlayoutmainid,fragmentname_obj).addToBackStack(null).commit();
    }//end of moveToFragCode method

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return true;
    }//end of options menu method
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuaboutusid:
                Aboutus_frag aboutus_frag_obj=new Aboutus_frag();
                moveToFragCode_method(aboutus_frag_obj);
                break;
            case R.id.menutermsid:
                Termscondition_frag terms_fragobj=new Termscondition_frag();
                moveToFragCode_method(terms_fragobj);
                break;
            case R.id.menuchnagepassid:
                Changepass_frag changepassword=new Changepass_frag();
                moveToFragCode_method(changepassword);
                break;
            case R.id.menulogoutid:
                basicComponentsReuse_obj.sharedclear_method(getApplicationContext(),"LoginAppSession");
                Intent intent_obj=new Intent(getApplicationContext(),Login.class);
                startActivity(intent_obj);
                finish();
                break;
        }//end of switch case
        return true;
    }//end of onOptionsItemSelected

    @Override
    public void onBackPressed() {
        updateshow_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"mainActfragmentsshow","jsupdateprofilefrag");
        profsumryshow_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"mainActfragmentsshow","jsprofsummaryfrag");
        appliedlistshow_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"mainActfragmentsshow","jsappliedlistfrag");
        myinterviewsshow_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"mainActfragmentsshow","jsmyinterviewfrag");
        eventlistshow_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"mainActfragmentsshow","jseventlistfrag");
        jsaboutus_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"mainActfragmentsshow","jsmainaboutusfrag");
        jsterms_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"mainActfragmentsshow","jsmaintermscondfrag");
        jschangepass_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"mainActfragmentsshow","jsmainchangepassfrag");


        if(updateshow_status.equals("1")) mainFragbackCode_method("mainActfragmentsshow");
        else if(profsumryshow_status.equals("1")) mainFragbackCode_method("mainActfragmentsshow");
        else if(appliedlistshow_status.equals("1")) mainFragbackCode_method("mainActfragmentsshow");
        else if(myinterviewsshow_status.equals("1")) mainFragbackCode_method("mainActfragmentsshow");
        else if(eventlistshow_status.equals("1")) mainFragbackCode_method("mainActfragmentsshow");
        else if(jsaboutus_status.equals("1")) mainFragbackCode_method("mainActfragmentsshow");
        else if(jsterms_status.equals("1")) mainFragbackCode_method("mainActfragmentsshow");
        else if(jschangepass_status.equals("1")) mainFragbackCode_method("mainActfragmentsshow");
        else if(doublebackpressed==true) {
            super.onBackPressed();
            finish();
        }//end of inner if
        else {
            doublebackpressed = true;
            full_layout.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Please press Back again to exit", Toast.LENGTH_SHORT).show();
            handler_obj.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doublebackpressed = false;
                }
            }, 2000);
        }//end of else condition
    }//end of onBackpressed method

    public void mainFragbackCode_method(String mainfragmentsshow){
        super.onBackPressed();
        full_layout.setVisibility(View.VISIBLE);
        basicComponentsReuse_obj.sharedclear_method(getApplicationContext(),mainfragmentsshow);
    }//end of reg frag back code method
    @Override
    public void onClick(View view) {
    }//end of onClick method
}//end of main class
