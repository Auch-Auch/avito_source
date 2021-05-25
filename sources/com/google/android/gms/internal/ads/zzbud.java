package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbud implements zzelo<zzbtu> {
    private final zzelx<Set<zzbys<zzbsu>>> zzfor;

    private zzbud(zzelx<Set<zzbys<zzbsu>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbud zzk(zzelx<Set<zzbys<zzbsu>>> zzelx) {
        return new zzbud(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbtu(this.zzfor.get());
    }
}
