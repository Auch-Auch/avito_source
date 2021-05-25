package com.yandex.mobile.ads.mediation.nativeads;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.r;
import java.util.WeakHashMap;
public final class f {
    private final WeakHashMap<r, Object> a = new WeakHashMap<>();

    public final void a(@NonNull r rVar) {
        this.a.put(rVar, null);
    }

    public final void b() {
        for (r rVar : this.a.keySet()) {
            rVar.b();
        }
    }

    public final void c() {
        for (r rVar : this.a.keySet()) {
            rVar.c();
        }
    }

    public final void d() {
        for (r rVar : this.a.keySet()) {
            rVar.d();
        }
    }

    public final void e() {
        for (r rVar : this.a.keySet()) {
            rVar.e();
        }
    }

    public final void a() {
        for (r rVar : this.a.keySet()) {
            rVar.a();
        }
    }
}
