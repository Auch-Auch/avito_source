package com.yandex.mobile.ads.mediation.interstitial;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.bf;
import com.yandex.mobile.ads.mediation.interstitial.MediatedInterstitialAdapter;
import java.util.Map;
public final class c implements bf<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> {
    @Nullable
    private MediatedInterstitialAdapter a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object, java.lang.Object, java.util.Map, java.util.Map] */
    @Override // com.yandex.mobile.ads.impl.bf
    public final /* synthetic */ void a(@NonNull Context context, @NonNull MediatedInterstitialAdapter mediatedInterstitialAdapter, @NonNull MediatedInterstitialAdapter.MediatedInterstitialAdapterListener mediatedInterstitialAdapterListener, @NonNull Map map, @NonNull Map map2) {
        MediatedInterstitialAdapter mediatedInterstitialAdapter2 = mediatedInterstitialAdapter;
        this.a = mediatedInterstitialAdapter2;
        mediatedInterstitialAdapter2.loadInterstitial(context, mediatedInterstitialAdapterListener, map, map2);
    }

    public final boolean b() {
        MediatedInterstitialAdapter mediatedInterstitialAdapter = this.a;
        return mediatedInterstitialAdapter != null && mediatedInterstitialAdapter.isLoaded();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.bf
    public final /* synthetic */ void a(@NonNull MediatedInterstitialAdapter mediatedInterstitialAdapter) {
        mediatedInterstitialAdapter.onInvalidate();
    }

    @Nullable
    public final MediatedInterstitialAdapter a() {
        return this.a;
    }
}
