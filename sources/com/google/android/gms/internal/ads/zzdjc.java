package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdjc implements zzelo<zzdiz<zzchx, zzchu>> {
    private final zzelx<Context> zzert;
    private final zzelx<zzdmt> zzetu;
    private final zzelx<zzdnl> zzetv;

    public zzdjc(zzelx<Context> zzelx, zzelx<zzdmt> zzelx2, zzelx<zzdnl> zzelx3) {
        this.zzert = zzelx;
        this.zzetu = zzelx2;
        this.zzetv = zzelx3;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        Object obj;
        Context context = this.zzert.get();
        zzdmt zzdmt = this.zzetu.get();
        zzdnl zzdnl = this.zzetv.get();
        if (((Integer) zzwe.zzpu().zzd(zzaat.zzcwe)).intValue() > 0) {
            zzdno zza = zzdnl.zza(zzdng.Rewarded, context, zzdmt, new zzdih(new zzdhy()));
            zzdiq zzdiq = new zzdiq(new zzdir());
            zzdna zzdna = zza.zzgyr;
            zzdvw zzdvw = zzbbi.zzedu;
            obj = new zzdid(zzdiq, new zzdii(zzdna, zzdvw), zza.zzhfm, zzdvw);
        } else {
            obj = new zzdir();
        }
        return (zzdiz) zzelu.zza(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
