package com.example.myapplicationmp.unit_6;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationmp.R;

import java.util.ArrayList;

public class CustomRecyclerViewListItem extends RecyclerView.Adapter<RecyclerItemHolder> {
    Activity ctx;
    ArrayList<AlbumDetail> data;

    public CustomRecyclerViewListItem(Activity ctx, ArrayList<AlbumDetail> d) {
        this.ctx = ctx;
        this.data = d;
    }

    @NonNull
    @Override
    public RecyclerItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View listItem = layoutInflater.inflate(R.layout.unit_6_custom_list_item, parent, false);
        return new RecyclerItemHolder(listItem, R.id.customListItemRoot, R.id.customListItemTitle, R.id.customListItemImage, R.id.customListItemDescription);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerItemHolder holder, int position) {
        AlbumDetail albumDetail = data.get(position);

        holder.titleView.setText(albumDetail.getTitle());
        holder.descriptionView.setText(albumDetail.getDescription());
        holder.imageView.setImageResource(albumDetail.getImage());

        holder.rootView.setOnClickListener(v -> {
            String close = "Let it go!";
            String message = albumDetail.getTitle() + " is selected " + position;
            Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}