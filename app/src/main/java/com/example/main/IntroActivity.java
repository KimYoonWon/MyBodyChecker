package com.example.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.main.MainActivity;

public class IntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();
            }
        },5000); //1초 후 인트로 실행
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
