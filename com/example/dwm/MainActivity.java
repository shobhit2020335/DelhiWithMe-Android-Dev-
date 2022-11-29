package com.example.dwm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.dwm.databinding.ActivityMainBinding;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (user == null) {
            Log.d("onstart","APP STARTED");

        } else if (user != null && !user.isEmailVerified()) {
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, home.class);
            startActivity(intent);
        }
    }

    public void gohome(View v) {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

}

