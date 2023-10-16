package com.example.amish_whatsapp.view.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.amish_whatsapp.R;
import com.example.amish_whatsapp.databinding.FragmentChatsBinding;
import com.example.amish_whatsapp.model.DataModel.Data;
import com.example.amish_whatsapp.model.DataModel.GroupData;
import com.example.amish_whatsapp.model.Interface.ApiService;
import com.example.amish_whatsapp.view.Adapter.ParentAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatsFragment extends Fragment {

    private FragmentChatsBinding xml;
    private ApiService apiService;
    private Data data;
    private ArrayList<GroupData> arrayList = new ArrayList<>();
    private ParentAdapter parentAdapter;

    public ChatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        xml = FragmentChatsBinding.inflate(getLayoutInflater());
        //View view = inflater.inflate(R.layout.fragment_chats, container, false);

        fetchData();

        return xml.getRoot();
    }

    private void fetchData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://png.boru.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

        Call<Data> call = apiService.fetchData();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful()) {
                    data = response.body();
                    setAdapter(data.getData());
                    // Process the data here
                } else {
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                // Handle network failure

            }
        });

    }

    private void setAdapter(List<GroupData> aar){
        parentAdapter = new ParentAdapter(getContext(), aar);
        xml.parentRecyclerview.setAdapter(parentAdapter);
        xml.parentRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
}