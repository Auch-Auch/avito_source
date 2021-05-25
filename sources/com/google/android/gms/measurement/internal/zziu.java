package com.google.android.gms.measurement.internal;
public final class zziu implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzkr zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ zzis zzd;

    public zziu(zzis zzis, boolean z, zzkr zzkr, zzn zzn) {
        this.zzd = zzis;
        this.zza = z;
        this.zzb = zzkr;
        this.zzc = zzn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzer zzer = this.zzd.zzb;
        if (zzer == null) {
            this.zzd.zzr().zzf().zza("Discarding data. Failed to set user property");
            return;
        }
        this.zzd.zza(zzer, this.zza ? null : this.zzb, this.zzc);
        this.zzd.zzak();
    }
}
