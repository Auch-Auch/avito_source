package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
public final class zziw implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzis zzb;

    public zziw(zzis zzis, zzn zzn) {
        this.zzb = zzis;
        this.zza = zzn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzer zzer = this.zzb.zzb;
        if (zzer == null) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzer.zzd(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzak();
    }
}
