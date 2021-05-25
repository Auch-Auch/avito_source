package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
public class rj {
    @NonNull
    private c a;
    @NonNull
    private a b;
    @NonNull
    private b c;
    @NonNull
    private Context d;
    @Nullable
    private ql e;
    @Nullable
    private rl f;
    @NonNull
    private rm g;
    @NonNull
    private pn h;
    @NonNull
    private final qr i;
    @Nullable
    private pu j;
    @NonNull
    private Map<String, qs> k;

    public static class a {
        @NonNull
        public pu a(@Nullable y<Location> yVar, @NonNull qr qrVar) {
            return new pu(yVar, qrVar);
        }
    }

    public static class b {
        @NonNull
        public qs a(@Nullable ql qlVar, @NonNull y<Location> yVar, @NonNull rm rmVar, @NonNull pn pnVar) {
            return new qs(qlVar, yVar, rmVar, pnVar);
        }
    }

    public static class c {
        @NonNull
        public rl a(@NonNull Context context, @Nullable y<Location> yVar) {
            return new rl(context, yVar);
        }
    }

    public rj(@NonNull Context context, @Nullable ql qlVar, @NonNull rm rmVar, @NonNull pn pnVar) {
        this(context, qlVar, new c(), new qr(), new a(), new b(), rmVar, pnVar);
    }

    @NonNull
    private qs c() {
        if (this.f == null) {
            this.f = this.a.a(this.d, null);
        }
        if (this.j == null) {
            this.j = this.b.a(this.f, this.i);
        }
        return this.c.a(this.e, this.j, this.g, this.h);
    }

    public void a(@NonNull Location location) {
        String provider = location.getProvider();
        qs qsVar = this.k.get(provider);
        if (qsVar == null) {
            qsVar = c();
            this.k.put(provider, qsVar);
        } else {
            qsVar.a(this.e);
        }
        qsVar.a(location);
    }

    @NonNull
    public qr b() {
        return this.i;
    }

    @VisibleForTesting
    public rj(@NonNull Context context, @Nullable ql qlVar, @NonNull c cVar, @NonNull qr qrVar, @NonNull a aVar, @NonNull b bVar, @NonNull rm rmVar, @NonNull pn pnVar) {
        this.k = new HashMap();
        this.d = context;
        this.e = qlVar;
        this.a = cVar;
        this.i = qrVar;
        this.b = aVar;
        this.c = bVar;
        this.g = rmVar;
        this.h = pnVar;
    }

    @Nullable
    public Location a() {
        return (Location) this.i.a();
    }

    public void a(@Nullable ql qlVar) {
        this.e = qlVar;
    }
}
