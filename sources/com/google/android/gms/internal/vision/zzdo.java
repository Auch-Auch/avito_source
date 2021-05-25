package com.google.android.gms.internal.vision;

import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzdo<K, V> implements zzen<K, V> {
    @NullableDecl
    private transient Map<K, Collection<V>> zzme;

    public boolean containsValue(@NullableDecl Object obj) {
        for (Collection<V> collection : zzcc().values()) {
            if (collection.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzen) {
            return zzcc().equals(((zzen) obj).zzcc());
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return zzcc().hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return zzcc().toString();
    }

    @Override // com.google.android.gms.internal.vision.zzen
    public Map<K, Collection<V>> zzcc() {
        Map<K, Collection<V>> map = this.zzme;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> zzcd = zzcd();
        this.zzme = zzcd;
        return zzcd;
    }

    public abstract Map<K, Collection<V>> zzcd();
}
