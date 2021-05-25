package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
public class l {
    @Nullable
    private final LocationManager a;

    public l(@NonNull Context context) {
        this((LocationManager) context.getSystemService("location"));
    }

    @NonNull
    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        LocationManager locationManager = this.a;
        return locationManager != null ? locationManager.getProviders(true) : arrayList;
    }

    @VisibleForTesting
    public l(@Nullable LocationManager locationManager) {
        this.a = locationManager;
    }
}
