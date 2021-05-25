package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.mediation.interstitial.d;
import com.yandex.mobile.ads.mediation.rewarded.a;
import com.yandex.mobile.ads.rewarded.b;
public final class kt implements kr {
    @NonNull
    private final x<String> a;
    @NonNull
    private final bm b;

    public kt(@NonNull x<String> xVar, @NonNull bm bmVar) {
        this.a = xVar;
        this.b = bmVar;
    }

    @Override // com.yandex.mobile.ads.impl.kr
    @NonNull
    public final kq a(@NonNull in inVar) {
        return new d(inVar, this.a, this.b);
    }

    @Override // com.yandex.mobile.ads.impl.kr
    @NonNull
    public final kq a(@NonNull b bVar) {
        return new a(bVar, this.a, this.b);
    }
}
