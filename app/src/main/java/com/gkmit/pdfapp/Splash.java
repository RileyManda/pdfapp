package com.gkmit.pdfapp;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Bundle;

import com.gkmit.pdfapp.auth.LoginActivity;
import com.gkmit.pdfapp.onboard.StartActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(Splash.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }
}
