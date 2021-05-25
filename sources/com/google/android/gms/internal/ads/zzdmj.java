package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdmj implements zzelo<zzdmk> {
    private final zzelx<Context> zzert;
    private final zzelx<zzaxv> zzeyd;

    private zzdmj(zzelx<Context> zzelx, zzelx<zzaxv> zzelx2) {
        this.zzert = zzelx;
        this.zzeyd = zzelx2;
    }

    public static zzdmj zzbj(zzelx<Context> zzelx, zzelx<zzaxv> zzelx2) {
        return new zzdmj(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdmk(this.zzert.get(), this.zzeyd.get());
    }
}
