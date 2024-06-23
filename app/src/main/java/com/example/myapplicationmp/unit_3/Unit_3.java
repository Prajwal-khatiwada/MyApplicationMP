package com.example.myapplicationmp.unit_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplicationmp.unit_2.Unit_2;
import com.example.myapplicationmp.unit_4.About;
import com.example.myapplicationmp.unit_4.Contact;
import com.google.android.material
        .snackbar
        .Snackbar;

import android.widget.Toast;

import com.example.myapplicationmp.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Unit_3 extends Activity {

    private Button submitBtn;

    private Button cancel_button;

    private Button contact_button;
    private TextView headingText;
    private EditText editText;

    private RadioGroup genderGroup;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("myStateLog", "Home-onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("myStateLog", "Home-onResume");
        Toast.makeText(getApplicationContext(), "Resumed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("myStateLog", "Home-onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("myStateLog", "Home-OnPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("myStateLog", "Home-onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("myStateLog", "Home-onStop");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String message = data.getStringExtra("contactData");
            headingText.setText(message);
        }
    }

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_3_constraint);

        Log.d("myStateLog", "Home-onCreate");

        Spinner country_spinner = findViewById(R.id.country_spinner);
        String[] countryList = {"Korea", "Netherlands", "United Kingdom", "Germany"};
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, R.layout.unit_3_spinner_item, countryList);
        country_spinner.setAdapter(countryAdapter);


        headingText = findViewById(R.id.heading_text);
        submitBtn = findViewById(R.id.submit_button);
        editText = findViewById(R.id.edit_text);
        cancel_button = findViewById(R.id.cancel_button);
        genderGroup = findViewById(R.id.radioGroup);

        CheckBox footballCheckbox = findViewById(R.id.checkbox_football);
        CheckBox basketballCheckbox = findViewById(R.id.checkbox_basketball);
        CheckBox cricketCheckbox = findViewById(R.id.checkbox_cricket);
        CheckBox judoCheckbox = findViewById(R.id.checkbox_judo);


        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a snackbar
                Snackbar snackbar = Snackbar.make(v, "Cancelled", Snackbar.LENGTH_LONG);
                snackbar.show();


                // Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();

            }
        });

        contact_button.setOnClickListener(v -> {
            Intent i = new Intent(Unit_3.this, Contact.class);
            startActivityForResult(i, 1);
        });


//
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedGender = "unknown";

                Intent i = new Intent(Unit_3.this, About.class);
//                boolean keyboard =keyboardUtil.isKeyboardVisible;

                ArrayList<String> selectedSports = new ArrayList<>();
                int checkedRadioButtonId = genderGroup.getCheckedRadioButtonId();

                if (checkedRadioButtonId == R.id.radioMale)
                    selectedGender = "Male";
                else selectedGender = "Female";

                CheckBox[] checkBoxes = {footballCheckbox, basketballCheckbox, cricketCheckbox, judoCheckbox};

                for (CheckBox checkBox : checkBoxes) {
                    if (checkBox.isChecked()) selectedSports.add(checkBox.getText().toString());
                }
                System.out.println(selectedSports);

                String fullname = editText.getText().toString();

                String selectedcountry = country_spinner.getSelectedItem().toString();

                i.putExtra("gender", selectedGender);
                i.putExtra("country", selectedcountry);
                i.putExtra("fullName", fullname);
                i.putExtra("sports", selectedSports);

                startActivity(i);
            }
        });
    }
}

