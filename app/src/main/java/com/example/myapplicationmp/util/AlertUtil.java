package com.example.myapplicationmp.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AlertUtil extends DialogFragment {
    private final Context context;

    public AlertUtil(Context ctx) {
        this.context = ctx;
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle b) {
        String noText = "No";
        String yesText = "Yes";
        String positive = "OK";
        String negative = "Cancel";
        String title = "Alert";
        String closeMessage = "Are you sure you want to close?";
        String message = "This is an Alert to get your attention.";
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton(positive, (dialog, which) -> {
            dialog.dismiss();
            Toast.makeText(context, "You clicked yes", Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton(negative, (dialog, which) -> {
            dialog.dismiss();
            Toast.makeText(getContext(), "You clicked no", Toast.LENGTH_SHORT);
        });
        setCancelable(false);
        return builder.create();
    }
}
