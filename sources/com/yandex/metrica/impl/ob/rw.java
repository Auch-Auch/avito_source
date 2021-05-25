package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.uu;
import java.util.concurrent.TimeUnit;
public class rw {
    @NonNull
    public uu.b.C0342b a(@NonNull rb rbVar) {
        uu.b.C0342b bVar = new uu.b.C0342b();
        Location c = rbVar.c();
        bVar.b = rbVar.a() == null ? bVar.b : rbVar.a().longValue();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        bVar.d = timeUnit.toSeconds(c.getTime());
        bVar.l = ci.a(rbVar.a);
        bVar.c = timeUnit.toSeconds(rbVar.b());
        bVar.m = timeUnit.toSeconds(rbVar.d());
        bVar.e = c.getLatitude();
        bVar.f = c.getLongitude();
        bVar.g = Math.round(c.getAccuracy());
        bVar.h = Math.round(c.getBearing());
        bVar.i = Math.round(c.getSpeed());
        bVar.j = (int) Math.round(c.getAltitude());
        bVar.k = a(c.getProvider());
        bVar.n = ci.a(rbVar.e());
        return bVar;
    }

    private static int a(@NonNull String str) {
        if ("gps".equals(str)) {
            return 1;
        }
        if ("network".equals(str)) {
            return 2;
        }
        return "fused".equals(str) ? 3 : 0;
    }
}
