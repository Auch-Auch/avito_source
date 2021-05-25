package com.google.android.gms.internal.ads;

import android.view.View;
public final class zzbnp implements zzelo<View> {
    private final zzbnl zzfoq;

    public zzbnp(zzbnl zzbnl) {
        this.zzfoq = zzbnl;
    }

    public static View zza(zzbnl zzbnl) {
        return (View) zzelu.zza(zzbnl.zzahq(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzfoq);
    }
}
