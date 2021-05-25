package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbxc implements zzelo<zzbwx> {
    private final zzelx<Set<zzbys<zzbxf>>> zzfor;

    private zzbxc(zzelx<Set<zzbys<zzbxf>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbxc zzs(zzelx<Set<zzbys<zzbxf>>> zzelx) {
        return new zzbxc(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbwx(this.zzfor.get());
    }
}
