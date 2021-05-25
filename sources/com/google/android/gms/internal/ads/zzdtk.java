package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzdtk<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzhnd = new Map.Entry[0];
    private transient zzdtn<Map.Entry<K, V>> zzhne;
    private transient zzdtn<K> zzhnf;
    private transient zzdtf<V> zzhng;

    public static <K, V> zzdtk<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        zzdta.zzb(k, v);
        zzdta.zzb(k2, v2);
        zzdta.zzb(k3, v3);
        zzdta.zzb(k4, v4);
        zzdta.zzb(k5, v5);
        return zzdtt.zzc(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    public static <K, V> zzdtk<K, V> zzc(K k, V v) {
        zzdta.zzb(k, v);
        return zzdtt.zzc(1, new Object[]{k, v});
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzdtf) values()).contains(obj);
    }

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        zzdtn<Map.Entry<K, V>> zzdtn = this.zzhne;
        if (zzdtn != null) {
            return zzdtn;
        }
        zzdtn<Map.Entry<K, V>> zzawu = zzawu();
        this.zzhne = zzawu;
        return zzawu;
    }

    @Override // java.lang.Object, java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        return zzdtz.zzg((zzdtn) entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public /* synthetic */ Set keySet() {
        zzdtn<K> zzdtn = this.zzhnf;
        if (zzdtn != null) {
            return zzdtn;
        }
        zzdtn<K> zzawv = zzawv();
        this.zzhnf = zzawv;
        return zzawv;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Object
    public String toString() {
        int size = size();
        zzdta.zzh(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append((Object) entry.getKey());
            sb.append('=');
            sb.append((Object) entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        zzdtf<V> zzdtf = this.zzhng;
        if (zzdtf != null) {
            return zzdtf;
        }
        zzdtf<V> zzaww = zzaww();
        this.zzhng = zzaww;
        return zzaww;
    }

    public abstract zzdtn<Map.Entry<K, V>> zzawu();

    public abstract zzdtn<K> zzawv();

    public abstract zzdtf<V> zzaww();
}
