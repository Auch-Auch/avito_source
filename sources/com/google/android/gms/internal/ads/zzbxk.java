package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbxk implements zzelo<zzbsx> {
    private final zzbxj zzfug;
    private final zzelx<Set<zzbys<zzbsz>>> zzfuh;

    private zzbxk(zzbxj zzbxj, zzelx<Set<zzbys<zzbsz>>> zzelx) {
        this.zzfug = zzbxj;
        this.zzfuh = zzelx;
    }

    public static zzbxk zza(zzbxj zzbxj, zzelx<Set<zzbys<zzbsz>>> zzelx) {
        return new zzbxk(zzbxj, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbsx) zzelu.zza(this.zzfug.zzc(this.zzfuh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
