package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;
public final class zzcca implements zzahf<Object> {
    private WeakReference<zzcbv> zzfwm;

    private zzcca(zzcbv zzcbv) {
        this.zzfwm = new WeakReference<>(zzcbv);
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zza(Object obj, Map<String, String> map) {
        zzcbv zzcbv = this.zzfwm.get();
        if (zzcbv != null) {
            zzcbv.zzfvu.onAdImpression();
        }
    }
}
