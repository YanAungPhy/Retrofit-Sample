package com.yap.retrofitsample.Project2.model;

import android.util.Log;

import com.yap.retrofitsample.Project2.network.ApiService;
import com.yap.retrofitsample.Project2.object.Post;
import com.yap.retrofitsample.Project2.presenter.PostPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostModel {
    private static PostModel Ins;
    ApiService apiService;

    public static PostModel getIns() {
        if (Ins == null) {
            Ins = new PostModel();
        }
        return Ins;
    }

    private PostModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public void getData(PostPresenter postPresenter) {
        apiService.getAllData().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {

                    List<Post> post = response.body();
//                    String[] mPost = new String[post.size()];
//
//                    for (int i = 0; i < mPost.size(); i++) {
//                        mPost[i] = oneHeroes.get(i).getName();
//                    }

                    Log.d("Entering",post.get(0).getTitle());
                    postPresenter.displayPostToView(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                postPresenter.displayErrorToView(t.getMessage());
            }
        });
    }
}
