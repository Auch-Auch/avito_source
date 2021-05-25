package com.google.android.gms.measurement.internal;
public final class zzgs implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzge zzb;

    public zzgs(zzge zzge, zzn zzn) {
        this.zzb = zzge;
        this.zza = zzn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zzb(this.zza);
    }
}
