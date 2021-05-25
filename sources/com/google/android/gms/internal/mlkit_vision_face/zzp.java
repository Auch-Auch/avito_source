package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzp extends zzbd<K, Collection<V>> {
    public final transient Map<K, Collection<V>> zza;
    public final /* synthetic */ zzm zzb;

    public zzp(zzm zzm, Map<K, Collection<V>> map) {
        this.zzb = zzm;
        this.zza = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (this.zza == this.zzb.zza) {
            this.zzb.zzb();
        } else {
            zzav.zza(new zzr(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return zzax.zzb(this.zza, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.lang.Object
    public final boolean equals(@NullableDecl Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) zzax.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zza((zzm) obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.lang.Object
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbd, java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        return this.zzb.zzf();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object remove(Object obj) {
        Collection<V> remove = this.zza.remove(obj);
        if (remove == null) {
            return null;
        }
        Collection zza2 = this.zzb.zza();
        zza2.addAll(remove);
        zzm.zzb(this.zzb, remove.size());
        remove.clear();
        return zza2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractMap, java.lang.Object
    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbd
    public final Set<Map.Entry<K, Collection<V>>> zza() {
        return new zzo(this);
    }
}
