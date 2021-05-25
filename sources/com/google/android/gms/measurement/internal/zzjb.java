package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
public final class zzjb implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzis zzb;

    public zzjb(zzis zzis, zzn zzn) {
        this.zzb = zzis;
        this.zza = zzn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzer zzer = this.zzb.zzb;
        if (zzer == null) {
            this.zzb.zzr().zzf().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzer.zza(this.zza);
            this.zzb.zzj().zzad();
            this.zzb.zza(zzer, (AbstractSafeParcelable) null, this.zza);
            this.zzb.zzak();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send app launch to the service", e);
        }
    }
}
