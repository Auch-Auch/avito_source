package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzbik implements zzelo<Context> {
    private final zzbih zzern;

    public zzbik(zzbih zzbih) {
        this.zzern = zzbih;
    }

    public static Context zza(zzbih zzbih) {
        return (Context) zzelu.zza(zzbih.zzade(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzern);
    }
}
