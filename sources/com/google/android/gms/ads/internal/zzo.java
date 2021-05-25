package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzed;
import com.google.android.gms.internal.ads.zzeg;
import java.util.concurrent.Callable;
public final class zzo implements Callable<zzeg> {
    private final /* synthetic */ zzj zzbpi;

    public zzo(zzj zzj) {
        this.zzbpi = zzj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzeg call() throws Exception {
        return new zzeg(zzed.zzb(this.zzbpi.zzbpa.zzbra, this.zzbpi.zzvr, false));
    }
}
