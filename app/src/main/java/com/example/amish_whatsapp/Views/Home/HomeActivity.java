package com.example.amish_whatsapp.Views.Home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.amish_whatsapp.R;
import com.example.amish_whatsapp.Views.Auth.WelcomeActivity;
import com.example.amish_whatsapp.Views.Home.Adapter.ViewPagerAdapter;
import com.example.amish_whatsapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ActivityHomeBinding xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //root
        xml = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(xml.getRoot());
        write(true);

        ViewPager viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter =  new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //moreOptionBtn
        xml.moreOptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
            }
        });

        xml.tabLayout.setupWithViewPager(viewPager);

    }

    private void write(boolean bool){
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Set the "userLoggedIn" flag to true when the user logs in
        editor.putBoolean("userLoggedIn", bool);

        // Apply the changes
        editor.apply();
    }

    private void showPopup(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.overflow_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.option_1){
            write(false);

            Intent intent = new Intent(HomeActivity.this, WelcomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

            return true;
        }

        return false;
    }
}