package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;
public final class zzjc implements Runnable {
    private final /* synthetic */ zzao zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzw zzc;
    private final /* synthetic */ zzis zzd;

    public zzjc(zzis zzis, zzao zzao, String str, zzw zzw) {
        this.zzd = zzis;
        this.zza = zzao;
        this.zzb = str;
        this.zzc = zzw;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArr = null;
        try {
            zzer zzer = this.zzd.zzb;
            if (zzer == null) {
                this.zzd.zzr().zzf().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] zza2 = zzer.zza(this.zza, this.zzb);
            this.zzd.zzak();
            this.zzd.zzp().zza(this.zzc, zza2);
        } catch (RemoteException e) {
            this.zzd.zzr().zzf().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.zzd.zzp().zza(this.zzc, bArr);
        }
    }
}
