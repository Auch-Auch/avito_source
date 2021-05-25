package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;
public final class bi {
    @NonNull
    private final ds a;
    @NonNull
    private final WeakReference<ab> b;

    public bi(@NonNull ab abVar, @NonNull bm bmVar) {
        this.b = new WeakReference<>(abVar);
        this.a = new dr(bmVar);
    }

    public final void a() {
        ab abVar = this.b.get();
        if (abVar != null && !abVar.m()) {
            abVar.c(this.a);
        }
    }
}
