package com.google.android.gms.internal.ads;
public final class zzbmf implements zzelo<zzalz> {
    private final zzelx<zzalu> zzfnb;

    private zzbmf(zzelx<zzalu> zzelx) {
        this.zzfnb = zzelx;
    }

    public static zzbmf zzb(zzelx<zzalu> zzelx) {
        return new zzbmf(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzalz) zzelu.zza(this.zzfnb.get().zztl(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
