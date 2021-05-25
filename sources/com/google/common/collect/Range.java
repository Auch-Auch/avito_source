package com.google.common.collect;

import a2.j.d.c.i0;
import a2.j.d.c.x2;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class Range<C extends Comparable> extends x2 implements Predicate<C>, Serializable {
    public static final Range<Comparable> c = new Range<>(i0.c.b, i0.a.b);
    private static final long serialVersionUID = 0;
    public final i0<C> a;
    public final i0<C> b;

    public static class a implements Function<Range, i0> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Function
        public i0 apply(Range range) {
            return range.a;
        }
    }

    public static class b extends Ordering<Range<?>> implements Serializable {
        public static final Ordering<Range<?>> a = new b();
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            Range range = (Range) obj;
            Range range2 = (Range) obj2;
            return ComparisonChain.start().compare(range.a, range2.a).compare(range.b, range2.b).result();
        }
    }

    public static class c implements Function<Range, i0> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Function
        public i0 apply(Range range) {
            return range.b;
        }
    }

    public Range(i0<C> i0Var, i0<C> i0Var2) {
        this.a = (i0) Preconditions.checkNotNull(i0Var);
        this.b = (i0) Preconditions.checkNotNull(i0Var2);
        if (i0Var.compareTo(i0Var2) > 0 || i0Var == i0.a.b || i0Var2 == i0.c.b) {
            StringBuilder L = a2.b.a.a.a.L("Invalid range: ");
            StringBuilder sb = new StringBuilder(16);
            i0Var.c(sb);
            sb.append("..");
            i0Var2.d(sb);
            L.append(sb.toString());
            throw new IllegalArgumentException(L.toString());
        }
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) c;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c2) {
        return new Range<>(new i0.d(c2), i0.a.b);
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c2) {
        return new Range<>(i0.c.b, new i0.b(c2));
    }

    public static <C extends Comparable<?>> Range<C> closed(C c2, C c3) {
        return new Range<>(new i0.d(c2), new i0.b(c3));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c2, C c3) {
        return new Range<>(new i0.d(c2), new i0.d(c3));
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c2, BoundType boundType) {
        int ordinal = boundType.ordinal();
        if (ordinal == 0) {
            return greaterThan(c2);
        }
        if (ordinal == 1) {
            return atLeast(c2);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) sortedSet.first(), (Comparable) sortedSet.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) Preconditions.checkNotNull(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) Preconditions.checkNotNull(it.next());
            comparable = (Comparable) Ordering.natural().min(comparable, comparable3);
            comparable2 = (Comparable) Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c2) {
        return new Range<>(new i0.b(c2), i0.a.b);
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c2) {
        return new Range<>(i0.c.b, new i0.d(c2));
    }

    public static <C extends Comparable<?>> Range<C> open(C c2, C c3) {
        return new Range<>(new i0.b(c2), new i0.d(c3));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c2, C c3) {
        return new Range<>(new i0.b(c2), new i0.b(c3));
    }

    public static <C extends Comparable<?>> Range<C> range(C c2, BoundType boundType, C c3, BoundType boundType2) {
        i0 i0Var;
        i0 i0Var2;
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        if (boundType == boundType3) {
            i0Var = new i0.b(c2);
        } else {
            i0Var = new i0.d(c2);
        }
        if (boundType2 == boundType3) {
            i0Var2 = new i0.d(c3);
        } else {
            i0Var2 = new i0.b(c3);
        }
        return new Range<>(i0Var, i0Var2);
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c2) {
        return closed(c2, c2);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c2, BoundType boundType) {
        int ordinal = boundType.ordinal();
        if (ordinal == 0) {
            return lessThan(c2);
        }
        if (ordinal == 1) {
            return atMost(c2);
        }
        throw new AssertionError();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Predicate
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Object obj) {
        return apply((Range<C>) ((Comparable) obj));
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        i0<C> a3 = this.a.a(discreteDomain);
        i0<C> a4 = this.b.a(discreteDomain);
        return (a3 == this.a && a4 == this.b) ? this : new Range<>(a3, a4);
    }

    public boolean contains(C c2) {
        Preconditions.checkNotNull(c2);
        return this.a.h(c2) && !this.b.h(c2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (Iterables.isEmpty(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                if (!contains((Comparable) sortedSet.first()) || !contains((Comparable) sortedSet.last())) {
                    return false;
                }
                return true;
            }
        }
        Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains((Comparable) it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        return this.a.compareTo(range.a) <= 0 && this.b.compareTo(range.b) >= 0;
    }

    @Override // java.lang.Object, com.google.common.base.Predicate
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (!this.a.equals(range.a) || !this.b.equals(range.b)) {
            return false;
        }
        return true;
    }

    public Range<C> gap(Range<C> range) {
        boolean z = this.a.compareTo(range.a) < 0;
        Range<C> range2 = z ? this : range;
        if (!z) {
            range = this;
        }
        return new Range<>(range2.b, range.a);
    }

    public boolean hasLowerBound() {
        return this.a != i0.c.b;
    }

    public boolean hasUpperBound() {
        return this.b != i0.a.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public Range<C> intersection(Range<C> range) {
        int b2 = this.a.compareTo(range.a);
        int b3 = this.b.compareTo(range.b);
        if (b2 >= 0 && b3 <= 0) {
            return this;
        }
        if (b2 <= 0 && b3 >= 0) {
            return range;
        }
        return new Range<>(b2 >= 0 ? this.a : range.a, b3 <= 0 ? this.b : range.b);
    }

    public boolean isConnected(Range<C> range) {
        return this.a.compareTo(range.b) <= 0 && range.a.compareTo(this.b) <= 0;
    }

    public boolean isEmpty() {
        return this.a.equals(this.b);
    }

    public BoundType lowerBoundType() {
        return this.a.j();
    }

    public C lowerEndpoint() {
        return this.a.e();
    }

    public Object readResolve() {
        return equals(c) ? all() : this;
    }

    public Range<C> span(Range<C> range) {
        int b2 = this.a.compareTo(range.a);
        int b3 = this.b.compareTo(range.b);
        if (b2 <= 0 && b3 >= 0) {
            return this;
        }
        if (b2 >= 0 && b3 <= 0) {
            return range;
        }
        return new Range<>(b2 <= 0 ? this.a : range.a, b3 >= 0 ? this.b : range.b);
    }

    @Override // java.lang.Object
    public String toString() {
        i0<C> i0Var = this.a;
        i0<C> i0Var2 = this.b;
        StringBuilder sb = new StringBuilder(16);
        i0Var.c(sb);
        sb.append("..");
        i0Var2.d(sb);
        return sb.toString();
    }

    public BoundType upperBoundType() {
        return this.b.l();
    }

    public C upperEndpoint() {
        return this.b.e();
    }

    @Deprecated
    public boolean apply(C c2) {
        return contains(c2);
    }
}
