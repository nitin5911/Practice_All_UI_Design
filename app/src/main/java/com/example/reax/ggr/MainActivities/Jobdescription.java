package com.example.reax.ggr.MainActivities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.reax.ggr.R;

public class Jobdescription extends AppCompatActivity implements View.OnClickListener{
   Toolbar jobdesctool_obj;
    Button jobapply_obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobdescription);

        jobdesctool_obj=findViewById(R.id.jobdesctoolid);
        jobapply_obj=findViewById(R.id.jobdescapplybtnid);

        jobapply_obj.setOnClickListener(this);

        jobdesctool_obj.setTitle("Job Description");
        jobdesctool_obj.setTitleTextColor(Color.WHITE);
        jobdesctool_obj.setNavigationIcon(R.drawable.leftarrow);
        jobdesctool_obj.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_about = new Intent(getApplicationContext(),Jobseeker_main.class);
                startActivity(intent_about);
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jobdescapplybtnid:
                Intent jobdesc_intent=new Intent(getApplicationContext(),Jobseeker_main.class);
                startActivity(jobdesc_intent);
                finish();
                break;
        }//end of switch case
    }//end of onClick method
}//end of main class
