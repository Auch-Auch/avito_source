package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
public final class zzo extends zzay<K, Collection<V>> {
    private final /* synthetic */ zzp zza;

    public zzo(zzp zzp) {
        this.zza = zzp;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzay, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return zzac.zza(this.zza.zza.entrySet(), obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, Collection<V>>> iterator() {
        return new zzr(this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzay, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        this.zza.zzb.zzc(((Map.Entry) obj).getKey());
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzay
    public final Map<K, Collection<V>> zza() {
        return this.zza;
    }
}
