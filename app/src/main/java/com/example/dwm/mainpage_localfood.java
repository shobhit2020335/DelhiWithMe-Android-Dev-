package com.example.dwm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dwm.databinding.FragmentMainpageLocalfoodBinding;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Adapter.localfood_listAdapter;
import Adapter.restaurant_listAdapter;

public class mainpage_localfood extends Fragment {

    FragmentMainpageLocalfoodBinding binding;
    private localfood_listAdapter l;
    private DatabaseReference myref;
    private ArrayList<MainModel> modelList;
    public mainpage_localfood() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentMainpageLocalfoodBinding.inflate(inflater,container,false);

        binding.localfoodlist.setLayoutManager(new LinearLayoutManager(getContext()));
        myref= FirebaseDatabase.getInstance().getReference();
        modelList=new ArrayList<>();
        clearall();
        getdata();
        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adView.loadAd(adRequest);

        binding.adView.setAdListener(new AdListener() {
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
                binding.adView.loadAd(adRequest);

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

        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_mainpage_localfood, container, false);
    }


    private void getdata(){
        Query query=myref.child("localfood");
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
                l=new localfood_listAdapter(getContext(),modelList);
                binding.localfoodlist.setAdapter(l);
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
}