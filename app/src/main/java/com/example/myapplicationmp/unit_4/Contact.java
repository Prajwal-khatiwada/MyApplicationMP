package com.example.myapplicationmp.unit_4;

import android.util.Log;
import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;
import android.widget.Button;
import android.content.Intent;

import com.example.myapplicationmp.R;


public class Contact extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_2_hello);

        this.setFinishOnTouchOutside(false);
        Log.d("myStateLog", "Contact - onCreate");

        Button submitButton = findViewById(R.id.submitBtn);
        Button cancelButton = findViewById(R.id.cancelBtn);

        submitButton.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show());

        cancelButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.putExtra("contactData", "Contact Text");
            setResult(RESULT_OK, i);
            finish();
        });
    }
}