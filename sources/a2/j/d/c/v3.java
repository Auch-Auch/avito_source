package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.SortedMultiset;
import java.util.Iterator;
import java.util.NavigableSet;
@GwtIncompatible
public class v3<E> extends u3<E> implements NavigableSet<E> {
    public v3(SortedMultiset<E> sortedMultiset) {
        super(sortedMultiset);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        return (E) AppCompatDelegateImpl.i.b(this.a.mo13tailMultiset(e, BoundType.CLOSED).firstEntry());
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return descendingSet().iterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return new v3(this.a.mo11descendingMultiset());
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        return (E) AppCompatDelegateImpl.i.b(this.a.mo12headMultiset(e, BoundType.CLOSED).lastEntry());
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        return new v3(this.a.mo12headMultiset(e, BoundType.a(z)));
    }

    @Override // java.util.NavigableSet
    public E higher(E e) {
        return (E) AppCompatDelegateImpl.i.b(this.a.mo13tailMultiset(e, BoundType.OPEN).firstEntry());
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        return (E) AppCompatDelegateImpl.i.b(this.a.mo12headMultiset(e, BoundType.OPEN).lastEntry());
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return (E) AppCompatDelegateImpl.i.b(this.a.pollFirstEntry());
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return (E) AppCompatDelegateImpl.i.b(this.a.pollLastEntry());
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return new v3(this.a.subMultiset(e, BoundType.a(z), e2, BoundType.a(z2)));
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        return new v3(this.a.mo13tailMultiset(e, BoundType.a(z)));
    }
}
