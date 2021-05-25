package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbxv implements zzelo<Set<zzbys<zzbuo>>> {
    private final zzbxj zzfug;

    private zzbxv(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbxv zzs(zzbxj zzbxj) {
        return new zzbxv(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(this.zzfug.zzakb(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
