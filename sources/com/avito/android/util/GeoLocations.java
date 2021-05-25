package com.avito.android.util;

import android.location.Location;
import androidx.annotation.Nullable;
import java.util.Locale;
public final class GeoLocations {
    public static final float LATITUDE_MIN_VALUE = -90.0f;
    public static final float LONGITUDE_MIN_VALUE = -180.0f;

    public static boolean equals(Location location, Location location2) {
        if (location == null) {
            return location2 == null;
        }
        if (location.getTime() == location2.getTime() && Float.compare(location.getAccuracy(), location2.getAccuracy()) == 0 && Double.compare(location.getLatitude(), location2.getLatitude()) == 0 && Double.compare(location.getLongitude(), location2.getLongitude()) == 0) {
            return true;
        }
        return false;
    }

    public static boolean fromSameProvider(@Nullable Location location, @Nullable Location location2) {
        String str = null;
        String provider = location == null ? null : location.getProvider();
        if (location2 != null) {
            str = location2.getProvider();
        }
        if (provider == null) {
            return str == null;
        }
        return provider.equals(str);
    }

    public static String print(@Nullable Location location) {
        if (location == null) {
            return "{}";
        }
        return String.format(Locale.ENGLISH, "%s provider [%.6f:%.6f] %.2f m; time=%d", location.getProvider(), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Float.valueOf(location.getAccuracy()), Long.valueOf(location.getTime()));
    }
}
