package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbwq implements zzelo<zzbwp> {
    private final zzelx<Set<zzbys<zzbwt>>> zzfor;

    private zzbwq(zzelx<Set<zzbys<zzbwt>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbwq zzq(zzelx<Set<zzbys<zzbwt>>> zzelx) {
        return new zzbwq(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbwp(this.zzfor.get());
    }
}
