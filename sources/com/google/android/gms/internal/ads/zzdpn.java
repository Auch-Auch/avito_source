package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzdpn implements zzelo<zzdpi> {
    private final zzelx<Set<zzbys<zzdpl>>> zzfor;

    private zzdpn(zzelx<Set<zzbys<zzdpl>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzdpn zzar(zzelx<Set<zzbys<zzdpl>>> zzelx) {
        return new zzdpn(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdpi(this.zzfor.get());
    }
}
