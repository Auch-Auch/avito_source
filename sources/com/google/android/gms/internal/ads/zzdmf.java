package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
public final class zzdmf implements zzelo<Clock> {
    private final zzdmg zzhdb;

    public zzdmf(zzdmg zzdmg) {
        this.zzhdb = zzdmg;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Clock) zzelu.zza(DefaultClock.getInstance(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
