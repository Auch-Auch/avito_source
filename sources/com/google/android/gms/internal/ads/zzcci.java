package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
public final class zzcci implements zzelo<zzbyr> {
    private final zzelx<Context> zzert;
    private final zzelx<zzdkx> zzfpe;

    public zzcci(zzelx<Context> zzelx, zzelx<zzdkx> zzelx2) {
        this.zzert = zzelx;
        this.zzfpe = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbyr) zzelu.zza(new zzbyr(this.zzert.get(), new HashSet(), this.zzfpe.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
