package com.lnmiit.plinth.Activity;

/**
 * Created by chanpreet on 12/12/16.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.lnmiit.plinth.Model.User;
import com.lnmiit.plinth.R;

public class SplashActivity extends AppCompatActivity {

    private Thread splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final User user = SharedPreferences.getSharedInfo(SplashActivity.this);
        splash = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (user.getEmailId().equals("") || user == null) {
                            Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                            startActivity(mainIntent);
                            finish();
                        } else {
                            Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(mainIntent);
                            finish();

                        }
                    } catch (Exception e) {
                        Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(mainIntent);
                        finish();


                    }
                }
            }
        };
        splash.start();
    }
}
