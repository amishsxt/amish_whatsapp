package com.example.amish_whatsapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.example.amish_whatsapp.R;
import com.example.amish_whatsapp.databinding.ActivityOtpBinding;

import java.util.Timer;

public class OtpActivity extends AppCompatActivity {

    private ActivityOtpBinding xml;
    private String phoneNumber;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //root
        xml = ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(xml.getRoot());

        //init
        phoneNumber = getIntent().getStringExtra("phoneNumber");
        xml.number.setText("+91 "+phoneNumber);
        resendTimer();

        //checkOtp
        xml.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(xml.numberText.getText().toString().length() == 6){
                    Intent intent = new Intent(OtpActivity.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });

    }

    private void resendTimer(){

        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // This method is called on each tick of the countdown
                // You can update a TextView or perform other actions here
                xml.resendTime.setClickable(false);
                xml.resendTime.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                // This method is called when the countdown timer finishes
                // Implement what you want to do when the timer finishes here
            }
        };

        // Start the countdown timer
        timer.start();

    }
}