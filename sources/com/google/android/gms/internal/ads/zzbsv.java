package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbsv implements zzelo<zzbst> {
    private final zzelx<Set<zzbys<zzut>>> zzfor;

    private zzbsv(zzelx<Set<zzbys<zzut>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbsv zzg(zzelx<Set<zzbys<zzut>>> zzelx) {
        return new zzbsv(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbst(this.zzfor.get());
    }
}
