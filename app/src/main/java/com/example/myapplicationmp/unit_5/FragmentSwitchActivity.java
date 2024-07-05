package com.example.myapplicationmp.unit_5;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplicationmp.R;

public class FragmentSwitchActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_5_segmemt_switch);

        FragmentManager fm = getSupportFragmentManager();
        int fragmentContainerId = R.id.bottomFragment;
        Button fragmentOneButton = findViewById(R.id.fragmentImageSwitch1);
        Button fragmentTwoButton = findViewById(R.id.fragmentImageSwitch2);
        Button fragmentXButton = findViewById(R.id.fragmentImageSwitchx);

        fragmentOneButton.setOnClickListener(v -> {
            Fragment coffeeFragment = new CoffeeFragment();

            FragmentTransaction ft = fm.beginTransaction();
            ft.add(fragmentContainerId, coffeeFragment);
            ft.addToBackStack(null);
            ft.commit();
        });

        fragmentTwoButton.setOnClickListener(v -> {
            Fragment notfound = new PageNotFoundFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(fragmentContainerId, notfound);
            ft.addToBackStack(null);
            ft.commit();
        });
        fragmentXButton.setOnClickListener(v -> {
            fm.popBackStack();
        });
    }
}
