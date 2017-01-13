package com.lnmiit.plinth.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.lnmiit.plinth.Model.User;
import com.lnmiit.plinth.Model.Validate;
import com.lnmiit.plinth.R;
import com.lnmiit.plinth.Tool.Tools;
import com.lnmiit.plinth.response.ValidateResponse;
import com.lnmiit.plinth.rest.ApiClient;
import com.lnmiit.plinth.rest.ApiInterface;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private static final int RC_SIGN_IN = 9002;
    private static final String TAG = "Google Sign In";
    private GoogleApiClient googleApiClient;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private SignInButton signInButton;
    private TextView skip;
    private String username="";
    private String emailId="";
    private String token;
    private String facebook_token;
    private String userId;
    private Button fb;
    private String login="";
    private Button google;
    ProgressDialog pd;


    @Override
    protected void onStart() {
        super.onStart();
        if (token != null)
        {
            signOut();
        }
        if(login.equals(""))
        {

            LoginManager.getInstance().logOut();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        loginButton = (LoginButton) findViewById(R.id.login);
        fb= (Button) findViewById(R.id.fb);
        pd = Tools.getProgressDialog(this);
        TextView text = (TextView) findViewById(R.id.plinth_text);
        TextView year = (TextView) findViewById(R.id.plinth_year);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "rez.ttf");
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(),  "hel.ttf");
        text.setTypeface(custom_font);
        year.setTypeface(custom_font1);
        google = (Button) findViewById(R.id.google_bt);

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.packagename",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==fb)
                {
                    loginButton.performClick();
                }
            }
        });
        skip = (TextView) findViewById(R.id.login_skip);
        skip.setPaintFlags(skip.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainIntent);
            }
        });
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.server_client_id)).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();
        callbackManager = CallbackManager.Factory.create();

        loginButton.setReadPermissions(Arrays.asList(
                "public_profile", "email", "user_birthday", "user_friends"));
        validateServerClientID();
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIdToken();
            }
        });

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                token= loginResult.getAccessToken().getToken();
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                Log.v("LoginActivity Response ", response.toString());
                                AccessToken token1 = AccessToken.getCurrentAccessToken();
                                userId=token1.getUserId();
                                login="facebook";
                                try {
                                    username = object.getString("name");
                                    emailId = object.getString("email");
                                    Validate validate = new Validate();
                                    validate.setAccessToken(token);
                                    validate.setValidateEmail(emailId);
                                    ApiInterface apiService = ApiClient.getRetrofitClient().create(ApiInterface.class);
                                    retrofit2.Call<ValidateResponse> call = apiService.validateFacebook(validate);
                                    pd.show();
                                    call.enqueue(new Callback<ValidateResponse>() {
                                        @Override
                                        public void onResponse(retrofit2.Call<ValidateResponse> call, Response<ValidateResponse> response) {
                                            if (response.isSuccessful())
                                            {
                                                pd.dismiss();
                                                if (response.body().getValidateMsg().equals("true"))
                                                {
                                                    Toast.makeText(LoginActivity.this,"Successful",Toast.LENGTH_LONG).show();
                                                    User user = new User();
                                                    user.setPhone(response.body().getValidatePhone());
                                                    user.setCollege(response.body().getValidateCollege());
                                                    user.setYear(response.body().getValidateYear());
                                                    user.setCity(response.body().getValidateCity());
                                                    user.setAccommodation(response.body().getValidateAccommodation());
                                                    user.setGender(response.body().getValidateGender());
                                                    user.setUsername(response.body().getValidateUsername());
                                                    user.setEmailId(response.body().getValidateEmailId());
                                                    SharedPreferences.putSharedPrefeneces(LoginActivity.this,user);
                                                    Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
                                                    startActivity(mainIntent);
                                                    finish();
                                                }
                                                else {
                                                    User user = new User();
                                                    user.setUsername(username);
                                                    user.setEmailId(emailId);
                                                    SharedPreferences.putSharedPrefeneces(getApplicationContext(),user);
                                                    gotoCompleteLogin();
                                                    finish();
                                                }
                                            }
                                        }

                                        @Override
                                        public void onFailure(retrofit2.Call<ValidateResponse> call, Throwable t) {
                                            pd.dismiss();
                                            Toast.makeText(LoginActivity.this,"Unsuccessful",Toast.LENGTH_LONG).show();
                                        }
                                    });

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();

            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Action Cancelled!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void gotoCompleteLogin(){
        Intent mainIntent = new Intent(this, CompleteLoginActivity.class);
        mainIntent.putExtra("login",login);
        mainIntent.putExtra("token",token);
        mainIntent.putExtra("userid",userId);
        startActivity(mainIntent);
    }
    public void getIdToken() {
        pd.show();
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        Log.d(TAG, "signOut:onResult:" + status);
                        //updateUI(false);
                    }
                });
    }

    private void revokeAccess() {
        Auth.GoogleSignInApi.revokeAccess(googleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        Log.d(TAG, "revokeAccess:onResult:" + status);
                        // updateUI(false);
                    }
                });
    }

    private void validateServerClientID() {
        String serverClientId = getString(R.string.server_client_id);
        String suffix = ".apps.googleusercontent.com";
        if (!serverClientId.trim().endsWith(suffix)) {
            String message = "Invalid server client ID in strings.xml, must end with " + suffix;

            Log.w(TAG, message);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            // [START get_id_token]
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            Log.d(TAG, "onActivityResult:GET_TOKEN:success:" + result.getStatus().isSuccess());

            if (result.isSuccess()) {
                pd.dismiss();
                GoogleSignInAccount acct = result.getSignInAccount();
                login="google";
                token = acct.getIdToken();
                username = acct.getDisplayName();
                emailId = acct.getEmail();
                userId =acct.getId();
                Validate validate = new Validate();
                validate.setValidateEmail(emailId);
                validate.setAccessToken(token);
                ApiInterface apiService = ApiClient.getRetrofitClient().create(ApiInterface.class);
                pd.show();
                retrofit2.Call<ValidateResponse> call = apiService.validateGoogle(validate);
                call.enqueue(new Callback<ValidateResponse>() {
                    @Override
                    public void onResponse(retrofit2.Call<ValidateResponse> call, Response<ValidateResponse> response) {
                        if (response.isSuccessful())
                        {
                            pd.dismiss();
                            if (response.body().getValidateMsg().equals("true"))
                            {
                                User user = new User();
                                user.setPhone(response.body().getValidatePhone());
                                user.setCollege(response.body().getValidateCollege());
                                user.setYear(response.body().getValidateYear());
                                user.setCity(response.body().getValidateCity());
                                user.setAccommodation(response.body().getValidateAccommodation());
                                user.setGender(response.body().getValidateGender());
                                user.setUsername(response.body().getValidateUsername());
                                user.setEmailId(response.body().getValidateEmailId());
                                SharedPreferences.putSharedPrefeneces(LoginActivity.this,user);
                                Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(mainIntent);
                                finish();
                            }
                            else
                            {
                                User user = new User();
                                user.setUsername(username);
                                user.setEmailId(emailId);
                                SharedPreferences.putSharedPrefeneces(getApplicationContext(),user);
                                Log.d(TAG, "idToken:" + token);
                                gotoCompleteLogin();
                                finish();
                            }
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<ValidateResponse> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(LoginActivity.this,"Unsuccessful",Toast.LENGTH_LONG).show();
                    }
                });

                //text.setText(idToken);
                //updateUI(true);

            } else {
                pd.dismiss();
                Log.e(TAG, "Google+ not connected");

            }
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

}
