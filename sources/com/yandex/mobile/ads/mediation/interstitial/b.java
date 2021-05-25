package com.yandex.mobile.ads.mediation.interstitial;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.bc;
import com.yandex.mobile.ads.impl.be;
import com.yandex.mobile.ads.impl.bg;
public final class b implements be<MediatedInterstitialAdapter> {
    @NonNull
    private final bg<MediatedInterstitialAdapter> a;

    public b(@NonNull bg<MediatedInterstitialAdapter> bgVar) {
        this.a = bgVar;
    }

    @Override // com.yandex.mobile.ads.impl.be
    @Nullable
    public final bc<MediatedInterstitialAdapter> a(@NonNull Context context) {
        return this.a.a(context, MediatedInterstitialAdapter.class);
    }
}
