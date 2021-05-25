package com.yandex.runtime.sensors.internal;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.Runtime;
public class LocationSubscription implements LocationListener {
    private static final String LOG_TAG = LocationSubscription.class.getCanonicalName();
    public LocationManager manager;
    private float movementThreshold;
    public NativeObject nativeObject;
    private boolean useGpsProvider;

    public LocationSubscription(boolean z, float f, NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
        this.useGpsProvider = z;
        this.movementThreshold = f;
        LocationManager locationManager = (LocationManager) Runtime.getApplicationContext().getSystemService("location");
        this.manager = locationManager;
        if (locationManager != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yandex.runtime.sensors.internal.LocationSubscription.1
                @Override // java.lang.Runnable
                public void run() {
                    LocationSubscription.this.start();
                }
            });
            return;
        }
        throw new RuntimeException("Can't get LocationManager. Missed permission?");
    }

    public static boolean isElapsedRealtimeSupported() {
        return true;
    }

    public static native void locationChanged(NativeObject nativeObject2, Location location);

    public static long relativeTimeDelta(Location location) {
        if (!isElapsedRealtimeSupported() || location.getElapsedRealtimeNanos() <= 0) {
            return 0;
        }
        return SystemClock.elapsedRealtime() - (location.getElapsedRealtimeNanos() / 1000000);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void start() {
        if (!startProvider(this.useGpsProvider ? "gps" : "network")) {
            statusChanged(this.nativeObject, false);
        }
    }

    private boolean startProvider(String str) {
        try {
            this.manager.requestLocationUpdates(str, 0, this.movementThreshold, this);
            return true;
        } catch (IllegalArgumentException | RuntimeException | SecurityException unused) {
            return false;
        }
    }

    public static native void statusChanged(NativeObject nativeObject2, boolean z);

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        locationChanged(this.nativeObject, location);
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        statusChanged(this.nativeObject, false);
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        statusChanged(this.nativeObject, i == 2);
    }

    public void stop() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yandex.runtime.sensors.internal.LocationSubscription.2
            @Override // java.lang.Runnable
            public void run() {
                LocationSubscription locationSubscription = LocationSubscription.this;
                locationSubscription.manager.removeUpdates(locationSubscription);
            }
        });
    }
}
