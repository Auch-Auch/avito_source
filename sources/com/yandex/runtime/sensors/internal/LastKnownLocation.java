package com.yandex.runtime.sensors.internal;

import android.location.Location;
import android.location.LocationManager;
import com.yandex.runtime.Runtime;
public class LastKnownLocation {
    private static final String TAG = "com.yandex.runtime.sensors.internal.LastKnownLocation";

    public static Location getLastKnownLocation() {
        LocationManager locationManager = (LocationManager) Runtime.getApplicationContext().getSystemService("location");
        if (locationManager != null) {
            try {
                Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                if (lastKnownLocation != null) {
                    return lastKnownLocation;
                }
                return locationManager.getLastKnownLocation("network");
            } catch (SecurityException e) {
                e.toString();
                return null;
            }
        } else {
            throw new RuntimeException("Can't get LocationManager. Missed permission?");
        }
    }
}
