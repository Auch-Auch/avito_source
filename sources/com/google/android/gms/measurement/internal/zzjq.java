package com.google.android.gms.measurement.internal;
public final class zzjq implements Runnable {
    private final /* synthetic */ zzjn zza;

    public zzjq(zzjn zzjn) {
        this.zza = zzjn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza.zzb = null;
        this.zza.zza.zzan();
    }
}
