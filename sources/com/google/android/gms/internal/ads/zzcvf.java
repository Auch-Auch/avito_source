package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzcvf implements zzcrh<zzchu, zzdlx, zzcsn> {
    private final Executor zzfmk;
    private final zzchx zzgno;
    private final Context zzvr;

    public zzcvf(Context context, Executor executor, zzchx zzchx) {
        this.zzvr = context;
        this.zzfmk = executor;
        this.zzgno = zzchx;
    }

    /* access modifiers changed from: private */
    public static void zzc(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzdlx, zzcsn> zzcrg) {
        try {
            zzcrg.zzdkn.zza(zzdlj.zzhbp.zzfqn.zzhbu, zzdkx.zzhar.toString());
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcrg.zzfqh);
            zzbbd.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void zza(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzdlx, zzcsn> zzcrg) throws zzdlr {
        if (!zzcrg.zzdkn.isInitialized()) {
            ((zzcsn) zzcrg.zzglc).zza(new zzcvh(this, zzdlj, zzdkx, zzcrg));
            zzcrg.zzdkn.zza(this.zzvr, zzdlj.zzhbp.zzfqn.zzhbu, null, (zzaua) zzcrg.zzglc, zzdkx.zzhar.toString());
            return;
        }
        zzc(zzdlj, zzdkx, zzcrg);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdlj, com.google.android.gms.internal.ads.zzdkx, com.google.android.gms.internal.ads.zzcrg] */
    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzchu zzb(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzdlx, zzcsn> zzcrg) throws zzdlr, zzcuh {
        zzchw zza = this.zzgno.zza(new zzbpt(zzdlj, zzdkx, zzcrg.zzfqh), new zzchv(new zzcaz(zzcrg) { // from class: com.google.android.gms.internal.ads.zzcvi
            private final zzcrg zzglo;

            {
                this.zzglo = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzcaz
            public final void zza(boolean z, Context context) {
                zzcrg zzcrg2 = this.zzglo;
                try {
                    zzcrg2.zzdkn.setImmersiveMode(z);
                    zzcrg2.zzdkn.showVideo();
                } catch (zzdlr e) {
                    zzbbd.zzd("Cannot show rewarded video.", e);
                    throw new zzcbc(e.getCause());
                }
            }
        }));
        zza.zzaem().zza((zzbto) new zzbll(zzcrg.zzdkn), this.zzfmk);
        zzbtu zzaen = zza.zzaen();
        zzbst zzaeo = zza.zzaeo();
        ((zzcsn) zzcrg.zzglc).zza(new zzcvj(this, zza.zzagc(), zzaeo, zzaen, zza.zzagi()));
        return zza.zzagh();
    }
}
