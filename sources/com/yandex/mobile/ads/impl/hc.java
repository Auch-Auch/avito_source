package com.yandex.mobile.ads.impl;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.TimeUnit;
public final class hc {
    private static final long a = TimeUnit.MINUTES.toMillis(2);

    public static boolean a(@NonNull Location location, @Nullable Location location2) {
        boolean z;
        if (location2 != null) {
            long time = location.getTime() - location2.getTime();
            long j = a;
            boolean z2 = time > j;
            boolean z3 = time < (-j);
            boolean z4 = time > 0;
            int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
            boolean z5 = accuracy > 0;
            boolean z7 = accuracy < 0;
            boolean z8 = ((long) accuracy) > 200;
            String provider = location.getProvider();
            String provider2 = location2.getProvider();
            if (provider == null) {
                z = provider2 == null;
            } else {
                z = provider.equals(provider2);
            }
            if (!(z2 || (!z3 && (z7 || ((z4 && !z5) || (z4 && !z8 && z)))))) {
                return false;
            }
        }
        return true;
    }
}
