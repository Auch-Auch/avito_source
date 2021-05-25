package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.Map;
public final class zzejf implements Comparable<zzejf>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzeja zzijy;
    private final K zzikc;

    public zzejf(zzeja zzeja, Map.Entry<K, V> entry) {
        this(zzeja, entry.getKey(), entry.getValue());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzejf zzejf) {
        return ((Comparable) getKey()).compareTo((Comparable) zzejf.getKey());
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
        return equals(this.zzikc, entry.getKey()) && equals(this.value, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzikc;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // java.lang.Object, java.util.Map.Entry
    public final int hashCode() {
        K k = this.zzikc;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzijy.zzbht();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    @Override // java.lang.Object
    public final String toString() {
        String valueOf = String.valueOf(this.zzikc);
        String valueOf2 = String.valueOf(this.value);
        return a.s2(valueOf2.length() + valueOf.length() + 1, valueOf, "=", valueOf2);
    }

    public zzejf(zzeja zzeja, K k, V v) {
        this.zzijy = zzeja;
        this.zzikc = k;
        this.value = v;
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
