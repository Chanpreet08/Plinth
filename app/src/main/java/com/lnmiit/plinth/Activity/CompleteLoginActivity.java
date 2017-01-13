package com.lnmiit.plinth.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.lnmiit.plinth.Model.User;
import com.lnmiit.plinth.R;
import com.lnmiit.plinth.Tool.Tools;
import com.lnmiit.plinth.response.registerResponse;
import com.lnmiit.plinth.rest.ApiClient;
import com.lnmiit.plinth.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompleteLoginActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText phone;
    private EditText institute;
    private EditText city;
    private RadioGroup gender, year, accommodation;
    private Button register;
    private String genders;
    private int years;
    private String acc;
    private String login;
    private String token;
    private String id;
    private TextInputLayout inputName,inputEmail,inputphone,inputcity,inputclg;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_login);
        getSupportActionBar().setTitle("Register");
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        institute = (EditText) findViewById(R.id.institute);
        city = (EditText) findViewById(R.id.city);
        gender = (RadioGroup) findViewById(R.id.gender);
        year = (RadioGroup) findViewById(R.id.year);
        accommodation = (RadioGroup) findViewById(R.id.accommodation);
        register = (Button) findViewById(R.id.complete_register);
         inputName = (TextInputLayout) findViewById(R.id.input_name);
         inputEmail = (TextInputLayout) findViewById(R.id.input_email);
         inputphone = (TextInputLayout) findViewById(R.id.input_phone);
         inputcity = (TextInputLayout) findViewById(R.id.input_city);
         inputclg = (TextInputLayout) findViewById(R.id.input_clg);
        Bundle bundle = getIntent().getExtras();
        login = bundle.getString("login");
        token = bundle.getString("token");
        id = bundle.getString("userid");
        pd= Tools.getProgressDialog(this);
        final User user =SharedPreferences.getSharedInfo(this);
        name.setText(user.getUsername());
        email.setText(user.getEmailId());
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.male)
                {
                    genders = "male";
                }
                if(checkedId==R.id.female)
                {
                    genders = "female";
                }
            }
        });

        year.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.one)
                {
                    years=1;
                }
                if(checkedId==R.id.two)
                {
                    years=2;
                }
                if(checkedId==R.id.three)
                {
                    years=3;
                }
                if(checkedId==R.id.four)
                {
                    years=4;
                }
                if(checkedId==R.id.five)
                {
                    years=5;
                }
                if(checkedId==R.id.na)
                {
                    years=0;
                }
            }
        });

        accommodation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.acc_yes)
                {
                    acc= "Yes";
                }
                if(checkedId==R.id.acc_no)
                {
                    acc = "No";
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isValidInput())
                {
                    return;
                }
                user.setPhone(phone.getText().toString());
                user.setAccommodation(acc);
                user.setCity(city.getText().toString());
                user.setCollege(institute.getText().toString());
                user.setGender(genders);
                user.setYear(years);
                user.setValid("");
                user.setEvents("");
                user.setPaidEvents("");
                user.setToken(token);
                user.setLoginId(id);
                if(login.equals("facebook")) {
                    pd.show();
                    ApiInterface apiService = ApiClient.getRetrofitClient().create(ApiInterface.class);
                    Call<registerResponse> call = apiService.sendCredentialsFacebook(user);
                    call.enqueue(new Callback<registerResponse>() {

                        @Override
                        public void onResponse(Call<registerResponse> call, Response<registerResponse> response) {
                            pd.dismiss();
                            if (response.isSuccessful()) {
                                //if (response.body().getMessage().equals("true")) {
                                    SharedPreferences.putSharedPrefeneces(getApplicationContext(), user);
                                    finish();
                                    gotoMainActivity();

                            }
                        }

                        @Override
                        public void onFailure(Call<registerResponse> call, Throwable t) {
                            pd.dismiss();
                            Toast.makeText(CompleteLoginActivity.this, "Connection Failed!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                if(login.equals("google"))
                {
                    pd.show();
                    ApiInterface apiService = ApiClient.getRetrofitClient().create(ApiInterface.class);
                    Call<registerResponse> call = apiService.sendCredentialsGoogle(user);
                    call.enqueue(new Callback<registerResponse>() {

                        @Override
                        public void onResponse(Call<registerResponse> call, Response<registerResponse> response) {
                            pd.dismiss();
                            if (response.isSuccessful()) {
                                //if (response.body().getMessage().equals("true")) {
                                SharedPreferences.putSharedPrefeneces(getApplicationContext(), user);
                                finish();
                                gotoMainActivity();

                            }
                        }

                        @Override
                        public void onFailure(Call<registerResponse> call, Throwable t) {
                            pd.dismiss();
                            Toast.makeText(CompleteLoginActivity.this, "Connection Failed!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }
        });

    }


    private void gotoMainActivity() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        startActivity(mainIntent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        User user = new User();
        user.setCollege("");
        user.setEmailId("");
        user.setYear(0);
        user.setCity("");
        user.setPhone("");
        user.setGender("");
        user.setUsername("");
        user.setAccommodation("");
        SharedPreferences.putSharedPrefeneces(this,user);
        Intent loginIntent = new Intent(this,LoginActivity.class);
        startActivity(loginIntent);
    }
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    boolean isValidMobile(String phone)
    {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean isValidInput() {
        if(name.getText().toString().isEmpty())
        {
            name.setError("Empty field");
            requestFocus(name);
            return false;

        }
        else {
            inputName.setErrorEnabled(false);
        }

        if (email.getText().toString().isEmpty() || !isValidEmail(email.getText().toString())) {
            email.setError("Wrong email");
            requestFocus(email);
            return false;
        }
        else {
            inputEmail.setErrorEnabled(false);
        }
        if(city.getText().toString().isEmpty())
        {
            city.setError("Empty field");
            requestFocus(city);
            return false;

        }
        else {
            inputcity.setErrorEnabled(false);
        }
        if(phone.getText().toString().isEmpty()||!isValidMobile(phone.getText().toString()))
        {
            phone.setError("Wrong phone number");
            requestFocus(phone);
            return false;

        }

        else {
            inputphone.setErrorEnabled(false);
        }
        if(institute.getText().toString().isEmpty())
        {
            institute.setError("Empty Field");
            requestFocus(institute);
            return false;

        }

        else {
            inputclg.setErrorEnabled(false);
        }

        if(gender.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(this,"Please! Fill In Details.",Toast.LENGTH_SHORT).show();
           return false;

        }

       if(year.getCheckedRadioButtonId()==-1)
       {
           Toast.makeText(this,"Please! Fill In Details.",Toast.LENGTH_SHORT).show();
           return false;
       }
        if(accommodation.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(this,"Please! Fill In Details.",Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }
}
