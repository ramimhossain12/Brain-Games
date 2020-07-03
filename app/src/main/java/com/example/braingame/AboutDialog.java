package com.example.braingame;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Dialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
public class  AboutDialog extends DialogFragment {
    public interface DialogListener {

    }

    DialogListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (DialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + "must implement DialogListener");
        }
    }

    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.about_title);
        builder.setMessage(R.string.about_text);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int j) {

            }
        });

        return builder.create();
    }
}