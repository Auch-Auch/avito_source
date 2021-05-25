package com.google.android.gms.measurement.internal;
public final class zzfi implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfj zzb;

    public zzfi(zzfj zzfj, boolean z) {
        this.zzb = zzfj;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}
