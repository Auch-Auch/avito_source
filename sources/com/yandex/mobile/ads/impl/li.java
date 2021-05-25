package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.mediation.nativeads.l;
import com.yandex.mobile.ads.mediation.nativeads.t;
import com.yandex.mobile.ads.nativeads.v;
public final class li implements lk {
    @NonNull
    private final x<oy> a;
    @NonNull
    private final bm b;

    public li(@NonNull x<oy> xVar, @NonNull bm bmVar) {
        this.a = xVar;
        this.b = bmVar;
    }

    @Override // com.yandex.mobile.ads.impl.lk
    @NonNull
    public final t a(@NonNull v vVar) {
        return new l(vVar, this.a, this.b);
    }
}
