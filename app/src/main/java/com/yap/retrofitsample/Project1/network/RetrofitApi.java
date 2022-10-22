package com.yap.retrofitsample.Project1.network;

import com.yap.retrofitsample.Project1.model.Model;

import retrofit2.Call;
import retrofit2.http.GET;

// ဘယ်လိုရှာရမလဲ sample api for testing
// https://reqres.in/မှာ sample api တေရှိတယ်

public interface RetrofitApi {
    @GET("api/users?page=2")
    Call<Model> getData();

}
