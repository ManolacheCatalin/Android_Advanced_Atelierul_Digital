package com.app.shopwithus;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

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
        manager = context.getSystemService(ConnectivityManager.class);
        Network net = manager.getActiveNetwork();
        NetworkCapabilities networkCapabilities = manager.getNetworkCapabilities(net);
        if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                && networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
            return true;
        else return false;
    }
}
