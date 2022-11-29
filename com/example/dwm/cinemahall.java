package com.example.dwm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dwm.databinding.ActivityCinemahallBinding;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Adapter.listAdapter;

public class cinemahall extends AppCompatActivity {
    ActivityCinemahallBinding binding;
   private listAdapter l;
   private DatabaseReference myref;
   private ArrayList<MainModel>modelList;
   private Context context;
    private AdView mAdView;

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCinemahallBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cinemahallList.setLayoutManager(new LinearLayoutManager(this));
        myref=FirebaseDatabase.getInstance().getReference();
        modelList=new ArrayList<>();
        clearall();
        getdata();

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override

            public void onAdClicked() {
                super.onAdClicked();

            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                super.onAdFailedToLoad(adError);
                mAdView.loadAd(adRequest);

            }

            @Override
            public void onAdImpression() {

            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });


    }
    private void getdata(){
        Query query=myref.child("cinemahall");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                clearall();
                for(DataSnapshot snapshot1:snapshot.getChildren()){
                    MainModel model=new MainModel();
                    model.setImg((String) snapshot1.child("img").getValue());
                    model.setName(snapshot1.child("name").getValue().toString());
                    model.setKey(snapshot1.getKey());
                    modelList.add(model);
                }
                l=new listAdapter(getApplicationContext(),modelList);
                binding.cinemahallList.setAdapter(l);
                l.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    private void clearall(){
        if(modelList!=null){
            modelList.clear();
            if(l!=null){
                l.notifyDataSetChanged();
            }
        }
        modelList=new ArrayList<>();
    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        l.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        l.stopListening();
//    }
}