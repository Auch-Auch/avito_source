package com.yandex.mobile.ads.mediation.rewarded;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.bd;
import com.yandex.mobile.ads.rewarded.b;
import java.lang.ref.WeakReference;
public final class d implements MediatedRewardedAdapterListener {
    @NonNull
    private final WeakReference<b> a;
    @NonNull
    private final bd<MediatedRewardedAdapter, MediatedRewardedAdapterListener> b;

    public d(@NonNull b bVar, @NonNull bd<MediatedRewardedAdapter, MediatedRewardedAdapterListener> bdVar) {
        this.a = new WeakReference<>(bVar);
        this.b = bdVar;
    }

    @Override // com.yandex.mobile.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewarded(@Nullable MediatedReward mediatedReward) {
        b bVar = this.a.get();
        if (bVar != null) {
            this.b.a(bVar.n(), bVar.z());
            bVar.F();
        }
    }

    @Override // com.yandex.mobile.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewardedAdClicked() {
        b bVar = this.a.get();
        if (bVar != null) {
            this.b.b(bVar.n());
        }
    }

    @Override // com.yandex.mobile.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewardedAdDismissed() {
        b bVar = this.a.get();
        if (bVar != null) {
            bVar.C();
        }
    }

    @Override // com.yandex.mobile.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewardedAdFailedToLoad(@NonNull AdRequestError adRequestError) {
        b bVar = this.a.get();
        if (bVar != null) {
            this.b.a(bVar.n(), adRequestError, (AdRequestError) this);
        }
    }

    @Override // com.yandex.mobile.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewardedAdLeftApplication() {
        b bVar = this.a.get();
        if (bVar != null) {
            bVar.onAdLeftApplication();
        }
    }

    @Override // com.yandex.mobile.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewardedAdLoaded() {
        b bVar = this.a.get();
        if (bVar != null) {
            this.b.e(bVar.n());
            bVar.onAdLoaded();
        }
    }

    @Override // com.yandex.mobile.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewardedAdShown() {
        b bVar = this.a.get();
        if (bVar != null) {
            this.b.c(bVar.n());
            bVar.B();
        }
    }
}
