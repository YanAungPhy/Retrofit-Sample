package com.yap.retrofitsample.Project2.view;

import com.yap.retrofitsample.Project2.object.Post;

import java.util.List;

public interface PostView {
    void displayView(List<Post> posts);
    void displayError(String str);
    void loadingShow();
    void loadingDimiss();
    void displayInternet();
    void displayNoInternet();
}
