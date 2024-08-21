package com.example.myapplicationmp.unit_7;

import android.database.Cursor;
import android.os.Bundle;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationmp.R;
import com.example.myapplicationmp.unit_1.UserInfo;

import java.util.ArrayList;


public class UserProfileMain extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();

        ActionBar bar = getSupportActionBar();
        if (bar != null) bar.hide();
    }

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_7_user_profile);

        Button selectButton = findViewById(R.id.userProfileSelectButton);
        Button insertButton = findViewById(R.id.userProfileInsertButton);
        Button updateButton = findViewById(R.id.userProfileUpdateButton);
        Button deleteButton = findViewById(R.id.userProfileDeleteButton);
        ListView mainList = findViewById(R.id.userProfileListMain);


        EditText idInput = findViewById(R.id.userProfileIdInput);
        EditText nameInput = findViewById(R.id.userProfileNameInput);
        EditText addressInput = findViewById(R.id.userProfileAddressInput);

        try (MyDatabase myDatabase = new MyDatabase(this)) {
            insertButton.setOnClickListener(v -> {
                String name = nameInput.getText().toString();
                String address = addressInput.getText().toString();
                int id = Integer.parseInt(idInput.getText().toString());

                UserInfo data = new UserInfo(id, name, address);
                myDatabase.insertData(data);
                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
            });

            selectButton.setOnClickListener(v -> {
                ArrayList<UserInfo> userInfo = new ArrayList<UserInfo>();

                Cursor cursor = myDatabase.selectData();
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String address = cursor.getString(2);
                    userInfo.add(new UserInfo(id, name, address));
                }

                UserListItemAdapter adapter = new UserListItemAdapter(UserProfileMain.this, userInfo);
                mainList.setAdapter(adapter);
            });
        }

        Resources res = getResources();
    }

}
