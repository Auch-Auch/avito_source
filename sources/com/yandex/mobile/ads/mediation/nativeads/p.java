package com.yandex.mobile.ads.mediation.nativeads;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.ox;
import com.yandex.mobile.ads.nativeads.bf;
import com.yandex.mobile.ads.nativeads.bg;
import com.yandex.mobile.ads.nativeads.bs;
public final class p implements bg {
    @NonNull
    private final MediatedNativeAd a;
    @NonNull
    private final bg b = new bs();

    public p(@NonNull MediatedNativeAd mediatedNativeAd) {
        this.a = mediatedNativeAd;
    }

    @Override // com.yandex.mobile.ads.nativeads.bg
    @NonNull
    public final bf a(@NonNull ox oxVar) {
        return new m(this.b.a(oxVar), this.a);
    }
}
