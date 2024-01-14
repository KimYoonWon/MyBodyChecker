package com.example.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FragmentMyPage extends Fragment {


    LinearLayout informationbutton, alarmbutton, introducebutton, developmentbutton;
    TextView userName;
    private FirebaseStorage storage;
    ImageView userImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_mypage, container, false);
        userName = rootView.findViewById(R.id.setname);

        //이미지뷰
        userImage = rootView.findViewById(R.id.setiv);
        storage = FirebaseStorage.getInstance(); //스토리지에 접근하기 위해 인스턴스 생성
        StorageReference storageRef = storage.getReference(); //스토리지에 어떤 폴더에 접근할 것인지 알려주는 코드로 폴더명 작성
        StorageReference pathReference = storageRef.child("photo/1.png");





        if (pathReference == null) {
            Toast.makeText(getContext(),"저장소에 사진이 없습니다.", Toast.LENGTH_SHORT).show();

        } else {
            StorageReference submitProfile = storageRef.child("photo/1.png");
            submitProfile.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Glide.with(FragmentMyPage.this).load(uri).into(userImage);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refUser = database.getReference("user_name");
        refUser.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String value = snapshot.getValue(String.class);
                userName.setText(value + "님");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                userName.setText("error: " + error.toException());
            }
        });




        informationbutton = rootView.findViewById(R.id.informationbutton);
        informationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "회원정보 변경", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MemberInformation.class);
                startActivity(intent);

            }
        });

        alarmbutton = rootView.findViewById(R.id.alarmbutton);
        alarmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "알림 설정", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), AlarmActivity.class);
                startActivity(intent);

            }
        });

        introducebutton = rootView.findViewById(R.id.introducebutton);
        introducebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "어플 소개", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), IntroduceActivity.class);
                startActivity(intent);

            }
        });

        developmentbutton = rootView.findViewById(R.id.developmentbutton);
        developmentbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "개발자 문의", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), Development.class);
                startActivity(intent);

            }
        });
        return rootView;
    }
}
