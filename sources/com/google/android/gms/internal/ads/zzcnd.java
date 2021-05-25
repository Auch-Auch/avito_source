package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
public final class zzcnd implements zzelo<zzdvt<String>> {
    private final zzelx<Context> zzert;
    private final zzelx<zzeg> zzfly;
    private final zzelx<zzdvw> zzfru;

    private zzcnd(zzelx<zzeg> zzelx, zzelx<Context> zzelx2, zzelx<zzdvw> zzelx3) {
        this.zzfly = zzelx;
        this.zzert = zzelx2;
        this.zzfru = zzelx3;
    }

    public static zzcnd zzo(zzelx<zzeg> zzelx, zzelx<Context> zzelx2, zzelx<zzdvw> zzelx3) {
        return new zzcnd(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzdvt) zzelu.zza(this.zzfru.get().zze(new Callable(this.zzfly.get(), this.zzert.get()) { // from class: com.google.android.gms.internal.ads.zzcne
            private final Context zzcjx;
            private final zzeg zzghi;

            {
                this.zzghi = r1;
                this.zzcjx = r2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzeg zzeg = this.zzghi;
                return zzeg.zzca().zzb(this.zzcjx);
            }
        }), "Cannot return null from a non-@Nullable @Provides method");
    }
}
