package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class rn extends qx {
    @Nullable
    private final LocationManager f;
    @NonNull
    private final String g;

    public rn(@NonNull Context context, @NonNull Looper looper, @Nullable LocationManager locationManager, @NonNull rj rjVar, @NonNull sp spVar, @NonNull String str) {
        this(context, looper, locationManager, spVar, str, new qt(rjVar));
    }

    @Override // com.yandex.metrica.impl.ob.qx
    public void b() {
        LocationManager locationManager = this.f;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this.d);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.qx
    @SuppressLint({"MissingPermission"})
    public void c() {
        if (this.c.a(this.b)) {
            AnonymousClass1 r0 = new aca<LocationManager, Location>() { // from class: com.yandex.metrica.impl.ob.rn.1
                public Location a(LocationManager locationManager) throws Throwable {
                    return locationManager.getLastKnownLocation(rn.this.g);
                }
            };
            LocationManager locationManager = this.f;
            StringBuilder L = a.L("getting last known location for provider ");
            L.append(this.g);
            this.d.onLocationChanged((Location) dl.a(r0, locationManager, L.toString(), "location manager"));
        }
    }

    @VisibleForTesting
    public rn(@NonNull Context context, @NonNull Looper looper, @Nullable LocationManager locationManager, @NonNull sp spVar, @NonNull String str, @NonNull LocationListener locationListener) {
        super(context, locationListener, spVar, looper);
        this.f = locationManager;
        this.g = str;
    }

    @Override // com.yandex.metrica.impl.ob.qx
    public boolean a() {
        if (this.c.a(this.b)) {
            return a(this.g, 0.0f, qx.a, this.d, this.e);
        }
        return false;
    }

    private boolean a(String str, float f2, long j, @NonNull LocationListener locationListener, @NonNull Looper looper) {
        LocationManager locationManager = this.f;
        if (locationManager == null) {
            return false;
        }
        try {
            locationManager.requestLocationUpdates(str, j, f2, locationListener, looper);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
