package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzcrx implements zzelo<zzcrv> {
    private final zzelx<Context> zzert;
    private final zzelx<zzbbg> zzfnd;
    private final zzelx<Executor> zzfol;
    private final zzelx<zzboe> zzglj;

    public zzcrx(zzelx<Context> zzelx, zzelx<zzbbg> zzelx2, zzelx<zzboe> zzelx3, zzelx<Executor> zzelx4) {
        this.zzert = zzelx;
        this.zzfnd = zzelx2;
        this.zzglj = zzelx3;
        this.zzfol = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcrv(this.zzert.get(), this.zzfnd.get(), this.zzglj.get(), this.zzfol.get());
    }
}
