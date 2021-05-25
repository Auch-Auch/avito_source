package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzdtf<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzhna = new Object[0];

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

    @Override // java.util.AbstractCollection, java.util.Collection
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
        return toArray(zzhna);
    }

    public int zza(Object[] objArr, int i) {
        zzdub zzdub = (zzdub) iterator();
        while (zzdub.hasNext()) {
            objArr[i] = zzdub.next();
            i++;
        }
        return i;
    }

    /* renamed from: zzawn */
    public abstract zzdub<E> iterator();

    @NullableDecl
    public Object[] zzawo() {
        return null;
    }

    public int zzawp() {
        throw new UnsupportedOperationException();
    }

    public int zzawq() {
        throw new UnsupportedOperationException();
    }

    public zzdtg<E> zzawr() {
        return isEmpty() ? zzdtg.zzawt() : zzdtg.zzc(toArray());
    }

    public abstract boolean zzaws();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        zzdsv.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzawo = zzawo();
            if (zzawo != null) {
                return (T[]) Arrays.copyOfRange(zzawo, zzawp(), zzawq(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) a.k2(tArr, size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }
}
