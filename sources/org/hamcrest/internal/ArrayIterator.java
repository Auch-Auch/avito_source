package org.hamcrest.internal;

import java.lang.reflect.Array;
import java.util.Iterator;
public class ArrayIterator implements Iterator<Object> {
    public final Object a;
    public int b = 0;

    public ArrayIterator(Object obj) {
        if (obj.getClass().isArray()) {
            this.a = obj;
            return;
        }
        throw new IllegalArgumentException("not an array");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < Array.getLength(this.a);
    }

    @Override // java.util.Iterator
    public Object next() {
        Object obj = this.a;
        int i = this.b;
        this.b = i + 1;
        return Array.get(obj, i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("cannot remove items from an array");
    }
}
