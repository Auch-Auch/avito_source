package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
public final class zzkb {
    public final /* synthetic */ zzjw zza;
    private zzka zzb;

    public zzkb(zzjw zzjw) {
        this.zza = zzjw;
    }

    @WorkerThread
    public final void zza() {
        this.zza.zzd();
        if (this.zza.zzt().zza(zzaq.zzbo) && this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
        if (this.zza.zzt().zza(zzaq.zzcc)) {
            this.zza.zzs().zzr.zza(false);
        }
    }

    @WorkerThread
    public final void zza(long j) {
        if (this.zza.zzt().zza(zzaq.zzbo)) {
            this.zzb = new zzka(this, this.zza.zzm().currentTimeMillis(), j);
            this.zza.zzc.postDelayed(this.zzb, 2000);
        }
    }
}
