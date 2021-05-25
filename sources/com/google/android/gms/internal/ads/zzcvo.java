package com.google.android.gms.internal.ads;
public final class zzcvo implements zzelo<zzcvl> {
    private final zzelx<zzcws> zzgog;

    private zzcvo(zzelx<zzcws> zzelx) {
        this.zzgog = zzelx;
    }

    public static zzcvo zzai(zzelx<zzcws> zzelx) {
        return new zzcvo(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcvl(this.zzgog.get());
    }
}
