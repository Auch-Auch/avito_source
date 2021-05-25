package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
public final class zzcea implements zzelo<zzcdy> {
    private final zzelx<zzchc> zzewz;
    private final zzelx<Clock> zzfms;

    public zzcea(zzelx<zzchc> zzelx, zzelx<Clock> zzelx2) {
        this.zzewz = zzelx;
        this.zzfms = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcdy(this.zzewz.get(), this.zzfms.get());
    }
}
