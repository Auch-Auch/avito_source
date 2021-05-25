package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public final class hq {
    private static final Set<String> a = new HashSet(Collections.singletonList("gps"));
    private static final Set<String> b = new HashSet(Arrays.asList("gps", "passive"));
    @Nullable
    private final LocationManager c;
    @NonNull
    private final hh d;

    public hq(@NonNull Context context, @Nullable LocationManager locationManager) {
        this.c = locationManager;
        this.d = new hh(context);
    }

    @Nullable
    private Location b(@NonNull String str) {
        try {
            LocationManager locationManager = this.c;
            if (locationManager != null) {
                return locationManager.getLastKnownLocation(str);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public final Location a(@NonNull String str) {
        boolean a3 = this.d.a();
        boolean b2 = this.d.b();
        boolean z = true;
        boolean z2 = !a.contains(str);
        if (!b.contains(str) ? !z2 || !a3 : !z2 || !a3 || !b2) {
            z = false;
        }
        if (z) {
            return b(str);
        }
        return null;
    }
}
