package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class qs {
    @Nullable
    private ql a;
    @NonNull
    private y<Location> b;
    @Nullable
    private Location c;
    private long d;
    @NonNull
    private dj e;
    @NonNull
    private rm f;
    @NonNull
    private pn g;

    public qs(@Nullable ql qlVar, @NonNull y<Location> yVar, @NonNull rm rmVar, @NonNull pn pnVar) {
        this(qlVar, yVar, null, 0, new dj(), rmVar, pnVar);
    }

    private void b() {
        this.f.a();
    }

    private void c(@Nullable Location location) {
        this.b.a(location);
    }

    private boolean d(@Nullable Location location) {
        if (!(location == null || this.a == null)) {
            if (this.c == null) {
                return true;
            }
            boolean c2 = c();
            boolean e2 = e(location);
            boolean f2 = f(location);
            if ((c2 || e2) && f2) {
                return true;
            }
        }
        return false;
    }

    private boolean e(Location location) {
        return g(location) > this.a.b;
    }

    private boolean f(@NonNull Location location) {
        return this.c == null || location.getTime() - this.c.getTime() >= 0;
    }

    private float g(Location location) {
        return location.distanceTo(this.c);
    }

    public void a(@Nullable Location location) {
        if (d(location)) {
            b(location);
            c(location);
            b();
            a();
        }
    }

    public qs(@Nullable ql qlVar, @NonNull y<Location> yVar, @Nullable Location location, long j, @NonNull dj djVar, @NonNull rm rmVar, @NonNull pn pnVar) {
        this.a = qlVar;
        this.b = yVar;
        this.c = location;
        this.d = j;
        this.e = djVar;
        this.f = rmVar;
        this.g = pnVar;
    }

    private void b(@Nullable Location location) {
        this.c = location;
        this.d = System.currentTimeMillis();
    }

    private boolean c() {
        return this.e.b(this.d, this.a.a, "isSavedLocationOutdated");
    }

    private void a() {
        this.g.a();
    }

    public void a(@Nullable ql qlVar) {
        this.a = qlVar;
    }
}
