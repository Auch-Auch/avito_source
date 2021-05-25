package com.google.common.collect;

import a2.j.d.c.f3;
import a2.j.d.c.i0;
import a2.j.d.c.k;
import a2.j.d.c.l0;
import a2.j.d.c.n1;
import a2.j.d.c.s3;
import a2.j.d.c.t3;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public final class ImmutableRangeSet<C extends Comparable> extends k<C> implements Serializable {
    public static final ImmutableRangeSet<Comparable<?>> c = new ImmutableRangeSet<>(ImmutableList.of());
    public static final ImmutableRangeSet<Comparable<?>> d = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));
    public final transient ImmutableList<Range<C>> a;
    @LazyInit
    public transient ImmutableRangeSet<C> b;

    public static class Builder<C extends Comparable<?>> {
        public final List<Range<C>> a = Lists.newArrayList();

        @CanIgnoreReturnValue
        public Builder<C> add(Range<C> range) {
            Preconditions.checkArgument(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.a.add(range);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<C> addAll(RangeSet<C> rangeSet) {
            return addAll(rangeSet.asRanges());
        }

        public ImmutableRangeSet<C> build() {
            ImmutableList.Builder builder = new ImmutableList.Builder(this.a.size());
            List<Range<C>> list = this.a;
            Range<Comparable> range = Range.c;
            Collections.sort(list, Range.b.a);
            PeekingIterator peekingIterator = Iterators.peekingIterator(this.a.iterator());
            while (peekingIterator.hasNext()) {
                Range range2 = (Range) peekingIterator.next();
                while (peekingIterator.hasNext()) {
                    Range<C> range3 = (Range) peekingIterator.peek();
                    if (!range2.isConnected(range3)) {
                        break;
                    }
                    Preconditions.checkArgument(range2.intersection(range3).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range2, range3);
                    range2 = range2.span((Range) peekingIterator.next());
                }
                builder.add((ImmutableList.Builder) range2);
            }
            ImmutableList build = builder.build();
            if (build.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            return (build.size() != 1 || !((Range) Iterables.getOnlyElement(build)).equals(Range.all())) ? new ImmutableRangeSet<>(build) : (ImmutableRangeSet<C>) ImmutableRangeSet.d;
        }

        @CanIgnoreReturnValue
        public Builder<C> addAll(Iterable<Range<C>> iterable) {
            for (Range<C> range : iterable) {
                add(range);
            }
            return this;
        }
    }

    public final class a extends ImmutableSortedSet<C> {
        public final DiscreteDomain<C> e;
        @MonotonicNonNullDecl
        public transient Integer f;

        /* renamed from: com.google.common.collect.ImmutableRangeSet$a$a  reason: collision with other inner class name */
        public class C0279a extends AbstractIterator<C> {
            public final Iterator<Range<C>> c;
            public Iterator<C> d = Iterators.j.e;

            public C0279a() {
                this.c = ImmutableRangeSet.this.a.mo99iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                while (!this.d.hasNext()) {
                    if (!this.c.hasNext()) {
                        return (Comparable) endOfData();
                    }
                    this.d = ContiguousSet.create(this.c.next(), a.this.e).mo99iterator();
                }
                return this.d.next();
            }
        }

        public class b extends AbstractIterator<C> {
            public final Iterator<Range<C>> c;
            public Iterator<C> d = Iterators.j.e;

            public b() {
                this.c = ImmutableRangeSet.this.a.reverse().mo99iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                while (!this.d.hasNext()) {
                    if (!this.c.hasNext()) {
                        return (Comparable) endOfData();
                    }
                    this.d = ContiguousSet.create(this.c.next(), a.this.e).descendingIterator();
                }
                return this.d.next();
            }
        }

        public a(DiscreteDomain<C> discreteDomain) {
            super(Ordering.natural());
            this.e = discreteDomain;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        @GwtIncompatible("NavigableSet")
        /* renamed from: descendingIterator */
        public UnmodifiableIterator<C> mo98descendingIterator() {
            return new b();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return ImmutableRangeSet.this.a.e();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: iterator */
        public UnmodifiableIterator<C> mo99iterator() {
            return new C0279a();
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> m() {
            return new l0(this);
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet o(Object obj, boolean z) {
            return r(Range.upTo((Comparable) obj, BoundType.a(z)));
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet p(Object obj, boolean z, Object obj2, boolean z2) {
            Comparable comparable = (Comparable) obj;
            Comparable comparable2 = (Comparable) obj2;
            if (!z && !z2) {
                Range<Comparable> range = Range.c;
                if (comparable.compareTo(comparable2) == 0) {
                    return ImmutableSortedSet.of();
                }
            }
            return r(Range.range(comparable, BoundType.a(z), comparable2, BoundType.a(z2)));
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet q(Object obj, boolean z) {
            return r(Range.downTo((Comparable) obj, BoundType.a(z)));
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.google.common.collect.DiscreteDomain<C>, com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
        public ImmutableSortedSet<C> r(Range<C> range) {
            return ImmutableRangeSet.this.subRangeSet((Range) range).asSet((DiscreteDomain<C>) this.e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer num = this.f;
            if (num == null) {
                long j = 0;
                UnmodifiableIterator<Range<C>> it = ImmutableRangeSet.this.a.mo99iterator();
                while (it.hasNext()) {
                    j += (long) ContiguousSet.create(it.next(), this.e).size();
                    if (j >= 2147483647L) {
                        break;
                    }
                }
                num = Integer.valueOf(Ints.saturatedCast(j));
                this.f = num;
            }
            return num.intValue();
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return ImmutableRangeSet.this.a.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new b(ImmutableRangeSet.this.a, this.e);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        @GwtIncompatible("NavigableSet")
        /* renamed from: descendingIterator  reason: collision with other method in class */
        public Iterator mo98descendingIterator() {
            return new b();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: iterator  reason: collision with other method in class */
        public Iterator mo99iterator() {
            return new C0279a();
        }
    }

    public static class b<C extends Comparable> implements Serializable {
        public final ImmutableList<Range<C>> a;
        public final DiscreteDomain<C> b;

        public b(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            this.a = immutableList;
            this.b = discreteDomain;
        }

        public Object readResolve() {
            return new ImmutableRangeSet(this.a).asSet(this.b);
        }
    }

    public final class c extends ImmutableList<Range<C>> {
        public final boolean c;
        public final boolean d;
        public final int e;

        public c() {
            boolean hasLowerBound = ImmutableRangeSet.this.a.get(0).hasLowerBound();
            this.c = hasLowerBound;
            boolean hasUpperBound = ((Range) Iterables.getLast(ImmutableRangeSet.this.a)).hasUpperBound();
            this.d = hasUpperBound;
            int size = ImmutableRangeSet.this.a.size() - 1;
            size = hasLowerBound ? size + 1 : size;
            this.e = hasUpperBound ? size + 1 : size;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i) {
            i0 i0Var;
            i0 i0Var2;
            Preconditions.checkElementIndex(i, this.e);
            if (!this.c) {
                i0Var = ImmutableRangeSet.this.a.get(i).b;
            } else if (i == 0) {
                i0Var = i0.c.b;
            } else {
                i0Var = ImmutableRangeSet.this.a.get(i - 1).b;
            }
            if (!this.d || i != this.e - 1) {
                i0Var2 = ImmutableRangeSet.this.a.get(i + (!this.c ? 1 : 0)).a;
            } else {
                i0Var2 = i0.a.b;
            }
            return new Range(i0Var, i0Var2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.e;
        }
    }

    public static final class d<C extends Comparable> implements Serializable {
        public final ImmutableList<Range<C>> a;

        public d(ImmutableList<Range<C>> immutableList) {
            this.a = immutableList;
        }

        public Object readResolve() {
            if (this.a.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (this.a.equals(ImmutableList.of(Range.all()))) {
                return ImmutableRangeSet.d;
            }
            return new ImmutableRangeSet(this.a);
        }
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.a = immutableList;
    }

    public static <C extends Comparable<?>> Builder<C> builder() {
        return new Builder<>();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(RangeSet<C> rangeSet) {
        Preconditions.checkNotNull(rangeSet);
        if (rangeSet.isEmpty()) {
            return of();
        }
        if (rangeSet.encloses(Range.all())) {
            return d;
        }
        if (rangeSet instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) rangeSet;
            if (!immutableRangeSet.a.e()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) rangeSet.asRanges()));
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return c;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    @Deprecated
    public void addAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        if (isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> canonical = span().canonical(discreteDomain);
        if (canonical.hasLowerBound()) {
            if (!canonical.hasUpperBound()) {
                try {
                    discreteDomain.maxValue();
                } catch (NoSuchElementException unused) {
                    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                }
            }
            return new a(discreteDomain);
        }
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public ImmutableRangeSet<C> difference(RangeSet<C> rangeSet) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(rangeSet);
        return copyOf(create);
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> range) {
        ImmutableList<Range<C>> immutableList = this.a;
        Range<Comparable> range2 = Range.c;
        int o = AppCompatDelegateImpl.i.o(immutableList, Range.a.a, range.a, Ordering.natural(), t3.ANY_PRESENT, s3.NEXT_LOWER);
        return o != -1 && this.a.get(o).encloses(range);
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public ImmutableRangeSet<C> intersection(RangeSet<C> rangeSet) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(rangeSet.complement());
        return copyOf(create);
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public boolean intersects(Range<C> range) {
        ImmutableList<Range<C>> immutableList = this.a;
        Range<Comparable> range2 = Range.c;
        int o = AppCompatDelegateImpl.i.o(immutableList, Range.a.a, range.a, Ordering.natural(), t3.ANY_PRESENT, s3.NEXT_HIGHER);
        if (o < this.a.size() && this.a.get(o).isConnected(range) && !this.a.get(o).intersection(range).isEmpty()) {
            return true;
        }
        if (o > 0) {
            int i = o - 1;
            if (this.a.get(i).isConnected(range) && !this.a.get(i).intersection(range).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public Range<C> rangeContaining(C c2) {
        ImmutableList<Range<C>> immutableList = this.a;
        Range<Comparable> range = Range.c;
        int o = AppCompatDelegateImpl.i.o(immutableList, Range.a.a, new i0.d(c2), Ordering.natural(), t3.ANY_PRESENT, s3.NEXT_LOWER);
        if (o == -1) {
            return null;
        }
        Range<C> range2 = this.a.get(o);
        if (range2.contains(c2)) {
            return range2;
        }
        return null;
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    @Deprecated
    public void removeAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        if (!this.a.isEmpty()) {
            i0<C> i0Var = this.a.get(0).a;
            ImmutableList<Range<C>> immutableList = this.a;
            return new Range<>(i0Var, immutableList.get(immutableList.size() - 1).b);
        }
        throw new NoSuchElementException();
    }

    public ImmutableRangeSet<C> union(RangeSet<C> rangeSet) {
        return unionOf(Iterables.concat(asRanges(), rangeSet.asRanges()));
    }

    public Object writeReplace() {
        return new d(this.a);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return of();
        }
        if (range.equals(Range.all())) {
            return d;
        }
        return new ImmutableRangeSet<>(ImmutableList.of(range));
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        if (this.a.isEmpty()) {
            return ImmutableSet.of();
        }
        ImmutableList<Range<C>> reverse = this.a.reverse();
        Range<Comparable> range = Range.c;
        return new f3(reverse, Range.b.a.reverse());
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asRanges() {
        if (this.a.isEmpty()) {
            return ImmutableSet.of();
        }
        ImmutableList<Range<C>> immutableList = this.a;
        Range<Comparable> range = Range.c;
        return new f3(immutableList, Range.b.a);
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.b;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.a.isEmpty()) {
            ImmutableRangeSet<Comparable<?>> immutableRangeSet2 = d;
            this.b = immutableRangeSet2;
            return immutableRangeSet2;
        } else if (this.a.size() != 1 || !this.a.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> immutableRangeSet3 = new ImmutableRangeSet<>(new c(), this);
            this.b = immutableRangeSet3;
            return immutableRangeSet3;
        } else {
            ImmutableRangeSet<C> of = of();
            this.b = of;
            return of;
        }
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        ImmutableList<Range<C>> immutableList;
        int i;
        int i2;
        if (!isEmpty()) {
            Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                s3 s3Var = s3.NEXT_HIGHER;
                if (this.a.isEmpty() || range.isEmpty()) {
                    immutableList = ImmutableList.of();
                } else if (range.encloses(span())) {
                    immutableList = this.a;
                } else {
                    if (range.hasLowerBound()) {
                        ImmutableList<Range<C>> immutableList2 = this.a;
                        Range<Comparable> range2 = Range.c;
                        i = AppCompatDelegateImpl.i.n(immutableList2, Range.c.a, range.a, t3.FIRST_AFTER, s3Var);
                    } else {
                        i = 0;
                    }
                    if (range.hasUpperBound()) {
                        ImmutableList<Range<C>> immutableList3 = this.a;
                        Range<Comparable> range3 = Range.c;
                        i2 = AppCompatDelegateImpl.i.n(immutableList3, Range.a.a, range.b, t3.FIRST_PRESENT, s3Var);
                    } else {
                        i2 = this.a.size();
                    }
                    int i3 = i2 - i;
                    if (i3 == 0) {
                        immutableList = ImmutableList.of();
                    } else {
                        immutableList = new n1(this, i3, i, range);
                    }
                }
                return new ImmutableRangeSet<>(immutableList);
            }
        }
        return of();
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.a = immutableList;
        this.b = immutableRangeSet;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        return new Builder().addAll(iterable).build();
    }
}
