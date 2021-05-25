package com.yandex.mobile.ads.impl;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;
public final class hg {
    @NonNull
    private final hc a = new hc();

    @Nullable
    public static Location a(@NonNull List<Location> list) {
        Location location = null;
        for (Location location2 : list) {
            if (hc.a(location2, location)) {
                location = location2;
            }
        }
        return location;
    }
}
