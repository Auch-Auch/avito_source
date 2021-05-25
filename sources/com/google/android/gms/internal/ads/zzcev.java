package com.google.android.gms.internal.ads;
public final class zzcev implements zzelo<zzcdd> {
    private final zzelx<zzceu> zzfez;
    private final zzcew zzgat;

    public zzcev(zzcew zzcew, zzelx<zzceu> zzelx) {
        this.zzgat = zzcew;
        this.zzfez = zzelx;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzcdd) zzelu.zza(this.zzfez.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
