package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;
public final class zzhu implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhh zzb;

    public zzhu(zzhh zzhh, AtomicReference atomicReference) {
        this.zzb = zzhh;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Long.valueOf(this.zzb.zzt().zza(this.zzb.zzg().zzab(), zzaq.zzal)));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
