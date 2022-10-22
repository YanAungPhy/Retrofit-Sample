package com.yap.retrofitsample.Project2.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yap.retrofitsample.Project2.network.ApiService;
import com.yap.retrofitsample.Project2.network.RetrofitClientOne;
import com.yap.retrofitsample.Project2.presenter.PostPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Post {

    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    // fetch data from server url
    public void getData(final PostPresenter postPresenter) {
        postPresenter.displayLoadingShow();
        ApiService apiService = RetrofitClientOne.getRetrofitInstance().create(ApiService.class);
        Call<List<Post>> call = apiService.getAllData();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                postPresenter.displayLoadingDimiss();
                if(response.isSuccessful()){
                    postPresenter.displayPostToView(response.body());
                }


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                postPresenter.displayErrorToView(t.getMessage());
                postPresenter.displayLoadingDimiss();
            }
        });
    }

}