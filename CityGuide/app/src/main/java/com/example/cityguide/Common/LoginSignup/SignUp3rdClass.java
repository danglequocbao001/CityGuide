package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.cityguide.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignUp3rdClass extends AppCompatActivity {

    //Variables
    ScrollView scrollView;
    TextInputLayout phoneNumber;
    CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3rd_class);

        //Hooks
        scrollView = findViewById(R.id.signup_3rd_screen_scroll_view);
        countryCodePicker = findViewById(R.id.country_code_picker);
        phoneNumber = findViewById(R.id.signup_phone_number);

    }

    public void callVerifyOTPScreen(View view) {

        //Validate fields
        if (!validatePhoneNumber()) {
            return;
        } //Validation succeeded and now move to next screen to verify phone number and save data

        //Get all values passe from previous screens using Intent
        String _fullname = getIntent().getStringExtra("fullName");
        String _email = getIntent().getStringExtra("email");
        String _username = getIntent().getStringExtra("username");
        String _password = getIntent().getStringExtra("password");
        String _date = getIntent().getStringExtra("date");
        String _gender = getIntent().getStringExtra("gender");

        String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim(); //Get Phone Number
        String _phoneNo = "+" + countryCodePicker.getSelectedCountryCode() + _getUserEnteredPhoneNumber;

        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);

        //Pass all fields to the next activity
        intent.putExtra("fullName",_fullname);
        intent.putExtra("email",_email);
        intent.putExtra("username",_username);
        intent.putExtra("password",_password);
        intent.putExtra("date",_date);
        intent.putExtra("gender",_gender);
        intent.putExtra("phoneNo",_phoneNo);

        //Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(scrollView,"transition_OTP_screen");
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    private boolean validatePhoneNumber() {
        return true;
    }
}