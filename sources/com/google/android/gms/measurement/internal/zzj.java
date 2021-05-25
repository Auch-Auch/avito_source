package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;
public final class zzj implements Runnable {
    private final /* synthetic */ zzw zza;
    private final /* synthetic */ zzao zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    public zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw, zzao zzao, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzw;
        this.zzb = zzao;
        this.zzc = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza.zzw().zza(this.zza, this.zzb, this.zzc);
    }
}
