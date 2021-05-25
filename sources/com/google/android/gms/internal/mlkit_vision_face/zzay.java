package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
public abstract class zzay<K, V> extends zzbg<Map.Entry<K, V>> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        zza().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object zza = zzax.zza(zza(), key);
            if (zzh.zza(zza, entry.getValue()) && (zza != null || zza().containsKey(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return zza().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (contains(obj)) {
            return zza().keySet().remove(((Map.Entry) obj).getKey());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        try {
            return super.removeAll((Collection) zzj.zza(collection));
        } catch (UnsupportedOperationException unused) {
            return zzbh.zza(this, collection.iterator());
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        int i;
        try {
            return super.retainAll((Collection) zzj.zza(collection));
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size < 3) {
                zzad.zza(size, "expectedSize");
                i = size + 1;
            } else {
                i = size < 1073741824 ? (int) ((((float) size) / 0.75f) + 1.0f) : Integer.MAX_VALUE;
            }
            HashSet hashSet = new HashSet(i);
            for (Object obj : collection) {
                if (contains(obj)) {
                    hashSet.add(((Map.Entry) obj).getKey());
                }
            }
            return zza().keySet().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return zza().size();
    }

    public abstract Map<K, V> zza();
}
