package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
public final class zzckc implements zzelo<Set<zzbys<zzdpl>>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzcks> zzfmx;

    private zzckc(zzelx<Executor> zzelx, zzelx<zzcks> zzelx2) {
        this.zzerr = zzelx;
        this.zzfmx = zzelx2;
    }

    public static zzckc zzaf(zzelx<Executor> zzelx, zzelx<zzcks> zzelx2) {
        return new zzckc(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        Set set;
        Executor executor = this.zzerr.get();
        zzcks zzcks = this.zzfmx.get();
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzctk)).booleanValue()) {
            set = Collections.singleton(new zzbys(zzcks, executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzelu.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
