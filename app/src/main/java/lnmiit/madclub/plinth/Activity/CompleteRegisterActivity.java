package lnmiit.madclub.plinth.Activity;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import lnmiit.madclub.plinth.Model.Register;
import lnmiit.madclub.plinth.Model.User;
import lnmiit.madclub.plinth.R;
import lnmiit.madclub.plinth.response.EventRegisterResponse;
import lnmiit.madclub.plinth.rest.ApiClient;
import lnmiit.madclub.plinth.rest.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompleteRegisterActivity extends AppCompatActivity {


    private EditText name;
    private EditText email;
    private EditText phone;
    private EditText institute;
    private EditText city;
    private RadioGroup gender, year, accommodation;
    private Button register;
    private Button addMember;
    private TextInputLayout inputName,inputEmail,inputphone,inputcity,inputclg;
    private int count =1;
    private ArrayList<User> userDetails= new ArrayList<>();
    private String event;
    private String clubName;
    private String genders;
    private int years;
    private String acc;
    private int upperLimit;
    private int lowerLimit;
    private TextView text1;
    User user;
    Register registerEvent = new Register();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_register);
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name = (EditText) findViewById(R.id.complete_name);
        email = (EditText) findViewById(R.id.complete_email);
        phone = (EditText) findViewById(R.id.complete_phone);
        institute = (EditText) findViewById(R.id.complete_institute);
        city = (EditText) findViewById(R.id.complete_city);
        gender = (RadioGroup) findViewById(R.id.complete_gender);
        year = (RadioGroup) findViewById(R.id.complete_year);
        accommodation = (RadioGroup) findViewById(R.id.complete_accommodation);
        register = (Button) findViewById(R.id.complete_register1);
        addMember = (Button) findViewById(R.id.complete_add_member);
        inputName = (TextInputLayout) findViewById(R.id.complete_input_name);
        inputEmail = (TextInputLayout) findViewById(R.id.complete_input_email);
        inputphone = (TextInputLayout) findViewById(R.id.complete_input_phone);
        inputcity = (TextInputLayout) findViewById(R.id.complete_input_city);
        inputclg = (TextInputLayout) findViewById(R.id.complete_input_clg);
        text1 = (TextView) findViewById(R.id.complete_text);
        user =SharedPreferences.getSharedInfo(this);
        Bundle bundle = getIntent().getExtras();
        event = bundle.getString("event");
        clubName = bundle.getString("clubname");
        upperLimit = bundle.getInt("upperlimit");
        lowerLimit = bundle.getInt("lowerlimit");
        text1.setText("Maximum "+upperLimit+" can Register");
        if(count==upperLimit)
        {
            addMember.setVisibility(View.GONE);
        }
        if(user.getUsername()==null||user.getUsername().equals(""))
        {
            //Toast.makeText(CompleteRegisterActivity.this,"Please Register", Toast.LENGTH_LONG).show();
        }
        else
        {
            addDetails();
        }

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.complete_male)
                {
                    genders = "male";
                }
                if(checkedId==R.id.complete_female)
                {
                    genders = "female";
                }
            }
        });

        year.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.complete_one)
                {
                    years=1;
                }
                if(checkedId==R.id.complete_two)
                {
                    years=2;
                }
                if(checkedId==R.id.complete_three)
                {
                    years=3;
                }
                if(checkedId==R.id.complete_four)
                {
                    years=4;
                }
                if(checkedId==R.id.complete_five)
                {
                    years=5;
                }
                if(checkedId==R.id.complete_na)
                {
                    years=0;
                }
            }
        });

        accommodation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.complete_acc_yes)
                {
                    acc= "Yes";
                }
                if(checkedId==R.id.complete_acc_no)
                {
                    acc = "No";
                }
            }
        });
        addMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isValidInput())
                {
                    return;
                }
                if(count==upperLimit-1)
                {
                    addMember.setVisibility(View.GONE);
                }
                if(count==1) {
                    userDetails.add(user);
                    name.setText("");
                    email.setText("");
                    phone.setText("");
                    institute.setText("");
                    city.setText("");
                    gender.clearCheck();
                    year.clearCheck();
                    accommodation.clearCheck();
                    count++;
                }
                else
                {
                    user= new User();
                    user.setUsername(name.getText().toString());
                    user.setEmailId(email.getText().toString());
                    user.setPhone(phone.getText().toString());
                    user.setCollege(institute.getText().toString());
                    user.setCity(city.getText().toString());

                    user.setGender(genders);
                    user.setYear(years);
                    user.setAccommodation(acc);
                    userDetails.add(user);
                    name.setText("");
                    email.setText("");
                    phone.setText("");
                    institute.setText("");
                    city.setText("");
                    gender.clearCheck();
                    year.clearCheck();
                    accommodation.clearCheck();
                    count++;
                }
                    Toast.makeText(CompleteRegisterActivity.this, "Member Added!!", Toast.LENGTH_SHORT).show();

                }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isValidInput())
                {
                    return;
                }
                if(count<lowerLimit)
                {
                    Toast.makeText(CompleteRegisterActivity.this, "Minimum Members Required is:"+lowerLimit, Toast.LENGTH_SHORT).show();
                    return;
                }
                user= new User();
                user.setUsername(name.getText().toString());
                user.setEmailId(email.getText().toString());
                user.setPhone(phone.getText().toString());
                user.setCollege(institute.getText().toString());
                user.setCity(city.getText().toString());
                gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId==R.id.complete_male)
                        {
                            genders = "male";
                        }
                        if(checkedId==R.id.complete_female)
                        {
                            genders = "female";
                        }
                    }
                });

                year.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId==R.id.complete_one)
                        {
                            years=1;
                        }
                        if(checkedId==R.id.complete_two)
                        {
                            years=2;
                        }
                        if(checkedId==R.id.complete_three)
                        {
                            years=3;
                        }
                        if(checkedId==R.id.complete_four)
                        {
                            years=4;
                        }
                        if(checkedId==R.id.complete_five)
                        {
                            years=5;
                        }
                        if(checkedId==R.id.complete_na)
                        {
                            years=0;
                        }
                    }
                });

                accommodation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId==R.id.complete_acc_yes)
                        {
                            acc= "Yes";
                        }
                        if(checkedId==R.id.complete_acc_no)
                        {
                            acc = "No";
                        }
                    }
                });
                user.setGender(genders);
                user.setYear(years);
                user.setAccommodation(acc);
                userDetails.add(user);
                registerEvent.setEventName(event);
                registerEvent.setClubName(clubName);
                registerEvent.setUserDetails(userDetails);
                ApiInterface apiService = ApiClient.getRetrofitClient().create(ApiInterface.class);
                if(clubName.equals("workshop"))
                {
                    Call<EventRegisterResponse> call = apiService.RegisterWorkshop(registerEvent);
                    call.enqueue(new Callback<EventRegisterResponse>() {
                        @Override
                        public void onResponse(Call<EventRegisterResponse> call, Response<EventRegisterResponse> response) {
                            if(response.isSuccessful())
                            {
                                Toast.makeText(CompleteRegisterActivity.this,"Successfully Registered!!",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<EventRegisterResponse> call, Throwable t) {
                            Toast.makeText(CompleteRegisterActivity.this,"UnSuccessful",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                {
                    Call<EventRegisterResponse> call = apiService.RegisterEvent(registerEvent);
                    call.enqueue(new Callback<EventRegisterResponse>() {
                        @Override
                        public void onResponse(Call<EventRegisterResponse> call, Response<EventRegisterResponse> response) {
                            if (response.isSuccessful())
                            {
                                Toast.makeText(CompleteRegisterActivity.this,"Successfully Registered!!",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<EventRegisterResponse> call, Throwable t) {
                            Toast.makeText(CompleteRegisterActivity.this,"UnSuccessful",Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
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

    private void addDetails() {
        name.setText(user.getUsername());
        if (user.getGender().equals("male")) {
            gender.check(R.id.complete_male);
        } else {
            gender.check(R.id.complete_female);
        }
        email.setText(user.getEmailId());
        phone.setText(user.getPhone());
        institute.setText(user.getCollege());
        if (user.getYear() == 1) {
            year.check(R.id.complete_one);
        }
        if (user.getYear() == 2) {
            year.check(R.id.complete_two);
        }
        if (user.getYear() == 3) {
            year.check(R.id.complete_three);
        }
        if (user.getYear() == 4) {
            year.check(R.id.complete_four);
        }
        if (user.getYear() == 5) {
            year.check(R.id.complete_five);
        }
        if (user.getYear() == 0) {
            year.check(R.id.complete_na);
        }
        city.setText(user.getCity());
        if (user.getAccommodation().equals("Yes")) {
            accommodation.check(R.id.complete_acc_yes);
        } else {
            accommodation.check(R.id.complete_acc_no);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
