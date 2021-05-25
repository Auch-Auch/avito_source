package com.google.common.collect;

import a2.j.d.c.n0;
import a2.j.d.c.v3;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
@Beta
@GwtCompatible(emulated = true)
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {

    public abstract class StandardDescendingMultiset extends n0<E> {
        public StandardDescendingMultiset() {
        }

        @Override // a2.j.d.c.n0
        public SortedMultiset<E> d() {
            return ForwardingSortedMultiset.this;
        }
    }

    public class StandardElementSet extends v3<E> {
        public StandardElementSet(ForwardingSortedMultiset forwardingSortedMultiset) {
            super(forwardingSortedMultiset);
        }
    }

    @Override // com.google.common.collect.SortedMultiset, a2.j.d.c.q3
    public Comparator<? super E> comparator() {
        return mo147delegate().comparator();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract SortedMultiset<E> mo147delegate();

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: descendingMultiset */
    public SortedMultiset<E> mo11descendingMultiset() {
        return mo147delegate().mo11descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return mo147delegate().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: headMultiset */
    public SortedMultiset<E> mo12headMultiset(E e, BoundType boundType) {
        return mo147delegate().mo12headMultiset(e, boundType);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return mo147delegate().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        return mo147delegate().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        return mo147delegate().pollLastEntry();
    }

    public Multiset.Entry<E> standardFirstEntry() {
        Iterator<Multiset.Entry<E>> it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Multiset.Entry<E> next = it.next();
        return Multisets.immutableEntry(next.getElement(), next.getCount());
    }

    public Multiset.Entry<E> standardLastEntry() {
        Iterator<Multiset.Entry<E>> it = mo11descendingMultiset().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Multiset.Entry<E> next = it.next();
        return Multisets.immutableEntry(next.getElement(), next.getCount());
    }

    public Multiset.Entry<E> standardPollFirstEntry() {
        Iterator<Multiset.Entry<E>> it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Multiset.Entry<E> next = it.next();
        Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(next.getElement(), next.getCount());
        it.remove();
        return immutableEntry;
    }

    public Multiset.Entry<E> standardPollLastEntry() {
        Iterator<Multiset.Entry<E>> it = mo11descendingMultiset().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Multiset.Entry<E> next = it.next();
        Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(next.getElement(), next.getCount());
        it.remove();
        return immutableEntry;
    }

    public SortedMultiset<E> standardSubMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return mo13tailMultiset(e, boundType).mo12headMultiset(e2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return mo147delegate().subMultiset(e, boundType, e2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: tailMultiset */
    public SortedMultiset<E> mo13tailMultiset(E e, BoundType boundType) {
        return mo147delegate().mo13tailMultiset(e, boundType);
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public NavigableSet<E> mo6elementSet() {
        return mo147delegate().elementSet();
    }
}
