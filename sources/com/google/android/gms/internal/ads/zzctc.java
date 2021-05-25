package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzctc implements zzcrh<zzbzr, zzapa, zzcso> {
    private final zzcar zzglr;
    private final Context zzvr;

    public zzctc(Context context, zzcar zzcar) {
        this.zzvr = context;
        this.zzglr = zzcar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void zza(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzapa, zzcso> zzcrg) throws zzdlr {
        try {
            zzcrg.zzdkn.zzdr(zzdkx.zzdln);
            zzcrg.zzdkn.zza(zzdkx.zzeqb, zzdkx.zzhar.toString(), zzdlj.zzhbp.zzfqn.zzhbu, ObjectWrapper.wrap(this.zzvr), new zzcte(this, zzcrg), (zzana) zzcrg.zzglc);
        } catch (RemoteException e) {
            throw new zzdlr(e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdlj, com.google.android.gms.internal.ads.zzdkx, com.google.android.gms.internal.ads.zzcrg] */
    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzbzr zzb(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzapa, zzcso> zzcrg) throws zzdlr, zzcuh {
        zzcsy zzcsy = new zzcsy(zzdkx, zzcrg.zzdkn, false);
        zzbzt zza = this.zzglr.zza(new zzbpt(zzdlj, zzdkx, zzcrg.zzfqh), new zzbzw(zzcsy));
        zzcsy.zza(zza.zzaep());
        ((zzcso) zzcrg.zzglc).zzb(zza.zzaes());
        return zza.zzagb();
    }
}
