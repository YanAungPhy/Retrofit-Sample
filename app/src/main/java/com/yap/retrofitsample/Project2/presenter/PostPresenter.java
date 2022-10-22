package com.yap.retrofitsample.Project2.presenter;

import com.yap.retrofitsample.Project2.object.Post;

import java.util.List;

public interface PostPresenter {
    void loadData();
    void displayPostToView(List<Post> posts);
    void displayErrorToView(String str);
    void displayLoadingShow();
    void displayLoadingDimiss();
}
