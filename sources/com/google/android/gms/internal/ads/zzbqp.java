package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
public final class zzbqp implements zzelo<zzbqq> {
    private final zzelx<Clock> zzfms;
    private final zzelx<zzaxj> zzfrc;

    private zzbqp(zzelx<Clock> zzelx, zzelx<zzaxj> zzelx2) {
        this.zzfms = zzelx;
        this.zzfrc = zzelx2;
    }

    public static zzbqp zzd(zzelx<Clock> zzelx, zzelx<zzaxj> zzelx2) {
        return new zzbqp(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbqq(this.zzfms.get(), this.zzfrc.get());
    }
}
