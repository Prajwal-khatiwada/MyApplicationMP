package com.example.myapplicationmp.unit_6;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationmp.R;

public class CustomGridViewMain extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_6_custom_gridview_main);
        gridView = findViewById(R.id.mygridview);


        // creating arrays
        String[] title = {
                "Title 1", "Title 2",
                "Title 3", "Title 4"
        };
        String[] description = {
                "This is description 1",
                "This is description 2",
                "This is description 3",
                "This is description 4"
        };

        GridViewMain adapter = new GridViewMain(this, title, description);
    }
}

