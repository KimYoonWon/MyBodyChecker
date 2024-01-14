package com.example.main;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOUser { //데이터베이스 연결 기능을 구현한 클래스
    private final DatabaseReference databaseReference;

    DAOUser() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(User.class.getSimpleName());
    }

    //등록
    public Task<Void> add(User user){

        return databaseReference.push().setValue(user);
    }
}
