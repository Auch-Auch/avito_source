package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
public final class zzjh implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzao zzc;
    private final /* synthetic */ zzn zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzis zzf;

    public zzjh(zzis zzis, boolean z, boolean z2, zzao zzao, zzn zzn, String str) {
        this.zzf = zzis;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzao;
        this.zzd = zzn;
        this.zze = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzer zzer = this.zzf.zzb;
        if (zzer == null) {
            this.zzf.zzr().zzf().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzer, this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    zzer.zza(this.zzc, this.zzd);
                } else {
                    zzer.zza(this.zzc, this.zze, this.zzf.zzr().zzy());
                }
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("Failed to send event to the service", e);
            }
        }
        this.zzf.zzak();
    }
}
