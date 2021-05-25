package com.google.android.gms.internal.ads;

import com.avito.android.util.preferences.GeoContract;
import java.util.LinkedHashMap;
public class zzelk<K, V, V2> {
    public final LinkedHashMap<K, zzelx<V>> zziqz;

    public zzelk(int i) {
        this.zziqz = zzelj.zzia(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap<K, com.google.android.gms.internal.ads.zzelx<V>> */
    /* JADX WARN: Multi-variable type inference failed */
    public zzelk<K, V, V2> zza(K k, zzelx<V> zzelx) {
        this.zziqz.put(zzelu.zza(k, "key"), zzelu.zza(zzelx, GeoContract.PROVIDER));
        return this;
    }
}
