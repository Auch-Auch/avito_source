package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzcrk implements zzcre<zzbnc> {
    private final Executor zzfmk;
    private final zzdln zzfqn;
    private final zzcih zzfzy;
    private final zzbmw zzglf;
    private final Context zzvr;

    public zzcrk(zzbmw zzbmw, Context context, Executor executor, zzcih zzcih, zzdln zzdln) {
        this.zzvr = context;
        this.zzglf = zzbmw;
        this.zzfmk = executor;
        this.zzfzy = zzcih;
        this.zzfqn = zzdln;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final boolean zza(zzdlj zzdlj, zzdkx zzdkx) {
        zzdlb zzdlb = zzdkx.zzhao;
        return (zzdlb == null || zzdlb.zzdou == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzdvt<zzbnc> zzb(zzdlj zzdlj, zzdkx zzdkx) {
        return zzdvl.zzb(zzdvl.zzaf(null), new zzduv(this, zzdlj, zzdkx) { // from class: com.google.android.gms.internal.ads.zzcrj
            private final zzdkx zzfoo;
            private final zzdlj zzgbj;
            private final zzcrk zzgle;

            {
                this.zzgle = r1;
                this.zzgbj = r2;
                this.zzfoo = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgle.zza(this.zzgbj, this.zzfoo, obj);
            }
        }, this.zzfmk);
    }

    public final /* synthetic */ zzdvt zza(zzdlj zzdlj, zzdkx zzdkx, Object obj) throws Exception {
        zzvj zzb = zzdls.zzb(this.zzvr, zzdkx.zzhaq);
        zzbfq zzc = this.zzfzy.zzc(zzb);
        zzbmq zza = this.zzglf.zza(new zzbpt(zzdlj, zzdkx, null), new zzbmp(zzc.getView(), zzc, zzdls.zzf(zzb), zzdkx.zzfnn, zzdkx.zzfno, zzdkx.zzfnp));
        zza.zzafo().zzb(zzc, false);
        zzbtl zzaep = zza.zzaep();
        zzcrm zzcrm = new zzbtm(zzc) { // from class: com.google.android.gms.internal.ads.zzcrm
            private final zzbfq zzepi;

            {
                this.zzepi = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbtm
            public final void onAdImpression() {
                zzbfq zzbfq = this.zzepi;
                if (zzbfq.zzabe() != null) {
                    zzbfq.zzabe().zzacd();
                }
            }
        };
        zzdvw zzdvw = zzbbi.zzedz;
        zzaep.zza(zzcrm, zzdvw);
        zza.zzafo();
        zzdlb zzdlb = zzdkx.zzhao;
        return zzdvl.zzb(zzcij.zza(zzc, zzdlb.zzdos, zzdlb.zzdou), new zzdsl(zza) { // from class: com.google.android.gms.internal.ads.zzcrl
            private final zzbmq zzglg;

            {
                this.zzglg = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj2) {
                return this.zzglg.zzafn();
            }
        }, zzdvw);
    }
}
