package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
public final class zzegs extends zzeez<Integer> implements zzegv, zzeil, RandomAccess {
    private static final zzegs zzigm;
    private int size;
    private int[] zzign;

    static {
        zzegs zzegs = new zzegs(new int[0], 0);
        zzigm = zzegs;
        zzegs.zzbdg();
    }

    public zzegs() {
        this(new int[10], 0);
    }

    public static zzegs zzbga() {
        return zzigm;
    }

    private final void zzfr(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzfs(i));
        }
    }

    private final String zzfs(int i) {
        return a.p2(35, "Index:", i, ", Size:", this.size);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        zzbdh();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfs(i));
        }
        int[] iArr = this.zzign;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[a.y2(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzign, i, iArr2, i + 1, this.size - i);
            this.zzign = iArr2;
        }
        this.zzign[i] = intValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbdh();
        zzegr.checkNotNull(collection);
        if (!(collection instanceof zzegs)) {
            return super.addAll(collection);
        }
        zzegs zzegs = (zzegs) collection;
        int i = zzegs.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzign;
            if (i3 > iArr.length) {
                this.zzign = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzegs.zzign, 0, this.zzign, this.size, zzegs.size);
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

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzegs)) {
            return super.equals(obj);
        }
        zzegs zzegs = (zzegs) obj;
        if (this.size != zzegs.size) {
            return false;
        }
        int[] iArr = zzegs.zzign;
        for (int i = 0; i < this.size; i++) {
            if (this.zzign[i] != iArr[i]) {
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
        zzfr(i);
        return this.zzign[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzign[i2];
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
            if (this.zzign[i] == intValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        zzbdh();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzign[i]))) {
                int[] iArr = this.zzign;
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
        zzbdh();
        if (i2 >= i) {
            int[] iArr = this.zzign;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzbdh();
        zzfr(i);
        int[] iArr = this.zzign;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzegv
    /* renamed from: zzhb */
    public final zzegv zzft(int i) {
        if (i >= this.size) {
            return new zzegs(Arrays.copyOf(this.zzign, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzegv
    public final void zzhc(int i) {
        zzbdh();
        int i2 = this.size;
        int[] iArr = this.zzign;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[a.y2(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzign = iArr2;
        }
        int[] iArr3 = this.zzign;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }

    private zzegs(int[] iArr, int i) {
        this.zzign = iArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbdh();
        zzfr(i);
        int[] iArr = this.zzign;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* synthetic */ boolean add(Object obj) {
        zzhc(((Integer) obj).intValue());
        return true;
    }
}
