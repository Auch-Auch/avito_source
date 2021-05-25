package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzeb<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzmu = new Object[0];

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
        return toArray(zzmu);
    }

    public int zza(Object[] objArr, int i) {
        zzfa zzfa = (zzfa) iterator();
        while (zzfa.hasNext()) {
            objArr[i] = zzfa.next();
            i++;
        }
        return i;
    }

    /* renamed from: zzcp */
    public abstract zzfa<E> iterator();

    @NullableDecl
    public Object[] zzcq() {
        return null;
    }

    public int zzcr() {
        throw new UnsupportedOperationException();
    }

    public int zzcs() {
        throw new UnsupportedOperationException();
    }

    public zzee<E> zzct() {
        return isEmpty() ? zzee.zzcv() : zzee.zza(toArray());
    }

    public abstract boolean zzcu();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        zzde.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzcq = zzcq();
            if (zzcq != null) {
                return (T[]) Arrays.copyOfRange(zzcq, zzcr(), zzcs(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) a.k2(tArr, size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }
}
