package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbtn implements zzelo<zzbtl> {
    private final zzelx<Set<zzbys<zzbtm>>> zzfor;

    private zzbtn(zzelx<Set<zzbys<zzbtm>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbtn zzi(zzelx<Set<zzbys<zzbtm>>> zzelx) {
        return new zzbtn(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbtl(this.zzfor.get());
    }
}
