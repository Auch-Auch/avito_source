package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
public final class zzccj implements zzelo<zzbmj> {
    private final zzelx<Executor> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<Clock> zzfms;
    private final zzelx<zzqo> zzfwu;

    public zzccj(zzelx<zzqo> zzelx, zzelx<Executor> zzelx2, zzelx<Context> zzelx3, zzelx<Clock> zzelx4) {
        this.zzfwu = zzelx;
        this.zzerr = zzelx2;
        this.zzert = zzelx3;
        this.zzfms = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbmj) zzelu.zza(new zzbmj(this.zzerr.get(), new zzbly(this.zzert.get(), this.zzfwu.get()), this.zzfms.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
