package com.google.android.gms.measurement.internal;
public final class zzju implements Runnable {
    private final /* synthetic */ zzkk zza;
    private final /* synthetic */ Runnable zzb;

    public zzju(zzjt zzjt, zzkk zzkk, Runnable runnable) {
        this.zza = zzkk;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzo();
        this.zza.zza(this.zzb);
        this.zza.zzl();
    }
}
