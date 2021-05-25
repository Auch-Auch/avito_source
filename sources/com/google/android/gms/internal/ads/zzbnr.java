package com.google.android.gms.internal.ads;
public final class zzbnr implements zzelo<zzbpe> {
    private final zzbnl zzfoq;

    public zzbnr(zzbnl zzbnl) {
        this.zzfoq = zzbnl;
    }

    public static zzbpe zzb(zzbnl zzbnl) {
        return (zzbpe) zzelu.zza(zzbnl.zzahy(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzb(this.zzfoq);
    }
}
