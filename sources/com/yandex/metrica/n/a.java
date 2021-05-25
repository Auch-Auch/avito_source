package com.yandex.metrica.n;

import android.location.LocationListener;
import android.support.annotation.NonNull;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
public class a extends LocationCallback {
    @NonNull
    public final LocationListener a;

    public a(@NonNull LocationListener locationListener) {
        this.a = locationListener;
    }

    @Override // com.google.android.gms.location.LocationCallback
    public void onLocationResult(LocationResult locationResult) {
        String str = "onLocationResult: " + locationResult;
        this.a.onLocationChanged(locationResult.getLastLocation());
    }
}
