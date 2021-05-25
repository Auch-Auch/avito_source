package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;
public final class zzagf extends zzafa {
    private final NativeContentAd.OnContentAdLoadedListener zzddn;

    public zzagf(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzddn = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final void zza(zzaeo zzaeo) {
        this.zzddn.onContentAdLoaded(new zzaep(zzaeo));
    }
}
