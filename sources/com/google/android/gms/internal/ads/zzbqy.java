package com.google.android.gms.internal.ads;
public final class zzbqy implements zzelo<zzbpg> {
    private final zzelx<zzbto> zzeuv;
    private final zzelx<zzbvi> zzeuw;
    private final zzelx<zzbue> zzewf;
    private final zzelx<zzdlj> zzflv;
    private final zzelx<zzdkx> zzfpe;
    private final zzelx<zzdiw> zzfre;
    private final zzelx<zzbsp> zzfrf;

    private zzbqy(zzelx<zzdlj> zzelx, zzelx<zzdkx> zzelx2, zzelx<zzbto> zzelx3, zzelx<zzbue> zzelx4, zzelx<zzdiw> zzelx5, zzelx<zzbsp> zzelx6, zzelx<zzbvi> zzelx7) {
        this.zzflv = zzelx;
        this.zzfpe = zzelx2;
        this.zzeuv = zzelx3;
        this.zzewf = zzelx4;
        this.zzfre = zzelx5;
        this.zzfrf = zzelx6;
        this.zzeuw = zzelx7;
    }

    public static zzbqy zza(zzelx<zzdlj> zzelx, zzelx<zzdkx> zzelx2, zzelx<zzbto> zzelx3, zzelx<zzbue> zzelx4, zzelx<zzdiw> zzelx5, zzelx<zzbsp> zzelx6, zzelx<zzbvi> zzelx7) {
        return new zzbqy(zzelx, zzelx2, zzelx3, zzelx4, zzelx5, zzelx6, zzelx7);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbpg(this.zzflv.get(), this.zzfpe.get(), this.zzeuv.get(), this.zzewf.get(), this.zzfre.get(), this.zzfrf.get(), this.zzeuw.get());
    }
}
