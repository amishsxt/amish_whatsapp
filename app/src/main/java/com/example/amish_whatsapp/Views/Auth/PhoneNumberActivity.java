package com.example.amish_whatsapp.Views.Auth;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.amish_whatsapp.R;
import com.example.amish_whatsapp.Views.Dialogs.ProgressDialogFragment;
import com.example.amish_whatsapp.databinding.ActivityPhoneNumberBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class PhoneNumberActivity extends AppCompatActivity {

    private ActivityPhoneNumberBinding xml;
    private MaterialAlertDialogBuilder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //root
        xml = ActivityPhoneNumberBinding.inflate(getLayoutInflater());
        setContentView(xml.getRoot());

        //init builder
        dialog = new MaterialAlertDialogBuilder(this, R.style.ThemeOverlay_App_MaterialAlertDialog);


        xml.countryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhoneNumberActivity.this, CountryCodeActivity.class);
                startActivity(intent);
            }
        });

        //nextLogic
        xml.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pText = xml.numberText.getText().toString();

                if(pText.isBlank() || pText.isEmpty()){
                    showDialogBox("Please enter your phone number.");
                }
                else if(pText.length() < 10){
                    showDialogBox("The phone number you entered is too short for the country: India.\n\n" +
                            "Include your area code if you haven't.");
                }
                else if (pText.length() > 10){
                    showDialogBox("The phone number you entered is too long for the country: India.");
                }
                else{
                    //valid
                    showProgressDialog(pText);
                }
            }
        });
    }

    private void showDialogBox(String message){
        //Showing Error Message
        dialog.setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();

    }

    private void showDialogBox2(String phoneNumber){
        //Showing Error Message
        dialog.setMessage("You entered the phone number:\n\n+91 "+
                        phoneNumber+
                        "\n\nIs this OK, or would you like to edit the number?")
                .setNeutralButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        navigateToNext(phoneNumber);
                    }
                })
                .show();

    }

    private void navigateToNext(String phoneNumber){
        Intent intent = new Intent(PhoneNumberActivity.this, OtpActivity.class);
        intent.putExtra("phoneNumber", phoneNumber);
        startActivity(intent);
    }


    private void showProgressDialog(String str){
        final ProgressDialogFragment progressDialog = new ProgressDialogFragment(this);
        progressDialog.startLoadingDialog();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismissDialog();
                showDialogBox2(str);
            }
        },500);
    }

    private void hideProgressDialog(){
        ProgressDialogFragment progressDialog = (ProgressDialogFragment) getSupportFragmentManager().findFragmentByTag("progress_dialog_tag");
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}