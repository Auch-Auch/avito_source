package com.google.android.gms.internal.ads;

import java.util.Iterator;
public abstract class zzdub<E> implements Iterator<E> {
    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
