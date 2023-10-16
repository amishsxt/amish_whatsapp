package com.example.amish_whatsapp.model.Interface;

import com.example.amish_whatsapp.model.DataModel.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("TestingAdminPanel/api/testing-1")
    Call<Data> fetchData();
}

