package com.google.android.gms.internal.measurement;

import a2.b.a.a.a;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzer<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zza = new Object[0];

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public abstract boolean contains(@NullableDecl Object obj);

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(zza);
    }

    public int zzb(Object[] objArr, int i) {
        zzfz zzfz = (zzfz) iterator();
        while (zzfz.hasNext()) {
            objArr[i] = zzfz.next();
            i++;
        }
        return i;
    }

    /* renamed from: zzb */
    public abstract zzfz<E> iterator();

    public zzeq<E> zzc() {
        return isEmpty() ? zzeq.zza() : zzeq.zza(toArray());
    }

    @NullableDecl
    public Object[] zze() {
        return null;
    }

    public int zzf() {
        throw new UnsupportedOperationException();
    }

    public int zzg() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean zzh();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        zzdq.zza(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zze = zze();
            if (zze != null) {
                return (T[]) Arrays.copyOfRange(zze, zzf(), zzg(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) a.k2(tArr, size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zzb(tArr, 0);
        return tArr;
    }
}
