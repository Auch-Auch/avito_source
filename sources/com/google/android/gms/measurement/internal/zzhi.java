package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;
public final class zzhi implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhh zzb;

    public zzhi(zzhh zzhh, AtomicReference atomicReference) {
        this.zzb = zzhh;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Boolean.valueOf(this.zzb.zzt().zzi(this.zzb.zzg().zzab())));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
