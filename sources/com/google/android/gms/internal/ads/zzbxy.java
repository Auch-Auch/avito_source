package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbxy implements zzelo<Set<zzbys<zzbuy>>> {
    private final zzbxj zzfug;

    private zzbxy(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbxy zzv(zzbxj zzbxj) {
        return new zzbxy(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(this.zzfug.zzakc(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
