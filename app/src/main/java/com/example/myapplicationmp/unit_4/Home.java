package com.example.myapplicationmp.unit_4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplicationmp.unit_2.Unit_2;
import com.example.myapplicationmp.unit_3.Unit_3;
import com.example.myapplicationmp.unit_4.About;
import com.example.myapplicationmp.unit_4.Contact;
import com.example.myapplicationmp.unit_6.CustomGridViewMain;
import com.example.myapplicationmp.unit_6.CustomListViewMain;
import com.example.myapplicationmp.unit_6.GridViewMain;
import com.example.myapplicationmp.unit_6.ListViewMain;
import com.example.myapplicationmp.unit_6.RecyclerViewListMain;
import com.example.myapplicationmp.unit_7.MapViewMain;
import com.example.myapplicationmp.unit_7.UserProfileMain;
import com.example.myapplicationmp.unit_7.UserProfileServerMain;
import com.google.android.material
        .snackbar
        .Snackbar;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationmp.R;
import com.example.myapplicationmp.util.AlertUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Home extends AppCompatActivity {

    private Button submitBtn;

    private Button cancel_button;

    private Button contact_button;
    private TextView headingText;
    private EditText editText;

    private RadioGroup genderGroup;

    private Button press_me_button;
    private Button calculator_button;
    private Button database_button;

    private Button sql_button;

    private Button map_button;


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("myStateLog", "Home-onStart");

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.button_color));

        if (getSupportActionBar() != null) {
            ActionBar bar = getSupportActionBar();
            int color = ContextCompat.getColor(this, R.color.button_color);
            int textColor = ContextCompat.getColor(this, R.color.black);
            Spannable text = new SpannableString("My Application");

            text.setSpan(new ForegroundColorSpan(textColor), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            text.setSpan(new AbsoluteSizeSpan(20, true), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            text.setSpan(new LeadingMarginSpan.Standard(20), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            bar.setTitle(text);
            bar.setElevation(10);
            bar.setBackgroundDrawable(new ColorDrawable(color));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        String close = "Go Away";
        int selectedItem = item.getItemId();

        if (selectedItem == R.id.appOptionsAbout) {
            Intent i = new Intent(Home.this, CustomListViewMain.class);
            startActivity(i);
            return true;
        }

        if (selectedItem == R.id.appOptionsContact) {
            Intent i = new Intent(Home.this, CustomGridViewMain.class);
            startActivity(i);
            return true;
        }

        if (selectedItem == R.id.appOptionsLogout) {
            Intent i = new Intent(Home.this, RecyclerViewListMain.class);
            startActivity(i);
            return true;
        }
        return false;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.app_options, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String close = "Go Away";
        int selectedItem = item.getItemId();
        if (selectedItem == R.id.appOptionsAbout) {
            Intent i = new Intent(Home.this, About.class);
            startActivity(i);
            return true;
        }
        return super.onContextItemSelected(item);

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("myStateLog", "Home-onResume");
        Toast.makeText(getApplicationContext(), "Resumed", Toast.LENGTH_SHORT).show();
        registerForContextMenu(press_me_button);
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
        contact_button = findViewById(R.id.contact_button);
        press_me_button = findViewById(R.id.press_me_button);
        calculator_button = findViewById(R.id.calculate_button);
        database_button = findViewById(R.id.user_details);
        sql_button = findViewById(R.id.user_details_database);
        map_button = findViewById(R.id.map_button);

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

        database_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, UserProfileMain.class);
                startActivity(i);

            }
        });

        sql_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, UserProfileServerMain.class);
                startActivity(i);

            }
        });
        map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, MapViewMain.class);
                startActivity(i);

            }
        });


//
        press_me_button.setOnClickListener(v -> {
            AlertUtil alert = new AlertUtil(this);
            alert.show(getSupportFragmentManager(), "alert");
        });

        calculator_button.setOnLongClickListener(v -> {
            LayoutInflater inflater = getLayoutInflater();
            View CalculatorView = inflater.inflate(R.layout.calculator, null);


            TextView result = CalculatorView.findViewById(R.id.addCalculatorResultValue);
            EditText num1 = CalculatorView.findViewById(R.id.addCalculatorFirstNumberInput);
            EditText num2 = CalculatorView.findViewById(R.id.addCalculatorSecondNumberInput);
            Button addBtn = CalculatorView.findViewById(R.id.addCalculatorCalculateButton);

            addBtn.setOnClickListener(v1 -> {
                String num1Text = num1.getText().toString();
                String num2Text = num2.getText().toString();

                if (num1Text.isEmpty() || num2Text.isEmpty()) {
                    result.setText("Please enter both numbers");
                } else {

                    int first = Integer.parseInt(num1Text);
                    int second = Integer.parseInt(num2Text);
                    int resultnum = first + second;
                    result.setText(String.valueOf(resultnum));
                }
            });
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(CalculatorView);
            builder.show();
            return true;
        });


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedGender = "unknown";

                Intent i = new Intent(Home.this, About.class);
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

