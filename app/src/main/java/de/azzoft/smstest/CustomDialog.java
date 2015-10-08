package de.azzoft.smstest;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.View;

public class CustomDialog extends AppCompatDialogFragment implements View.OnClickListener {

    DatePicker datePicker;

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle);
        View root = getActivity().getLayoutInflater().inflate(R.layout.dialog, null);

        root.findViewById(R.id.btn).setOnClickListener(this);
        datePicker = (DatePicker) root.findViewById(R.id.datePicker);

        builder.setView(root);
        return builder.create();
    }

    @Override
    public void onClick(View v) {
        datePicker.setVisibility(View.VISIBLE);
    }
}
