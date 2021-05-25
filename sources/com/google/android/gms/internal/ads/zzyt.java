package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
public final class zzyt extends zzwh {
    private final /* synthetic */ zzyq zzcjv;

    public zzyt(zzyq zzyq) {
        this.zzcjv = zzyq;
    }

    @Override // com.google.android.gms.internal.ads.zzwh, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i) {
        this.zzcjv.zzcjj.zza(this.zzcjv.zzdt());
        super.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzwh, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        this.zzcjv.zzcjj.zza(this.zzcjv.zzdt());
        super.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzwh, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzcjv.zzcjj.zza(this.zzcjv.zzdt());
        super.onAdFailedToLoad(loadAdError);
    }
}
