package com.google.android.gms.internal.ads;
public final class zzckx implements zzelo<zzcky> {
    private final zzelx<zzcln> zzesn;
    private final zzelx<zzclg> zzeyr;

    private zzckx(zzelx<zzclg> zzelx, zzelx<zzcln> zzelx2) {
        this.zzeyr = zzelx;
        this.zzesn = zzelx2;
    }

    public static zzckx zzai(zzelx<zzclg> zzelx, zzelx<zzcln> zzelx2) {
        return new zzckx(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcky(this.zzeyr.get(), this.zzesn.get());
    }
}
