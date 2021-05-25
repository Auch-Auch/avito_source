package com.google.android.gms.internal.ads;
public final class zzczo implements zzelo<zzczp> {
    private final zzelx<zzdln> zzfos;

    private zzczo(zzelx<zzdln> zzelx) {
        this.zzfos = zzelx;
    }

    public static zzczo zzak(zzelx<zzdln> zzelx) {
        return new zzczo(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzczp(this.zzfos.get());
    }
}
