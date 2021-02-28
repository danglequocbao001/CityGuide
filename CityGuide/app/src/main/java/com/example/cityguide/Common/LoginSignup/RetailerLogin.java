package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.cityguide.R;

public class RetailerLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_login);
    }

    public void backToRetailerStartUpScreen(View view) {
        startActivity(new Intent(this, RetailerStartUpScreen.class));
        finish();
    }

    public void callForgetPassword(View view) {
        startActivity(new Intent(this, ForgetPassword.class));
        finish();
    }

    public void callCreateAccountScreen(View view) {
        startActivity(new Intent(this, RetailerSignUp.class));
        finish();
    }
}