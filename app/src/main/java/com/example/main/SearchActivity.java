package com.example.main;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {
    Button testbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        testbtn = findViewById(R.id.buttontest);

        testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("result", "1");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}
