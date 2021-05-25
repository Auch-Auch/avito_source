package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.nativeads.r;
public final class om implements oj<pa> {
    @NonNull
    private final cq a;
    @NonNull
    private final r b;

    public om(@NonNull cq cqVar, @NonNull r rVar) {
        this.a = cqVar;
        this.b = rVar;
    }

    @Override // com.yandex.mobile.ads.impl.oj
    public final void a(@NonNull Context context, @NonNull pa paVar) {
        this.b.h();
        this.a.a(hv.b.CLOSE);
    }
}
