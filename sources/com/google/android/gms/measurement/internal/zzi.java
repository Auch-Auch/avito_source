package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;
public final class zzi implements Runnable {
    private final /* synthetic */ zzw zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ AppMeasurementDynamiteService zze;

    public zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw, String str, String str2, boolean z) {
        this.zze = appMeasurementDynamiteService;
        this.zza = zzw;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza.zzw().zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
