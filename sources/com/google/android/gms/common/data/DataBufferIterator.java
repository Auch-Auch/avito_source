package com.google.android.gms.common.data;

import a2.b.a.a.a;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;
@KeepForSdk
public class DataBufferIterator<T> implements Iterator<T> {
    @RecentlyNonNull
    public final DataBuffer<T> zaa;
    @RecentlyNonNull
    public int zab = -1;

    public DataBufferIterator(@RecentlyNonNull DataBuffer<T> dataBuffer) {
        this.zaa = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    @Override // java.util.Iterator
    @RecentlyNonNull
    public boolean hasNext() {
        return this.zab < this.zaa.getCount() - 1;
    }

    @Override // java.util.Iterator
    @RecentlyNonNull
    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.zaa;
            int i = this.zab + 1;
            this.zab = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException(a.m2(46, "Cannot advance the iterator beyond ", this.zab));
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
