package com.google.android.gms.internal.ads;
public final class zzcqn implements zzelo<zzcqo> {
    private final zzelx<zzcqt> zzgjx;

    private zzcqn(zzelx<zzcqt> zzelx) {
        this.zzgjx = zzelx;
    }

    public static zzcqn zzag(zzelx<zzcqt> zzelx) {
        return new zzcqn(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcqo(this.zzgjx.get());
    }
}
