package a2.j.d.c;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultiset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public final class k0<E> extends ImmutableSortedMultiset<E> {
    public final transient ImmutableSortedMultiset<E> f;

    public k0(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.f = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        return this.f.count(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* renamed from: descendingMultiset */
    public ImmutableSortedMultiset<E> mo11descendingMultiset() {
        return this.f;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return this.f.e();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return this.f.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public Multiset.Entry<E> h(int i) {
        return this.f.entrySet().asList().reverse().get(i);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* renamed from: headMultiset */
    public ImmutableSortedMultiset<E> mo12headMultiset(E e, BoundType boundType) {
        return this.f.mo13tailMultiset((ImmutableSortedMultiset<E>) e, boundType).mo11descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return this.f.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return this.f.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* renamed from: tailMultiset */
    public ImmutableSortedMultiset<E> mo13tailMultiset(E e, BoundType boundType) {
        return this.f.mo12headMultiset((ImmutableSortedMultiset<E>) e, boundType).mo11descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* renamed from: descendingMultiset  reason: collision with other method in class */
    public SortedMultiset mo11descendingMultiset() {
        return this.f;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* renamed from: headMultiset  reason: collision with other method in class */
    public SortedMultiset mo12headMultiset(Object obj, BoundType boundType) {
        return this.f.mo13tailMultiset((ImmutableSortedMultiset<E>) obj, boundType).mo11descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* renamed from: tailMultiset  reason: collision with other method in class */
    public SortedMultiset mo13tailMultiset(Object obj, BoundType boundType) {
        return this.f.mo12headMultiset((ImmutableSortedMultiset<E>) obj, boundType).mo11descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public ImmutableSortedSet<E> mo6elementSet() {
        return this.f.mo6elementSet().descendingSet();
    }
}
