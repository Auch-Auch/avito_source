package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzcsx implements zzcrh<zzbzr, zzdlx, zzcso> {
    private final zzbbg zzbop;
    private final Executor zzfmk;
    private final zzcar zzglr;
    private final Context zzvr;

    public zzcsx(Context context, zzbbg zzbbg, zzcar zzcar, Executor executor) {
        this.zzvr = context;
        this.zzbop = zzbbg;
        this.zzglr = zzcar;
        this.zzfmk = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void zza(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzdlx, zzcso> zzcrg) throws zzdlr {
        if (this.zzbop.zzedr < 4100000) {
            zzcrg.zzdkn.zza(this.zzvr, zzdlj.zzhbp.zzfqn.zzhbu, zzdkx.zzhar.toString(), (zzana) zzcrg.zzglc);
        } else {
            zzcrg.zzdkn.zza(this.zzvr, zzdlj.zzhbp.zzfqn.zzhbu, zzdkx.zzhar.toString(), zzbab.zza(zzdkx.zzhao), (zzana) zzcrg.zzglc);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdlj, com.google.android.gms.internal.ads.zzdkx, com.google.android.gms.internal.ads.zzcrg] */
    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzbzr zzb(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzdlx, zzcso> zzcrg) throws zzdlr, zzcuh {
        zzbzt zza = this.zzglr.zza(new zzbpt(zzdlj, zzdkx, zzcrg.zzfqh), new zzbzw(new zzcaz(zzcrg) { // from class: com.google.android.gms.internal.ads.zzcta
            private final zzcrg zzglo;

            {
                this.zzglo = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzcaz
            public final void zza(boolean z, Context context) {
                zzcrg zzcrg2 = this.zzglo;
                try {
                    zzcrg2.zzdkn.setImmersiveMode(z);
                    zzcrg2.zzdkn.showInterstitial();
                } catch (zzdlr e) {
                    zzbbd.zzfd("Cannot show interstitial.");
                    throw new zzcbc(e.getCause());
                }
            }
        }));
        zza.zzaem().zza((zzbto) new zzbll(zzcrg.zzdkn), this.zzfmk);
        ((zzcso) zzcrg.zzglc).zzb(zza.zzaer());
        return zza.zzagb();
    }
}
