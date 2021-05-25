package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbwn implements zzelo<zzbwl> {
    private final zzelx<Set<zzbys<zzbwm>>> zzfor;

    private zzbwn(zzelx<Set<zzbys<zzbwm>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbwn zzp(zzelx<Set<zzbys<zzbwm>>> zzelx) {
        return new zzbwn(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbwl(this.zzfor.get());
    }
}
