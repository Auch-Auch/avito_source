package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbup implements zzelo<zzbun> {
    private final zzelx<Set<zzbys<zzbuo>>> zzfor;

    private zzbup(zzelx<Set<zzbys<zzbuo>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbup zzn(zzelx<Set<zzbys<zzbuo>>> zzelx) {
        return new zzbup(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbun(this.zzfor.get());
    }
}
