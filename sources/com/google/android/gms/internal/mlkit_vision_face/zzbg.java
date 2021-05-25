package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
public abstract class zzbg<E> extends AbstractSet<E> {
    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        zzj.zza(collection);
        if (collection instanceof zzbf) {
            collection = ((zzbf) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= size()) {
            return zzbh.zza(this, collection.iterator());
        }
        Iterator<E> it = iterator();
        zzj.zza(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        return super.retainAll((Collection) zzj.zza(collection));
    }
}
