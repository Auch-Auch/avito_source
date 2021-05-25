package com.facebook.imagepipeline.cache;

import java.util.LinkedHashSet;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public class BoundedLinkedHashSet<E> {
    public int a;
    public LinkedHashSet<E> b;

    public BoundedLinkedHashSet(int i) {
        this.b = new LinkedHashSet<>(i);
        this.a = i;
    }

    public synchronized boolean add(E e) {
        if (this.b.size() == this.a) {
            LinkedHashSet<E> linkedHashSet = this.b;
            linkedHashSet.remove(linkedHashSet.iterator().next());
        }
        this.b.remove(e);
        return this.b.add(e);
    }

    public synchronized boolean contains(E e) {
        return this.b.contains(e);
    }
}
