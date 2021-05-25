package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzq extends zzbb<K, Collection<V>> {
    public final /* synthetic */ zzm zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzq(zzm zzm, Map<K, Collection<V>> map) {
        super(map);
        this.zza = zzm;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbb, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        zzav.zza(iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        return this.zzb.keySet().containsAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set, java.lang.Object
    public final boolean equals(@NullableDecl Object obj) {
        return this == obj || this.zzb.keySet().equals(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set, java.lang.Object
    public final int hashCode() {
        return this.zzb.keySet().hashCode();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbb, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<K> iterator() {
        return new zzt(this, this.zzb.entrySet().iterator());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbb, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int i;
        V remove = this.zzb.remove(obj);
        if (remove != null) {
            i = remove.size();
            remove.clear();
            zzm.zzb(this.zza, i);
        } else {
            i = 0;
        }
        if (i > 0) {
            return true;
        }
        return false;
    }
}
