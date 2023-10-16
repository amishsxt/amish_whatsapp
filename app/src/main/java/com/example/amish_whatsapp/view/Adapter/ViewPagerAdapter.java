package com.example.amish_whatsapp.view.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.amish_whatsapp.view.tabs.CallsFragment;
import com.example.amish_whatsapp.view.tabs.ChatsFragment;
import com.example.amish_whatsapp.view.tabs.UpdatesFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ChatsFragment();
        } else if (position == 1) {
            return new UpdatesFragment();
        } else {
            return new CallsFragment();
        }
    }

        @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Chats";
        }
        else if (position==1) {
            return "Updates";
        }
        else{
            return "Calls";
        }
    }
}
