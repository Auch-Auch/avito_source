package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbyp implements zzelo<zzbyo> {
    private final zzelx<Set<zzbys<zzbyl>>> zzfor;

    private zzbyp(zzelx<Set<zzbys<zzbyl>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbyp zzt(zzelx<Set<zzbys<zzbyl>>> zzelx) {
        return new zzbyp(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbyo(this.zzfor.get());
    }
}
