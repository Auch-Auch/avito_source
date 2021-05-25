package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Deque;
import java.util.Iterator;
@GwtIncompatible
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    @Override // java.util.Deque
    public void addFirst(E e) {
        mo147delegate().addFirst(e);
    }

    @Override // java.util.Deque
    public void addLast(E e) {
        mo147delegate().addLast(e);
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract Deque<E> mo147delegate();

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return mo147delegate().descendingIterator();
    }

    @Override // java.util.Deque
    public E getFirst() {
        return mo147delegate().getFirst();
    }

    @Override // java.util.Deque
    public E getLast() {
        return mo147delegate().getLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean offerFirst(E e) {
        return mo147delegate().offerFirst(e);
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean offerLast(E e) {
        return mo147delegate().offerLast(e);
    }

    @Override // java.util.Deque
    public E peekFirst() {
        return mo147delegate().peekFirst();
    }

    @Override // java.util.Deque
    public E peekLast() {
        return mo147delegate().peekLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E pollFirst() {
        return mo147delegate().pollFirst();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E pollLast() {
        return mo147delegate().pollLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E pop() {
        return mo147delegate().pop();
    }

    @Override // java.util.Deque
    public void push(E e) {
        mo147delegate().push(e);
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E removeFirst() {
        return mo147delegate().removeFirst();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean removeFirstOccurrence(Object obj) {
        return mo147delegate().removeFirstOccurrence(obj);
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E removeLast() {
        return mo147delegate().removeLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean removeLastOccurrence(Object obj) {
        return mo147delegate().removeLastOccurrence(obj);
    }
}
