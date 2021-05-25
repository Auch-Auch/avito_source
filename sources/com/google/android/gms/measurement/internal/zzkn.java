package com.google.android.gms.measurement.internal;
public final class zzkn implements Runnable {
    private final /* synthetic */ zzkq zza;
    private final /* synthetic */ zzkk zzb;

    public zzkn(zzkk zzkk, zzkq zzkq) {
        this.zzb = zzkk;
        this.zza = zzkq;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
