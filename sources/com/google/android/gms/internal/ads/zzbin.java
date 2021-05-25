package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
public final class zzbin implements zzelo<WeakReference<Context>> {
    private final zzbih zzern;

    public zzbin(zzbih zzbih) {
        this.zzern = zzbih;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (WeakReference) zzelu.zza(this.zzern.zzadf(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
