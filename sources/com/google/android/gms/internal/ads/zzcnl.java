package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzcnl implements zzelo<zzcoh> {
    private final zzelx<Context> zzert;

    private zzcnl(zzelx<Context> zzelx) {
        this.zzert = zzelx;
    }

    public static zzcnl zzad(zzelx<Context> zzelx) {
        return new zzcnl(zzelx);
    }

    public static zzcoh zzcf(Context context) {
        return (zzcoh) zzelu.zza(new zzcoh(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzcf(this.zzert.get());
    }
}
