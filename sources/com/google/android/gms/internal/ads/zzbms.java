package com.google.android.gms.internal.ads;

import android.view.View;
public final class zzbms implements zzelo<View> {
    private final zzbmp zzfnq;

    public zzbms(zzbmp zzbmp) {
        this.zzfnq = zzbmp;
    }

    public static View zza(zzbmp zzbmp) {
        return (View) zzelu.zza(zzbmp.zzahf(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzfnq);
    }
}
