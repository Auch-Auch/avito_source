package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbtv implements zzelo<zzbto> {
    private final zzelx<Set<zzbys<zzbtp>>> zzfor;

    private zzbtv(zzelx<Set<zzbys<zzbtp>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbtv zzj(zzelx<Set<zzbys<zzbtp>>> zzelx) {
        return new zzbtv(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbto(this.zzfor.get());
    }
}
