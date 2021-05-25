package com.google.android.gms.internal.ads;
public final class zzcui implements zzelo<zzcuf> {
    private final zzelx<zzcjd> zzesd;
    private final zzelx<zzdlt> zzetm;
    private final zzelx<zzcli> zzetn;

    private zzcui(zzelx<zzdlt> zzelx, zzelx<zzcjd> zzelx2, zzelx<zzcli> zzelx3) {
        this.zzetm = zzelx;
        this.zzesd = zzelx2;
        this.zzetn = zzelx3;
    }

    public static zzcui zzp(zzelx<zzdlt> zzelx, zzelx<zzcjd> zzelx2, zzelx<zzcli> zzelx3) {
        return new zzcui(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcuf(this.zzetm.get(), this.zzesd.get(), this.zzetn.get());
    }
}
