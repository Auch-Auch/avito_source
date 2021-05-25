package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzeq<E> extends zzer<E> implements List<E>, RandomAccess {
    private static final zzfy<Object> zza = new zzet(zzfn.zza, 0);

    public static <E> zzeq<E> zza() {
        return (zzeq<E>) zzfn.zza;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.zzer, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzdq.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzdo.zza(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e = get(i2);
                        i2++;
                        if (!zzdo.zza(e, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~(get(i2).hashCode() + (i * 31)));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i) {
        zzdq.zzb(i, size());
        if (isEmpty()) {
            return zza;
        }
        return new zzet(this, i);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    /* renamed from: zzb */
    public final zzfz<E> iterator() {
        return (zzfy) listIterator();
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final zzeq<E> zzc() {
        return this;
    }

    public zzeq<E> zzd() {
        return size() <= 1 ? this : new zzes(this);
    }

    public static <E> zzeq<E> zza(E e) {
        Object[] objArr = {e};
        for (int i = 0; i < 1; i++) {
            zzfl.zza(objArr[i], i);
        }
        return zza(objArr, 1);
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public int zzb(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public static <E> zzeq<E> zza(Object[] objArr) {
        return zza(objArr, objArr.length);
    }

    public static <E> zzeq<E> zza(Object[] objArr, int i) {
        return i == 0 ? (zzeq<E>) zzfn.zza : new zzfn(objArr, i);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzfy) listIterator(0);
    }

    /* renamed from: zza */
    public zzeq<E> subList(int i, int i2) {
        zzdq.zza(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? (zzeq<E>) zzfn.zza : new zzev(this, i, i3);
    }
}
