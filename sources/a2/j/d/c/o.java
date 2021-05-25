package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedMultiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public abstract class o<E> extends i<E> implements SortedMultiset<E> {
    public final Comparator<? super E> c;
    @MonotonicNonNullDecl
    public transient SortedMultiset<E> d;

    public o() {
        this(Ordering.natural());
    }

    @Override // a2.j.d.c.i
    public Set a() {
        return new v3(this);
    }

    @Override // com.google.common.collect.SortedMultiset, a2.j.d.c.q3
    public Comparator<? super E> comparator() {
        return this.c;
    }

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: descendingMultiset */
    public SortedMultiset<E> mo11descendingMultiset() {
        SortedMultiset<E> sortedMultiset = this.d;
        if (sortedMultiset != null) {
            return sortedMultiset;
        }
        n nVar = new n(this);
        this.d = nVar;
        return nVar;
    }

    public abstract Iterator<Multiset.Entry<E>> e();

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        Iterator<Multiset.Entry<E>> d2 = d();
        if (d2.hasNext()) {
            return d2.next();
        }
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        Iterator<Multiset.Entry<E>> e = e();
        if (e.hasNext()) {
            return e.next();
        }
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        Iterator<Multiset.Entry<E>> d2 = d();
        if (!d2.hasNext()) {
            return null;
        }
        Multiset.Entry<E> next = d2.next();
        Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(next.getElement(), next.getCount());
        d2.remove();
        return immutableEntry;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        Iterator<Multiset.Entry<E>> e = e();
        if (!e.hasNext()) {
            return null;
        }
        Multiset.Entry<E> next = e.next();
        Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(next.getElement(), next.getCount());
        e.remove();
        return immutableEntry;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(@NullableDecl E e, BoundType boundType, @NullableDecl E e2, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return mo13tailMultiset(e, boundType).mo12headMultiset(e2, boundType2);
    }

    public o(Comparator<? super E> comparator) {
        this.c = (Comparator) Preconditions.checkNotNull(comparator);
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public NavigableSet<E> mo6elementSet() {
        return (NavigableSet) super.mo6elementSet();
    }
}
