package com.example.myapplicationmp.unit_6;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationmp.R;

import java.util.ArrayList;

public class RecyclerViewListMain extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_6_recycler_view_main);

        Resources res = getResources();

        ArrayList<AlbumDetail> albumDetails = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerViewListMain);

        String[] coffeeList = res.getStringArray(R.array.Coffee_list);
        String[] coffeeDescription = res.getStringArray(R.array.coffee_description);
        int[] imageIds = {R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon};

        for (int i = 0; i < coffeeList.length; i++) {
            albumDetails.add(new AlbumDetail(coffeeList[i], coffeeDescription[i], imageIds[i]));
        }
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);

        CustomRecyclerViewListItem itemList = new CustomRecyclerViewListItem(this, albumDetails);
        recyclerView.setAdapter(itemList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
