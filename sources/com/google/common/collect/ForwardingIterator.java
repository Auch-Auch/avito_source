package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
@GwtCompatible
public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T> {
    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract Iterator<T> mo147delegate();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return mo147delegate().hasNext();
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public T next() {
        return mo147delegate().next();
    }

    @Override // java.util.Iterator
    public void remove() {
        mo147delegate().remove();
    }
}
