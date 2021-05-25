package a2.j.d.c;

import com.google.common.collect.ForwardingNavigableSet;
import java.util.Collection;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
public final class k2 extends ForwardingNavigableSet<E> {
    public final /* synthetic */ NavigableSet a;

    public k2(NavigableSet navigableSet) {
        this.a = navigableSet;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public Object mo147delegate() {
        return this.a;
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return new k2(super.descendingSet());
    }

    @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return new j2(super.headSet(e));
    }

    @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
    public SortedSet<E> subSet(E e, E e2) {
        return new j2(super.subSet(e, e2));
    }

    @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return new j2(super.tailSet(e));
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate  reason: collision with other method in class */
    public Collection mo147delegate() {
        return this.a;
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public NavigableSet<E> mo147delegate() {
        return this.a;
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        return new k2(super.headSet(e, z));
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return new k2(super.subSet(e, z, e2, z2));
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        return new k2(super.tailSet(e, z));
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate  reason: collision with other method in class */
    public Set mo147delegate() {
        return this.a;
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public SortedSet mo147delegate() {
        return this.a;
    }
}
