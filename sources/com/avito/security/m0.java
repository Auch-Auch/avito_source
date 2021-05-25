package com.avito.security;

import java.util.Iterator;
public abstract class m0 implements Iterator<Integer> {
    /* renamed from: a */
    public final Integer next() {
        return Integer.valueOf(b());
    }

    public abstract int b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
