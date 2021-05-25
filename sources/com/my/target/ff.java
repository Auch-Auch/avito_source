package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
public class ff extends fb {
    @Override // com.my.target.fb
    @SuppressLint({"MissingPermission"})
    @WorkerThread
    public synchronized void collectData(@NonNull Context context) {
        removeAll();
        NetworkInfo networkInfo = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo != null) {
                addParam("connection", networkInfo.getTypeName());
                String str = "";
                if (networkInfo.getType() == 0) {
                    if (networkInfo.getSubtypeName() != null) {
                        str = networkInfo.getSubtypeName();
                    }
                } else if (networkInfo.getTypeName() != null) {
                    str = networkInfo.getTypeName();
                }
                addParam("connection_type", str);
            }
        } catch (Throwable unused) {
            ae.a("No permissions for access to network state");
        }
    }
}
