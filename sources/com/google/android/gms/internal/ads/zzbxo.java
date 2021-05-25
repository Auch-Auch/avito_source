package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Collections;
import java.util.Set;
public final class zzbxo implements zzelo<Set<zzbys<zzo>>> {
    private final zzbxj zzfug;

    private zzbxo(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbxo zzk(zzbxj zzbxj) {
        return new zzbxo(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
