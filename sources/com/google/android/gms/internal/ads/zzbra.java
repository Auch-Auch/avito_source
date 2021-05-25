package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
public final class zzbra implements zzelo<zza> {
    private final zzelx<Context> zzert;
    private final zzbqx zzfrg;
    private final zzelx<zzavu> zzfrh;

    private zzbra(zzbqx zzbqx, zzelx<Context> zzelx, zzelx<zzavu> zzelx2) {
        this.zzfrg = zzbqx;
        this.zzert = zzelx;
        this.zzfrh = zzelx2;
    }

    public static zzbra zza(zzbqx zzbqx, zzelx<Context> zzelx, zzelx<zzavu> zzelx2) {
        return new zzbra(zzbqx, zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zza) zzelu.zza(new zza(this.zzert.get(), this.zzfrh.get(), null), "Cannot return null from a non-@Nullable @Provides method");
    }
}
