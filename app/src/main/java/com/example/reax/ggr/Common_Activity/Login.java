package com.example.reax.ggr.Common_Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.reax.ggr.Common_Classes.BasicComponentsReuse;
import com.example.reax.ggr.Common_Fragments.Forget_frag;
import com.example.reax.ggr.Jobseeker.Jobseekerreg1;
import com.example.reax.ggr.MainActivities.Jobseeker_main;
import com.example.reax.ggr.POJO_Classes.LoginPOJO1;
import com.example.reax.ggr.POJO_Classes.LoginPOJO2;
import com.example.reax.ggr.R;
import com.example.reax.ggr.Retrofit_files.Retrofitinstancefile;
import com.example.reax.ggr.Retrofit_files.Retrofitinterfacefile;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Login extends AppCompatActivity implements View.OnClickListener{
    Button login;
    TextView signup_obj,forgetpass_obj;
    EditText username,userpassword;
    LinearLayout container;
    String struserpass,strusername,reg1show_status,reg2show_status,reg3show_status,forget1show_status,forget2show_status,forget3show_status;
    Retrofitinterfacefile retrofitinterfacefile;
    ArrayList<LoginPOJO2> login_arraylist=new ArrayList<>();
    BasicComponentsReuse basicComponentsReuse_obj=null;
    ProgressDialog loginprogressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        //TypeCaste work
        container=findViewById(R.id.containerid);
        username=findViewById(R.id.login_unameid);
        userpassword=findViewById(R.id.login_upassid);
        signup_obj=findViewById(R.id.signupid);
        login=findViewById(R.id.loginbtn);
        forgetpass_obj=findViewById(R.id.forgetpassid);
        forgetpass_obj.setOnClickListener(this);
        signup_obj.setOnClickListener(this);
        login.setOnClickListener(this);

        //Progress dialog work
        loginprogressbar=basicComponentsReuse_obj.showProgressBar_method(Login.this,loginprogressbar);

        //get all jbs jobs API work
        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
    }//end of onCreate method

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signupid:
                signup_method();
                break;
            case R.id.loginbtn:
                login_method();
//                Intent intent = new Intent(Login.this, Jobseeker_main.class);
//                startActivity(intent);
//                finish();
                 break;
            case R.id.forgetpassid:
                container.setVisibility(View.GONE);
                Forget_frag forgetFrag_obj=new Forget_frag();
                getSupportFragmentManager().beginTransaction().add(R.id.mainloginlayoutid,forgetFrag_obj).addToBackStack(null).commit();
                break;
        }//end of switch case
    }//end of onClick method

    private void signup_method( ){
                container.setVisibility(View.GONE);
                Jobseekerreg1 jobseekerreg1_obj= new Jobseekerreg1();
                getSupportFragmentManager().beginTransaction().add(R.id.mainloginlayoutid,jobseekerreg1_obj).addToBackStack(null).commit();
    }//end of signup method

    @Override
    public void onBackPressed() {
        reg1show_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"regfragmentsshow","reg1fragvisible");
        reg2show_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"regfragmentsshow","reg2fragvisible");
        reg3show_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"regfragmentsshow","reg3fragvisible");
        forget1show_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"forgetfragmentsshow","forget1fragvisible");
        forget2show_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"forgetfragmentsshow","forget2fragvisible");
        forget3show_status=basicComponentsReuse_obj.getfragValueFromSession_method(getApplicationContext(),"forgetfragmentsshow","forget3fragvisible");
        if(reg1show_status.equals("1")) regFragbackCode_method("regfragmentsshow");
        else if(reg2show_status.equals("1")) regFragbackCode_method("regfragmentsshow");
        else if(reg3show_status.equals("1")) regFragbackCode_method("regfragmentsshow");
        else if(forget1show_status.equals("1")) regFragbackCode_method("forgetfragmentsshow");
        else if(forget2show_status.equals("1")) regFragbackCode_method("forgetfragmentsshow");
        else if(forget3show_status.equals("1")) regFragbackCode_method("forgetfragmentsshow");
        else super.onBackPressed();
    }//end of onBackPressed method

    public void regFragbackCode_method(String regfragmentsshow){
        super.onBackPressed();
        container.setVisibility(View.VISIBLE);
        basicComponentsReuse_obj.sharedclear_method(getApplicationContext(),regfragmentsshow);
    }//end of reg frag back code method

    private void login_method() {
        strusername = username.getText().toString().trim();
        struserpass = userpassword.getText().toString().trim();
        if (strusername.length() == 0)
            basicComponentsReuse_obj.editTextfieldvalidate_method(username, "Please enter the username");
        else if (struserpass.length() == 0)
            basicComponentsReuse_obj.editTextfieldvalidate_method(userpassword, "Please enter the password");
        else {
            loginApi_method();
        }
    }// end of login method

    private void loginApi_method() {
        //show progress bar
        loginprogressbar.show();
        Call<LoginPOJO1> loginData=retrofitinterfacefile.getlogin_method(strusername,struserpass);
        loginData.enqueue(new Callback<LoginPOJO1>() {
            @Override
            public void onResponse(Call<LoginPOJO1> call, Response<LoginPOJO1> response) {
                if (response.body()!=null){
                    if (response.body().getStatus().equals(1)){
                        login_arraylist.add(response.body().getData());
                        basicComponentsReuse_obj.mainAppSessioncreate_method(getApplicationContext(),"LoginAppSession","LoginuserAuthKey",response.body().getData().getAuthKey(),"Loginuserdetaillist",login_arraylist);
                        loginprogressbar.dismiss();
                        Intent intent = new Intent(Login.this, Jobseeker_main.class);
                        startActivity(intent);
                        finish();
                    }//end of inner if condition
                    else {
                        loginprogressbar.dismiss();
                        basicComponentsReuse_obj.printToast_method(getApplicationContext(),"Username and Password mismatch"); }
                    }//end of if condition
                else {
                    loginprogressbar.dismiss();
                    basicComponentsReuse_obj.printToast_method(getApplicationContext(),"Something went wrong. Please try again");}
            }//end of onResponse method
            @Override
            public void onFailure(Call<LoginPOJO1> call, Throwable t) {
                loginprogressbar.dismiss();
                basicComponentsReuse_obj.printToast_method(getApplicationContext(),"Check internet connection or Server Problem");
            }//end of onFailure method
        });
    }//end of login API method
}//end of main class