package com.google.android.gms.internal.ads;
public final class zzcki implements zzelo<zzckb> {
    private final zzelx<zzdjf> zzeyl;
    private final zzelx<zzto> zzgek;

    private zzcki(zzelx<zzto> zzelx, zzelx<zzdjf> zzelx2) {
        this.zzgek = zzelx;
        this.zzeyl = zzelx2;
    }

    public static zzcki zzag(zzelx<zzto> zzelx, zzelx<zzdjf> zzelx2) {
        return new zzcki(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzckb(this.zzgek.get(), this.zzeyl.get());
    }
}
