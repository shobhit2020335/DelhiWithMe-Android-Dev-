package com.example.dwm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.delhiwithme.databinding.ActivitySignupBinding;
import com.example.dwm.databinding.ActivitySignupBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class signup extends AppCompatActivity {
    ActivitySignupBinding binding;
    GoogleSignInClient mGoogleSignInClient;
    private final int RC_SIGN_IN = 65;
    private TextView tv;
    FirebaseAuth auth;
    FirebaseDatabase database;
    TextInputEditText mail, password, name;
    LoadingDialog loadingDialog = new LoadingDialog(signup.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getIntent();

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mail = (TextInputEditText) findViewById(R.id.namesignup3);
        name = (TextInputEditText) findViewById(R.id.namesignup2);
        password = (TextInputEditText) findViewById(R.id.namesignup4);

        binding.signupbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()) {
                    name.setError("Required");
                    name.requestFocus();
                } else if (mail.getText().toString().isEmpty()) {
                    mail.setError("Required");
                    mail.requestFocus();
                } else if (password.getText().toString().isEmpty()) {
                    password.setError("Required");
                    password.requestFocus();
                } else {
                    loadingDialog.startLoading();

                    String email = Objects.requireNonNull(mail.getText()).toString();
                    String pass = Objects.requireNonNull(password.getText()).toString();
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(signup.this, "REGISTERD SUCCESSFULLY. PLEASE LOGIN.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(signup.this, login.class);
                                startActivity(intent);
                                loadingDialog.dismissdialog();
                                User u1 = new User(Objects.requireNonNull(name.getText()).toString(), email, pass);
                                String id = Objects.requireNonNull(task.getResult().getUser()).getUid();
                                database.getReference().child("users").child(id).setValue(u1);
                            } else {
                                loadingDialog.dismissdialog();
                                Toast.makeText(signup.this, "ERROR:" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        tv = findViewById(R.id.logintxt2);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                loadingDialog.startLoading();
                signIn();

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(signup.this, home.class);
            startActivity(intent);
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);


            try {
                GoogleSignInAccount acct = task.getResult(ApiException.class);
                Log.d("TAG", "firebaseauthwithgoogle:" + acct.getId());
                firebaseauthwithgoogle(acct.getIdToken());

            } catch (ApiException e) {
                Log.w("TAG", "GOOGLESIGNINFAILED", e);
            }
        }
    }

    private void firebaseauthwithgoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Log.d("TAG", "signinwithcredential success");
                    Intent intent = new Intent(signup.this, home.class);
                    startActivity(intent);
                    loadingDialog.dismissdialog();
                    FirebaseUser user = auth.getCurrentUser();
                    User u = new User(user.getDisplayName(), user.getEmail(), user.getUid().toString());
                    database.getReference().child("users").child(user.getUid()).setValue(u);
                } else {
                    Log.w("TAG", "signinwithcredential failed", task.getException());
                }
            }
        });

    }


}