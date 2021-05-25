package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzbqt implements zzelo<zzbys<zzbti>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzbln> zzfnr;

    private zzbqt(zzelx<zzbln> zzelx, zzelx<Executor> zzelx2) {
        this.zzfnr = zzelx;
        this.zzerr = zzelx2;
    }

    public static zzbqt zzg(zzelx<zzbln> zzelx, zzelx<Executor> zzelx2) {
        return new zzbqt(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfnr.get(), this.zzerr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
