package com.example.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MemberInformation extends AppCompatActivity {

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    EditText username, userage, userKey, userWeight;
    Button btn_im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_information);
        username = findViewById(R.id.name_edit);
        userage = findViewById(R.id.et_age);
        userKey = findViewById(R.id.et_cm);
        userWeight = findViewById(R.id.kg_et);
        btn_im = findViewById(R.id.btn_im);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refUser = database.getReference("user_name");
        DatabaseReference refAge = database.getReference("user_age");
        DatabaseReference refKey = database.getReference("user_key");
        DatabaseReference refWeight = database.getReference("user_weight");

        refUser.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String value = snapshot.getValue(String.class);
                username.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                username.setText("error: " + error.toException());
            }
        });

        refAge.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String value = snapshot.getValue(String.class);
                userage.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                username.setText("error: " + error.toException());
            }
        });

        refKey.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String value = snapshot.getValue(String.class);
                userKey.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                userKey.setText("error: " + error.toException());
            }
        });
        refWeight.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String value = snapshot.getValue(String.class);
                userWeight.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                userWeight.setText("error: " + error.toException());
            }
        });

        btn_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MemberInformation.this, "회원정보 변경완료", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MemberInformation.this,BottomActivity.class);
                startActivity(intent);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("user_name");
                myRef = database.getReference("user_name");
                myRef.setValue(username.getText().toString());
                myRef = database.getReference("user_age");
                myRef.setValue(userage.getText().toString());
                myRef = database.getReference("key");
                myRef.setValue(userKey.getText().toString());
                myRef = database.getReference("weight");
                myRef.setValue(userWeight.getText().toString());

                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String value = snapshot.getValue(String.class);
                        username.setText(value);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }
}