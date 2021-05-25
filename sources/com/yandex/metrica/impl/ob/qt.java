package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class qt implements LocationListener {
    @NonNull
    private final rj a;

    public qt(@NonNull rj rjVar) {
        this.a = rjVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(@Nullable Location location) {
        if (location != null) {
            this.a.a(location);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
