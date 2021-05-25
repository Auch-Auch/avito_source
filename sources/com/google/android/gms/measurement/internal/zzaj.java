package com.google.android.gms.measurement.internal;
public final class zzaj implements Runnable {
    private final /* synthetic */ zzgz zza;
    private final /* synthetic */ zzag zzb;

    public zzaj(zzag zzag, zzgz zzgz) {
        this.zzb = zzag;
        this.zza = zzgz;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzu();
        if (zzx.zza()) {
            this.zza.zzq().zza(this);
            return;
        }
        boolean zzb2 = this.zzb.zzb();
        zzag.zza(this.zzb, 0);
        if (zzb2) {
            this.zzb.zza();
        }
    }
}
