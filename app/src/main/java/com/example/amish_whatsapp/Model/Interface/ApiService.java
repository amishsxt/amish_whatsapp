package com.example.amish_whatsapp.Model.Interface;

import com.example.amish_whatsapp.Model.DataModel.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("TestingAdminPanel/api/testing-1")
    Call<Data> fetchData();
}

