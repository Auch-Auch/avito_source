package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
public final class zzdga implements zzden<zzdgb> {
    private String packageName;
    private zzdvw zzgay;
    private zzaxc zzgwk;

    public zzdga(zzaxc zzaxc, zzdvw zzdvw, String str) {
        this.zzgwk = zzaxc;
        this.zzgay = zzdvw;
        this.packageName = str;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdgb> zzaqs() {
        new zzbbq();
        zzdvt<String> zzaf = zzdvl.zzaf(null);
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvc)).booleanValue()) {
            zzaf = this.zzgwk.zzeg(this.packageName);
        }
        zzdvt<String> zzeh = this.zzgwk.zzeh(this.packageName);
        return zzdvl.zzb(zzaf, zzeh).zza(new Callable(zzaf, zzeh) { // from class: com.google.android.gms.internal.ads.zzdgd
            private final zzdvt zzfsi;
            private final zzdvt zzgbt;

            {
                this.zzgbt = r1;
                this.zzfsi = r2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzdgb((String) this.zzgbt.get(), (String) this.zzfsi.get());
            }
        }, zzbbi.zzedu);
    }
}
