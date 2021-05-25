package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzy<K, V> implements zzbc<K, V> {
    @NullableDecl
    private transient Set<K> zza;
    @NullableDecl
    private transient Map<K, Collection<V>> zzb;

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbc) {
            return zzg().equals(((zzbc) obj).zzg());
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return zzg().hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return zzg().toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbc
    public boolean zza(@NullableDecl K k, @NullableDecl V v) {
        return zza(k).add(v);
    }

    public abstract Set<K> zzc();

    public abstract Map<K, Collection<V>> zzd();

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbc
    public Set<K> zzf() {
        Set<K> set = this.zza;
        if (set != null) {
            return set;
        }
        Set<K> zzc = zzc();
        this.zza = zzc;
        return zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbc
    public Map<K, Collection<V>> zzg() {
        Map<K, Collection<V>> map = this.zzb;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> zzd = zzd();
        this.zzb = zzd;
        return zzd;
    }
}
