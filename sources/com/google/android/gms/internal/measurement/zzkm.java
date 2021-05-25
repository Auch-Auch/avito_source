package com.google.android.gms.internal.measurement;

import a2.b.a.a.a;
import java.util.Map;
public final class zzkm implements Comparable<zzkm>, Map.Entry<K, V> {
    private final K zza;
    private V zzb;
    private final /* synthetic */ zzkd zzc;

    public zzkm(zzkd zzkd, Map.Entry<K, V> entry) {
        this(zzkd, entry.getKey(), entry.getValue());
    }

    private static boolean zza(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzkm zzkm) {
        return ((Comparable) getKey()).compareTo((Comparable) zzkm.getKey());
    }

    @Override // java.lang.Object, java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zza(this.zza, entry.getKey()) && zza(this.zzb, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zza;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.zzb;
    }

    @Override // java.lang.Object, java.util.Map.Entry
    public final int hashCode() {
        K k = this.zza;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.zzb;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzc.zzf();
        V v2 = this.zzb;
        this.zzb = v;
        return v2;
    }

    @Override // java.lang.Object
    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        return a.s2(valueOf2.length() + valueOf.length() + 1, valueOf, "=", valueOf2);
    }

    public zzkm(zzkd zzkd, K k, V v) {
        this.zzc = zzkd;
        this.zza = k;
        this.zzb = v;
    }
}
