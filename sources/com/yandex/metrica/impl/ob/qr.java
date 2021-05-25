package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class qr extends at<Location> {
    public static final long c = TimeUnit.MINUTES.toMillis(2);
    public static final long d = TimeUnit.SECONDS.toMillis(10);
    public static final List<String> e = Arrays.asList("gps", "network");
    @NonNull
    private a f;

    public static class a {
        public final long a;
        public final long b;
        public final long c;

        public a(long j, long j2, long j3) {
            this.a = j;
            this.b = j2;
            this.c = j3;
        }
    }

    public qr() {
        this(new a(c, 200, 50), d);
    }

    /* renamed from: a */
    public boolean b(@NonNull Location location) {
        return e.contains(location.getProvider()) && (this.a.b() || this.a.a(this.b) || a(location, this.a.a()));
    }

    @VisibleForTesting
    public qr(@NonNull a aVar, long j) {
        super(j);
        this.f = aVar;
    }

    private boolean a(@Nullable Location location, @Nullable Location location2) {
        a aVar = this.f;
        return a(location, location2, aVar.a, aVar.b);
    }

    public static boolean a(@Nullable Location location, @Nullable Location location2, long j, long j2) {
        if (location2 == null) {
            return true;
        }
        if (location == null) {
            return false;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > j;
        boolean z2 = time < (-j);
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z7 = ((long) accuracy) > j2;
        boolean a3 = a(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z7 && a3;
        }
        return true;
    }

    public static boolean a(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }
}
