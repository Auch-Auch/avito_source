package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;
public final class zzagk extends zzafo {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zzddu;

    public zzagk(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zzddu = onUnifiedNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafl
    public final void zza(zzafw zzafw) {
        this.zzddu.onUnifiedNativeAdLoaded(new zzafx(zzafw));
    }
}
