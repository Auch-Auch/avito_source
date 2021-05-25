package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;
public final class zzagj extends zzafu {
    private final UnifiedNativeAd.UnconfirmedClickListener zzddt;

    public zzagj(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzddt = unconfirmedClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final void onUnconfirmedClickCancelled() {
        this.zzddt.onUnconfirmedClickCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final void onUnconfirmedClickReceived(String str) {
        this.zzddt.onUnconfirmedClickReceived(str);
    }
}
