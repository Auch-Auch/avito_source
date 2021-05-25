package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedMultiset;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
@GwtCompatible(emulated = true)
public final class e5<E> extends Multisets.l<E> implements SortedMultiset<E> {
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    public transient e5<E> d;

    public e5(SortedMultiset<E> sortedMultiset) {
        super(sortedMultiset);
    }

    @Override // com.google.common.collect.SortedMultiset, a2.j.d.c.q3
    public Comparator<? super E> comparator() {
        return ((SortedMultiset) this.a).comparator();
    }

    @Override // com.google.common.collect.Multisets.l
    public Set d() {
        return Sets.unmodifiableNavigableSet(((SortedMultiset) this.a).elementSet());
    }

    @Override // com.google.common.collect.Multisets.l, com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public Multiset mo147delegate() {
        return (SortedMultiset) this.a;
    }

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: descendingMultiset */
    public SortedMultiset<E> mo11descendingMultiset() {
        e5<E> e5Var = this.d;
        if (e5Var != null) {
            return e5Var;
        }
        e5<E> e5Var2 = new e5<>(((SortedMultiset) this.a).mo11descendingMultiset());
        e5Var2.d = this;
        this.d = e5Var2;
        return e5Var2;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return ((SortedMultiset) this.a).firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: headMultiset */
    public SortedMultiset<E> mo12headMultiset(E e, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(((SortedMultiset) this.a).mo12headMultiset(e, boundType));
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return ((SortedMultiset) this.a).lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return Multisets.unmodifiableSortedMultiset(((SortedMultiset) this.a).subMultiset(e, boundType, e2, boundType2));
    }

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: tailMultiset */
    public SortedMultiset<E> mo13tailMultiset(E e, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(((SortedMultiset) this.a).mo13tailMultiset(e, boundType));
    }

    @Override // com.google.common.collect.Multisets.l, com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate  reason: collision with other method in class */
    public Object mo147delegate() {
        return (SortedMultiset) this.a;
    }

    @Override // com.google.common.collect.Multisets.l, com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public NavigableSet<E> mo6elementSet() {
        return (NavigableSet) super.mo6elementSet();
    }

    @Override // com.google.common.collect.Multisets.l, com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public Collection mo147delegate() {
        return (SortedMultiset) this.a;
    }
}
