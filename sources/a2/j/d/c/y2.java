package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.BoundType;
import com.google.common.collect.Collections2;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class y2<C extends Comparable> extends ContiguousSet<C> {
    public static final /* synthetic */ int g = 0;
    private static final long serialVersionUID = 0;
    public final Range<C> f;

    public class a extends AbstractSequentialIterator<C> {
        public final C b;

        public a(Comparable comparable) {
            super(comparable);
            this.b = (C) y2.this.last();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0015 A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
        @Override // com.google.common.collect.AbstractSequentialIterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object computeNext(java.lang.Object r3) {
            /*
                r2 = this;
                java.lang.Comparable r3 = (java.lang.Comparable) r3
                C r0 = r2.b
                int r1 = a2.j.d.c.y2.g
                if (r0 == 0) goto L_0x0012
                com.google.common.collect.Range<java.lang.Comparable> r1 = com.google.common.collect.Range.c
                int r0 = r3.compareTo(r0)
                if (r0 != 0) goto L_0x0012
                r0 = 1
                goto L_0x0013
            L_0x0012:
                r0 = 0
            L_0x0013:
                if (r0 == 0) goto L_0x0017
                r3 = 0
                goto L_0x001f
            L_0x0017:
                a2.j.d.c.y2 r0 = a2.j.d.c.y2.this
                com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> r0 = r0.e
                java.lang.Comparable r3 = r0.next(r3)
            L_0x001f:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.d.c.y2.a.computeNext(java.lang.Object):java.lang.Object");
        }
    }

    public class b extends AbstractSequentialIterator<C> {
        public final C b;

        public b(Comparable comparable) {
            super(comparable);
            this.b = (C) y2.this.first();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0015 A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
        @Override // com.google.common.collect.AbstractSequentialIterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object computeNext(java.lang.Object r3) {
            /*
                r2 = this;
                java.lang.Comparable r3 = (java.lang.Comparable) r3
                C r0 = r2.b
                int r1 = a2.j.d.c.y2.g
                if (r0 == 0) goto L_0x0012
                com.google.common.collect.Range<java.lang.Comparable> r1 = com.google.common.collect.Range.c
                int r0 = r3.compareTo(r0)
                if (r0 != 0) goto L_0x0012
                r0 = 1
                goto L_0x0013
            L_0x0012:
                r0 = 0
            L_0x0013:
                if (r0 == 0) goto L_0x0017
                r3 = 0
                goto L_0x001f
            L_0x0017:
                a2.j.d.c.y2 r0 = a2.j.d.c.y2.this
                com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> r0 = r0.e
                java.lang.Comparable r3 = r0.previous(r3)
            L_0x001f:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.d.c.y2.b.computeNext(java.lang.Object):java.lang.Object");
        }
    }

    public class c extends d1<C> {
        public c() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public Object get(int i) {
            Preconditions.checkElementIndex(i, size());
            y2 y2Var = y2.this;
            return y2Var.e.a(y2Var.first(), (long) i);
        }

        @Override // a2.j.d.c.d1
        public ImmutableCollection j() {
            return y2.this;
        }
    }

    @GwtIncompatible
    public static final class d<C extends Comparable> implements Serializable {
        public final Range<C> a;
        public final DiscreteDomain<C> b;

        public d(Range range, DiscreteDomain discreteDomain, a aVar) {
            this.a = range;
            this.b = discreteDomain;
        }

        private Object readResolve() {
            return new y2(this.a, this.b);
        }
    }

    public y2(Range<C> range, DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
        this.f = range;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.f.contains((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return Collections2.b(this, collection);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    /* renamed from: descendingIterator */
    public UnmodifiableIterator<C> mo98descendingIterator() {
        return new b(last());
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y2) {
            y2 y2Var = (y2) obj;
            if (this.e.equals(y2Var.e)) {
                if (!first().equals(y2Var.first()) || !last().equals(y2Var.last())) {
                    return false;
                }
                return true;
            }
        }
        return super.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        return Sets.b(this);
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<C> i() {
        if (this.e.a) {
            return new c();
        }
        return ImmutableList.f(toArray());
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        Preconditions.checkNotNull(contiguousSet);
        Preconditions.checkArgument(this.e.equals(contiguousSet.e));
        if (contiguousSet.isEmpty()) {
            return contiguousSet;
        }
        Comparable comparable = (Comparable) Ordering.natural().max(first(), contiguousSet.first());
        Comparable comparable2 = (Comparable) Ordering.natural().min(last(), contiguousSet.last());
        return comparable.compareTo(comparable2) <= 0 ? ContiguousSet.create(Range.closed(comparable, comparable2), this.e) : new o0(this.e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: iterator */
    public UnmodifiableIterator<C> mo99iterator() {
        return new a(first());
    }

    @Override // com.google.common.collect.ContiguousSet
    /* renamed from: r */
    public ContiguousSet<C> o(C c2, boolean z) {
        return v(Range.upTo(c2, BoundType.a(z)));
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        BoundType boundType = BoundType.CLOSED;
        return new Range<>(this.f.a.m(boundType, this.e), this.f.b.n(boundType, this.e));
    }

    @Override // com.google.common.collect.ContiguousSet
    /* renamed from: s */
    public ContiguousSet<C> p(C c2, boolean z, C c3, boolean z2) {
        if (c2.compareTo(c3) != 0 || z || z2) {
            return v(Range.range(c2, BoundType.a(z), c3, BoundType.a(z2)));
        }
        return new o0(this.e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long distance = this.e.distance(first(), last());
        if (distance >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) distance) + 1;
    }

    @Override // com.google.common.collect.ContiguousSet
    /* renamed from: t */
    public ContiguousSet<C> q(C c2, boolean z) {
        return v(Range.downTo(c2, BoundType.a(z)));
    }

    /* renamed from: u */
    public C first() {
        return this.f.a.i(this.e);
    }

    public final ContiguousSet<C> v(Range<C> range) {
        return this.f.isConnected(range) ? ContiguousSet.create(this.f.intersection(range), this.e) : new o0(this.e);
    }

    /* renamed from: w */
    public C last() {
        return this.f.b.f(this.e);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new d(this.f, this.e, null);
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType boundType, BoundType boundType2) {
        return new Range<>(this.f.a.m(boundType, this.e), this.f.b.n(boundType2, this.e));
    }
}
