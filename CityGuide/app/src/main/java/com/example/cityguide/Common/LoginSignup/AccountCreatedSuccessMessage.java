package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cityguide.R;

public class AccountCreatedSuccessMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_created_success_message);
    }

    public void callLoginScreen(View view) {
        startActivity(new Intent(this, RetailerLogin.class));
        finish();
    }
}