package com.google.android.gms.vision.clearcut;

import com.google.android.gms.internal.vision.zzfl;
public final class zza implements Runnable {
    private final /* synthetic */ int zzby;
    private final /* synthetic */ zzfl.zzo zzbz;
    private final /* synthetic */ DynamiteClearcutLogger zzca;

    public zza(DynamiteClearcutLogger dynamiteClearcutLogger, int i, zzfl.zzo zzo) {
        this.zzca = dynamiteClearcutLogger;
        this.zzby = i;
        this.zzbz = zzo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DynamiteClearcutLogger.zza(this.zzca).zzb(this.zzby, this.zzbz);
    }
}
