package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
public final class zzdfv implements zzden<zzdfs> {
    private zzdvw zzgay;
    public zztc zzgwh;
    public Context zzvr;

    public zzdfv(zztc zztc, zzdvw zzdvw, Context context) {
        this.zzgwh = zztc;
        this.zzgay = zzdvw;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdfs> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdfu
            private final zzdfv zzgwg;

            {
                this.zzgwg = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdfv zzdfv = this.zzgwg;
                return new zzdfs(zzdfv.zzgwh.zzf(zzdfv.zzvr));
            }
        });
    }
}
