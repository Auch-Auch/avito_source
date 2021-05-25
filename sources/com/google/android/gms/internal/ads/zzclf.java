package com.google.android.gms.internal.ads;
public final class zzclf implements zzelo<zzclg> {
    private final zzelx<zzcln> zzesn;

    private zzclf(zzelx<zzcln> zzelx) {
        this.zzesn = zzelx;
    }

    public static zzclf zzab(zzelx<zzcln> zzelx) {
        return new zzclf(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzclg(this.zzesn.get());
    }
}
