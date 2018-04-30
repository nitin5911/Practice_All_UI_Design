package com.example.reax.ggr.Common_Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.reax.ggr.MainActivities.Jobseeker_main;
import com.example.reax.ggr.R;

public class Splash extends AppCompatActivity {
    public static final String sessionvalue = "Session not created";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences sharedPreferences_obj = getSharedPreferences("LoginAppSession", Context.MODE_PRIVATE);
        String sessionstatus = sharedPreferences_obj.getString("LoginuserAuthKey", sessionvalue);
        if (sessionstatus.equals(sessionvalue) || sessionstatus.equals("")) {
            final Thread thread_obj = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                                finish();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }//end of catch
                        }//end of run method
                    }//end of Runnable
            ); //end of Thread
            thread_obj.start();
        } else {
            Intent intent_obj = new Intent(getApplicationContext(), Jobseeker_main.class);
            startActivity(intent_obj);
            finish();
        }//end of else
    }//end of onCreate method
    }//end of main class