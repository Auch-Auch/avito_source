package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Deprecated
public class qf {
    public static final Set<String> a = new HashSet(Arrays.asList("gps"));
    @NonNull
    private Context b;
    @Nullable
    private LocationManager c;
    @NonNull
    private so d;

    public qf(@NonNull Context context, @Nullable LocationManager locationManager, @NonNull so soVar) {
        this.b = context;
        this.c = locationManager;
        this.d = soVar;
    }

    @Nullable
    public Location a() {
        List<String> list;
        Location location;
        Location location2;
        if (this.c == null) {
            return null;
        }
        boolean a3 = this.d.a(this.b);
        boolean b2 = this.d.b(this.b);
        try {
            list = this.c.getAllProviders();
        } catch (Throwable unused) {
            list = null;
        }
        if (list == null) {
            return null;
        }
        Location location3 = null;
        for (String str : list) {
            if (!a.contains(str)) {
                if (a3) {
                    try {
                        if (!"passive".equals(str) || b2) {
                            location2 = this.c.getLastKnownLocation(str);
                            location = location2;
                            if (location != null && qr.a(location, location3, qr.c, 200)) {
                                location3 = location;
                            }
                        }
                    } catch (Throwable unused2) {
                        location = null;
                    }
                }
                location2 = null;
                location = location2;
                location3 = location;
            }
        }
        return location3;
    }
}
