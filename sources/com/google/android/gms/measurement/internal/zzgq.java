package com.google.android.gms.measurement.internal;
public final class zzgq implements Runnable {
    private final /* synthetic */ zzkr zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzge zzc;

    public zzgq(zzge zzge, zzkr zzkr, zzn zzn) {
        this.zzc = zzge;
        this.zza = zzkr;
        this.zzb = zzn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzo();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
