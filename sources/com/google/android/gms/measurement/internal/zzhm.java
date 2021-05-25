package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;
public final class zzhm implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzhh zzc;

    public zzhm(zzhh zzhh, AtomicReference atomicReference, boolean z) {
        this.zzc = zzhh;
        this.zza = atomicReference;
        this.zzb = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzh().zza(this.zza, this.zzb);
    }
}
