package com.mobilestar.rongo.android.Activity.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mobilestar.rongo.android.Fragment.HomeFragment;
import com.mobilestar.rongo.android.Fragment.notification.NotificationNewsFragment;
import com.mobilestar.rongo.android.Fragment.ProfileFragment;
import com.mobilestar.rongo.android.Fragment.SearchFragment;
import com.mobilestar.rongo.android.R;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    ProfileFragment profileFragment;
    NotificationNewsFragment notificationNewsFragment;
    SearchFragment searchFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();
        notificationNewsFragment = new NotificationNewsFragment();
        searchFragment = new SearchFragment();

        this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment).commit();
        this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, profileFragment).commit();
        this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, notificationNewsFragment).commit();
        this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, searchFragment).commit();

        this.HideAllFragemnt();

        bottomNavigationView = findViewById(R.id.mani_bottom_nav_bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                HideAllFragemnt();
                int id = menuItem.getItemId();
                switch(id) {
                    case  R.id.navigation_home :
                        getSupportFragmentManager().beginTransaction().show(homeFragment).commit();
                        return true;
                    case  R.id.navigation_profile :
                        getSupportFragmentManager().beginTransaction().show(profileFragment).commit();
                        return true;
                    case  R.id.navigation_message :
                        getSupportFragmentManager().beginTransaction().show(notificationNewsFragment).commit();
                        return true;
                    case  R.id.navigation_checkin :
                        getSupportFragmentManager().beginTransaction().show(searchFragment).commit();
                        return true;
                }
                return false;
            }
        });
        getSupportFragmentManager().beginTransaction().show(homeFragment).commit();
    }

    private void HideAllFragemnt() {
        this.getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
        this.getSupportFragmentManager().beginTransaction().hide(profileFragment).commit();
        this.getSupportFragmentManager().beginTransaction().hide(notificationNewsFragment).commit();
        this.getSupportFragmentManager().beginTransaction().hide(searchFragment).commit();
    }
}
