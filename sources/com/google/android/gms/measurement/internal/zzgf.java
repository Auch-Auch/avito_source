package com.google.android.gms.measurement.internal;
public final class zzgf implements Runnable {
    private final /* synthetic */ zzhe zza;
    private final /* synthetic */ zzgd zzb;

    public zzgf(zzgd zzgd, zzhe zzhe) {
        this.zzb = zzgd;
        this.zza = zzhe;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
