package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzcbk implements zzelo<zzcbh> {
    private final zzelx<zzcdg> zzfok;
    private final zzelx<Map<String, zzcre<zzbpj>>> zzfpz;
    private final zzelx<zzbpi<zzbni>> zzfvk;
    private final zzelx<Map<String, zzcre<zzcco>>> zzfvm;
    private final zzelx<Map<String, zzctf<zzcco>>> zzfvn;

    public zzcbk(zzelx<Map<String, zzcre<zzbpj>>> zzelx, zzelx<Map<String, zzcre<zzcco>>> zzelx2, zzelx<Map<String, zzctf<zzcco>>> zzelx3, zzelx<zzbpi<zzbni>> zzelx4, zzelx<zzcdg> zzelx5) {
        this.zzfpz = zzelx;
        this.zzfvm = zzelx2;
        this.zzfvn = zzelx3;
        this.zzfvk = zzelx4;
        this.zzfok = zzelx5;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcbh(this.zzfpz.get(), this.zzfvm.get(), this.zzfvn.get(), this.zzfvk, this.zzfok.get());
    }
}
