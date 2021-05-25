package com.google.android.gms.internal.measurement;

import java.util.Iterator;
public abstract class zzfz<E> implements Iterator<E> {
    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
