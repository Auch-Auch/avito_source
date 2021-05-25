package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzctp implements zzcrh<zzcco, zzapa, zzcso> {
    private final zzcbn zzgmp;
    private zzanj zzgmw;
    private final Context zzvr;

    public zzctp(Context context, zzcbn zzcbn) {
        this.zzvr = context;
        this.zzgmp = zzcbn;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void zza(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzapa, zzcso> zzcrg) throws zzdlr {
        try {
            zzcrg.zzdkn.zzdr(zzdkx.zzdln);
            zzcrg.zzdkn.zza(zzdkx.zzeqb, zzdkx.zzhar.toString(), zzdlj.zzhbp.zzfqn.zzhbu, ObjectWrapper.wrap(this.zzvr), new zzctr(this, zzcrg), (zzana) zzcrg.zzglc);
        } catch (RemoteException e) {
            throw new zzdlr(e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdlj, com.google.android.gms.internal.ads.zzdkx, com.google.android.gms.internal.ads.zzcrg] */
    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzcco zzb(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzapa, zzcso> zzcrg) throws zzdlr, zzcuh {
        if (zzdlj.zzhbp.zzfqn.zzhbw.contains(Integer.toString(6))) {
            zzccv zzb = zzccv.zzb(this.zzgmw);
            if (zzdlj.zzhbp.zzfqn.zzhbw.contains(Integer.toString(zzb.zzaln()))) {
                zzcda zza = this.zzgmp.zza(new zzbpt(zzdlj, zzdkx, zzcrg.zzfqh), new zzcdh(zzb), new zzcew(null, null, this.zzgmw));
                ((zzcso) zzcrg.zzglc).zzb(zza.zzaes());
                return zza.zzaet();
            }
            throw new zzcuh(zzdmd.zzhco, "No corresponding native ad listener");
        }
        throw new zzcuh(zzdmd.zzhcp, "Unified must be used for RTB.");
    }
}
