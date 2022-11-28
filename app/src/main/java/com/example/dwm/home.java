package com.example.dwm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//import com.example.dwm.databinding.ActivityHomeBinding;
import com.example.dwm.databinding.ActivityHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import Adapter.homeAdapter;

public class home extends AppCompatActivity {
    ActivityHomeBinding binding;
    FirebaseAuth auth;
    FirebaseUser user;
    FirebaseDatabase database;
    LoadingDialog loadingDialog = new LoadingDialog(home.this);

    String[] category = {"Places to hangout or chill", "Are you a Movie addict? Let's Watch Movies", "Are you a foodie? Search for best restaurants and local food corners", "Shopping malls", "Local and Cheap markets", "Gotcha! You want to travel. Search for airports, Railway Stations and bus stations", "Devotional Places", "Must Visit Places"};
    int[] images = {R.drawable.b5, R.drawable.cinemahall, R.drawable.restaurant, R.drawable.mall, R.drawable.localmarket, R.drawable.airport, R.drawable.temple, R.drawable.akshardham};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        SharedPreferences preferences = getSharedPreferences("pref", MODE_PRIVATE);
        boolean showonstart = preferences.getBoolean("show", true);
        int check = 1;

        if (showonstart) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(home.this);
            builder1.setMessage("Do you live in Delhi?");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putBoolean("show", false);
                            editor.apply();

//                        binding.imageView2.setVisibility(View.VISIBLE);
                            database.getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("liveindelhi").setValue("yes");

                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putBoolean("show", false);
                            editor.apply();
                            database.getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("liveindelhi").setValue("no");
                        }
                    });


            AlertDialog alert11 = builder1.create();
            alert11.show();
        }


        database.getReference().child("users").child(auth.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    User user = snapshot.getValue(User.class);
                    if (snapshot.hasChild("profilephoto")) {
                        Picasso.get()
                                .load(user.getProfilephoto())
                                .placeholder(R.drawable.placeholder)
                                .into(binding.profilepic);
                    }
                    if (snapshot.hasChild("liveindelhi")) {
                        if (snapshot.child("liveindelhi").getValue().equals("yes")) {
                            binding.dlbadge.setVisibility(View.VISIBLE);
                        } else if (snapshot.child("liveindelhi").getValue().equals("no")) {
                            binding.dlbadge.setVisibility(View.INVISIBLE);
                        }
                    }
                    binding.hiTxt.setText("Hii " + user.getName());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        binding.categories.setLayoutManager(new LinearLayoutManager(this));
        binding.categories.setAdapter(new homeAdapter(category, images, new homeAdapter.ItemClickListener() {
            @Override
            public void onItemclick(int index) {

                if (index == 0) {
                    loadingDialog.startLoading();
                    Fragment fragment = new mainpage_hangout();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.hlayout, fragment).commit();
                    loadingDialog.dismissdialog();
                } else if (index == 1) {
                    loadingDialog.startLoading();
                    Intent intent = new Intent(home.this, cinemahall.class);
                    startActivity(intent);
                    loadingDialog.dismissdialog();
                } else if (index == 2) {
                    loadingDialog.startLoading();
                    Fragment fragment = new choicefood();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.hlayout, fragment).commit();
                    loadingDialog.dismissdialog();
                    binding.categories.setVisibility(View.INVISIBLE);
                    binding.profilepic.setVisibility(View.INVISIBLE);
                } else if (index == 3) {
                    loadingDialog.startLoading();
                    Fragment fragment = new mainpage();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.hlayout, fragment).commit();
                    loadingDialog.dismissdialog();
                    binding.categories.setVisibility(View.INVISIBLE);
                    binding.profilepic.setVisibility(View.INVISIBLE);

                } else if (index == 4) {
                    loadingDialog.startLoading();
                    Fragment fragment = new mainpage_localmarket();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.hlayout, fragment).commit();
                    loadingDialog.dismissdialog();
                    binding.categories.setVisibility(View.INVISIBLE);
                    binding.profilepic.setVisibility(View.INVISIBLE);
                } else if (index == 5) {
                    loadingDialog.startLoading();
                    Fragment fragment = new choicetransport();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.hlayout, fragment).commit();
                    loadingDialog.dismissdialog();
                    binding.categories.setVisibility(View.INVISIBLE);
                    binding.profilepic.setVisibility(View.INVISIBLE);
                } else if (index == 6) {
                    loadingDialog.startLoading();
                    Fragment fragment = new mainpage_devotional();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.hlayout, fragment).commit();
                    loadingDialog.dismissdialog();
                    binding.categories.setVisibility(View.INVISIBLE);
                    binding.profilepic.setVisibility(View.INVISIBLE);
                } else if (index == 7) {
                    loadingDialog.startLoading();
                    Fragment fragment = new mainpage_mustvisit();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.hlayout, fragment).commit();
                    loadingDialog.dismissdialog();
                    binding.categories.setVisibility(View.INVISIBLE);
                    binding.profilepic.setVisibility(View.INVISIBLE);
                }


            }
        }));

        binding.profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.startLoading();
                Intent intent = new Intent(home.this, profile.class);
                startActivity(intent);
                loadingDialog.dismissdialog();
            }
        });

    }


}