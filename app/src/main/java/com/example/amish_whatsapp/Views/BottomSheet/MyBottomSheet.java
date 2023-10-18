package com.example.amish_whatsapp.Views.BottomSheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.amish_whatsapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MyBottomSheet extends BottomSheetDialogFragment {

    public static final String TAG = "MyBottomSheet";
    private TextView count;
    private String countText;

    public MyBottomSheet() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        //casting views
        count=view.findViewById(R.id.countText);
        count.setText(countText);

        return view;
    }

    public void setCount(String str){
        countText = str;
    }

}
