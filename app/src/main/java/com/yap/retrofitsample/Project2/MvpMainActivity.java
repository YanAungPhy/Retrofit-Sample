package com.yap.retrofitsample.Project2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yap.retrofitsample.Project2.adapter.PostAdapter;
import com.yap.retrofitsample.Project2.object.Post;
import com.yap.retrofitsample.Project2.presenter.PostPresenter;
import com.yap.retrofitsample.Project2.presenter.PostPresenterImpl;
import com.yap.retrofitsample.Project2.utils.AappUtils;
import com.yap.retrofitsample.Project2.view.PostView;
import com.yap.retrofitsample.R;

import java.util.List;

public class MvpMainActivity extends AppCompatActivity implements PostView {

    Button btnRetry;
    ProgressDialog progressDialog;
    LinearLayout checkInternetState;
    RecyclerView recyclerView;
    PostPresenter postPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_main);
        getSupportActionBar().hide();

        btnRetry = findViewById(R.id.btnRetry);
        recyclerView = findViewById(R.id.recyclerView);
        checkInternetState = findViewById(R.id.noInternet);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading.....");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postPresenter = new PostPresenterImpl(this, getApplicationContext());
        postPresenter.loadData();

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(AappUtils.isOnline(getApplicationContext())){
                    postPresenter.loadData();
                }else {
                    Toast.makeText(getApplicationContext(),"Please check your internet connection!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public void displayView(List<Post> posts) {
        PostAdapter adapter = new PostAdapter(MvpMainActivity.this, posts);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void displayError(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadingShow() {
        Log.d("DATACHECK", "Dialog is showing");
        progressDialog.show();
    }

    @Override
    public void loadingDimiss() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void displayInternet() {
        recyclerView.setVisibility(View.VISIBLE);
        checkInternetState.setVisibility(View.GONE);

    }

    @Override
    public void displayNoInternet() {
        checkInternetState.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }
}