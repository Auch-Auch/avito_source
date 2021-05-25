package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Collections;
import java.util.Set;
public final class zzbyd implements zzelo<Set<zzbys<VideoController.VideoLifecycleCallbacks>>> {
    private final zzbxj zzfug;

    private zzbyd(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbyd zzaa(zzbxj zzbxj) {
        return new zzbyd(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
