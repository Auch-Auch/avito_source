package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbnq implements zzelo<zzbue> {
    private final zzbnl zzfoq;
    private final zzelx<Set<zzbys<zzbuj>>> zzfor;

    public zzbnq(zzbnl zzbnl, zzelx<Set<zzbys<zzbuj>>> zzelx) {
        this.zzfoq = zzbnl;
        this.zzfor = zzelx;
    }

    public static zzbue zza(zzbnl zzbnl, Set<zzbys<zzbuj>> set) {
        return (zzbue) zzelu.zza(zzbnl.zza(set), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzfoq, this.zzfor.get());
    }
}
