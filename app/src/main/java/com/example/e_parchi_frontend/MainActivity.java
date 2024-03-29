package com.example.e_parchi_frontend;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerLayout;
    FragmentManager fragmentManager;
    Toolbar toolbar;

    // Firebase var

    FirebaseUser currentUser ;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//below command forces the device to use light theme even if its in dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mAuth =FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();



        if (currentUser == null) {
            // User is not signed in, start login activity
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
            return;
        }




        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar,
                R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);

        //setting color of hamburger icon to white
        toggle.getDrawerArrowDrawable().setColor(getColor(android.R.color.white));

        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigation_drawer);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        // Get a reference to the BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.home_bottom_nav);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation item clicks here
                int itemId = item.getItemId();
                if(itemId == R.id.home){
                    openFragment(new home());
                    return true;
                } else if (itemId == R.id.history) {
                    Intent intent = new Intent(MainActivity.this, History.class);
                    startActivity(intent);
                    return true;
                }else if (itemId == R.id.your_info) {
                    openFragment(new Info());
                    return true;
                }else if(itemId == R.id.add_record){
                    openFragment(new RecordsFragment());
                    return true;
                }
                return false;
            }
        });
        fragmentManager = getSupportFragmentManager();
        openFragment(new home());
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.settings) {
            openFragment(new Settings());
        }else if (itemId == R.id.drawer_home) {
            openFragment(new home());
        }else if(itemId == R.id.about){
            openFragment(new About());
        }else if(itemId == R.id.share){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT,"Check out this cool App");
            intent.putExtra(Intent.EXTRA_TEXT,"Application's link");
            startActivity(intent);
        } else if (itemId==R.id.log_out) {
            // firebase
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(MainActivity.this,"successfully logout",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();


        } else if(itemId == R.id.about)
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
    public void openFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
    }
}