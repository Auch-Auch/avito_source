package a2.j.d.c;

import com.google.common.collect.ForwardingSortedSet;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;
public final class j2 extends ForwardingSortedSet<E> {
    public final /* synthetic */ SortedSet a;

    public j2(SortedSet sortedSet) {
        this.a = sortedSet;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public Object mo147delegate() {
        return this.a;
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

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate  reason: collision with other method in class */
    public Collection mo147delegate() {
        return this.a;
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public Set mo147delegate() {
        return this.a;
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate  reason: collision with other method in class */
    public SortedSet<E> mo147delegate() {
        return this.a;
    }
}
