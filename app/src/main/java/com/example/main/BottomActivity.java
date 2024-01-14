package com.example.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomActivity extends AppCompatActivity {
   int CODE_SEARCH_ACTIVITY = 101;

   FragmentSearch fragment2;
   FragmentMyPage fragment1;
   FragmentHome fragment3;
   FragmentChecker fragment4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        fragment1 = new FragmentMyPage();
        fragment2 = new FragmentSearch();
        fragment3 = new FragmentHome();
        fragment4 = new FragmentChecker();


        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, fragment3).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(getApplicationContext(), "홈화면", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, fragment3).commit();
                        return true;

                    case R.id.mypage:
                        Toast.makeText(getApplicationContext(), "마이페이지", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, fragment1).commit();
                        return true;

                    case R.id.search:
                        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                        intent.putExtra("training","dumbell");
                        startActivityForResult(intent,CODE_SEARCH_ACTIVITY);

                        //Toast.makeText(getApplicationContext(), "검색", Toast.LENGTH_SHORT).show();
                        //getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, fragment2).commit();

                        return true;

                    case R.id.checker:
                        Toast.makeText(getApplicationContext(), "체커", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, fragment4).commit();
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CODE_SEARCH_ACTIVITY){
            if(resultCode == RESULT_OK){
                String res = data.getStringExtra("result");
                Toast.makeText(this,res,Toast.LENGTH_SHORT).show();

            }
        }
    }
}

