package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
public final class zzefd extends zzeez<Boolean> implements zzeha<Boolean>, zzeil, RandomAccess {
    private static final zzefd zziba;
    private int size;
    private boolean[] zzibb;

    static {
        zzefd zzefd = new zzefd(new boolean[0], 0);
        zziba = zzefd;
        zzefd.zzbdg();
    }

    public zzefd() {
        this(new boolean[10], 0);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbdh();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfs(i));
        }
        boolean[] zArr = this.zzibb;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[a.y2(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzibb, i, zArr2, i + 1, this.size - i);
            this.zzibb = zArr2;
        }
        this.zzibb[i] = booleanValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbdh();
        zzegr.checkNotNull(collection);
        if (!(collection instanceof zzefd)) {
            return super.addAll(collection);
        }
        zzefd zzefd = (zzefd) collection;
        int i = zzefd.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzibb;
            if (i3 > zArr.length) {
                this.zzibb = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzefd.zzibb, 0, this.zzibb, this.size, zzefd.size);
            this.size = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z) {
        zzbdh();
        int i = this.size;
        boolean[] zArr = this.zzibb;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[a.y2(i, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zzibb = zArr2;
        }
        boolean[] zArr3 = this.zzibb;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr3[i2] = z;
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
        if (!(obj instanceof zzefd)) {
            return super.equals(obj);
        }
        zzefd zzefd = (zzefd) obj;
        if (this.size != zzefd.size) {
            return false;
        }
        boolean[] zArr = zzefd.zzibb;
        for (int i = 0; i < this.size; i++) {
            if (this.zzibb[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzfr(i);
        return Boolean.valueOf(this.zzibb[i]);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzegr.zzbu(this.zzibb[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzibb[i] == booleanValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        zzbdh();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzibb[i]))) {
                boolean[] zArr = this.zzibb;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
            boolean[] zArr = this.zzibb;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
            this.size -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbdh();
        zzfr(i);
        boolean[] zArr = this.zzibb;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.size;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzeha' to match base method */
    @Override // com.google.android.gms.internal.ads.zzeha
    public final /* synthetic */ zzeha<Boolean> zzft(int i) {
        if (i >= this.size) {
            return new zzefd(Arrays.copyOf(this.zzibb, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzefd(boolean[] zArr, int i) {
        this.zzibb = zArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbdh();
        zzfr(i);
        boolean[] zArr = this.zzibb;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* synthetic */ boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }
}
