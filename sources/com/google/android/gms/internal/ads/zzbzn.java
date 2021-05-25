package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;
public final class zzbzn implements zzelo<zzbzh> {
    private final zzelx<Set<zzbys<VideoController.VideoLifecycleCallbacks>>> zzfor;

    private zzbzn(zzelx<Set<zzbys<VideoController.VideoLifecycleCallbacks>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbzn zzv(zzelx<Set<zzbys<VideoController.VideoLifecycleCallbacks>>> zzelx) {
        return new zzbzn(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbzh(this.zzfor.get());
    }
}
