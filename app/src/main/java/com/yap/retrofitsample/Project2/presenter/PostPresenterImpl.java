package com.yap.retrofitsample.Project2.presenter;

import android.content.Context;
import android.util.Log;

import com.yap.retrofitsample.Project2.model.PostModel;
import com.yap.retrofitsample.Project2.object.Post;
import com.yap.retrofitsample.Project2.utils.AappUtils;
import com.yap.retrofitsample.Project2.view.PostView;

import java.util.List;

public class PostPresenterImpl implements PostPresenter {
    PostView pv;
    Context context;

    public PostPresenterImpl(PostView pv, Context context) {
        this.pv = pv;
        this.context = context;
    }

    @Override
    public void loadData() {
        Log.d("CHECKING", AappUtils.isOnline(context)+"");
        //first way
//        PostModel pm = PostModel.getIns();
//        pm.getData(this);
        //second way
        if (AappUtils.isOnline(context)) {
            pv.displayInternet();
            Log.d("InternetAccess","OK");
            Post post = new Post();
            post.getData(this);
        }else
        {
            Log.d("InternetAccess","No");
            pv.displayNoInternet();
        }

    }

    @Override
    public void displayPostToView(List<Post> posts) {
        pv.displayView(posts);

    }

    @Override
    public void displayErrorToView(String str) {
        pv.displayError(str);
    }

    @Override
    public void displayLoadingShow() {
        pv.loadingShow();
    }

    @Override
    public void displayLoadingDimiss() {
        pv.loadingDimiss();
    }

}
