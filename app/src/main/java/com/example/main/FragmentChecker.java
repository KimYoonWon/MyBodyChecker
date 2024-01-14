package com.example.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentChecker extends Fragment {

    private ArrayList<RecyclerViewItem> favoritesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.activity_checker, container, false);

        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        mAdapter = new RecyclerViewAdapter(favoritesList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

}
