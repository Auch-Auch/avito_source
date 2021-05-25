package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
public final class zzgg implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzge zzb;

    public zzgg(zzge zzge, zzn zzn) {
        this.zzb = zzge;
        this.zza = zzn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        zzkk zzkk = this.zzb.zza;
        zzn zzn = this.zza;
        zzkk.zzq().zzd();
        zzkk.zzk();
        Preconditions.checkNotEmpty(zzn.zza);
        zzkk.zzc(zzn);
    }
}
