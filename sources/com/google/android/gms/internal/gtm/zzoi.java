package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.NoSuchElementException;
public final class zzoi implements Iterator<zzoa<?>> {
    private int currentIndex = 0;
    private final /* synthetic */ zzoh zzauq;

    public zzoi(zzoh zzoh) {
        this.zzauq = zzoh;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        for (int i = this.currentIndex; i < this.zzauq.zzaup.size(); i++) {
            if (this.zzauq.zzaup.get(i) != null) {
                return true;
            }
        }
        return false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ zzoa<?> next() {
        if (this.currentIndex < this.zzauq.zzaup.size()) {
            for (int i = this.currentIndex; i < this.zzauq.zzaup.size(); i++) {
                if (this.zzauq.zzaup.get(i) != null) {
                    this.currentIndex = i;
                    int i2 = this.currentIndex;
                    this.currentIndex = i2 + 1;
                    return new zzoe(Double.valueOf((double) i2));
                }
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
