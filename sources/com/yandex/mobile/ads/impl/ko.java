package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.mediation.banner.b;
import com.yandex.mobile.ads.mediation.banner.e;
public final class ko implements kn {
    @NonNull
    private final x<String> a;
    @NonNull
    private final bm b;

    public ko(@NonNull x<String> xVar, @NonNull bm bmVar) {
        this.a = xVar;
        this.b = bmVar;
    }

    @Override // com.yandex.mobile.ads.impl.kn
    @NonNull
    public final b a(@NonNull a aVar) {
        return new e(aVar, this.a, this.b);
    }
}
