package com.example.myapplicationmp.unit_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationmp.R;

import java.util.ArrayList;

public class About extends Activity {
    private Button submitBtn;
    private TextView headingText;
    private EditText editText;

    private Button backbtn;


    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_profile);

        Intent i = getIntent();
        String gender = i.getStringExtra("gender");
        String country = i.getStringExtra("country");
        String fullName = i.getStringExtra("fullName");
        ArrayList<String> sports = i.getStringArrayListExtra("sports");

        TextView f_name = findViewById(R.id.fname);
        TextView gen = findViewById(R.id.gender);
        TextView coun = findViewById(R.id.country);
        TextView sport = findViewById(R.id.sports);
        Button backbtn = findViewById(R.id.button_go_back);

        backbtn.setOnClickListener(v -> finish());
        gen.setText(gender);
        coun.setText(country);
        f_name.setText(fullName);

        if (fullName != null && !fullName.isEmpty()) f_name.setText(fullName);
        else f_name.setText("N/A");

        if (sports != null && !sports.isEmpty()) {
            String joinedSports = String.join(", ", sports);
            sport.setText(joinedSports);
        } else {
            Toast.makeText(getApplicationContext(), "No Sports", Toast.LENGTH_SHORT).show();
            sport.setText("N/A");

        }


//        submitBtn.setOnClickListener(v -> {
//            String inputValue = editText.getText().toString();
//
//            if (inputValue.isEmpty()) {
//                headingText.setText("Empty!");
//            } else
//                headingText.setText(inputValue);
//        });
    }
}
