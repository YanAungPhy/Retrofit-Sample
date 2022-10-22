package com.yap.retrofitsample.Project1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.yap.retrofitsample.Project1.model.Model;
import com.yap.retrofitsample.Project1.network.RetrofitApi;
import com.yap.retrofitsample.Project1.network.RetrofitClient;
import com.yap.retrofitsample.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //github မှာ android studio နဲ့ project တင်နည်း  https://youtu.be/Tzfen6zKKQU
    //github မှာ android studio နဲ့ file update commit လုပ်နည်း  https://youtu.be/1RpW5DPzALg

    //jsonview chrome extension
    //jsonplaceholder မှာ free api တေယူစမ်းရတယ်  OR sample api for testing ဆိုရိုက်ပြီးရှာလို့ရတယ်

    //server က json formatကို android model classဖြစ်တဲ့ pojoကိုပြောင်းချင်ရင် ဒီ siteမှာ ဝင်ပြောင်းပါ  **https://www.jsonschema2pojo.org/**

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

                Integer data = response.body().getPage();
                Log.d("CHECKRESPONSE", data + "");
//                for (Datum data1 : data) {
//                    Log.d("CHECKRESPONSE", data1.getEmail());
//                    Log.d("CHECKRESPONSE",data1.getAvatar());
//                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }
}