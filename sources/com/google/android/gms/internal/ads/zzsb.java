package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAd;
import java.lang.ref.WeakReference;
public final class zzsb extends zzsh {
    private final WeakReference<AppOpenAd.AppOpenAdLoadCallback> zzbul;

    public zzsb(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzbul = new WeakReference<>(appOpenAdLoadCallback);
    }

    @Override // com.google.android.gms.internal.ads.zzsi
    public final void onAppOpenAdFailedToLoad(int i) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbul.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsi
    public final void zza(zzsd zzsd) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbul.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdLoaded(new zzso(zzsd));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsi
    public final void zza(zzuw zzuw) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbul.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdFailedToLoad(zzuw.zzpg());
        }
    }
}
