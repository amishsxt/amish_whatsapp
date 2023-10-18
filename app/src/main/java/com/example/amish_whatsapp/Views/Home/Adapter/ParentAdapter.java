package com.example.amish_whatsapp.Views.Home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amish_whatsapp.Model.DataModel.GroupData;
import com.example.amish_whatsapp.R;
import com.example.amish_whatsapp.Views.BottomSheet.MyBottomSheet;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentViewHolder> implements MainAdapter.SelectAllButton {

    private Context context;
    private List<GroupData> arrayList;
    private MyBottomSheetListener listener;
   //private int totalDelivered=0;

    public ParentAdapter(Context context, List<GroupData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        listener = (MyBottomSheetListener) context;
    }


    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ParentViewHolder(LayoutInflater.from(context).inflate(R.layout.parent_data_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {

        holder.groupName.setText(arrayList.get(position).getGroup_name());

        ChildAdapter childAdapter = new ChildAdapter(context, arrayList.get(position).getGroup_data());
        holder.recyclerView.setAdapter(childAdapter);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));

        holder.groupCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.groupClicked();
            }
        });

        holder.selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.clickedCount == 0){
                    selectAll(holder);
                    holder.clickedOnce();
                }
                else{
                    int totalDelivered = 0;
                    for(int i=0; i<arrayList.get(position).getGroup_data().size(); i++){
                        totalDelivered+=arrayList.get(position).getGroup_data().get(i).getOrder_detail().size();
                    }
                    listener.showBottomSheet(totalDelivered);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    private void selectAll(ParentViewHolder holder){
        for (int i=0; i<holder.recyclerView.getAdapter().getItemCount(); i++){
            RecyclerView.ViewHolder viewHolder = holder.recyclerView.findViewHolderForAdapterPosition(i);

            if(viewHolder instanceof ChildViewHolder){
                RecyclerView recyclerView2 = viewHolder.itemView.findViewById(R.id.childRecyclerView);

                //Iterate through every item
                for(int j=0; j<recyclerView2.getAdapter().getItemCount(); j++){
                    RecyclerView.ViewHolder viewHolder2 = recyclerView2.findViewHolderForAdapterPosition(j);

                    if (viewHolder2 instanceof MainViewHolder){
                        ((MainViewHolder) viewHolder2).setDelivered();
                    }
                }
            }
        }

    }

    @Override
    public void firstState() {

    }

    @Override
    public void secondState() {

    }

    public interface MyBottomSheetListener{
        public void showBottomSheet(int count);
    }
}
