package com.example.amish_whatsapp.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.amish_whatsapp.R;
import com.example.amish_whatsapp.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //root
        xml = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(xml.getRoot());

        // Fade-in animation
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeInAnimation.setDuration(800);

        fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                read();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        xml.splashLayout.startAnimation(fadeInAnimation);

    }

    private void read(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        // Get the "userLoggedIn" flag; default to false if it's not set
        boolean userLoggedIn = sharedPreferences.getBoolean("userLoggedIn", false);

        if (userLoggedIn) {
            // The user is logged in
            // You can perform actions accordingly
            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            // The user is not logged in
            // Perform actions for a non-logged-in user
            Intent intent = new Intent(SplashActivity.this, LanguageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }
}