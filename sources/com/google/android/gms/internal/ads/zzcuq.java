package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzcuq implements zzcrh<zzchu, zzapa, zzcso> {
    private final zzchx zzgno;
    private final Context zzvr;

    public zzcuq(Context context, zzchx zzchx) {
        this.zzvr = context;
        this.zzgno = zzchx;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void zza(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzapa, zzcso> zzcrg) throws zzdlr {
        try {
            zzcrg.zzdkn.zzdr(zzdkx.zzdln);
            if (zzdlj.zzhbp.zzfqn.zzhcb.zzhbf == zzdlf.zzhbj) {
                zzcrg.zzdkn.zzb(zzdkx.zzeqb, zzdkx.zzhar.toString(), zzdlj.zzhbp.zzfqn.zzhbu, ObjectWrapper.wrap(this.zzvr), new zzcus(this, zzcrg), (zzana) zzcrg.zzglc);
            } else {
                zzcrg.zzdkn.zza(zzdkx.zzeqb, zzdkx.zzhar.toString(), zzdlj.zzhbp.zzfqn.zzhbu, ObjectWrapper.wrap(this.zzvr), new zzcus(this, zzcrg), (zzana) zzcrg.zzglc);
            }
        } catch (RemoteException e) {
            zzaxy.zza("Remote exception loading a rewarded RTB ad", e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdlj, com.google.android.gms.internal.ads.zzdkx, com.google.android.gms.internal.ads.zzcrg] */
    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzchu zzb(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzapa, zzcso> zzcrg) throws zzdlr, zzcuh {
        zzcsy zzcsy = new zzcsy(zzdkx, zzcrg.zzdkn, true);
        zzchw zza = this.zzgno.zza(new zzbpt(zzdlj, zzdkx, zzcrg.zzfqh), new zzchv(zzcsy));
        zzcsy.zza(zza.zzaep());
        ((zzcso) zzcrg.zzglc).zzb(zza.zzagk());
        return zza.zzagh();
    }
}
