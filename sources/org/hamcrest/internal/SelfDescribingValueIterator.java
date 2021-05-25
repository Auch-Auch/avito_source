package org.hamcrest.internal;

import java.util.Iterator;
import org.hamcrest.SelfDescribing;
public class SelfDescribingValueIterator<T> implements Iterator<SelfDescribing> {
    public Iterator<T> a;

    public SelfDescribingValueIterator(Iterator<T> it) {
        this.a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.a.remove();
    }

    @Override // java.util.Iterator
    public SelfDescribing next() {
        return new SelfDescribingValue(this.a.next());
    }
}
