package com.google.android.gms.internal.clearcut;

import a2.b.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
public final class zzce extends zzav<Float> implements zzcn<Float>, RandomAccess {
    private static final zzce zzjm;
    private int size;
    private float[] zzjn;

    static {
        zzce zzce = new zzce();
        zzjm = zzce;
        zzce.zzv();
    }

    public zzce() {
        this(new float[10], 0);
    }

    private zzce(float[] fArr, int i) {
        this.zzjn = fArr;
        this.size = i;
    }

    private final void zzc(int i, float f) {
        int i2;
        zzw();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        float[] fArr = this.zzjn;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[a.y2(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzjn, i, fArr2, i + 1, this.size - i);
            this.zzjn = fArr2;
        }
        this.zzjn[i] = f;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    private final void zzg(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
    }

    private final String zzh(int i) {
        return a.p2(35, "Index:", i, ", Size:", this.size);
    }

    @Override // com.google.android.gms.internal.clearcut.zzav, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.clearcut.zzav, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Float> collection) {
        zzw();
        zzci.checkNotNull(collection);
        if (!(collection instanceof zzce)) {
            return super.addAll(collection);
        }
        zzce zzce = (zzce) collection;
        int i = zzce.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzjn;
            if (i3 > fArr.length) {
                this.zzjn = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzce.zzjn, 0, this.zzjn, this.size, zzce.size);
            this.size = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.android.gms.internal.clearcut.zzav, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzce)) {
            return super.equals(obj);
        }
        zzce zzce = (zzce) obj;
        if (this.size != zzce.size) {
            return false;
        }
        float[] fArr = zzce.zzjn;
        for (int i = 0; i < this.size; i++) {
            if (this.zzjn[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzg(i);
        return Float.valueOf(this.zzjn[i]);
    }

    @Override // com.google.android.gms.internal.clearcut.zzav, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzjn[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.clearcut.zzav, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzw();
        zzg(i);
        float[] fArr = this.zzjn;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, i2 - i);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // com.google.android.gms.internal.clearcut.zzav, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        zzw();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzjn[i]))) {
                float[] fArr = this.zzjn;
                System.arraycopy(fArr, i + 1, fArr, i, this.size - i);
                this.size--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zzw();
        if (i2 >= i) {
            float[] fArr = this.zzjn;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
            this.size -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.clearcut.zzav, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzw();
        zzg(i);
        float[] fArr = this.zzjn;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.size;
    }

    public final void zzc(float f) {
        zzc(this.size, f);
    }

    /* Return type fixed from 'com.google.android.gms.internal.clearcut.zzcn' to match base method */
    @Override // com.google.android.gms.internal.clearcut.zzcn
    public final /* synthetic */ zzcn<Float> zzi(int i) {
        if (i >= this.size) {
            return new zzce(Arrays.copyOf(this.zzjn, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
