package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzcsa implements zzcrh<zzbni, zzapa, zzcso> {
    private View view;
    private final zzboe zzglh;
    private final Context zzvr;

    public zzcsa(Context context, zzboe zzboe) {
        this.zzvr = context;
        this.zzglh = zzboe;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void zza(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzapa, zzcso> zzcrg) throws zzdlr {
        try {
            zzcrg.zzdkn.zzdr(zzdkx.zzdln);
            zzcrg.zzdkn.zza(zzdkx.zzeqb, zzdkx.zzhar.toString(), zzdlj.zzhbp.zzfqn.zzhbu, ObjectWrapper.wrap(this.zzvr), new zzcsb(this, zzcrg), (zzana) zzcrg.zzglc, zzdlj.zzhbp.zzfqn.zzbpb);
        } catch (RemoteException e) {
            throw new zzdlr(e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdlj, com.google.android.gms.internal.ads.zzdkx, com.google.android.gms.internal.ads.zzcrg] */
    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzbni zzb(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzapa, zzcso> zzcrg) throws zzdlr, zzcuh {
        zzbnh zza = this.zzglh.zza(new zzbpt(zzdlj, zzdkx, zzcrg.zzfqh), new zzbnl(this.view, null, new zzbpe(zzcrg) { // from class: com.google.android.gms.internal.ads.zzcrz
            private final zzcrg zzglo;

            {
                this.zzglo = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbpe
            public final zzyg getVideoController() {
                return zzcsa.zza(this.zzglo);
            }
        }, zzdkx.zzhaq.get(0)));
        zza.zzaft().zzv(this.view);
        ((zzcso) zzcrg.zzglc).zzb(zza.zzaes());
        return zza.zzafs();
    }

    public static final /* synthetic */ zzyg zza(zzcrg zzcrg) throws zzdlr {
        try {
            return zzcrg.zzdkn.getVideoController();
        } catch (RemoteException e) {
            throw new zzdlr(e);
        }
    }
}
