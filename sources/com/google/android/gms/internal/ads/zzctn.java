package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzctn implements zzcrh<zzcco, zzdlx, zzcso> {
    private final Executor zzfmk;
    private final zzcbn zzgmp;
    private final Context zzvr;

    public zzctn(Context context, zzcbn zzcbn, Executor executor) {
        this.zzvr = context;
        this.zzgmp = zzcbn;
        this.zzfmk = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void zza(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzdlx, zzcso> zzcrg) throws zzdlr {
        zzdln zzdln = zzdlj.zzhbp.zzfqn;
        zzcrg.zzdkn.zza(this.zzvr, zzdlj.zzhbp.zzfqn.zzhbu, zzdkx.zzhar.toString(), zzbab.zza(zzdkx.zzhao), (zzana) zzcrg.zzglc, zzdln.zzdla, zzdln.zzhbw);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdlj, com.google.android.gms.internal.ads.zzdkx, com.google.android.gms.internal.ads.zzcrg] */
    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzcco zzb(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzdlx, zzcso> zzcrg) throws zzdlr, zzcuh {
        zzccv zzccv;
        zzand zztp = zzcrg.zzdkn.zztp();
        zzani zztq = zzcrg.zzdkn.zztq();
        zzanj zztv = zzcrg.zzdkn.zztv();
        if (zztv != null && zza(zzdlj, 6)) {
            zzccv = zzccv.zzb(zztv);
        } else if (zztp != null && zza(zzdlj, 6)) {
            zzccv = zzccv.zzb(zztp);
        } else if (zztp != null && zza(zzdlj, 2)) {
            zzccv = zzccv.zza(zztp);
        } else if (zztq != null && zza(zzdlj, 6)) {
            zzccv = zzccv.zzb(zztq);
        } else if (zztq == null || !zza(zzdlj, 1)) {
            throw new zzcuh(zzdmd.zzhco, "No native ad mappers");
        } else {
            zzccv = zzccv.zza(zztq);
        }
        if (zzdlj.zzhbp.zzfqn.zzhbw.contains(Integer.toString(zzccv.zzaln()))) {
            zzcda zza = this.zzgmp.zza(new zzbpt(zzdlj, zzdkx, zzcrg.zzfqh), new zzcdh(zzccv), new zzcew(zztq, zztp, zztv));
            ((zzcso) zzcrg.zzglc).zzb(zza.zzaer());
            zza.zzaem().zza((zzbto) new zzbll(zzcrg.zzdkn), this.zzfmk);
            return zza.zzaet();
        }
        throw new zzcuh(zzdmd.zzhco, "No corresponding native ad listener");
    }

    private static boolean zza(zzdlj zzdlj, int i) {
        return zzdlj.zzhbp.zzfqn.zzhbw.contains(Integer.toString(i));
    }
}
