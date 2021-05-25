package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.instream.InstreamAd;
public final class zzajg extends zzajc {
    private final InstreamAd.InstreamAdLoadCallback zzdfn;

    public zzajg(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        this.zzdfn = instreamAdLoadCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzaiz
    public final void onInstreamAdFailedToLoad(int i) {
        this.zzdfn.onInstreamAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzaiz
    public final void zza(zzait zzait) {
        this.zzdfn.onInstreamAdLoaded(new zzaje(zzait));
    }

    @Override // com.google.android.gms.internal.ads.zzaiz
    public final void zzc(zzuw zzuw) {
        this.zzdfn.onInstreamAdFailedToLoad(zzuw.zzpg());
    }
}
