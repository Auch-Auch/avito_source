package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.j;
import java.util.LinkedHashMap;
import java.util.Map;
public class ae implements bm {
    private Location a;
    private Boolean b;
    private Boolean c;
    private Boolean d;
    private Map<String, String> e = new LinkedHashMap();
    private Map<String, String> f = new LinkedHashMap();
    private boolean g;
    private boolean h;
    private cs i;

    private static boolean a(Object obj) {
        return obj == null;
    }

    private void e() {
        this.a = null;
        this.b = null;
        this.d = null;
        this.e.clear();
        this.f.clear();
        this.g = false;
    }

    private void f() {
        cs csVar = this.i;
        if (csVar != null) {
            csVar.a(this.b, this.d, this.c);
        }
    }

    public Location a() {
        return this.a;
    }

    public Boolean b() {
        return this.b;
    }

    public Boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.g;
    }

    @Override // com.yandex.metrica.impl.ob.bm
    public void setStatisticsSending(boolean z) {
        this.d = Boolean.valueOf(z);
        f();
    }

    @Override // com.yandex.metrica.impl.ob.bm
    public void a(boolean z) {
        this.b = Boolean.valueOf(z);
        f();
    }

    @Override // com.yandex.metrica.impl.ob.bm
    public void b(boolean z) {
        this.c = Boolean.valueOf(z);
        f();
    }

    private j.a b(j jVar) {
        j.a a3 = j.a(jVar.apiKey);
        a3.a(jVar.b, jVar.j);
        a3.c(jVar.a);
        a3.a(jVar.preloadInfo);
        a3.a(jVar.location);
        a3.a(jVar.m);
        a(a3, jVar);
        a(this.e, a3);
        a(jVar.i, a3);
        b(this.f, a3);
        b(jVar.h, a3);
        return a3;
    }

    @Override // com.yandex.metrica.impl.ob.bm
    public void a(Location location) {
        this.a = location;
    }

    public j a(j jVar) {
        if (this.h) {
            return jVar;
        }
        j.a b2 = b(jVar);
        a(jVar, b2);
        this.h = true;
        e();
        return b2.b();
    }

    private void a(@NonNull j.a aVar, @NonNull j jVar) {
        if (dl.a((Object) jVar.d)) {
            aVar.a(jVar.d);
        }
        if (dl.a((Object) jVar.appVersion)) {
            aVar.a(jVar.appVersion);
        }
        if (dl.a(jVar.f)) {
            aVar.d(jVar.f.intValue());
        }
        if (dl.a(jVar.e)) {
            aVar.b(jVar.e.intValue());
        }
        if (dl.a(jVar.g)) {
            aVar.c(jVar.g.intValue());
        }
        if (dl.a(jVar.logs) && jVar.logs.booleanValue()) {
            aVar.a();
        }
        if (dl.a(jVar.sessionTimeout)) {
            aVar.a(jVar.sessionTimeout.intValue());
        }
        if (dl.a(jVar.crashReporting)) {
            aVar.a(jVar.crashReporting.booleanValue());
        }
        if (dl.a(jVar.nativeCrashReporting)) {
            aVar.b(jVar.nativeCrashReporting.booleanValue());
        }
        if (dl.a(jVar.locationTracking)) {
            aVar.d(jVar.locationTracking.booleanValue());
        }
        if (dl.a(jVar.installedAppCollecting)) {
            aVar.e(jVar.installedAppCollecting.booleanValue());
        }
        if (dl.a((Object) jVar.c)) {
            aVar.b(jVar.c);
        }
        if (dl.a(jVar.firstActivationAsUpdate)) {
            aVar.g(jVar.firstActivationAsUpdate.booleanValue());
        }
        if (dl.a(jVar.statisticsSending)) {
            aVar.f(jVar.statisticsSending.booleanValue());
        }
        if (dl.a(jVar.l)) {
            aVar.c(jVar.l.booleanValue());
        }
        if (dl.a(jVar.maxReportsInDatabaseCount)) {
            aVar.e(jVar.maxReportsInDatabaseCount.intValue());
        }
        if (dl.a(jVar.n)) {
            aVar.a(jVar.n);
        }
    }

    private void b(@Nullable Map<String, String> map, @NonNull j.a aVar) {
        if (!dl.a((Map) map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        }
    }

    private void a(@Nullable Map<String, String> map, @NonNull j.a aVar) {
        if (!dl.a((Map) map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.b(entry.getKey(), entry.getValue());
            }
        }
    }

    private void a(j jVar, j.a aVar) {
        Boolean b2 = b();
        if (a(jVar.locationTracking) && dl.a(b2)) {
            aVar.d(b2.booleanValue());
        }
        Location a3 = a();
        if (a((Object) jVar.location) && dl.a(a3)) {
            aVar.a(a3);
        }
        Boolean c2 = c();
        if (a(jVar.statisticsSending) && dl.a(c2)) {
            aVar.f(c2.booleanValue());
        }
    }

    public void a(cs csVar) {
        this.i = csVar;
    }
}
