package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.WeakHashMap;
public final class gx {
    @NonNull
    private final Object a = new Object();
    @NonNull
    private final WeakHashMap<gz, Object> b = new WeakHashMap<>();

    public final void a(@NonNull gz gzVar) {
        synchronized (this.a) {
            this.b.put(gzVar, null);
        }
    }

    public final void b(@NonNull gz gzVar) {
        synchronized (this.a) {
            this.b.remove(gzVar);
        }
    }

    private void b(@Nullable gs gsVar) {
        for (gz gzVar : this.b.keySet()) {
            gzVar.a(gsVar);
        }
        this.b.clear();
    }

    public final void a(@NonNull gs gsVar) {
        synchronized (this.a) {
            b(gsVar);
        }
    }

    public final void a() {
        synchronized (this.a) {
            b((gs) null);
        }
    }
}
