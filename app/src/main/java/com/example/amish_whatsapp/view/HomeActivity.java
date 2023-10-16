package com.example.amish_whatsapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.amish_whatsapp.R;
import com.example.amish_whatsapp.databinding.ActivityHomeBinding;
import com.example.amish_whatsapp.view.Adapter.ViewPagerAdapter;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //root
        xml = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(xml.getRoot());
        write();

        ViewPager viewPager = findViewById(R.id.viewPager);



        ViewPagerAdapter adapter =  new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);



        xml.tabLayout.setupWithViewPager(viewPager);

    }

    private void write(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Set the "userLoggedIn" flag to true when the user logs in
        editor.putBoolean("userLoggedIn", true);

        // Apply the changes
        editor.apply();
    }
}