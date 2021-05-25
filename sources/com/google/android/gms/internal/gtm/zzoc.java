package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.NoSuchElementException;
public final class zzoc implements Iterator<zzoa<?>> {
    private zzoc() {
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ zzoa<?> next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ zzoc(zzob zzob) {
        this();
    }
}
