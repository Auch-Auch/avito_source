package com.google.android.gms.measurement.internal;
public final class zzgj implements Runnable {
    private final /* synthetic */ zzw zza;
    private final /* synthetic */ zzge zzb;

    public zzgj(zzge zzge, zzw zzw) {
        this.zzb = zzge;
        this.zza = zzw;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzb(this.zza);
        } else {
            this.zzb.zza.zza(this.zza);
        }
    }
}
