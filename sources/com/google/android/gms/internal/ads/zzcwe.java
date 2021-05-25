package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
public final class zzcwe<AdT> implements zzcre<AdT> {
    private final zzdpf zzfqo;
    private final zzdvw zzgoi;
    @Nullable
    private final zzabq zzgop;
    private final zzcwf<AdT> zzgoy;

    public zzcwe(zzdpf zzdpf, zzdvw zzdvw, @Nullable zzabq zzabq, zzcwf<AdT> zzcwf) {
        this.zzfqo = zzdpf;
        this.zzgoi = zzdvw;
        this.zzgop = zzabq;
        this.zzgoy = zzcwf;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final boolean zza(zzdlj zzdlj, zzdkx zzdkx) {
        zzdlb zzdlb;
        return (this.zzgop == null || (zzdlb = zzdkx.zzhao) == null || zzdlb.zzdou == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzdvt<AdT> zzb(zzdlj zzdlj, zzdkx zzdkx) {
        zzbbq zzbbq = new zzbbq();
        zzcwm zzcwm = new zzcwm();
        zzcwm.zza(new zzcwg(this, zzbbq, zzdlj, zzdkx, zzcwm));
        zzdlb zzdlb = zzdkx.zzhao;
        return this.zzfqo.zzu(zzdpg.CUSTOM_RENDER_SYN).zza(new zzdop(this, new zzabj(zzcwm, zzdlb.zzdos, zzdlb.zzdou)) { // from class: com.google.android.gms.internal.ads.zzcwd
            private final zzabj zzgos;
            private final zzcwe zzgox;

            {
                this.zzgox = r1;
                this.zzgos = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzdop
            public final void run() {
                this.zzgox.zzb(this.zzgos);
            }
        }, this.zzgoi).zzw(zzdpg.CUSTOM_RENDER_ACK).zze(zzbbq).zzauz();
    }

    public final /* synthetic */ void zzb(zzabj zzabj) throws Exception {
        this.zzgop.zza(zzabj);
    }
}
