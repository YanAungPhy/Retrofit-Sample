package com.yap.retrofitsample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.yap.retrofitsample.retrofit.Model;
import com.yap.retrofitsample.retrofit.RetrofitApi;
import com.yap.retrofitsample.retrofit.RetrofitClient;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //github မှာ android studio နဲ့ project တင်နည်း  https://youtu.be/Tzfen6zKKQU

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataFromServer();
    }

    private void getDataFromServer() {
        RetrofitApi retrofitApi = RetrofitClient.getRetrofitInstance().create(RetrofitApi.class);
        Call<Model> call = retrofitApi.getData();

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {


                ArrayList<Model.data> data = response.body().getData();
                for (Model.data data1 : data) {
                    Log.d("CHECKRESPONSE", data1.getEmail());
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }
}