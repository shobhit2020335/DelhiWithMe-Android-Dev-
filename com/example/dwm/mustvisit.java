package com.example.dwm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.dwm.databinding.ActivityMustvisitBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;

import Adapter.commentAdapter;

public class mustvisit extends AppCompatActivity {
    ActivityMustvisitBinding binding;
    Context context;
    private DatabaseReference myref;
    FirebaseDatabase database;
    ArrayList<comment> list;
    private commentAdapter cAdapter;
    commentAdapter ca;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMustvisitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = mustvisit.this;
        Intent intent = getIntent();
//        setSupportActionBar(binding.toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        database = FirebaseDatabase.getInstance();
        myref = FirebaseDatabase.getInstance().getReference();
        String key = intent.getStringExtra("key");
        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);
        binding.imageView4.startAnimation(animation);
        binding.textView9.startAnimation(animation);

        Query query = myref.child("mustvisit").child(intent.getStringExtra("key"));
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {


                    Log.d("KEYVALUE", snapshot.getKey());

//                    if(snapshot.getKey().equals(intent.getStringExtra("key"))){
//                        Log.d("KkEYVALUE",snapshot.getKey());
                    MainModel model = snapshot.getValue(MainModel.class);
                    binding.heading.setText(model.getName());
                    binding.address.setText(model.getAddress());
                    binding.description.setText(model.getDescription());
                    binding.sname.setText(model.getMetro());
                    Picasso.get()
                            .load(model.getImg())
                            .placeholder(R.drawable.placeholder)
                            .into(binding.i1);
                    Picasso.get()
                            .load(model.getI1())
                            .placeholder(R.drawable.placeholder)
                            .into(binding.i2);
                    Picasso.get()
                            .load(model.getI2())
                            .placeholder(R.drawable.placeholder)
                            .into(binding.i3);
                    binding.cmmntCOUNT.setText(model.getCommentcount() + "");
//                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.cmmntRV.setLayoutManager(new LinearLayoutManager(this));
        binding.commentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.commentET.getText().toString().length()>0) {
                comment cmmnt = new comment();
                cmmnt.setCommentbody(binding.commentET.getText().toString());
                cmmnt.setCommentedat(new Date().getTime());
                cmmnt.setCommentedby(FirebaseAuth.getInstance().getUid());
                database.getReference()
                        .child("mustvisit")
                        .child(intent.getStringExtra("key"))
                        .child("comments")
                        .push()
                        .setValue(cmmnt).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                database.getReference().child("mustvisit").child(intent.getStringExtra("key")).child("commentcount").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        int cmmntcount = 0;
                                        if (snapshot.exists()) {
                                            cmmntcount = snapshot.getValue(Integer.class);

                                        }
                                        database.getReference()
                                                .child("mustvisit").
                                                child(intent.getStringExtra("key")).
                                                child("commentcount")
                                                .setValue(cmmntcount + 1).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void unused) {
                                                        binding.commentET.setText("");
                                                        Log.d("COMMENTTOAST", "commented");
                                                    }
                                                });

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                        });
            }
                    else {
                Toast.makeText(context, "Add some text first", Toast.LENGTH_SHORT).show();
            }
            }
        });

        list = new ArrayList<>();
        clearall();
        getdata();
    }


    private void getdata() {
        Query query = myref.child("mustvisit").child(getIntent().getStringExtra("key")).child("comments");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                clearall();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    comment c1 = snapshot1.getValue(comment.class);
//                                c1.setName(snapshot1.child("").getValue().toString());
                    c1.setCommentedby(snapshot1.child("commentedby").getValue().toString());
                    c1.setCommentedat(Long.parseLong(snapshot1.child("commentedat").getValue().toString() + ""));
                    c1.setCommentbody(snapshot1.child("commentbody").getValue().toString());

                    list.add(c1);
                }
                ca = new commentAdapter(getApplicationContext(), list);
                binding.cmmntRV.setAdapter(ca);
                ca.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


    private void clearall() {
        if (list != null) {
            list.clear();
            if (cAdapter != null) {
                cAdapter.notifyDataSetChanged();
            }
        }
        list = new ArrayList<>();
    }
}