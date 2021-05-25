package com.google.android.gms.measurement.internal;
public final class zzhz implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhh zzb;

    public zzhz(zzhh zzhh, boolean z) {
        this.zzb = zzhh;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
