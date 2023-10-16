package com.example.amish_whatsapp.view.Adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amish_whatsapp.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainViewHolder extends RecyclerView.ViewHolder {

    TextView itemName, quantity, delivered, notDelivered;
    ImageView itemImage;
    ProgressBar imageProgressBar;


    public MainViewHolder(@NonNull View itemView) {
        super(itemView);

        quantity=itemView.findViewById(R.id.item_quantity);
        itemName=itemView.findViewById(R.id.item_name);
        delivered=itemView.findViewById(R.id.delivered);
        notDelivered=itemView.findViewById(R.id.notDelivered);
        itemImage=itemView.findViewById(R.id.item_image);
        imageProgressBar=itemView.findViewById(R.id.imgProgressBar);
    }

    public void setDelivered(){
        // Get the Drawable from the resource ID
        Drawable drawable = itemView.getContext().getResources().getDrawable(R.drawable.selected_border);

        delivered.setBackground(drawable);
        delivered.setTextColor(itemView.getResources().getColor(R.color.sky_blue));
    }

    public void setNotDelivered(){
        // Get the Drawable from the resource ID
        Drawable drawable = itemView.getContext().getResources().getDrawable(R.drawable.selected_border);

        notDelivered.setBackground(drawable);
        notDelivered.setTextColor(itemView.getResources().getColor(R.color.sky_blue));
    }

    public void setItemImage(String imgUrl){
        showProgressBar();

        Picasso.get()
                .load(imgUrl)
                .error(R.drawable.error_img)
                .into(itemImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        hideProgressBar();
                    }

                    @Override
                    public void onError(Exception e) {
                        hideProgressBar();
                    }
                });
    }

    public void showProgressBar(){
        imageProgressBar.setVisibility(View.VISIBLE);
        itemImage.setVisibility(View.INVISIBLE);
    }

    public void hideProgressBar(){
        imageProgressBar.setVisibility(View.GONE);
        itemImage.setVisibility(View.VISIBLE);
    }
}
