package com.yandex.mobile.ads.mediation.interstitial;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.bd;
import com.yandex.mobile.ads.impl.in;
import com.yandex.mobile.ads.mediation.interstitial.MediatedInterstitialAdapter;
import java.lang.ref.WeakReference;
public final class a implements MediatedInterstitialAdapter.MediatedInterstitialAdapterListener {
    @NonNull
    private final WeakReference<in> a;
    @NonNull
    private final bd<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> b;

    public a(@NonNull in inVar, @NonNull bd<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> bdVar) {
        this.a = new WeakReference<>(inVar);
        this.b = bdVar;
    }

    @Override // com.yandex.mobile.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onInterstitialClicked() {
        in inVar = this.a.get();
        if (inVar != null) {
            this.b.b(inVar.n());
        }
    }

    @Override // com.yandex.mobile.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onInterstitialDismissed() {
        in inVar = this.a.get();
        if (inVar != null) {
            inVar.C();
        }
    }

    @Override // com.yandex.mobile.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onInterstitialFailedToLoad(@NonNull AdRequestError adRequestError) {
        in inVar = this.a.get();
        if (inVar != null) {
            this.b.a(inVar.n(), adRequestError, (AdRequestError) this);
        }
    }

    @Override // com.yandex.mobile.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onInterstitialLeftApplication() {
        in inVar = this.a.get();
        if (inVar != null) {
            inVar.onAdLeftApplication();
        }
    }

    @Override // com.yandex.mobile.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onInterstitialLoaded() {
        in inVar = this.a.get();
        if (inVar != null) {
            this.b.e(inVar.n());
            inVar.onAdLoaded();
        }
    }

    @Override // com.yandex.mobile.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onInterstitialShown() {
        in inVar = this.a.get();
        if (inVar != null) {
            this.b.c(inVar.n());
            inVar.B();
        }
    }
}
