package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzcow implements zzcox {
    private final zzdvw zzgay;
    private final Map<String, zzelx<zzcox>> zzgiq;
    private final zzbve zzgir;

    public zzcow(Map<String, zzelx<zzcox>> map, zzdvw zzdvw, zzbve zzbve) {
        this.zzgiq = map;
        this.zzgay = zzdvw;
        this.zzgir = zzbve;
    }

    @Override // com.google.android.gms.internal.ads.zzcox
    public final zzdvt<zzdlj> zzh(zzasp zzasp) {
        this.zzgir.zzd(zzasp);
        zzdvt<zzdlj> immediateFailedFuture = zzdvl.immediateFailedFuture(new zzcmt(zzdmd.zzhcq));
        for (String str : ((String) zzwe.zzpu().zzd(zzaat.zzcxv)).split(",")) {
            zzelx<zzcox> zzelx = this.zzgiq.get(str.trim());
            if (zzelx != null) {
                immediateFailedFuture = zzdvl.zzb(immediateFailedFuture, zzcmt.class, new zzduv(zzelx, zzasp) { // from class: com.google.android.gms.internal.ads.zzcov
                    private final zzasp zzggz;
                    private final zzelx zzgip;

                    {
                        this.zzgip = r1;
                        this.zzggz = r2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzduv
                    public final zzdvt zzf(Object obj) {
                        zzelx zzelx2 = this.zzgip;
                        zzcmt zzcmt = (zzcmt) obj;
                        return ((zzcox) zzelx2.get()).zzh(this.zzggz);
                    }
                }, this.zzgay);
            }
        }
        zzdvl.zza(immediateFailedFuture, new zzcoy(this), zzbbi.zzedz);
        return immediateFailedFuture;
    }
}
