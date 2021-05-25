package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;
public final class zzdal implements zzden<zzdek<Bundle>> {
    private final Executor executor;
    private final zzaxk zzbps;

    public zzdal(Executor executor2, zzaxk zzaxk) {
        this.executor = executor2;
        this.zzbps = zzaxk;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdek<Bundle>> zzaqs() {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcqq)).booleanValue()) {
            return zzdvl.zzaf(null);
        }
        return zzdvl.zzb(this.zzbps.zzwk(), zzdak.zzdwg, this.executor);
    }
}
