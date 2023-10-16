package com.example.amish_whatsapp.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.amish_whatsapp.databinding.ActivityCountryCodeBinding;

public class CountryCodeActivity extends AppCompatActivity {

    private ActivityCountryCodeBinding xml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //root
        xml = ActivityCountryCodeBinding.inflate(getLayoutInflater());
        setContentView(xml.getRoot());

        xml.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}