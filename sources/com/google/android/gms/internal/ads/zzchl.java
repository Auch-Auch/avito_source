package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;
public final class zzchl<T> implements zzahf<Object> {
    private final WeakReference<T> zzgcu;
    private final String zzgcv;
    private final zzahf<T> zzgcw;
    private final /* synthetic */ zzchc zzgcx;

    private zzchl(zzchc zzchc, WeakReference<T> weakReference, String str, zzahf<T> zzahf) {
        this.zzgcx = zzchc;
        this.zzgcu = weakReference;
        this.zzgcv = str;
        this.zzgcw = zzahf;
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zza(Object obj, Map<String, String> map) {
        T t = this.zzgcu.get();
        if (t == null) {
            this.zzgcx.zzb(this.zzgcv, this);
        } else {
            this.zzgcw.zza(t, map);
        }
    }

    public /* synthetic */ zzchl(zzchc zzchc, WeakReference weakReference, String str, zzahf zzahf, zzchd zzchd) {
        this(zzchc, weakReference, str, zzahf);
    }
}
