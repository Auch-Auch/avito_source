package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ListIterator;
@GwtCompatible
public abstract class ForwardingListIterator<E> extends ForwardingIterator<E> implements ListIterator<E> {
    @Override // java.util.ListIterator
    public void add(E e) {
        mo147delegate().add(e);
    }

    @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract ListIterator<E> mo147delegate();

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return mo147delegate().hasPrevious();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return mo147delegate().nextIndex();
    }

    @Override // java.util.ListIterator
    @CanIgnoreReturnValue
    public E previous() {
        return mo147delegate().previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return mo147delegate().previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(E e) {
        mo147delegate().set(e);
    }
}
