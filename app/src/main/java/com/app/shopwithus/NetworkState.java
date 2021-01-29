package com.app.shopwithus;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;

public class NetworkState {

    private static NetworkState instance;
    private static ConnectivityManager manager;

    public NetworkState() {

    }

    public static NetworkState getInstance() {
        if (instance == null) {
            instance = new NetworkState();
        }
        return instance;
    }

    public static boolean hasNetworkAccess(Context context) {
        boolean flag=false;
        manager = context.getSystemService(ConnectivityManager.class);
        Network net = manager.getActiveNetwork();
        NetworkCapabilities networkCapabilities = manager.getNetworkCapabilities(net);
        try {
            if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                    && networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
                flag=true;
        }catch (NullPointerException e){
            Log.e("DEBUG","Something went wrong!");
        }
        return flag;
    }
}
