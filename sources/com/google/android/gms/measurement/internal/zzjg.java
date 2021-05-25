package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
public final class zzjg implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzw zzc;
    private final /* synthetic */ zzn zzd;
    private final /* synthetic */ zzw zze;
    private final /* synthetic */ zzis zzf;

    public zzjg(zzis zzis, boolean z, boolean z2, zzw zzw, zzn zzn, zzw zzw2) {
        this.zzf = zzis;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzw;
        this.zzd = zzn;
        this.zze = zzw2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzer zzer = this.zzf.zzb;
        if (zzer == null) {
            this.zzf.zzr().zzf().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzer, this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    zzer.zza(this.zzc, this.zzd);
                } else {
                    zzer.zza(this.zzc);
                }
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzak();
    }
}
