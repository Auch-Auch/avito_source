package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;
public final class zzjk implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzn zzd;
    private final /* synthetic */ zzw zze;
    private final /* synthetic */ zzis zzf;

    public zzjk(zzis zzis, String str, String str2, boolean z, zzn zzn, zzw zzw) {
        this.zzf = zzis;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzn;
        this.zze = zzw;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzer zzer = this.zzf.zzb;
            if (zzer == null) {
                this.zzf.zzr().zzf().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Bundle zza2 = zzkw.zza(zzer.zza(this.zza, this.zzb, this.zzc, this.zzd));
            this.zzf.zzak();
            this.zzf.zzp().zza(this.zze, zza2);
        } catch (RemoteException e) {
            this.zzf.zzr().zzf().zza("Failed to get user properties; remote exception", this.zza, e);
        } finally {
            this.zzf.zzp().zza(this.zze, bundle);
        }
    }
}
