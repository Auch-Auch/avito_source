package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;
public final class zzhw implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhh zzb;

    public zzhw(zzhh zzhh, AtomicReference atomicReference) {
        this.zzb = zzhh;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Double.valueOf(this.zzb.zzt().zzc(this.zzb.zzg().zzab(), zzaq.zzan)));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
