package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
public final class zzbkq implements zzelo<zzdqm> {
    private final zzelx<Context> zzert;

    public zzbkq(zzelx<Context> zzelx) {
        this.zzert = zzelx;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzdqm) zzelu.zza(new zzdqm(this.zzert.get(), zzp.zzld().zzyf()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
