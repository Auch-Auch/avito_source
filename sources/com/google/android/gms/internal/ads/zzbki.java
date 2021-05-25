package com.google.android.gms.internal.ads;
public final class zzbki implements zzelo<zzamh> {
    private final zzbke zzfkj;

    public zzbki(zzbke zzbke) {
        this.zzfkj = zzbke;
    }

    public static zzamh zzb(zzbke zzbke) {
        return (zzamh) zzelu.zza(zzbke.zzaei(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzb(this.zzfkj);
    }
}
