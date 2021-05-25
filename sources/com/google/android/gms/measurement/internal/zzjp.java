package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
public final class zzjp implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzjn zzb;

    public zzjp(zzjn zzjn, ComponentName componentName) {
        this.zzb = zzjn;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zza(this.zza);
    }
}
