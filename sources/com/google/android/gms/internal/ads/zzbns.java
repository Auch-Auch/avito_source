package com.google.android.gms.internal.ads;
public final class zzbns implements zzelo<zzdkw> {
    private final zzbnl zzfoq;

    public zzbns(zzbnl zzbnl) {
        this.zzfoq = zzbnl;
    }

    public static zzdkw zzc(zzbnl zzbnl) {
        return (zzdkw) zzelu.zza(zzbnl.zzahz(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzc(this.zzfoq);
    }
}
