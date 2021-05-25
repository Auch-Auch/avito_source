package a2.j.d.c;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import java.util.NavigableSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public final class l0<E> extends ImmutableSortedSet<E> {
    public final ImmutableSortedSet<E> e;

    public l0(ImmutableSortedSet<E> immutableSortedSet) {
        super(Ordering.from(immutableSortedSet.comparator()).reverse());
        this.e = immutableSortedSet;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e2) {
        return this.e.floor(e2);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return this.e.contains(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible("NavigableSet")
    /* renamed from: descendingSet */
    public ImmutableSortedSet<E> mo17descendingSet() {
        return this.e;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return this.e.e();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e2) {
        return this.e.ceiling(e2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e2) {
        return this.e.lower(e2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e2) {
        return this.e.higher(e2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible("NavigableSet")
    public ImmutableSortedSet<E> m() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> o(E e2, boolean z) {
        return this.e.tailSet((ImmutableSortedSet<E>) e2, z).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> p(E e2, boolean z, E e3, boolean z2) {
        return this.e.subSet((boolean) e3, z2, (boolean) e2, z).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> q(E e2, boolean z) {
        return this.e.headSet((ImmutableSortedSet<E>) e2, z).descendingSet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.e.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible("NavigableSet")
    /* renamed from: descendingIterator */
    public UnmodifiableIterator<E> mo98descendingIterator() {
        return this.e.mo99iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible("NavigableSet")
    /* renamed from: descendingSet  reason: collision with other method in class */
    public NavigableSet mo17descendingSet() {
        return this.e;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: iterator */
    public UnmodifiableIterator<E> mo99iterator() {
        return this.e.descendingIterator();
    }
}
