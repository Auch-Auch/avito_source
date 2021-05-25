package com.google.android.gms.internal.ads;
public final class zzbks implements zzelo<zzbbh> {
    private final zzelx<String> zzfkv;

    public zzbks(zzelx<String> zzelx) {
        this.zzfkv = zzelx;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbbh) zzelu.zza(new zzbbh(this.zzfkv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
