package com.example.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment {

    Button btnArm,btnArm2,btnLeg,btnLeg2,btnStomach,btnCalf,btnCalf2,btnChest,btnDeltoid,btnCheack,btnSearch;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_home,
                container,false);

        setHasOptionsMenu(true);


        btnArm = rootView.findViewById(R.id.arm);

        btnArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"팔", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),forearmActivity.class);
                startActivity(intent);
            }
        });

        btnArm2 = rootView.findViewById(R.id.arm2);

        btnArm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"팔", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),forearmActivity.class);
                startActivity(intent);
            }
        });

        btnLeg = rootView.findViewById(R.id.leg);

        btnLeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"종아리", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),legActivity.class);
                startActivity(intent);
            }
        });

        btnLeg2 = rootView.findViewById(R.id.leg2);

        btnLeg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"종아리", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),legActivity.class);
                startActivity(intent);
            }
        });

        btnCalf = rootView.findViewById(R.id.calf);

        btnCalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"허벅지", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),calfActivity.class);
                startActivity(intent);
            }
        });

        btnCalf2 = rootView.findViewById(R.id.calf2);

        btnCalf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"허벅지", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),calfActivity.class);
                startActivity(intent);
            }
        });

        btnStomach = rootView.findViewById(R.id.stomach);

        btnStomach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"복부", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
            }
        });

        btnChest = rootView.findViewById(R.id.chest);

        btnChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"가슴", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),ChestActivity.class);
                startActivity(intent);
            }
        });

        btnDeltoid = rootView.findViewById(R.id.deltoid);

        btnDeltoid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"삼각근", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),DeltoidActivity.class);
                startActivity(intent);
            }
        });

        btnCalf = rootView.findViewById(R.id.calf);

        btnCalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"허벅지", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),calfActivity.class);
                startActivity(intent);
            }
        });

        btnCheack = rootView.findViewById(R.id.button_check);

        btnCheack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"체커", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),CheckerActivity.class);
                startActivity(intent);

            }
        });

        btnSearch = rootView.findViewById(R.id.button_search);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"검색", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
            }
        });


        return rootView;
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.top_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curId = item.getItemId();

        switch (curId){
            case R.id.home:
                Toast.makeText(getActivity(), "마이페이지", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
