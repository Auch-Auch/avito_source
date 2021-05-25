package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;
public final class zzix implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzis zzd;

    public zzix(zzis zzis, AtomicReference atomicReference, zzn zzn, boolean z) {
        this.zzd = zzis;
        this.zza = atomicReference;
        this.zzb = zzn;
        this.zzc = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                zzer zzer = this.zzd.zzb;
                if (zzer == null) {
                    this.zzd.zzr().zzf().zza("Failed to get all user properties; not connected to service");
                    return;
                }
                this.zza.set(zzer.zza(this.zzb, this.zzc));
                this.zzd.zzak();
                this.zza.notify();
            } catch (RemoteException e) {
                this.zzd.zzr().zzf().zza("Failed to get all user properties; remote exception", e);
            } finally {
                this.zza.notify();
            }
        }
    }
}
