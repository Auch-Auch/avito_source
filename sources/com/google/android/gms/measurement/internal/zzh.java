package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;
public final class zzh implements Runnable {
    private final /* synthetic */ zzw zza;
    private final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzw;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzw().zza(this.zza);
    }
}
