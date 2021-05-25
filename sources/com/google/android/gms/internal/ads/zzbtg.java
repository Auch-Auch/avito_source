package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbtg implements zzelo<zzbtf> {
    private final zzelx<Set<zzbys<zzbti>>> zzfor;

    private zzbtg(zzelx<Set<zzbys<zzbti>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbtg zzh(zzelx<Set<zzbys<zzbti>>> zzelx) {
        return new zzbtg(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbtf(this.zzfor.get());
    }
}
