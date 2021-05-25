package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbyy implements zzelo<zzbyw> {
    private final zzelx<Set<zzbys<zzbyx>>> zzfor;

    private zzbyy(zzelx<Set<zzbys<zzbyx>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbyy zzu(zzelx<Set<zzbys<zzbyx>>> zzelx) {
        return new zzbyy(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbyw(this.zzfor.get());
    }
}
