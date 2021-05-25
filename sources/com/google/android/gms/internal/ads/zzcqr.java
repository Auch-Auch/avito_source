package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
public final class zzcqr implements zzdpl {
    private final zzcqq zzgki;

    public zzcqr(zzcqq zzcqq) {
        this.zzgki = zzcqq;
    }

    @Override // com.google.android.gms.internal.ads.zzdpl
    public final void zza(zzdpg zzdpg, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdpl
    public final void zza(zzdpg zzdpg, String str, Throwable th) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvx)).booleanValue() && zzdpg.RENDERER == zzdpg && this.zzgki.zzapq() != 0) {
            this.zzgki.zzep(zzp.zzkw().elapsedRealtime() - this.zzgki.zzapq());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpl
    public final void zzb(zzdpg zzdpg, String str) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvx)).booleanValue() && zzdpg.RENDERER == zzdpg) {
            this.zzgki.zzff(zzp.zzkw().elapsedRealtime());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpl
    public final void zzc(zzdpg zzdpg, String str) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvx)).booleanValue() && zzdpg.RENDERER == zzdpg && this.zzgki.zzapq() != 0) {
            this.zzgki.zzep(zzp.zzkw().elapsedRealtime() - this.zzgki.zzapq());
        }
    }
}
