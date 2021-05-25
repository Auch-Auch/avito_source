package com.google.android.gms.internal.ads;
public final class zzbli implements zzelo<zzblf> {
    private final zzelx<zzaya> zzeyo;

    private zzbli(zzelx<zzaya> zzelx) {
        this.zzeyo = zzelx;
    }

    public static zzbli zza(zzelx<zzaya> zzelx) {
        return new zzbli(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzblf(this.zzeyo.get());
    }
}
