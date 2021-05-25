package com.google.android.gms.measurement.internal;
public final class zzjo implements Runnable {
    private final /* synthetic */ zzer zza;
    private final /* synthetic */ zzjn zzb;

    public zzjo(zzjn zzjn, zzer zzer) {
        this.zzb = zzjn;
        this.zza = zzer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            zzjn.zza(this.zzb, false);
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzw().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
