package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzcul implements zzcrh<zzchu, zzdlx, zzcso> {
    private final Executor zzfmk;
    private final zzchx zzgno;
    private final Context zzvr;

    public zzcul(Context context, Executor executor, zzchx zzchx) {
        this.zzvr = context;
        this.zzfmk = executor;
        this.zzgno = zzchx;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void zza(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzdlx, zzcso> zzcrg) throws zzdlr {
        try {
            zzdln zzdln = zzdlj.zzhbp.zzfqn;
            if (zzdln.zzhcb.zzhbf == zzdlf.zzhbj) {
                zzcrg.zzdkn.zzc(this.zzvr, zzdln.zzhbu, zzdkx.zzhar.toString(), (zzana) zzcrg.zzglc);
            } else {
                zzcrg.zzdkn.zzb(this.zzvr, zzdln.zzhbu, zzdkx.zzhar.toString(), (zzana) zzcrg.zzglc);
            }
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcrg.zzfqh);
            zzbbd.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdlj, com.google.android.gms.internal.ads.zzdkx, com.google.android.gms.internal.ads.zzcrg] */
    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzchu zzb(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzdlx, zzcso> zzcrg) throws zzdlr, zzcuh {
        zzchw zza = this.zzgno.zza(new zzbpt(zzdlj, zzdkx, zzcrg.zzfqh), new zzchv(new zzcaz(zzcrg) { // from class: com.google.android.gms.internal.ads.zzcuo
            private final zzcrg zzglo;

            {
                this.zzglo = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzcaz
            public final void zza(boolean z, Context context) {
                zzcrg zzcrg2 = this.zzglo;
                try {
                    zzcrg2.zzdkn.setImmersiveMode(z);
                    zzcrg2.zzdkn.zzch(context);
                } catch (zzdlr e) {
                    throw new zzcbc(e.getCause());
                }
            }
        }));
        zza.zzaem().zza((zzbto) new zzbll(zzcrg.zzdkn), this.zzfmk);
        ((zzcso) zzcrg.zzglc).zzb(zza.zzagj());
        return zza.zzagh();
    }
}
