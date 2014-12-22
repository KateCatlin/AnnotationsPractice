package com.example.katecatlin.annotationspractice.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.katecatlin.annotationspractice.ApplicationProvider;

/**
 * Created by katecatlin on 12/22/14.
 */
public final class NetworkUtil {

    private NetworkUtil() { }

    public static boolean checkInternetConnection() {
        ConnectivityManager conMgr = (ConnectivityManager) ApplicationProvider.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();

        return i != null && i.isConnected() && i.isAvailable();
    }

}

