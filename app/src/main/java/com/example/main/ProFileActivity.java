package com.example.main;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.InputStream;

public class ProFileActivity extends AppCompatActivity {

    private final int GALLERY_CODE = 10;
    private FirebaseStorage storage;
    ImageView photo;
    TextView setname;
    User user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditText name_edit = findViewById(R.id.name_edit);
        EditText age_edit = findViewById(R.id.age_edit);
        EditText key_edit = findViewById(R.id.key_edit);
        EditText weight_edit = findViewById(R.id.weight_edit);
        Button addBtn = findViewById(R.id.add_btn);
        photo = findViewById(R.id.user_image);
        storage = FirebaseStorage.getInstance();
        setname = findViewById(R.id.setname);
        user = new User();
        DAOUser dao = new DAOUser();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("user_name");
                myRef.setValue(name_edit.getText().toString());

                myRef = database.getReference("user_age");
                myRef.setValue(age_edit.getText().toString());
                myRef = database.getReference("user_weight");
                myRef.setValue(weight_edit.getText().toString());
                myRef = database.getReference("user_key");
                myRef.setValue(key_edit.getText().toString());



                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String value = snapshot.getValue(String.class);
                        //setname.setText("value: " + value);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        setname.setText("error: " + error.toException());
                    }
                });

                //입력값 변수에 담기
                String name = name_edit.getText().toString(); //이름
                String age = age_edit.getText().toString(); //나이
                String key = key_edit.getText().toString(); //키
                String weight = weight_edit.getText().toString(); //몸무게



                User user = new User(name, age, key, weight);

                //데이터베이스 사용자 등록
                dao.add(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), BottomActivity.class);
                        startActivity(intent);

                        //입력창 초기화
                        name_edit.setText("");
                        age_edit.setText("");
                        key_edit.setText("");
                        weight_edit.setText("");

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "실패:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.user_image:
                        loadAlbum();
                        break;
                }
            }


        });
    }
    private void loadAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, GALLERY_CODE);
    }


    @Override
    protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_CODE) {


            Uri file = data.getData();
            StorageReference storageRef = storage.getReference();
            StorageReference riversRef = storageRef.child("photo/1.png");
            UploadTask uploadTask = riversRef.putFile(file);


            try {
                InputStream in = getContentResolver().openInputStream(data.getData());
                Bitmap img = BitmapFactory.decodeStream(in);
                in.close();
                photo.setImageBitmap(img);
            } catch (Exception e) {
                e.printStackTrace();
            }

            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(ProFileActivity.this, "사진이 정상적으로 업로드 되지 않았습니다.",
                            Toast.LENGTH_SHORT).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(ProFileActivity.this, "사진이 정상적으로 업로드 되었습니다.",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
