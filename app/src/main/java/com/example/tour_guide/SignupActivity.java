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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signupemailedittext,signuppasswordedittext;
    private Button signupbutton;
    private TextView signintextview;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        this.setTitle("Sign Up ");
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressbarid);
        signupemailedittext=findViewById(R.id.signup_emailid);
        signuppasswordedittext=findViewById(R.id.signup_password);
        signupbutton=findViewById(R.id.signupBtn);
        signintextview=findViewById(R.id.signintextid);
        signintextview.setOnClickListener(this);
        signupbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signupBtn:
                userregister();


                break;
            case  R.id.signintextid:
                Intent intent=new Intent(getApplicationContext(),SigninActivity.class);
                startActivity(intent);

                break;
        }
    }
    private void userregister() {
        String email=signupemailedittext.getText().toString();
        String password=signuppasswordedittext.getText().toString();
        if(email.isEmpty()){
            signupemailedittext.setError("Enter an email address");
            signupemailedittext.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            signupemailedittext.setError("Enter an valid email address");
            signupemailedittext.requestFocus();
            return;

        }
        if(password.isEmpty()){
            signuppasswordedittext.setError("Enter a Password");
            signuppasswordedittext .requestFocus();
            return;
        }
        if(password.length()<6){
            signuppasswordedittext.setError("Minimum length of password should be 6");
            signuppasswordedittext.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE );
                if (task.isSuccessful()) {
                    finish();
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                } else {

                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"User allready registered",Toast.LENGTH_SHORT).show();

                    }
                    else
                        Toast.makeText(getApplicationContext(),"Error:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });


    }
}
