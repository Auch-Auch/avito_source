package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzcrn implements zzcre<zzbni> {
    private final Executor zzfmk;
    private final zzdln zzfqn;
    private final zzcih zzfzy;
    private final zzboe zzglh;
    private final zzdsl<zzdkx, zzayy> zzgli;
    private final Context zzvr;

    public zzcrn(zzboe zzboe, Context context, Executor executor, zzcih zzcih, zzdln zzdln, zzdsl<zzdkx, zzayy> zzdsl) {
        this.zzvr = context;
        this.zzglh = zzboe;
        this.zzfmk = executor;
        this.zzfzy = zzcih;
        this.zzfqn = zzdln;
        this.zzgli = zzdsl;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final boolean zza(zzdlj zzdlj, zzdkx zzdkx) {
        zzdlb zzdlb = zzdkx.zzhao;
        return (zzdlb == null || zzdlb.zzdou == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzdvt<zzbni> zzb(zzdlj zzdlj, zzdkx zzdkx) {
        return zzdvl.zzb(zzdvl.zzaf(null), new zzduv(this, zzdlj, zzdkx) { // from class: com.google.android.gms.internal.ads.zzcrq
            private final zzdkx zzfoo;
            private final zzdlj zzgbj;
            private final zzcrn zzglk;

            {
                this.zzglk = r1;
                this.zzgbj = r2;
                this.zzfoo = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzglk.zzb(this.zzgbj, this.zzfoo, obj);
            }
        }, this.zzfmk);
    }

    public final /* synthetic */ void zzo(zzbfq zzbfq) {
        zzbfq.zzaay();
        zzbgk zzzo = zzbfq.zzzo();
        zzaac zzaac = this.zzfqn.zzhbt;
        if (zzaac != null && zzzo != null) {
            zzzo.zzb(zzaac);
        }
    }

    public final /* synthetic */ zzdvt zzb(zzdlj zzdlj, zzdkx zzdkx, Object obj) throws Exception {
        zzvj zzb = zzdls.zzb(this.zzvr, zzdkx.zzhaq);
        zzbfq zzc = this.zzfzy.zzc(zzb);
        zzc.zzba(zzdkx.zzdsu);
        zzbnh zza = this.zzglh.zza(new zzbpt(zzdlj, zzdkx, null), new zzbnl(new zzciy(this.zzvr, zzc.getView(), this.zzgli.apply(zzdkx)), zzc, zzcrp.zzp(zzc), zzdls.zzf(zzb)));
        zza.zzafo().zzb(zzc, false);
        zzbtl zzaep = zza.zzaep();
        zzcrs zzcrs = new zzbtm(zzc) { // from class: com.google.android.gms.internal.ads.zzcrs
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
        zzaep.zza(zzcrs, zzdvw);
        zza.zzafo();
        zzdlb zzdlb = zzdkx.zzhao;
        zzdvt<?> zza2 = zzcij.zza(zzc, zzdlb.zzdos, zzdlb.zzdou);
        if (zzdkx.zzduo) {
            zza2.addListener(zzcrr.zzh(zzc), this.zzfmk);
        }
        zza2.addListener(new Runnable(this, zzc) { // from class: com.google.android.gms.internal.ads.zzcru
            private final zzbfq zzgak;
            private final zzcrn zzglk;

            {
                this.zzglk = r1;
                this.zzgak = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzglk.zzo(this.zzgak);
            }
        }, this.zzfmk);
        return zzdvl.zzb(zza2, new zzdsl(zza) { // from class: com.google.android.gms.internal.ads.zzcrt
            private final zzbnh zzgll;

            {
                this.zzgll = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj2) {
                return this.zzgll.zzafs();
            }
        }, zzdvw);
    }
}
