package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cityguide.R;

public class SetNewPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
    }

    public void callForgetPasswordSuccessMessage(View view) {
        startActivity(new Intent(this, ForgetPasswordSuccessMessage.class));
        finish();
    }
}