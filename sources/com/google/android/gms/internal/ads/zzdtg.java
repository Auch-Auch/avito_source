package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzdtg<E> extends zzdtf<E> implements List<E>, RandomAccess {
    private static final zzdua<Object> zzhnb = new zzdti(zzdtq.zzhnm, 0);

    public static <E> zzdtg<E> zzac(E e) {
        Object[] objArr = {e};
        for (int i = 0; i <= 0; i++) {
            zzdtr.zzd(objArr[0], 0);
        }
        return zzb(objArr, 1);
    }

    public static <E> zzdtg<E> zzawt() {
        return (zzdtg<E>) zzdtq.zzhnm;
    }

    public static <E> zzdtg<E> zzb(E[] eArr) {
        if (eArr.length == 0) {
            return (zzdtg<E>) zzdtq.zzhnm;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            zzdtr.zzd(objArr[i], i);
        }
        return zzb(objArr, objArr.length);
    }

    public static <E> zzdtg<E> zzc(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    public static <E> zzdtg<E> zzh(Iterable<? extends E> iterable) {
        zzdsv.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection instanceof zzdtf) {
                zzdtg<E> zzawr = ((zzdtf) collection).zzawr();
                if (!zzawr.zzaws()) {
                    return zzawr;
                }
                Object[] array = zzawr.toArray();
                return zzb(array, array.length);
            }
            Object[] array2 = collection.toArray();
            int length = array2.length;
            for (int i = 0; i < length; i++) {
                zzdtr.zzd(array2[i], i);
            }
            return zzb(array2, array2.length);
        }
        Iterator<? extends E> it = iterable.iterator();
        if (!it.hasNext()) {
            return (zzdtg<E>) zzdtq.zzhnm;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return zzac(next);
        }
        zzdtj zzdtj = (zzdtj) ((zzdtj) new zzdtj().zzab(next)).zza(it);
        zzdtj.zzhmz = true;
        return zzb(zzdtj.zzhmy, zzdtj.size);
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

    @Override // com.google.android.gms.internal.ads.zzdtf, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzdsv.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzdss.equal(get(i), list.get(i))) {
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
                        if (!zzdss.equal(e, it.next())) {
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
        zzdsv.zzt(i, size());
        if (isEmpty()) {
            return zzhnb;
        }
        return new zzdti(this, i);
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

    @Override // com.google.android.gms.internal.ads.zzdtf
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    /* renamed from: zzawn */
    public final zzdub<E> iterator() {
        return (zzdua) listIterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final zzdtg<E> zzawr() {
        return this;
    }

    /* renamed from: zzu */
    public zzdtg<E> subList(int i, int i2) {
        zzdsv.zzf(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? (zzdtg<E>) zzdtq.zzhnm : new zzdtl(this, i, i3);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzdua) listIterator(0);
    }

    public static <E> zzdtg<E> zzb(Object[] objArr, int i) {
        return i == 0 ? (zzdtg<E>) zzdtq.zzhnm : new zzdtq(objArr, i);
    }
}
