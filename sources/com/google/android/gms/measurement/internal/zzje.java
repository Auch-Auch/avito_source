package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
public final class zzje implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzis zzb;

    public zzje(zzis zzis, zzn zzn) {
        this.zzb = zzis;
        this.zza = zzn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzer zzer = this.zzb.zzb;
        if (zzer == null) {
            this.zzb.zzr().zzf().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzer.zzb(this.zza);
            this.zzb.zzak();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send measurementEnabled to the service", e);
        }
    }
}
