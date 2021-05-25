package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    @NullableDecl
    public T a;

    public AbstractSequentialIterator(@NullableDecl T t) {
        this.a = t;
    }

    @NullableDecl
    public abstract T computeNext(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            try {
                T t = this.a;
                this.a = computeNext(t);
                return t;
            } catch (Throwable th) {
                this.a = computeNext(this.a);
                throw th;
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
