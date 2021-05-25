package com.google.android.gms.measurement.internal;
public final class zzgm implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzge zzb;

    public zzgm(zzge zzge, zzn zzn) {
        this.zzb = zzge;
        this.zza = zzn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zza(this.zza);
    }
}
