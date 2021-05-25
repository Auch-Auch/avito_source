package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzcnm implements zzelo<String> {
    private final zzelx<Context> zzert;

    private zzcnm(zzelx<Context> zzelx) {
        this.zzert = zzelx;
    }

    public static zzcnm zzae(zzelx<Context> zzelx) {
        return new zzcnm(zzelx);
    }

    public static String zzcg(Context context) {
        return (String) zzelu.zza(context.getPackageName(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzcg(this.zzert.get());
    }
}
