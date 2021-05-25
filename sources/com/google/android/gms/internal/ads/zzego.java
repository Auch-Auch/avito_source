package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
public final class zzego extends zzeez<Float> implements zzeha<Float>, zzeil, RandomAccess {
    private static final zzego zzifm;
    private int size;
    private float[] zzifn;

    static {
        zzego zzego = new zzego(new float[0], 0);
        zzifm = zzego;
        zzego.zzbdg();
    }

    public zzego() {
        this(new float[10], 0);
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
        float floatValue = ((Float) obj).floatValue();
        zzbdh();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfs(i));
        }
        float[] fArr = this.zzifn;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[a.y2(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzifn, i, fArr2, i + 1, this.size - i);
            this.zzifn = fArr2;
        }
        this.zzifn[i] = floatValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Float> collection) {
        zzbdh();
        zzegr.checkNotNull(collection);
        if (!(collection instanceof zzego)) {
            return super.addAll(collection);
        }
        zzego zzego = (zzego) collection;
        int i = zzego.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzifn;
            if (i3 > fArr.length) {
                this.zzifn = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzego.zzifn, 0, this.zzifn, this.size, zzego.size);
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
        if (!(obj instanceof zzego)) {
            return super.equals(obj);
        }
        zzego zzego = (zzego) obj;
        if (this.size != zzego.size) {
            return false;
        }
        float[] fArr = zzego.zzifn;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzifn[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzfr(i);
        return Float.valueOf(this.zzifn[i]);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzifn[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzifn[i] == floatValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        zzbdh();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzifn[i]))) {
                float[] fArr = this.zzifn;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
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
            float[] fArr = this.zzifn;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
            this.size -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzbdh();
        zzfr(i);
        float[] fArr = this.zzifn;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.size;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzeha' to match base method */
    @Override // com.google.android.gms.internal.ads.zzeha
    public final /* synthetic */ zzeha<Float> zzft(int i) {
        if (i >= this.size) {
            return new zzego(Arrays.copyOf(this.zzifn, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(float f) {
        zzbdh();
        int i = this.size;
        float[] fArr = this.zzifn;
        if (i == fArr.length) {
            float[] fArr2 = new float[a.y2(i, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.zzifn = fArr2;
        }
        float[] fArr3 = this.zzifn;
        int i2 = this.size;
        this.size = i2 + 1;
        fArr3[i2] = f;
    }

    private zzego(float[] fArr, int i) {
        this.zzifn = fArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbdh();
        zzfr(i);
        float[] fArr = this.zzifn;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* synthetic */ boolean add(Object obj) {
        zzh(((Float) obj).floatValue());
        return true;
    }
}
