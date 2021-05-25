package com.google.android.gms.internal.ads;
public final class zzdgr implements zzelo<String> {
    private final zzdgo zzgws;

    public zzdgr(zzdgo zzdgo) {
        this.zzgws = zzdgo;
    }

    public static String zzc(zzdgo zzdgo) {
        return (String) zzelu.zza(zzdgo.zzarn(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzc(this.zzgws);
    }
}
