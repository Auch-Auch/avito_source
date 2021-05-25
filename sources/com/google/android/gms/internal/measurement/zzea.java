package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzea<K, V> implements zzfg<K, V> {
    @NullableDecl
    private transient Map<K, Collection<V>> zza;

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfg) {
            return zza().equals(((zzfg) obj).zza());
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return zza().hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return zza().toString();
    }

    public boolean zza(@NullableDecl Object obj) {
        for (Collection<V> collection : zza().values()) {
            if (collection.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map<K, Collection<V>> zzb();

    @Override // com.google.android.gms.internal.measurement.zzfg
    public Map<K, Collection<V>> zza() {
        Map<K, Collection<V>> map = this.zza;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> zzb = zzb();
        this.zza = zzb;
        return zzb;
    }
}
