package com.example.myapplicationmp.unit_2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplicationmp.R;

public class Unit_2 extends Activity {
    private Button submitBtn;
    private TextView headingText;
    private EditText editText;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_2_hello);

        headingText = findViewById(R.id.headingText);
        submitBtn = findViewById(R.id.submitBtn);
        editText = findViewById(R.id.editTxt);

        submitBtn.setOnClickListener(v -> {
            String inputValue = editText.getText().toString();

            if (inputValue.isEmpty()) {
                headingText.setText("Empty!");
            } else {
                headingText.setText(inputValue);
            }
        });
    }
}
