package com.zeynep.myphone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btmnavim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btmnavim=findViewById(R.id.bnavim);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new recentsFragment()).commit();




        btmnavim.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.recents:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new recentsFragment()).commit();
                        break;
                    case R.id.contacts:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new contactsFragment()).commit();
                        break;
                    case R.id.keypad:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new keypadFragment()).commit();
                        break;
                }
                return true;
            }
        });

    }}