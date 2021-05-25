package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
public final class zzka<E> extends zzgi<E> implements RandomAccess {
    private static final zzka<Object> zzabg;
    private int size;
    private E[] zznl;

    static {
        zzka<Object> zzka = new zzka<>(new Object[0], 0);
        zzabg = zzka;
        zzka.zzej();
    }

    public zzka() {
        this(new Object[10], 0);
    }

    private final void zzal(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzam(i));
        }
    }

    private final String zzam(int i) {
        return a.p2(35, "Index:", i, ", Size:", this.size);
    }

    public static <E> zzka<E> zzij() {
        return (zzka<E>) zzabg;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean add(E e) {
        zzek();
        int i = this.size;
        E[] eArr = this.zznl;
        if (i == eArr.length) {
            this.zznl = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zznl;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        zzal(i);
        return this.zznl[i];
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zzek();
        zzal(i);
        E[] eArr = this.zznl;
        E e = eArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        zzek();
        zzal(i);
        E[] eArr = this.zznl;
        E e2 = eArr[i];
        eArr[i] = e;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.vision.zzik
    public final /* synthetic */ zzik zzan(int i) {
        if (i >= this.size) {
            return new zzka(Arrays.copyOf(this.zznl, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzka(E[] eArr, int i) {
        this.zznl = eArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        int i2;
        zzek();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzam(i));
        }
        E[] eArr = this.zznl;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[a.y2(i2, 3, 2, 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zznl, i, eArr2, i + 1, this.size - i);
            this.zznl = eArr2;
        }
        this.zznl[i] = e;
        this.size++;
        ((AbstractList) this).modCount++;
    }
}
