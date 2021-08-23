package com.example.tour_guide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signinemailedittext, signinpasswordedittext;
    private Button signinbutton;
    private TextView signuptextview;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        this.setTitle("Sign in");
        setContentView(R.layout.activity_signin);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.inprogressbarid);
        signinemailedittext = findViewById(R.id.signin_emailid);
        signinpasswordedittext = findViewById(R.id.signin_password);
        signinbutton = findViewById(R.id.signinBtn);
        signuptextview = findViewById(R.id.signuptextid);

        signinbutton.setOnClickListener(this);
        signuptextview.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signinBtn:
                userLogin();

                break;
            case R.id.signuptextid:
                Intent intent1 = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent1);



        }
    }

    private void userLogin() {
        String email = signinemailedittext.getText().toString();
        String password = signinpasswordedittext.getText().toString();
        if (email.isEmpty()) {
            signinemailedittext.setError("Enter an email address");
            signinemailedittext.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signinemailedittext.setError("Enter an valid email address");
            signinemailedittext.requestFocus();
            return;

        }
        if (password.isEmpty()) {
            signinpasswordedittext.setError("Enter the Password");
            signinpasswordedittext.requestFocus();
            return;
        }
        if (password.length() < 6) {
            signinpasswordedittext.setError("Minimum length of password should be 6");
            signinpasswordedittext.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login is not succesful", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }
}
