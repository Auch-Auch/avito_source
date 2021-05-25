package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
public final class hp implements he {
    @NonNull
    private final hg a = new hg();
    @NonNull
    private final hq b;
    @Nullable
    private final LocationManager c;

    public hp(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        LocationManager locationManager = (LocationManager) applicationContext.getSystemService("location");
        this.c = locationManager;
        this.b = new hq(applicationContext, locationManager);
    }

    @Nullable
    private List<String> b() {
        try {
            LocationManager locationManager = this.c;
            if (locationManager != null) {
                return locationManager.getAllProviders();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.he
    @Nullable
    public final Location a() {
        List<String> b2 = b();
        if (b2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : b2) {
            Location a3 = this.b.a(str);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return hg.a(arrayList);
    }
}
