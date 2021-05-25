package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
public final class zzif extends zzgi<Integer> implements zzik<Integer>, zzjz, RandomAccess {
    private static final zzif zzyv;
    private int size;
    private int[] zzyw;

    static {
        zzif zzif = new zzif(new int[0], 0);
        zzyv = zzif;
        zzif.zzej();
    }

    public zzif() {
        this(new int[10], 0);
    }

    private final void zzal(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzam(i));
        }
    }

    private final String zzam(int i) {
        return a.p2(35, "Index:", i, ", Size:", this.size);
    }

    public static zzif zzhg() {
        return zzyv;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        zzek();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzam(i));
        }
        int[] iArr = this.zzyw;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[a.y2(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzyw, i, iArr2, i + 1, this.size - i);
            this.zzyw = iArr2;
        }
        this.zzyw[i] = intValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzek();
        zzie.checkNotNull(collection);
        if (!(collection instanceof zzif)) {
            return super.addAll(collection);
        }
        zzif zzif = (zzif) collection;
        int i = zzif.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzyw;
            if (i3 > iArr.length) {
                this.zzyw = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzif.zzyw, 0, this.zzyw, this.size, zzif.size);
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
        if (!(obj instanceof zzif)) {
            return super.equals(obj);
        }
        zzif zzif = (zzif) obj;
        if (this.size != zzif.size) {
            return false;
        }
        int[] iArr = zzif.zzyw;
        for (int i = 0; i < this.size; i++) {
            if (this.zzyw[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        zzal(i);
        return this.zzyw[i];
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzyw[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzyw[i] == intValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        zzek();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzyw[i]))) {
                int[] iArr = this.zzyw;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
            int[] iArr = this.zzyw;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzek();
        zzal(i);
        int[] iArr = this.zzyw;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.size;
    }

    /* Return type fixed from 'com.google.android.gms.internal.vision.zzik' to match base method */
    @Override // com.google.android.gms.internal.vision.zzik
    public final /* synthetic */ zzik<Integer> zzan(int i) {
        if (i >= this.size) {
            return new zzif(Arrays.copyOf(this.zzyw, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzbs(int i) {
        zzek();
        int i2 = this.size;
        int[] iArr = this.zzyw;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[a.y2(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzyw = iArr2;
        }
        int[] iArr3 = this.zzyw;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }

    private zzif(int[] iArr, int i) {
        this.zzyw = iArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzek();
        zzal(i);
        int[] iArr = this.zzyw;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* synthetic */ boolean add(Object obj) {
        zzbs(((Integer) obj).intValue());
        return true;
    }
}
