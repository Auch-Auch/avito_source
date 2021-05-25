package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
@GwtIncompatible
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    @Beta
    public class StandardDescendingSet extends Sets.g<E> {
        public StandardDescendingSet(ForwardingNavigableSet forwardingNavigableSet) {
            super(forwardingNavigableSet);
        }
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        return mo147delegate().ceiling(e);
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract NavigableSet<E> mo147delegate();

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return mo147delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return mo147delegate().descendingSet();
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        return mo147delegate().floor(e);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        return mo147delegate().headSet(e, z);
    }

    @Override // java.util.NavigableSet
    public E higher(E e) {
        return mo147delegate().higher(e);
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        return mo147delegate().lower(e);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return mo147delegate().pollFirst();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return mo147delegate().pollLast();
    }

    public E standardCeiling(E e) {
        return (E) Iterators.getNext(tailSet(e, true).iterator(), null);
    }

    public E standardFirst() {
        return iterator().next();
    }

    public E standardFloor(E e) {
        return (E) Iterators.getNext(headSet(e, true).descendingIterator(), null);
    }

    public SortedSet<E> standardHeadSet(E e) {
        return headSet(e, false);
    }

    public E standardHigher(E e) {
        return (E) Iterators.getNext(tailSet(e, false).iterator(), null);
    }

    public E standardLast() {
        return descendingIterator().next();
    }

    public E standardLower(E e) {
        return (E) Iterators.getNext(headSet(e, false).descendingIterator(), null);
    }

    public E standardPollFirst() {
        return (E) Iterators.c(iterator());
    }

    public E standardPollLast() {
        return (E) Iterators.c(descendingIterator());
    }

    @Beta
    public NavigableSet<E> standardSubSet(E e, boolean z, E e2, boolean z2) {
        return tailSet(e, z).headSet(e2, z2);
    }

    public SortedSet<E> standardTailSet(E e) {
        return tailSet(e, true);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return mo147delegate().subSet(e, z, e2, z2);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        return mo147delegate().tailSet(e, z);
    }

    @Override // com.google.common.collect.ForwardingSortedSet
    public SortedSet<E> standardSubSet(E e, E e2) {
        return subSet(e, true, e2, false);
    }
}
