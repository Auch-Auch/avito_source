package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzm<K, V> extends zzy<K, V> implements Serializable {
    private transient Map<K, Collection<V>> zza;
    private transient int zzb;

    public zzm(Map<K, Collection<V>> map) {
        if (map.isEmpty()) {
            this.zza = map;
            return;
        }
        throw new IllegalArgumentException();
    }

    public abstract Collection<V> zza();

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzy, com.google.android.gms.internal.mlkit_vision_face.zzbc
    public boolean zza(@NullableDecl K k, @NullableDecl V v) {
        Collection<V> collection = this.zza.get(k);
        if (collection == null) {
            Collection<V> zza2 = zza();
            if (zza2.add(v)) {
                this.zzb++;
                this.zza.put(k, zza2);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.zzb++;
            return true;
        }
    }

    public void zzb() {
        for (Collection<V> collection : this.zza.values()) {
            collection.clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzy
    public final Set<K> zzc() {
        return new zzq(this, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzy
    public final Map<K, Collection<V>> zzd() {
        return new zzp(this, this.zza);
    }

    /* access modifiers changed from: private */
    public final void zzc(Object obj) {
        Collection collection = (Collection) zzax.zzc(this.zza, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.zzb -= size;
        }
    }

    /* access modifiers changed from: private */
    public static <E> Iterator<E> zzb(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    public static /* synthetic */ int zzc(zzm zzm) {
        int i = zzm.zzb;
        zzm.zzb = i + 1;
        return i;
    }

    public static /* synthetic */ int zzb(zzm zzm) {
        int i = zzm.zzb;
        zzm.zzb = i - 1;
        return i;
    }

    public static /* synthetic */ int zzb(zzm zzm, int i) {
        int i2 = zzm.zzb - i;
        zzm.zzb = i2;
        return i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbc
    public Collection<V> zza(@NullableDecl K k) {
        Collection<V> collection = this.zza.get(k);
        if (collection == null) {
            collection = zza();
        }
        return zza((zzm<K, V>) k, (Collection) collection);
    }

    public Collection<V> zza(@NullableDecl K k, Collection<V> collection) {
        return new zzv(this, k, collection, null);
    }

    public final List<V> zza(@NullableDecl K k, List<V> list, @NullableDecl zzv zzv) {
        if (list instanceof RandomAccess) {
            return new zzs(this, k, list, zzv);
        }
        return new zzx(this, k, list, zzv);
    }

    public static /* synthetic */ int zza(zzm zzm, int i) {
        int i2 = zzm.zzb + i;
        zzm.zzb = i2;
        return i2;
    }
}
