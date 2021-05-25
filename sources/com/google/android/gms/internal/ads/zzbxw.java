package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;
public final class zzbxw implements zzelo<Set<zzbys<AdMetadataListener>>> {
    private final zzbxj zzfug;

    private zzbxw(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbxw zzt(zzbxj zzbxj) {
        return new zzbxw(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(this.zzfug.zzajx(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
