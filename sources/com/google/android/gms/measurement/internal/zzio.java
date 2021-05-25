package com.google.android.gms.measurement.internal;
public final class zzio implements Runnable {
    private final /* synthetic */ zzin zza;

    public zzio(zzin zzin) {
        this.zza = zzin;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzin zzin = this.zza;
        zzin.zza = zzin.zzh;
    }
}
