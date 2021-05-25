package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class zzv extends AbstractCollection<V> {
    @NullableDecl
    public final K zza;
    public Collection<V> zzb;
    @NullableDecl
    public final zzv zzc;
    public final /* synthetic */ zzm zzd;
    @NullableDecl
    private final Collection<V> zze;

    public zzv(@NullableDecl zzm zzm, K k, @NullableDecl Collection<V> collection, zzv zzv) {
        Collection<V> collection2;
        this.zzd = zzm;
        this.zza = k;
        this.zzb = collection;
        this.zzc = zzv;
        if (zzv == null) {
            collection2 = null;
        } else {
            collection2 = zzv.zzb;
        }
        this.zze = collection2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(V v) {
        zza();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(v);
        if (add) {
            zzm.zzc(this.zzd);
            if (isEmpty) {
                zzc();
            }
        }
        return add;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends V> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (addAll) {
            zzm.zza(this.zzd, this.zzb.size() - size);
            if (size == 0) {
                zzc();
            }
        }
        return addAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        int size = size();
        if (size != 0) {
            this.zzb.clear();
            zzm.zzb(this.zzd, size);
            zzb();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        zza();
        return this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        zza();
        return this.zzb.containsAll(collection);
    }

    @Override // java.util.Collection, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        zza();
        return this.zzb.equals(obj);
    }

    @Override // java.util.Collection, java.lang.Object
    public int hashCode() {
        zza();
        return this.zzb.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        zza();
        return new zzu(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        zza();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzm.zzb(this.zzd);
            zzb();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            zzm.zza(this.zzd, this.zzb.size() - size);
            zzb();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        zzj.zza(collection);
        int size = size();
        boolean retainAll = this.zzb.retainAll(collection);
        if (retainAll) {
            zzm.zza(this.zzd, this.zzb.size() - size);
            zzb();
        }
        return retainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        zza();
        return this.zzb.size();
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        zza();
        return this.zzb.toString();
    }

    public final void zza() {
        Collection<V> collection;
        zzv zzv = this.zzc;
        if (zzv != null) {
            zzv.zza();
            if (this.zzc.zzb != this.zze) {
                throw new ConcurrentModificationException();
            }
        } else if (this.zzb.isEmpty() && (collection = (Collection) this.zzd.zza.get(this.zza)) != null) {
            this.zzb = collection;
        }
    }

    public final void zzb() {
        zzv zzv = this;
        while (true) {
            zzv zzv2 = zzv.zzc;
            if (zzv2 == null) {
                break;
            }
            zzv = zzv2;
        }
        if (zzv.zzb.isEmpty()) {
            zzv.zzd.zza.remove(zzv.zza);
        }
    }

    public final void zzc() {
        zzv zzv = this;
        while (true) {
            zzv zzv2 = zzv.zzc;
            if (zzv2 != null) {
                zzv = zzv2;
            } else {
                zzv.zzd.zza.put(zzv.zza, zzv.zzb);
                return;
            }
        }
    }
}
