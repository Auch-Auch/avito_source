package com.google.android.gms.measurement.internal;
public final class zzjz implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjw zzb;

    public zzjz(zzjw zzjw, long j) {
        this.zzb = zzjw;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
