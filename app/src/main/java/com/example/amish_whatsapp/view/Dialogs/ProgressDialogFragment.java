package com.example.amish_whatsapp.view.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import androidx.fragment.app.DialogFragment;

import com.example.amish_whatsapp.R;

public class ProgressDialogFragment extends DialogFragment {

    private Activity activity;
    private AlertDialog dialog;

    public ProgressDialogFragment(Activity myActivity){
        activity = myActivity;
    }

    public void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_progress_dialog_layout, null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
    }

    public void dismissDialog(){
        dialog.dismiss();
    }
}
