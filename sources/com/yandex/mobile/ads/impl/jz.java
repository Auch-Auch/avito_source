package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.InterstitialEventListener;
import com.yandex.mobile.ads.b;
public final class jz extends in {
    @NonNull
    private final jy h;
    @NonNull
    private final js i;

    public jz(@NonNull Context context, @NonNull jy jyVar) {
        super(context, b.INTERSTITIAL, jyVar);
        this.h = jyVar;
        js jsVar = new js();
        this.i = jsVar;
        jyVar.a(jsVar);
    }

    @Nullable
    public final InterstitialEventListener F() {
        return this.h.i();
    }

    public final void a(@Nullable InterstitialEventListener interstitialEventListener) {
        this.h.a(interstitialEventListener);
    }

    @Override // com.yandex.mobile.ads.impl.in
    @NonNull
    public final kq a(@NonNull kr krVar) {
        return krVar.a(this);
    }

    @Override // com.yandex.mobile.ads.impl.in, com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab
    public final void a(@NonNull x<String> xVar) {
        super.a(xVar);
        this.i.a(xVar);
    }
}
