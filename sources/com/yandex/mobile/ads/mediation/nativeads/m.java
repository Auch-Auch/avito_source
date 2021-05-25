package com.yandex.mobile.ads.mediation.nativeads;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.NativeAdViewBinder;
import com.yandex.mobile.ads.nativeads.ag;
import com.yandex.mobile.ads.nativeads.bf;
import com.yandex.mobile.ads.nativeads.e;
public final class m implements bf {
    @NonNull
    private final bf a;
    @NonNull
    private final MediatedNativeAd b;

    public m(@NonNull bf bfVar, @NonNull MediatedNativeAd mediatedNativeAd) {
        this.a = bfVar;
        this.b = mediatedNativeAd;
    }

    @Override // com.yandex.mobile.ads.nativeads.bf
    public final void a(@NonNull ag agVar) {
        this.a.a(agVar);
        NativeAdViewBinder b2 = agVar.b();
        if (b2 != null) {
            this.b.unbindNativeAd(b2);
        }
    }

    @Override // com.yandex.mobile.ads.nativeads.bf
    public final void a(@NonNull ag agVar, @NonNull e eVar) {
        this.a.a(agVar, eVar);
        NativeAdViewBinder b2 = agVar.b();
        if (b2 != null) {
            this.b.bindNativeAd(b2);
        }
    }

    @Override // com.yandex.mobile.ads.nativeads.bf
    public final void a() {
        this.a.a();
    }
}
