package com.example.amish_whatsapp.Views.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.amish_whatsapp.databinding.ActivityLanguageBinding;

public class LanguageActivity extends AppCompatActivity {

    private ActivityLanguageBinding xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //root
        xml=ActivityLanguageBinding.inflate(getLayoutInflater());
        setContentView(xml.getRoot());

        xml.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LanguageActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });
    }
}