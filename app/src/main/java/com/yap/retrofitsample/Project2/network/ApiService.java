package com.yap.retrofitsample.Project2.network;

import com.yap.retrofitsample.Project2.object.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("posts")
    Call<List<Post>> getAllData();
}
