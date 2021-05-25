package com.google.android.gms.internal.measurement;

import java.io.IOException;
public final class zzjb<K, V> {
    public static <K, V> void zza(zzhi zzhi, zzje<K, V> zzje, K k, V v) throws IOException {
        zzhr.zza(zzhi, zzje.zza, 1, k);
        zzhr.zza(zzhi, zzje.zzc, 2, v);
    }

    public static <K, V> int zza(zzje<K, V> zzje, K k, V v) {
        return zzhr.zza(zzje.zzc, 2, v) + zzhr.zza(zzje.zza, 1, k);
    }
}
