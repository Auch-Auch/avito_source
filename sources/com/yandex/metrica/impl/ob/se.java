package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class se {
    private long a;
    private int b;
    @NonNull
    private final sf c;
    @Nullable
    private final xq d;
    @NonNull
    private final dj e;
    @NonNull
    private final abt f;

    public se(@NonNull sf sfVar, @Nullable xq xqVar) {
        this(sfVar, xqVar, new dj(), new abs());
    }

    private void d() {
        this.b = this.c.a();
        this.a = this.c.b();
    }

    public void a() {
        this.b = 1;
        this.a = 0;
        this.c.a(1);
        this.c.a(this.a);
    }

    public void b() {
        long b2 = this.f.b();
        this.a = b2;
        this.b++;
        this.c.a(b2);
        this.c.a(this.b);
    }

    public boolean c() {
        xq xqVar = this.d;
        if (xqVar == null) {
            return true;
        }
        long j = this.a;
        if (j == 0) {
            return true;
        }
        return this.e.a(j, (long) a(xqVar), "last send attempt");
    }

    @VisibleForTesting
    public se(@NonNull sf sfVar, @Nullable xq xqVar, @NonNull dj djVar, @NonNull abt abt) {
        this.d = xqVar;
        this.c = sfVar;
        this.e = djVar;
        this.f = abt;
        d();
    }

    private int a(@NonNull xq xqVar) {
        int i = ((1 << (this.b - 1)) - 1) * xqVar.b;
        int i2 = xqVar.a;
        return i <= i2 ? i : i2;
    }
}
