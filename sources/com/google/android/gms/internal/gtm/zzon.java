package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.NoSuchElementException;
public final class zzon implements Iterator<zzoa<?>> {
    private int currentIndex = 0;
    private final /* synthetic */ zzom zzauw;

    public zzon(zzom zzom) {
        this.zzauw = zzom;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.currentIndex < this.zzauw.value.length();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ zzoa<?> next() {
        if (this.currentIndex < this.zzauw.value.length()) {
            int i = this.currentIndex;
            this.currentIndex = i + 1;
            return new zzoe(Double.valueOf((double) i));
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
