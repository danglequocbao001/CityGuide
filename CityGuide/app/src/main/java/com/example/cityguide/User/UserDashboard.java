package com.example.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import android.graphics.drawable.GradientDrawable;
import android.content.Intent;
import android.os.Bundle;
//import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
//import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cityguide.Common.LoginSignup.RetailerLogin;
import com.example.cityguide.Common.LoginSignup.BaoRetailerSignin;
import com.example.cityguide.Common.LoginSignup.RetailerSignUp;
import com.example.cityguide.Common.LoginSignup.RetailerStartUpScreen;
import com.example.cityguide.HelperClasses.HomeAdapter.CategoryAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.cityguide.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.cityguide.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler, mostViewedRecycler, categoryRecycler;
    RecyclerView.Adapter adapter;
    //private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menuIcon;
    LinearLayout contentView;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoryRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        ////Navigation Drawer Function Calls
        navigationDrawer();

        //Recycler Views Function Calls
        featuredRecycler();
        mostViewedRecycler();
        categoryRecycler();
    }

    //Navigation Drawer Functions
    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {

        //add enOfRight screen color when start drawerLayout
        //drawerLayout.setScrimColor(getResources().getColor(R.color.invisible_color));

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                                           @Override
                                           public void onDrawerSlide(View drawerView, float slideOffset) {

                                               // Scale the View based on current slide offset
                                               final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                                               final float offsetScale = 1 - diffScaledOffset;
                                               contentView.setScaleX(offsetScale);
                                               contentView.setScaleY(offsetScale);

                                               // Translate the View, accounting for the scaled width
                                               final float xOffset = drawerView.getWidth() * slideOffset;
                                               final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                                               final float xTranslation = xOffset - xOffsetDiff;
                                               contentView.setTranslationX(xTranslation);
                                           }
                                       }
        );
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.nav_all_categories) {
            startActivity(new Intent(getApplicationContext(), AllCategories.class));
        }

        if (item.getItemId() == R.id.nav_login) {
            startActivity(new Intent(getApplicationContext(), RetailerLogin.class));
        }

        if (item.getItemId() == R.id.nav_signin) {
            startActivity(new Intent(getApplicationContext(), RetailerSignUp.class));
        }

        return true;
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.bmt, "Buon Me Thuot", "Let's go back home"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.sai_gon_night, "Sai Gon", "Be Mature"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.kfc_img, "KFC", "Make Money"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_1, "New York City", "City of The Most Interested Nation"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2, "Houston City", "My University Dream in There"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.bao, "Bao Dang", "Android Application Creator"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

        //GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});
    }

    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)));

        ArrayList<FeaturedHelperClass> mostViewedLocations = new ArrayList<>();

        mostViewedLocations.add(new FeaturedHelperClass(R.drawable.bmt, "Buon Me Thuot", "Let's go back home"));
        mostViewedLocations.add(new FeaturedHelperClass(R.drawable.sai_gon_night, "Sai Gon", "Be Mature"));
        mostViewedLocations.add(new FeaturedHelperClass(R.drawable.kfc_img, "KFC", "Make Money"));
        mostViewedLocations.add(new FeaturedHelperClass(R.drawable.city_1, "New York City", "City of The Most Interested Nation"));
        mostViewedLocations.add(new FeaturedHelperClass(R.drawable.city_2, "Houston City", "My University Dream in There"));
        mostViewedLocations.add(new FeaturedHelperClass(R.drawable.bao, "Bao Dang", "Android Application Creator"));

        adapter = new MostViewedAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);

        //GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});
    }

    private void categoryRecycler() {
        categoryRecycler.setHasFixedSize(true);
        categoryRecycler.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)));

        ArrayList<FeaturedHelperClass> categoryLocations = new ArrayList<>();

        categoryLocations.add(new FeaturedHelperClass(R.drawable.bmt, "Buon Me Thuot", "Let's go back home"));
        categoryLocations.add(new FeaturedHelperClass(R.drawable.sai_gon_night, "Sai Gon", "Be Mature"));
        categoryLocations.add(new FeaturedHelperClass(R.drawable.kfc_img, "KFC", "Make Money"));
        categoryLocations.add(new FeaturedHelperClass(R.drawable.city_1, "New York City", "City of The Most Interested Nation"));
        categoryLocations.add(new FeaturedHelperClass(R.drawable.city_2, "Houston City", "My University Dream in There"));
        categoryLocations.add(new FeaturedHelperClass(R.drawable.bao, "Bao Dang", "Android Application Creator"));

        adapter = new CategoryAdapter(categoryLocations);
        categoryRecycler.setAdapter(adapter);

        //GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});
    }

    //Normal Functions

    public void callRetailerScreens(View view) {
        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else super.onBackPressed();
    }

}