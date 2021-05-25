package com.google.android.gms.measurement.internal;
public final class zzho implements Runnable {
    private final /* synthetic */ zzhc zza;
    private final /* synthetic */ zzhh zzb;

    public zzho(zzhh zzhh, zzhc zzhc) {
        this.zzb = zzhh;
        this.zza = zzhc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
    }
}
