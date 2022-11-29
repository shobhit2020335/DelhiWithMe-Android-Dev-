package com.example.dwm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.TimeAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.dwm.databinding.ActivityProfileBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class profile extends AppCompatActivity {
    ActivityProfileBinding binding;
    FirebaseAuth auth;
    FirebaseStorage storage;
    FirebaseDatabase database;
    LoadingDialog loadingDialog = new LoadingDialog(profile.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getIntent();
        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();
//        String imageUri = "drawable://" + R.drawable.defaultuser;
//        database.getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("profilephoto").setValue(imageUri);

        database.getReference().child("users").child(auth.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    User user = snapshot.getValue(User.class);
//                    if(snapshot.hasChild(pr))
                    if (snapshot.hasChild("profilephoto")) {


                        Picasso.get()
                                .load(user.getProfilephoto())
                                .placeholder(R.drawable.placeholder)
                                .into(binding.dp);
                    } else {
                        binding.dp.setImageResource(R.drawable.defaultuser);
                    }
                    binding.profileName.setText(user.getName());
                    binding.profileEmail.setText(user.getEmail());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.uploadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.startLoading();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 11);
            }
        });
        binding.profileName.setFocusable(false);
        binding.logouttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(profile.this);
                builder1.setMessage("Are you sure you want to logout?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                FirebaseAuth.getInstance().signOut();
                                Intent intent = new Intent(profile.this, MainActivity.class);
                                startActivity(intent);
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


                AlertDialog alert11 = builder1.create();
                alert11.show();


            }
        });

        binding.logoutimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(profile.this);
                builder1.setMessage("Are you sure you want to logout?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                FirebaseAuth.getInstance().signOut();
                                GoogleSignIn.getClient(
                                        getApplicationContext(),
                                        new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
                                ).signOut();

//                                FirebaseAuth.getInstance().signOut();
                                Intent intent = new Intent(profile.this, MainActivity.class);
                                startActivity(intent);
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
        binding.editname.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                binding.profileName.setFocusableInTouchMode(true);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

                binding.updateprofilebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String updatedname = binding.profileName.getText().toString();
                        Toast.makeText(profile.this, "profile updated successfully", Toast.LENGTH_SHORT).show();
                        database.getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("name").setValue(updatedname);
//                        binding.profileName.setText(updatedname);
                        binding.profileName.setFocusable(false);
//                        database.getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("profile_photo").setValue(binding.dp.get)


                    }
                });

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11) {
            if (data.getData() != null) {
                Uri uri = data.getData();
                binding.dp.setImageURI(uri);
                loadingDialog.dismissdialog();
                binding.updateprofilebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loadingDialog.startLoading();


                        final StorageReference reference = storage.getReference().child("profile_photo").child(FirebaseAuth.getInstance().getUid());
                        reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                Toast.makeText(profile.this, "profile updated successfully", Toast.LENGTH_SHORT).show();
                                loadingDialog.dismissdialog();
                                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        database.getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("profilephoto").setValue(uri.toString());
                                        loadingDialog.dismissdialog();

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(profile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        });
                    }
                });
            }


        }
    }
}