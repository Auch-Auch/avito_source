package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
public final class zzdag implements zzden<zzdah> {
    private final zzdln zzfqn;
    private final zzdvw zzgay;

    public zzdag(zzdvw zzdvw, zzdln zzdln) {
        this.zzgay = zzdvw;
        this.zzfqn = zzdln;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdah> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdaj
            private final zzdag zzgsy;

            {
                this.zzgsy = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgsy.zzaqv();
            }
        });
    }

    public final /* synthetic */ zzdah zzaqv() throws Exception {
        return new zzdah(this.zzfqn.zzhby);
    }
}
