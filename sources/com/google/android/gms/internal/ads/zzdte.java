package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
public class zzdte<E> extends zzdth<E> {
    public int size = 0;
    public Object[] zzhmy;
    public boolean zzhmz;

    public zzdte(int i) {
        zzdta.zzh(i, "initialCapacity");
        this.zzhmy = new Object[i];
    }

    private final void zzem(int i) {
        Object[] objArr = this.zzhmy;
        if (objArr.length < i) {
            int length = objArr.length;
            if (i >= 0) {
                int i2 = length + (length >> 1) + 1;
                if (i2 < i) {
                    i2 = Integer.highestOneBit(i - 1) << 1;
                }
                if (i2 < 0) {
                    i2 = Integer.MAX_VALUE;
                }
                this.zzhmy = Arrays.copyOf(objArr, i2);
                this.zzhmz = false;
                return;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        } else if (this.zzhmz) {
            this.zzhmy = (Object[]) objArr.clone();
            this.zzhmz = false;
        }
    }

    /* renamed from: zzaa */
    public zzdte<E> zzab(E e) {
        zzdsv.checkNotNull(e);
        zzem(this.size + 1);
        Object[] objArr = this.zzhmy;
        int i = this.size;
        this.size = i + 1;
        objArr[i] = e;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdth
    public zzdth<E> zzg(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzem(collection.size() + this.size);
            if (collection instanceof zzdtf) {
                this.size = ((zzdtf) collection).zza(this.zzhmy, this.size);
                return this;
            }
        }
        super.zzg(iterable);
        return this;
    }
}
