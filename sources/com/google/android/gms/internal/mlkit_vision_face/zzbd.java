package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzbd<K, V> extends AbstractMap<K, V> {
    @NullableDecl
    private transient Set<Map.Entry<K, V>> zza;
    @NullableDecl
    private transient Set<K> zzb;
    @NullableDecl
    private transient Collection<V> zzc;

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zza;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> zza2 = zza();
        this.zza = zza2;
        return zza2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.zzb;
        if (set != null) {
            return set;
        }
        zzbb zzbb = new zzbb(this);
        this.zzb = zzbb;
        return zzbb;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzba zzba = new zzba(this);
        this.zzc = zzba;
        return zzba;
    }

    public abstract Set<Map.Entry<K, V>> zza();
}
