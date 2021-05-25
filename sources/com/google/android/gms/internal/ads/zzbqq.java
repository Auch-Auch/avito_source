package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
public final class zzbqq implements zzbsu, zzbtm, zzbuj, zzbvj, zzut {
    private final Clock zzbpw;
    private final zzaxj zzfrd;

    public zzbqq(Clock clock, zzaxj zzaxj) {
        this.zzbpw = clock;
        this.zzfrd = zzaxj;
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final void onAdClicked() {
        this.zzfrd.zzwa();
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdClosed() {
        this.zzfrd.zzwb();
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final void onAdImpression() {
        this.zzfrd.zzvz();
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        this.zzfrd.zzan(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void zzb(zzatj zzatj, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvj
    public final void zzb(zzdlj zzdlj) {
        this.zzfrd.zzey(this.zzbpw.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzbvj
    public final void zzd(zzasp zzasp) {
    }

    public final void zzf(zzvc zzvc) {
        this.zzfrd.zze(zzvc);
    }

    public final String zzwc() {
        return this.zzfrd.zzwc();
    }
}
