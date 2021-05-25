package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbuc;
public final class zzcvt<AdT, AdapterT, ListenerT extends zzbuc> implements zzelo<zzcvp<AdT, AdapterT, ListenerT>> {
    private final zzelx<zzcrf<AdapterT, ListenerT>> zzfks;
    private final zzelx<zzdvw> zzfol;
    private final zzelx<zzdpf> zzfow;
    private final zzelx<zzcrh<AdT, AdapterT, ListenerT>> zzgok;

    private zzcvt(zzelx<zzdpf> zzelx, zzelx<zzdvw> zzelx2, zzelx<zzcrf<AdapterT, ListenerT>> zzelx3, zzelx<zzcrh<AdT, AdapterT, ListenerT>> zzelx4) {
        this.zzfow = zzelx;
        this.zzfol = zzelx2;
        this.zzfks = zzelx3;
        this.zzgok = zzelx4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbuc> zzcvt<AdT, AdapterT, ListenerT> zzf(zzelx<zzdpf> zzelx, zzelx<zzdvw> zzelx2, zzelx<zzcrf<AdapterT, ListenerT>> zzelx3, zzelx<zzcrh<AdT, AdapterT, ListenerT>> zzelx4) {
        return new zzcvt<>(zzelx, zzelx2, zzelx3, zzelx4);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcvp(this.zzfow.get(), this.zzfol.get(), this.zzfks.get(), this.zzgok.get());
    }
}
