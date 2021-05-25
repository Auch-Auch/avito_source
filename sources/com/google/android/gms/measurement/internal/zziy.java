package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;
public final class zziy implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzw zzb;
    private final /* synthetic */ zzis zzc;

    public zziy(zzis zzis, zzn zzn, zzw zzw) {
        this.zzc = zzis;
        this.zza = zzn;
        this.zzb = zzw;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = null;
        try {
            zzer zzer = this.zzc.zzb;
            if (zzer == null) {
                this.zzc.zzr().zzf().zza("Failed to get app instance id");
                return;
            }
            String zzc2 = zzer.zzc(this.zza);
            if (zzc2 != null) {
                this.zzc.zzf().zza(zzc2);
                this.zzc.zzs().zzj.zza(zzc2);
            }
            this.zzc.zzak();
            this.zzc.zzp().zza(this.zzb, zzc2);
        } catch (RemoteException e) {
            this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
        } finally {
            this.zzc.zzp().zza(this.zzb, str);
        }
    }
}
