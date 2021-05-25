package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;
public final class zzgt implements Callable<List<zzkt>> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzge zzb;

    public zzgt(zzge zzge, zzn zzn) {
        this.zzb = zzge;
        this.zza = zzn;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzkt> call() throws Exception {
        this.zzb.zza.zzo();
        return this.zzb.zza.zze().zza(this.zza.zza);
    }
}
