package com.google.android.gms.measurement.internal;
public final class zzia implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhh zzb;

    public zzia(zzhh zzhh, long j) {
        this.zzb = zzhh;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzs().zzk.zza(this.zza);
        this.zzb.zzr().zzw().zza("Minimum session duration set", Long.valueOf(this.zza));
    }
}
