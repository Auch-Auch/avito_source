package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
public final class zzcuv implements zzcre<zzchu> {
    private final zzbbg zzbop;
    private final Executor zzfmk;
    private final zzdln zzfqn;
    private final zzcih zzfzy;
    private final zzchx zzgno;
    private final Context zzvr;

    public zzcuv(Context context, zzbbg zzbbg, zzdln zzdln, Executor executor, zzchx zzchx, zzcih zzcih) {
        this.zzvr = context;
        this.zzfqn = zzdln;
        this.zzgno = zzchx;
        this.zzfmk = executor;
        this.zzbop = zzbbg;
        this.zzfzy = zzcih;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final boolean zza(zzdlj zzdlj, zzdkx zzdkx) {
        zzdlb zzdlb = zzdkx.zzhao;
        return (zzdlb == null || zzdlb.zzdou == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzdvt<zzchu> zzb(zzdlj zzdlj, zzdkx zzdkx) {
        zzcix zzcix = new zzcix();
        zzdvt<zzchu> zzb = zzdvl.zzb(zzdvl.zzaf(null), new zzduv(this, zzdkx, zzcix, zzdlj) { // from class: com.google.android.gms.internal.ads.zzcuy
            private final zzdkx zzgmf;
            private final zzcix zzgmg;
            private final zzdlj zzgmh;
            private final zzcuv zzgns;

            {
                this.zzgns = r1;
                this.zzgmf = r2;
                this.zzgmg = r3;
                this.zzgmh = r4;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgns.zzb(this.zzgmf, this.zzgmg, this.zzgmh, obj);
            }
        }, this.zzfmk);
        zzb.addListener(zzcux.zza(zzcix), this.zzfmk);
        return zzb;
    }

    public final /* synthetic */ zzdvt zzb(zzdkx zzdkx, zzcix zzcix, zzdlj zzdlj, Object obj) throws Exception {
        zzdvt<?> zzdvt;
        zzbfq zza = this.zzfzy.zza(this.zzfqn.zzbpb, zzdkx.zzent);
        zza.zzba(zzdkx.zzdsu);
        zzcix.zzc(this.zzvr, zza.getView());
        zzbbq zzbbq = new zzbbq();
        zzchw zza2 = this.zzgno.zza(new zzbpt(zzdlj, zzdkx, null), new zzchv(new zzcvb(this.zzvr, this.zzfzy, this.zzfqn, this.zzbop, zzdkx, zzbbq, zza), zza));
        zzbbq.set(zza2);
        zzahq.zza(zza, zza2.zzagi());
        zza2.zzaep().zza(new zzbtm(zza) { // from class: com.google.android.gms.internal.ads.zzcva
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
        }, zzbbi.zzedz);
        zza2.zzafo().zzb(zza, true);
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcwc)).booleanValue() || !zzdkx.zzent) {
            zza2.zzafo();
            zzdlb zzdlb = zzdkx.zzhao;
            zzdvt = zzcij.zza(zza, zzdlb.zzdos, zzdlb.zzdou);
        } else {
            zzdvt = zzdvl.zzaf(null);
        }
        return zzdvl.zzb(zzdvt, new zzdsl(this, zza, zzdkx, zza2) { // from class: com.google.android.gms.internal.ads.zzcuz
            private final zzdkx zzfoo;
            private final zzbfq zzgak;
            private final zzcuv zzgns;
            private final zzchw zzgnt;

            {
                this.zzgns = r1;
                this.zzgak = r2;
                this.zzfoo = r3;
                this.zzgnt = r4;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj2) {
                zzbfq zzbfq = this.zzgak;
                zzdkx zzdkx2 = this.zzfoo;
                zzchw zzchw = this.zzgnt;
                if (zzdkx2.zzduo) {
                    zzbfq.zzabr();
                }
                zzbfq.zzaay();
                if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcns)).booleanValue()) {
                    zzp.zzkr();
                    zzaym.zza(zzbfq);
                }
                return zzchw.zzagh();
            }
        }, this.zzfmk);
    }
}
