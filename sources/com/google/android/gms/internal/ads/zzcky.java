package com.google.android.gms.internal.ads;
public final class zzcky implements zzbsz, zzbuj, zzbvj {
    private final zzclg zzgfa;
    private final zzcln zzgfb;

    public zzcky(zzclg zzclg, zzcln zzcln) {
        this.zzgfa = zzclg;
        this.zzgfb = zzcln;
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        this.zzgfa.zzrr().put("action", "loaded");
        this.zzgfb.zzn(this.zzgfa.zzrr());
    }

    @Override // com.google.android.gms.internal.ads.zzbvj
    public final void zzb(zzdlj zzdlj) {
        this.zzgfa.zzc(zzdlj);
    }

    @Override // com.google.android.gms.internal.ads.zzbvj
    public final void zzd(zzasp zzasp) {
        this.zzgfa.zzj(zzasp.zzdtd);
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzg(zzuw zzuw) {
        this.zzgfa.zzrr().put("action", "ftl");
        this.zzgfa.zzrr().put("ftl", String.valueOf(zzuw.errorCode));
        this.zzgfa.zzrr().put("ed", zzuw.zzcgs);
        this.zzgfb.zzn(this.zzgfa.zzrr());
    }
}
