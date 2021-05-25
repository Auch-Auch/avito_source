package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;
public final class zzhx implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhh zzb;

    public zzhx(zzhh zzhh, AtomicReference atomicReference) {
        this.zzb = zzhh;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Integer.valueOf(this.zzb.zzt().zzb(this.zzb.zzg().zzab(), zzaq.zzam)));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
