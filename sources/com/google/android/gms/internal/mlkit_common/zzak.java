package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
public abstract class zzak<E> implements Iterator<E> {
    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
