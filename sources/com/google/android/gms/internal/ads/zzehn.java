package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
public final class zzehn extends zzeez<Long> implements zzegx, zzeil, RandomAccess {
    private static final zzehn zziho;
    private int size;
    private long[] zzihp;

    static {
        zzehn zzehn = new zzehn(new long[0], 0);
        zziho = zzehn;
        zzehn.zzbdg();
    }

    public zzehn() {
        this(new long[10], 0);
    }

    public static zzehn zzbgr() {
        return zziho;
    }

    private final void zzfr(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzfs(i));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        zzbdh();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfs(i));
        }
        long[] jArr = this.zzihp;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[a.y2(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzihp, i, jArr2, i + 1, this.size - i);
            this.zzihp = jArr2;
        }
        this.zzihp[i] = longValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Long> collection) {
        zzbdh();
        zzegr.checkNotNull(collection);
        if (!(collection instanceof zzehn)) {
            return super.addAll(collection);
        }
        zzehn zzehn = (zzehn) collection;
        int i = zzehn.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzihp;
            if (i3 > jArr.length) {
                this.zzihp = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzehn.zzihp, 0, this.zzihp, this.size, zzehn.size);
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
        if (!(obj instanceof zzehn)) {
            return super.equals(obj);
        }
        zzehn zzehn = (zzehn) obj;
        if (this.size != zzehn.size) {
            return false;
        }
        long[] jArr = zzehn.zzihp;
        for (int i = 0; i < this.size; i++) {
            if (this.zzihp[i] != jArr[i]) {
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
        zzfr(i);
        return this.zzihp[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzegr.zzfr(this.zzihp[i2]);
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
            if (this.zzihp[i] == longValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        zzbdh();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzihp[i]))) {
                long[] jArr = this.zzihp;
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
        zzbdh();
        if (i2 >= i) {
            long[] jArr = this.zzihp;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
            this.size -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbdh();
        zzfr(i);
        long[] jArr = this.zzihp;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.size;
    }

    public final void zzfs(long j) {
        zzbdh();
        int i = this.size;
        long[] jArr = this.zzihp;
        if (i == jArr.length) {
            long[] jArr2 = new long[a.y2(i, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzihp = jArr2;
        }
        long[] jArr3 = this.zzihp;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // com.google.android.gms.internal.ads.zzegx
    /* renamed from: zzhd */
    public final zzegx zzft(int i) {
        if (i >= this.size) {
            return new zzehn(Arrays.copyOf(this.zzihp, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzehn(long[] jArr, int i) {
        this.zzihp = jArr;
        this.size = i;
    }

    private final String zzfs(int i) {
        return a.p2(35, "Index:", i, ", Size:", this.size);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbdh();
        zzfr(i);
        long[] jArr = this.zzihp;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* synthetic */ boolean add(Object obj) {
        zzfs(((Long) obj).longValue());
        return true;
    }
}
