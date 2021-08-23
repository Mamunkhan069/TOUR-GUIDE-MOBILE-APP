package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterguideActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText guidename,guideemail,guideage,guidemobilenumber,guidedistrict;
    private Button registerBtn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerguide);
        guidename=findViewById(R.id.fullName);
        guideemail=findViewById(R.id.GuideEmailId);
        guideage=findViewById(R.id.age);
        guidemobilenumber=findViewById(R.id.mobileNumber);
        guidedistrict=findViewById(R.id.GuideDistrict);
        registerBtn=findViewById(R.id.Guideregister);
        registerBtn.setOnClickListener(this);
        databaseReference=FirebaseDatabase.getInstance().getReference("guideInformation");
    }

    @Override
    public void onClick(View view) {


        saveData();
        Toast.makeText(getApplicationContext(), "Register is  succesful", Toast.LENGTH_SHORT).show();

        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent1);
        finish();
    }
    public void saveData(){
        String name=guidename.getText().toString().trim();
        String email=guideemail.getText().toString().trim();
        String age=guideage.getText().toString().trim();
        String mobilenumber=guidemobilenumber.getText().toString().trim();
        String district=guidedistrict.getText().toString().trim();
        String key=databaseReference.push().getKey();
        guideInformation guideInformation= new guideInformation(name,email,age,mobilenumber,district);

        databaseReference.child(key).setValue(guideInformation);

    }
}
