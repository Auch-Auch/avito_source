package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
public final class zzjb extends zzgi<Long> implements zzik<Long>, zzjz, RandomAccess {
    private static final zzjb zzzz;
    private int size;
    private long[] zzaaa;

    static {
        zzjb zzjb = new zzjb(new long[0], 0);
        zzzz = zzjb;
        zzjb.zzej();
    }

    public zzjb() {
        this(new long[10], 0);
    }

    private final void zzal(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzam(i));
        }
    }

    private final String zzam(int i) {
        return a.p2(35, "Index:", i, ", Size:", this.size);
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        zzek();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzam(i));
        }
        long[] jArr = this.zzaaa;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[a.y2(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzaaa, i, jArr2, i + 1, this.size - i);
            this.zzaaa = jArr2;
        }
        this.zzaaa[i] = longValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Long> collection) {
        zzek();
        zzie.checkNotNull(collection);
        if (!(collection instanceof zzjb)) {
            return super.addAll(collection);
        }
        zzjb zzjb = (zzjb) collection;
        int i = zzjb.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzaaa;
            if (i3 > jArr.length) {
                this.zzaaa = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzjb.zzaaa, 0, this.zzaaa, this.size, zzjb.size);
            this.size = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjb)) {
            return super.equals(obj);
        }
        zzjb zzjb = (zzjb) obj;
        if (this.size != zzjb.size) {
            return false;
        }
        long[] jArr = zzjb.zzaaa;
        for (int i = 0; i < this.size; i++) {
            if (this.zzaaa[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    public final long getLong(int i) {
        zzal(i);
        return this.zzaaa[i];
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzie.zzab(this.zzaaa[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzaaa[i] == longValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        zzek();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzaaa[i]))) {
                long[] jArr = this.zzaaa;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
                this.size--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zzek();
        if (i2 >= i) {
            long[] jArr = this.zzaaa;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
            this.size -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzek();
        zzal(i);
        long[] jArr = this.zzaaa;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.size;
    }

    public final void zzac(long j) {
        zzek();
        int i = this.size;
        long[] jArr = this.zzaaa;
        if (i == jArr.length) {
            long[] jArr2 = new long[a.y2(i, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzaaa = jArr2;
        }
        long[] jArr3 = this.zzaaa;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }

    /* Return type fixed from 'com.google.android.gms.internal.vision.zzik' to match base method */
    @Override // com.google.android.gms.internal.vision.zzik
    public final /* synthetic */ zzik<Long> zzan(int i) {
        if (i >= this.size) {
            return new zzjb(Arrays.copyOf(this.zzaaa, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzjb(long[] jArr, int i) {
        this.zzaaa = jArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzek();
        zzal(i);
        long[] jArr = this.zzaaa;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* synthetic */ boolean add(Object obj) {
        zzac(((Long) obj).longValue());
        return true;
    }
}
