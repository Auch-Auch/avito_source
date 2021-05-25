package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
public final class zzbnm implements zzelo<zzbnk> {
    private final zzelx<Context> zzert;
    private final zzelx<zzbyw> zzewb;
    private final zzelx<zzbpg> zzewy;
    private final zzelx<zzcwz> zzfgv;
    private final zzelx<View> zzflx;
    private final zzelx<zzdkw> zzfoh;
    private final zzelx<zzbfq> zzfoi;
    private final zzelx<zzbpe> zzfoj;
    private final zzelx<zzcdg> zzfok;
    private final zzelx<Executor> zzfol;

    public zzbnm(zzelx<zzbpg> zzelx, zzelx<Context> zzelx2, zzelx<zzdkw> zzelx3, zzelx<View> zzelx4, zzelx<zzbfq> zzelx5, zzelx<zzbpe> zzelx6, zzelx<zzcdg> zzelx7, zzelx<zzbyw> zzelx8, zzelx<zzcwz> zzelx9, zzelx<Executor> zzelx10) {
        this.zzewy = zzelx;
        this.zzert = zzelx2;
        this.zzfoh = zzelx3;
        this.zzflx = zzelx4;
        this.zzfoi = zzelx5;
        this.zzfoj = zzelx6;
        this.zzfok = zzelx7;
        this.zzewb = zzelx8;
        this.zzfgv = zzelx9;
        this.zzfol = zzelx10;
    }

    public static zzbnk zza(zzbpg zzbpg, Context context, zzdkw zzdkw, View view, zzbfq zzbfq, zzbpe zzbpe, zzcdg zzcdg, zzbyw zzbyw, zzeli<zzcwz> zzeli, Executor executor) {
        return new zzbnk(zzbpg, context, zzdkw, view, zzbfq, zzbpe, zzcdg, zzbyw, zzeli, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzewy.get(), this.zzert.get(), this.zzfoh.get(), this.zzflx.get(), this.zzfoi.get(), this.zzfoj.get(), this.zzfok.get(), this.zzewb.get(), zzell.zzat(this.zzfgv), this.zzfol.get());
    }
}
