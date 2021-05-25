package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzbqw implements zzelo<zzbys<zzbtm>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzbln> zzfnr;

    private zzbqw(zzelx<zzbln> zzelx, zzelx<Executor> zzelx2) {
        this.zzfnr = zzelx;
        this.zzerr = zzelx2;
    }

    public static zzbqw zzj(zzelx<zzbln> zzelx, zzelx<Executor> zzelx2) {
        return new zzbqw(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfnr.get(), this.zzerr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
