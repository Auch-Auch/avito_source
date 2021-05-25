package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzbiy implements zzelo<zzatd> {
    private final zzelx<Context> zzert;

    public zzbiy(zzelx<Context> zzelx) {
        this.zzert = zzelx;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        Context context = this.zzert.get();
        return (zzatd) zzelu.zza(new zzatb(context, new zzate(context).zzvd()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
