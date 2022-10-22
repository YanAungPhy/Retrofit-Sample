package com.yap.retrofitsample.Project2.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AappUtils {

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkState = connectivityManager.getActiveNetworkInfo();

        if (networkState != null && networkState.isConnected()) {
            return true;
        }
        return false;
    }
}
