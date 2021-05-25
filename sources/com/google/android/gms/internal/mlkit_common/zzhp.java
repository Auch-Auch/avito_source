package com.google.android.gms.internal.mlkit_common;

import a2.b.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
public final class zzhp<E> extends zzek<E> implements RandomAccess {
    private static final zzhp<Object> zza;
    private E[] zzb;
    private int zzc;

    static {
        zzhp<Object> zzhp = new zzhp<>(new Object[0], 0);
        zza = zzhp;
        zzhp.b_();
    }

    public zzhp() {
        this(new Object[10], 0);
    }

    private final void zza(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
    }

    private final String zzc(int i) {
        return a.p2(35, "Index:", i, ", Size:", this.zzc);
    }

    public static <E> zzhp<E> zzd() {
        return (zzhp<E>) zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzek, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean add(E e) {
        zzc();
        int i = this.zzc;
        E[] eArr = this.zzb;
        if (i == eArr.length) {
            this.zzb = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        eArr2[i2] = e;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        zza(i);
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzek, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zzc();
        zza(i);
        E[] eArr = this.zzb;
        E e = eArr[i];
        int i2 = this.zzc;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzek, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        zzc();
        zza(i);
        E[] eArr = this.zzb;
        E e2 = eArr[i];
        eArr[i] = e;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfy
    public final /* synthetic */ zzfy zzb(int i) {
        if (i >= this.zzc) {
            return new zzhp(Arrays.copyOf(this.zzb, i), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzhp(E[] eArr, int i) {
        this.zzb = eArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzek, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        int i2;
        zzc();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
        E[] eArr = this.zzb;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[a.y2(i2, 3, 2, 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzb, i, eArr2, i + 1, this.zzc - i);
            this.zzb = eArr2;
        }
        this.zzb[i] = e;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }
}
