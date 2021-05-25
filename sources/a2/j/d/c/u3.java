package a2.j.d.c;

import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SortedMultiset;
import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
public class u3<E> extends Multisets.g<E> implements SortedSet<E> {
    @Weak
    public final SortedMultiset<E> a;

    public u3(SortedMultiset<E> sortedMultiset) {
        this.a = sortedMultiset;
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return this.a.comparator();
    }

    @Override // com.google.common.collect.Multisets.g
    public Multiset d() {
        return this.a;
    }

    @Override // java.util.SortedSet
    public E first() {
        Multiset.Entry<E> firstEntry = this.a.firstEntry();
        if (firstEntry != null) {
            return firstEntry.getElement();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return this.a.mo12headMultiset(e, BoundType.OPEN).elementSet();
    }

    @Override // com.google.common.collect.Multisets.g, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<E> iterator() {
        return new q2(this.a.entrySet().iterator());
    }

    @Override // java.util.SortedSet
    public E last() {
        Multiset.Entry<E> lastEntry = this.a.lastEntry();
        if (lastEntry != null) {
            return lastEntry.getElement();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e, E e2) {
        return this.a.subMultiset(e, BoundType.CLOSED, e2, BoundType.OPEN).elementSet();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return this.a.mo13tailMultiset(e, BoundType.CLOSED).elementSet();
    }
}
