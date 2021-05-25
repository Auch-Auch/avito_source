package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return mo147delegate().comparator();
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract SortedSet<E> mo147delegate();

    @Override // java.util.SortedSet
    public E first() {
        return mo147delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return mo147delegate().headSet(e);
    }

    @Override // java.util.SortedSet
    public E last() {
        return mo147delegate().last();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    public boolean standardContains(@NullableDecl Object obj) {
        int i;
        try {
            E first = tailSet(obj).first();
            Comparator<? super E> comparator = comparator();
            if (comparator == null) {
                i = first.compareTo(obj);
            } else {
                i = comparator.compare(first, obj);
            }
            return i == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    public boolean standardRemove(@NullableDecl Object obj) {
        int i;
        try {
            Iterator<E> it = tailSet(obj).iterator();
            if (!it.hasNext()) {
                return false;
            }
            E next = it.next();
            Comparator<? super E> comparator = comparator();
            if (comparator == null) {
                i = next.compareTo(obj);
            } else {
                i = comparator.compare(next, obj);
            }
            if (i != 0) {
                return false;
            }
            it.remove();
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Beta
    public SortedSet<E> standardSubSet(E e, E e2) {
        return tailSet(e).headSet(e2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e, E e2) {
        return mo147delegate().subSet(e, e2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return mo147delegate().tailSet(e);
    }
}
