package com.example.myapplicationmp.unit_6;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationmp.R;

public class ListViewMain extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        ActionBar bar = getSupportActionBar();
        if (bar != null) bar.hide();
    }

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        Resources res = getResources();
        setContentView(R.layout.unit_6_list_view_main);

        ListView listView = findViewById(R.id.listViewMainList);
        ViewGroup rootLayout = findViewById(R.id.listViewRoot);

        String[] coffeeTypes = res.getStringArray(R.array.Coffee_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.unit_3_spinner_item, R.id.spinnerItemText, coffeeTypes);
        listView.setAdapter(adapter);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String close = "Ok!";
                Adapter listadapter = parent.getAdapter();
                String value = listadapter.getItem(position).toString();
                String message = "You selected " + value + " at position " + position + " with id " + id;

                android.widget.Toast.makeText(getApplicationContext(), message, android.widget.Toast.LENGTH_SHORT).show();
            }
        });


    }
}
