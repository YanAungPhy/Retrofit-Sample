package com.yap.retrofitsample.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

// ဘယ်လိုရှာရမလဲ sample api for testing
// https://reqres.in/မှာ sample api တေရှိတယ်

public interface RetrofitApi {
    @GET("api/users?page=2")
    Call<Model> getData();

}
