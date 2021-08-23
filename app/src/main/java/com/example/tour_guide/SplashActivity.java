package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splash);



        progressBar=findViewById(R.id.progressbarid);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
                startApp();

            }
        });
        thread.start();
    }
    public void dowork(){
        for(progress=10;progress <=100;progress=progress+10) {
            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
    public void startApp(){
        Intent intent=new Intent(SplashActivity.this,SigninActivity.class);
        startActivity(intent);
        finish();
    }
}
