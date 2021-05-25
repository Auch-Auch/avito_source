package com.google.android.gms.internal.ads;
public final class zzcbg implements zzelo<zzcbd> {
    private final zzelx<zzbto> zzfrs;

    private zzcbg(zzelx<zzbto> zzelx) {
        this.zzfrs = zzelx;
    }

    public static zzcbg zzx(zzelx<zzbto> zzelx) {
        return new zzcbg(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcbd(this.zzfrs.get());
    }
}
