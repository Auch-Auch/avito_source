package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;
/* JADX WARN: Field signature parse error: zzhgq */
public final class zzdov {
    private final Object zzhgq;
    private final /* synthetic */ zzdor zzhgu;

    /* JADX WARN: Failed to parse method signature: (TE)V */
    private zzdov(zzdor zzdor, Object obj) {
        this.zzhgu = zzdor;
        this.zzhgq = obj;
    }

    private final <O> zzdox<O> zza(Callable<O> callable, zzdvw zzdvw) {
        return new zzdox<>(this.zzhgu, this.zzhgq, zzdor.zzhgo, Collections.emptyList(), zzdvw.zze(callable));
    }

    public final <O> zzdox<O> zzc(Callable<O> callable) {
        return zza(callable, this.zzhgu.zzgay);
    }

    public final <O> zzdox<O> zze(zzdvt<O> zzdvt) {
        return new zzdox<>(this.zzhgu, this.zzhgq, zzdor.zzhgo, Collections.emptyList(), zzdvt);
    }

    public final zzdox<?> zza(zzdop zzdop, zzdvw zzdvw) {
        return zza(new Callable(zzdop) { // from class: com.google.android.gms.internal.ads.zzdoy
            private final zzdop zzhgx;

            {
                this.zzhgx = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.zzhgx.run();
                return null;
            }
        }, zzdvw);
    }
}
