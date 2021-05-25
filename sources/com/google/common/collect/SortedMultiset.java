package com.google.common.collect;

import a2.j.d.c.q3;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
@GwtCompatible(emulated = true)
public interface SortedMultiset<E> extends Object<E>, q3<E> {
    @Override // a2.j.d.c.q3
    Comparator<? super E> comparator();

    /* renamed from: descendingMultiset */
    SortedMultiset<E> mo11descendingMultiset();

    NavigableSet<E> elementSet();

    /* synthetic */ SortedSet<E> elementSet();

    Set<Multiset.Entry<E>> entrySet();

    Multiset.Entry<E> firstEntry();

    /* renamed from: headMultiset */
    SortedMultiset<E> mo12headMultiset(E e, BoundType boundType);

    @Override // java.lang.Iterable
    Iterator<E> iterator();

    Multiset.Entry<E> lastEntry();

    Multiset.Entry<E> pollFirstEntry();

    Multiset.Entry<E> pollLastEntry();

    SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2);

    /* renamed from: tailMultiset */
    SortedMultiset<E> mo13tailMultiset(E e, BoundType boundType);
}
