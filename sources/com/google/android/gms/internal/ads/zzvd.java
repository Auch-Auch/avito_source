package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
public final class zzvd extends zzxa {
    private final AdMetadataListener zzchk;

    public zzvd(AdMetadataListener adMetadataListener) {
        this.zzchk = adMetadataListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.zzchk;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
