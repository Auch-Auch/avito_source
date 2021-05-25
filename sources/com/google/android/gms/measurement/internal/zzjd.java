package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
public final class zzjd implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzis zzc;

    public zzjd(zzis zzis, Bundle bundle, zzn zzn) {
        this.zzc = zzis;
        this.zza = bundle;
        this.zzb = zzn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzer zzer = this.zzc.zzb;
        if (zzer == null) {
            this.zzc.zzr().zzf().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            zzer.zza(this.zza, this.zzb);
        } catch (RemoteException e) {
            this.zzc.zzr().zzf().zza("Failed to send default event parameters to service", e);
        }
    }
}
