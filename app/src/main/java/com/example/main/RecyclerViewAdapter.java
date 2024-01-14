package com.example.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView_item;
        TextView txt_main;
        TextView txt_sub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView_item = (ImageView) itemView.findViewById(R.id.imgView_item);
            txt_main = (TextView) itemView.findViewById(R.id.txt_main);
            txt_sub = (TextView) itemView.findViewById(R.id.txt_sub);
        }
    }

    private ArrayList<RecyclerViewItem> mList = null;

    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_recycler_item, parent, false);
        RecyclerViewAdapter.ViewHolder vh = new RecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerViewItem item = mList.get(position);

        holder.imgView_item.setImageResource(R.drawable.ic_launcher_background);
        holder.txt_main.setText(item.getMainText());
        holder.txt_sub.setText(item.getSubText());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
