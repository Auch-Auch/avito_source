package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.zzb;
import java.util.concurrent.Executor;
public final class zzcrv implements zzcrh<zzbni, zzdlx, zzcso> {
    private final zzbbg zzbop;
    private final Executor zzfmk;
    private final zzboe zzglh;
    private final Context zzvr;

    public zzcrv(Context context, zzbbg zzbbg, zzboe zzboe, Executor executor) {
        this.zzvr = context;
        this.zzbop = zzbbg;
        this.zzglh = zzboe;
        this.zzfmk = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void zza(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzdlx, zzcso> zzcrg) throws zzdlr {
        zzvj zzvj;
        zzvj zzvj2 = zzdlj.zzhbp.zzfqn.zzbpb;
        if (zzvj2.zzchu) {
            zzvj = new zzvj(this.zzvr, zzb.zza(zzvj2.width, zzvj2.height));
        } else {
            zzvj = zzdls.zzb(this.zzvr, zzdkx.zzhaq);
        }
        if (this.zzbop.zzedr < 4100000) {
            zzcrg.zzdkn.zza(this.zzvr, zzvj, zzdlj.zzhbp.zzfqn.zzhbu, zzdkx.zzhar.toString(), (zzana) zzcrg.zzglc);
        } else {
            zzcrg.zzdkn.zza(this.zzvr, zzvj, zzdlj.zzhbp.zzfqn.zzhbu, zzdkx.zzhar.toString(), zzbab.zza(zzdkx.zzhao), (zzana) zzcrg.zzglc);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdlj, com.google.android.gms.internal.ads.zzdkx, com.google.android.gms.internal.ads.zzcrg] */
    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzbni zzb(zzdlj zzdlj, zzdkx zzdkx, zzcrg<zzdlx, zzcso> zzcrg) throws zzdlr, zzcuh {
        zzboe zzboe = this.zzglh;
        zzbpt zzbpt = new zzbpt(zzdlj, zzdkx, zzcrg.zzfqh);
        View view = zzcrg.zzdkn.getView();
        AdapterT adaptert = zzcrg.zzdkn;
        adaptert.getClass();
        zzbnh zza = zzboe.zza(zzbpt, new zzbnl(view, null, zzcry.zza(adaptert), zzdkx.zzhaq.get(0)));
        zza.zzaft().zzv(zzcrg.zzdkn.getView());
        zza.zzaem().zza((zzbto) new zzbll(zzcrg.zzdkn), this.zzfmk);
        ((zzcso) zzcrg.zzglc).zzb(zza.zzaer());
        return zza.zzafs();
    }
}
