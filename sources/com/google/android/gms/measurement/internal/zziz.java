package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;
public final class zziz implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzis zzc;

    public zziz(zzis zzis, AtomicReference atomicReference, zzn zzn) {
        this.zzc = zzis;
        this.zza = atomicReference;
        this.zzb = zzn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                zzer zzer = this.zzc.zzb;
                if (zzer == null) {
                    this.zzc.zzr().zzf().zza("Failed to get app instance id");
                    return;
                }
                this.zza.set(zzer.zzc(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    this.zzc.zzf().zza(str);
                    this.zzc.zzs().zzj.zza(str);
                }
                this.zzc.zzak();
                this.zza.notify();
            } catch (RemoteException e) {
                this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
            } finally {
                this.zza.notify();
            }
        }
    }
}
