package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
public final class zzbwu implements zzelo<zzbws> {
    private final zzelx<Set<zzbys<AppEventListener>>> zzfor;

    private zzbwu(zzelx<Set<zzbys<AppEventListener>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbwu zzr(zzelx<Set<zzbys<AppEventListener>>> zzelx) {
        return new zzbwu(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbws(this.zzfor.get());
    }
}
