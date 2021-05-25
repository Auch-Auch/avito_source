package com.google.android.gms.measurement.internal;
public final class zzir implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzin zzb;

    public zzir(zzin zzin, long j) {
        this.zzb = zzin;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zze().zza(this.zza);
        this.zzb.zza = null;
    }
}
