package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
public final class zzdgq implements zzelo<ApplicationInfo> {
    private final zzdgo zzgws;

    public zzdgq(zzdgo zzdgo) {
        this.zzgws = zzdgo;
    }

    public static ApplicationInfo zzb(zzdgo zzdgo) {
        return (ApplicationInfo) zzelu.zza(zzdgo.zzars(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzb(this.zzgws);
    }
}
