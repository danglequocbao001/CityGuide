package com.example.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguide.R;
//import com.example.cityguide.User.UserDashboard;

import static com.example.cityguide.R.anim.bottom_anim;
import static com.example.cityguide.R.anim.side_anim;

public class SplashScreen extends AppCompatActivity {

    //Variables
    ImageView backgroundImage;
    TextView poweredByLine;

    //Animation
    Animation sideAnim, bottomAnim;

    //this variable use for "firstTime" code
    //SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //Hooks
        Mapping();

        //Animations
        sideAnim = AnimationUtils.loadAnimation(this, side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, bottom_anim);

        //set Animations on elements
        backgroundImage.setAnimation(sideAnim);
        poweredByLine.setAnimation(bottomAnim);

        int SPLASH_TIMER = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

//                /*this "firstTime" code will display onBoardingScreen for first time open the application, and always display UserDashboard after*/
//                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
//                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);
//
//                if (isFirstTime) {
//                    SharedPreferences.Editor editor = onBoardingScreen.edit();
//                    editor.putBoolean("firstTime",false);
//                    editor.commit();
//                    editor.apply();
//
//                    Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
//                    startActivity(intent);
//                    finish();
//                }
//                else {
//                    Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
//                    startActivity(intent);
//                    finish();
//                }

                //this code will always display OnBoarding
                Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMER);
    }

    private void Mapping() {
        backgroundImage = findViewById(R.id.background_image);
        poweredByLine = findViewById(R.id.powered_by_line);
    }
}