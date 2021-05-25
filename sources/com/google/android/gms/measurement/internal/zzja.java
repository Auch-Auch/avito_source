package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
public final class zzja implements Runnable {
    private final /* synthetic */ zzik zza;
    private final /* synthetic */ zzis zzb;

    public zzja(zzis zzis, zzik zzik) {
        this.zzb = zzis;
        this.zza = zzik;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzer zzer = this.zzb.zzb;
        if (zzer == null) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzik zzik = this.zza;
            if (zzik == null) {
                zzer.zza(0, (String) null, (String) null, this.zzb.zzn().getPackageName());
            } else {
                zzer.zza(zzik.zzc, zzik.zza, zzik.zzb, this.zzb.zzn().getPackageName());
            }
            this.zzb.zzak();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to the service", e);
        }
    }
}
