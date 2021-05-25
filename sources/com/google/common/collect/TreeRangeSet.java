package com.google.common.collect;

import a2.j.d.c.i0;
import a2.j.d.c.j;
import a2.j.d.c.k;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public class TreeRangeSet<C extends Comparable<?>> extends k<C> implements Serializable {
    @VisibleForTesting
    public final NavigableMap<i0<C>, Range<C>> a;
    @MonotonicNonNullDecl
    public transient Set<Range<C>> b;
    @MonotonicNonNullDecl
    public transient Set<Range<C>> c;
    @MonotonicNonNullDecl
    public transient RangeSet<C> d;

    public final class b extends ForwardingCollection<Range<C>> implements Set<Range<C>> {
        public final Collection<Range<C>> a;

        public b(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.a = collection;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return this.a;
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Collection<com.google.common.collect.Range<C>>, java.util.Collection<com.google.common.collect.Range<C extends java.lang.Comparable<?>>> */
        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection<Range<C>> mo147delegate() {
            return (Collection<Range<C>>) this.a;
        }
    }

    public final class c extends TreeRangeSet<C> {
        public c() {
            super(new d(TreeRangeSet.this.a), null);
        }

        @Override // com.google.common.collect.TreeRangeSet, a2.j.d.c.k, com.google.common.collect.RangeSet
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, a2.j.d.c.k, com.google.common.collect.RangeSet
        public boolean contains(C c) {
            return !TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.TreeRangeSet, a2.j.d.c.k, com.google.common.collect.RangeSet
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    public final class f extends TreeRangeSet<C> {
        public final Range<C> e;

        public f(Range<C> range) {
            super(new g(Range.all(), range, TreeRangeSet.this.a), null);
            this.e = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, a2.j.d.c.k, com.google.common.collect.RangeSet
        public void add(Range<C> range) {
            Preconditions.checkArgument(this.e.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.e);
            TreeRangeSet.super.add(range);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.TreeRangeSet */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.TreeRangeSet, a2.j.d.c.k, com.google.common.collect.RangeSet
        public void clear() {
            TreeRangeSet.this.remove(this.e);
        }

        @Override // com.google.common.collect.TreeRangeSet, a2.j.d.c.k, com.google.common.collect.RangeSet
        public boolean contains(C c) {
            return this.e.contains(c) && TreeRangeSet.this.contains(c);
        }

        /* JADX DEBUG: Type inference failed for r0v7. Raw type applied. Possible types: com.google.common.collect.Range<C>, com.google.common.collect.Range<C extends java.lang.Comparable<?>> */
        @Override // com.google.common.collect.TreeRangeSet, a2.j.d.c.k, com.google.common.collect.RangeSet
        public boolean encloses(Range<C> range) {
            if (this.e.isEmpty() || !this.e.encloses(range)) {
                return false;
            }
            TreeRangeSet treeRangeSet = TreeRangeSet.this;
            Objects.requireNonNull(treeRangeSet);
            Preconditions.checkNotNull(range);
            Map.Entry<i0<C>, Range<C>> floorEntry = treeRangeSet.a.floorEntry(range.a);
            Range<C> value = (floorEntry == null || !floorEntry.getValue().encloses(range)) ? null : floorEntry.getValue();
            if (value == null || value.intersection((Range<C>) this.e).isEmpty()) {
                return false;
            }
            return true;
        }

        /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.google.common.collect.Range<C>, com.google.common.collect.Range<C extends java.lang.Comparable<?>> */
        @Override // com.google.common.collect.TreeRangeSet, a2.j.d.c.k, com.google.common.collect.RangeSet
        @NullableDecl
        public Range<C> rangeContaining(C c) {
            Range<C> rangeContaining;
            if (this.e.contains(c) && (rangeContaining = TreeRangeSet.this.rangeContaining(c)) != null) {
                return rangeContaining.intersection((Range<C>) this.e);
            }
            return null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable<?>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.TreeRangeSet, a2.j.d.c.k, com.google.common.collect.RangeSet
        public void remove(Range<C> range) {
            if (range.isConnected(this.e)) {
                TreeRangeSet.this.remove(range.intersection(this.e));
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable<?>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> subRangeSet(Range<C> range) {
            if (range.encloses(this.e)) {
                return this;
            }
            if (range.isConnected(this.e)) {
                return new f(this.e.intersection(range));
            }
            return ImmutableRangeSet.of();
        }
    }

    public static final class g<C extends Comparable<?>> extends j<i0<C>, Range<C>> {
        public final Range<i0<C>> a;
        public final Range<C> b;
        public final NavigableMap<i0<C>, Range<C>> c;
        public final NavigableMap<i0<C>, Range<C>> d;

        public class a extends AbstractIterator<Map.Entry<i0<C>, Range<C>>> {
            public final /* synthetic */ Iterator c;
            public final /* synthetic */ i0 d;

            public a(Iterator it, i0 i0Var) {
                this.c = it;
                this.d = i0Var;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) this.c.next();
                if (this.d.h(range.a)) {
                    return (Map.Entry) endOfData();
                }
                Range intersection = range.intersection(g.this.b);
                return Maps.immutableEntry(intersection.a, intersection);
            }
        }

        public class b extends AbstractIterator<Map.Entry<i0<C>, Range<C>>> {
            public final /* synthetic */ Iterator c;

            public b(Iterator it) {
                this.c = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) this.c.next();
                if (g.this.b.a.compareTo(range.b) >= 0) {
                    return (Map.Entry) endOfData();
                }
                Range intersection = range.intersection(g.this.b);
                if (g.this.a.contains(intersection.a)) {
                    return Maps.immutableEntry(intersection.a, intersection);
                }
                return (Map.Entry) endOfData();
            }
        }

        public g(Range<i0<C>> range, Range<C> range2, NavigableMap<i0<C>, Range<C>> navigableMap) {
            this.a = (Range) Preconditions.checkNotNull(range);
            this.b = (Range) Preconditions.checkNotNull(range2);
            this.c = (NavigableMap) Preconditions.checkNotNull(navigableMap);
            this.d = new e(navigableMap);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.util.NavigableMap<a2.j.d.c.i0<C extends java.lang.Comparable<?>>, com.google.common.collect.Range<C extends java.lang.Comparable<?>>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<i0<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (this.b.isEmpty()) {
                return Iterators.j.e;
            }
            if (this.a.b.h(this.b.a)) {
                return Iterators.j.e;
            }
            boolean z = false;
            if (this.a.a.h(this.b.a)) {
                it = this.d.tailMap(this.b.a, false).values().iterator();
            } else {
                NavigableMap<i0<C>, Range<C>> navigableMap = this.c;
                C e = this.a.a.e();
                if (this.a.lowerBoundType() == BoundType.CLOSED) {
                    z = true;
                }
                it = navigableMap.tailMap(e, z).values().iterator();
            }
            return new a(it, (i0) Ordering.natural().min(this.a.b, new i0.d(this.b.b)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.NavigableMap<a2.j.d.c.i0<C extends java.lang.Comparable<?>>, com.google.common.collect.Range<C extends java.lang.Comparable<?>>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // a2.j.d.c.j
        public Iterator<Map.Entry<i0<C>, Range<C>>> c() {
            if (this.b.isEmpty()) {
                return Iterators.j.e;
            }
            i0 i0Var = (i0) Ordering.natural().min(this.a.b, new i0.d(this.b.b));
            return new b(this.c.headMap(i0Var.e(), i0Var.l() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public Comparator<? super i0<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return get(obj) != null;
        }

        @NullableDecl
        /* renamed from: d */
        public Range<C> get(@NullableDecl Object obj) {
            Range<C> range;
            if (obj instanceof i0) {
                try {
                    i0<C> i0Var = (i0) obj;
                    if (this.a.contains(i0Var) && i0Var.compareTo(this.b.a) >= 0) {
                        if (i0Var.compareTo(this.b.b) < 0) {
                            if (i0Var.equals(this.b.a)) {
                                Map.Entry<i0<C>, Range<C>> floorEntry = this.c.floorEntry(i0Var);
                                if (floorEntry == null) {
                                    range = null;
                                } else {
                                    range = floorEntry.getValue();
                                }
                                Range<C> range2 = range;
                                if (range2 != null && range2.b.compareTo(this.b.a) > 0) {
                                    return range2.intersection(this.b);
                                }
                            } else {
                                Range range3 = (Range) this.c.get(i0Var);
                                if (range3 != null) {
                                    return range3.intersection(this.b);
                                }
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        public final NavigableMap<i0<C>, Range<C>> e(Range<i0<C>> range) {
            if (!range.isConnected(this.a)) {
                return ImmutableSortedMap.of();
            }
            return new g(this.a.intersection(range), this.b, this.c);
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return e(Range.upTo((i0) obj, BoundType.a(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.size(a());
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return e(Range.range((i0) obj, BoundType.a(z), (i0) obj2, BoundType.a(z2)));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return e(Range.downTo((i0) obj, BoundType.a(z)));
        }
    }

    public TreeRangeSet(NavigableMap<i0<C>, Range<C>> navigableMap) {
        this.a = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    public final void a(Range<C> range) {
        if (range.isEmpty()) {
            this.a.remove(range.a);
        } else {
            this.a.put(range.a, range);
        }
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public void add(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (!range.isEmpty()) {
            i0<C> i0Var = range.a;
            i0<C> i0Var2 = range.b;
            Map.Entry<i0<C>, Range<C>> lowerEntry = this.a.lowerEntry(i0Var);
            if (lowerEntry != null) {
                Range<C> value = lowerEntry.getValue();
                if (value.b.compareTo(i0Var) >= 0) {
                    if (value.b.compareTo(i0Var2) >= 0) {
                        i0Var2 = value.b;
                    }
                    i0Var = value.a;
                }
            }
            Map.Entry<i0<C>, Range<C>> floorEntry = this.a.floorEntry(i0Var2);
            if (floorEntry != null) {
                Range<C> value2 = floorEntry.getValue();
                if (value2.b.compareTo(i0Var2) >= 0) {
                    i0Var2 = value2.b;
                }
            }
            this.a.subMap(i0Var, i0Var2).clear();
            a(new Range<>(i0Var, i0Var2));
        }
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(RangeSet rangeSet) {
        super.addAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.c;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.a.descendingMap().values());
        this.c = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.b;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.a.values());
        this.b = bVar;
        return bVar;
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> complement() {
        RangeSet<C> rangeSet = this.d;
        if (rangeSet != null) {
            return rangeSet;
        }
        c cVar = new c();
        this.d = cVar;
        return cVar;
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> range) {
        Preconditions.checkNotNull(range);
        Map.Entry<i0<C>, Range<C>> floorEntry = this.a.floorEntry(range.a);
        return floorEntry != null && floorEntry.getValue().encloses(range);
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public boolean intersects(Range<C> range) {
        Preconditions.checkNotNull(range);
        Map.Entry<i0<C>, Range<C>> ceilingEntry = this.a.ceilingEntry(range.a);
        if (ceilingEntry != null && ceilingEntry.getValue().isConnected(range) && !ceilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<i0<C>, Range<C>> lowerEntry = this.a.lowerEntry(range.a);
        if (lowerEntry == null || !lowerEntry.getValue().isConnected(range) || lowerEntry.getValue().intersection(range).isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    @NullableDecl
    public Range<C> rangeContaining(C c2) {
        Preconditions.checkNotNull(c2);
        Map.Entry<i0<C>, Range<C>> floorEntry = this.a.floorEntry(new i0.d(c2));
        if (floorEntry == null || !floorEntry.getValue().contains(c2)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public void remove(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (!range.isEmpty()) {
            Map.Entry<i0<C>, Range<C>> lowerEntry = this.a.lowerEntry(range.a);
            if (lowerEntry != null) {
                Range<C> value = lowerEntry.getValue();
                if (value.b.compareTo(range.a) >= 0) {
                    if (range.hasUpperBound() && value.b.compareTo(range.b) >= 0) {
                        a(new Range<>(range.b, value.b));
                    }
                    a(new Range<>(value.a, range.a));
                }
            }
            Map.Entry<i0<C>, Range<C>> floorEntry = this.a.floorEntry(range.b);
            if (floorEntry != null) {
                Range<C> value2 = floorEntry.getValue();
                if (range.hasUpperBound() && value2.b.compareTo(range.b) >= 0) {
                    a(new Range<>(range.b, value2.b));
                }
            }
            this.a.subMap(range.a, range.b).clear();
        }
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(RangeSet rangeSet) {
        super.removeAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        Map.Entry<i0<C>, Range<C>> firstEntry = this.a.firstEntry();
        Map.Entry<i0<C>, Range<C>> lastEntry = this.a.lastEntry();
        if (firstEntry != null) {
            return new Range<>(firstEntry.getValue().a, lastEntry.getValue().b);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new f(range);
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(RangeSet<C> rangeSet) {
        TreeRangeSet<C> create = create();
        create.addAll(rangeSet);
        return create;
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // a2.j.d.c.k, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    @VisibleForTesting
    public static final class e<C extends Comparable<?>> extends j<i0<C>, Range<C>> {
        public final NavigableMap<i0<C>, Range<C>> a;
        public final Range<i0<C>> b;

        public class a extends AbstractIterator<Map.Entry<i0<C>, Range<C>>> {
            public final /* synthetic */ Iterator c;

            public a(Iterator it) {
                this.c = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) this.c.next();
                if (e.this.b.b.h(range.b)) {
                    return (Map.Entry) endOfData();
                }
                return Maps.immutableEntry(range.b, range);
            }
        }

        public class b extends AbstractIterator<Map.Entry<i0<C>, Range<C>>> {
            public final /* synthetic */ PeekingIterator c;

            public b(PeekingIterator peekingIterator) {
                this.c = peekingIterator;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) this.c.next();
                if (e.this.b.a.h(range.b)) {
                    return Maps.immutableEntry(range.b, range);
                }
                return (Map.Entry) endOfData();
            }
        }

        public e(NavigableMap<i0<C>, Range<C>> navigableMap) {
            this.a = navigableMap;
            this.b = Range.all();
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<i0<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (!this.b.hasLowerBound()) {
                it = this.a.values().iterator();
            } else {
                Map.Entry<i0<C>, Range<C>> lowerEntry = this.a.lowerEntry(this.b.lowerEndpoint());
                if (lowerEntry == null) {
                    it = this.a.values().iterator();
                } else if (this.b.a.h(lowerEntry.getValue().b)) {
                    it = this.a.tailMap(lowerEntry.getKey(), true).values().iterator();
                } else {
                    it = this.a.tailMap(this.b.lowerEndpoint(), true).values().iterator();
                }
            }
            return new a(it);
        }

        @Override // a2.j.d.c.j
        public Iterator<Map.Entry<i0<C>, Range<C>>> c() {
            Collection<Range<C>> collection;
            if (this.b.hasUpperBound()) {
                collection = this.a.headMap(this.b.upperEndpoint(), false).descendingMap().values();
            } else {
                collection = this.a.descendingMap().values();
            }
            PeekingIterator peekingIterator = Iterators.peekingIterator(collection.iterator());
            if (peekingIterator.hasNext() && this.b.b.h(((Range) peekingIterator.peek()).b)) {
                peekingIterator.next();
            }
            return new b(peekingIterator);
        }

        @Override // java.util.SortedMap
        public Comparator<? super i0<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return get(obj) != null;
        }

        /* renamed from: d */
        public Range<C> get(@NullableDecl Object obj) {
            Map.Entry<i0<C>, Range<C>> lowerEntry;
            if (obj instanceof i0) {
                try {
                    i0<C> i0Var = (i0) obj;
                    if (this.b.contains(i0Var) && (lowerEntry = this.a.lowerEntry(i0Var)) != null && lowerEntry.getValue().b.equals(i0Var)) {
                        return lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        public final NavigableMap<i0<C>, Range<C>> e(Range<i0<C>> range) {
            if (range.isConnected(this.b)) {
                return new e(this.a, range.intersection(this.b));
            }
            return ImmutableSortedMap.of();
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return e(Range.upTo((i0) obj, BoundType.a(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.b.equals(Range.all())) {
                return this.a.isEmpty();
            }
            return !a().hasNext();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            if (this.b.equals(Range.all())) {
                return this.a.size();
            }
            return Iterators.size(a());
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return e(Range.range((i0) obj, BoundType.a(z), (i0) obj2, BoundType.a(z2)));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return e(Range.downTo((i0) obj, BoundType.a(z)));
        }

        public e(NavigableMap<i0<C>, Range<C>> navigableMap, Range<i0<C>> range) {
            this.a = navigableMap;
            this.b = range;
        }
    }

    public TreeRangeSet(NavigableMap navigableMap, a aVar) {
        this.a = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }

    public static final class d<C extends Comparable<?>> extends j<i0<C>, Range<C>> {
        public final NavigableMap<i0<C>, Range<C>> a;
        public final NavigableMap<i0<C>, Range<C>> b;
        public final Range<i0<C>> c;

        public class a extends AbstractIterator<Map.Entry<i0<C>, Range<C>>> {
            public i0<C> c;
            public final /* synthetic */ i0 d;
            public final /* synthetic */ PeekingIterator e;

            public a(i0 i0Var, PeekingIterator peekingIterator) {
                this.d = i0Var;
                this.e = peekingIterator;
                this.c = i0Var;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                i0.a aVar;
                Range range;
                if (d.this.c.b.h(this.c) || this.c == (aVar = i0.a.b)) {
                    return (Map.Entry) endOfData();
                }
                if (this.e.hasNext()) {
                    Range range2 = (Range) this.e.next();
                    range = new Range(this.c, range2.a);
                    this.c = range2.b;
                } else {
                    range = new Range(this.c, aVar);
                    this.c = aVar;
                }
                return Maps.immutableEntry(range.a, range);
            }
        }

        public class b extends AbstractIterator<Map.Entry<i0<C>, Range<C>>> {
            public i0<C> c;
            public final /* synthetic */ i0 d;
            public final /* synthetic */ PeekingIterator e;

            public b(i0 i0Var, PeekingIterator peekingIterator) {
                this.d = i0Var;
                this.e = peekingIterator;
                this.c = i0Var;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                i0<C> i0Var = this.c;
                i0.c cVar = i0.c.b;
                if (i0Var == cVar) {
                    return (Map.Entry) endOfData();
                }
                if (this.e.hasNext()) {
                    Range range = (Range) this.e.next();
                    Range range2 = new Range(range.b, this.c);
                    this.c = range.a;
                    if (d.this.c.a.h(range2.a)) {
                        return Maps.immutableEntry(range2.a, range2);
                    }
                } else if (d.this.c.a.h(cVar)) {
                    Range range3 = new Range(cVar, this.c);
                    this.c = cVar;
                    return Maps.immutableEntry(cVar, range3);
                }
                return (Map.Entry) endOfData();
            }
        }

        public d(NavigableMap<i0<C>, Range<C>> navigableMap) {
            Range<i0<C>> all = Range.all();
            this.a = navigableMap;
            this.b = new e(navigableMap);
            this.c = all;
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<i0<C>, Range<C>>> a() {
            Collection<Range<C>> collection;
            if (this.c.hasLowerBound()) {
                collection = this.b.tailMap(this.c.lowerEndpoint(), this.c.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                collection = this.b.values();
            }
            PeekingIterator peekingIterator = Iterators.peekingIterator(collection.iterator());
            Range<i0<C>> range = this.c;
            i0<C> i0Var = i0.c.b;
            if (!range.contains(i0Var) || (peekingIterator.hasNext() && ((Range) peekingIterator.peek()).a == i0Var)) {
                if (!peekingIterator.hasNext()) {
                    return Iterators.j.e;
                }
                i0Var = ((Range) peekingIterator.next()).b;
            }
            return new a(i0Var, peekingIterator);
        }

        @Override // a2.j.d.c.j
        public Iterator<Map.Entry<i0<C>, Range<C>>> c() {
            i0<C> i0Var;
            i0<C> i0Var2;
            if (this.c.hasUpperBound()) {
                i0Var = this.c.upperEndpoint();
            } else {
                i0Var = i0.a.b;
            }
            PeekingIterator peekingIterator = Iterators.peekingIterator(this.b.headMap(i0Var, this.c.hasUpperBound() && this.c.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (!peekingIterator.hasNext()) {
                Range<i0<C>> range = this.c;
                i0.c cVar = i0.c.b;
                if (!range.contains(cVar) || this.a.containsKey(cVar)) {
                    return Iterators.j.e;
                }
                i0Var2 = this.a.higherKey(cVar);
            } else if (((Range) peekingIterator.peek()).b == i0.a.b) {
                i0Var2 = ((Range) peekingIterator.next()).a;
            } else {
                i0Var2 = this.a.higherKey(((Range) peekingIterator.peek()).b);
            }
            return new b((i0) MoreObjects.firstNonNull(i0Var2, i0.a.b), peekingIterator);
        }

        @Override // java.util.SortedMap
        public Comparator<? super i0<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @NullableDecl
        /* renamed from: d */
        public Range<C> get(Object obj) {
            if (!(obj instanceof i0)) {
                return null;
            }
            try {
                i0 i0Var = (i0) obj;
                Map.Entry<i0<C>, Range<C>> firstEntry = e(Range.downTo(i0Var, BoundType.a(true))).firstEntry();
                if (firstEntry == null || !firstEntry.getKey().equals(i0Var)) {
                    return null;
                }
                return firstEntry.getValue();
            } catch (ClassCastException unused) {
                return null;
            }
        }

        public final NavigableMap<i0<C>, Range<C>> e(Range<i0<C>> range) {
            if (!this.c.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new d(this.a, range.intersection(this.c));
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return e(Range.upTo((i0) obj, BoundType.a(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.size(a());
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return e(Range.range((i0) obj, BoundType.a(z), (i0) obj2, BoundType.a(z2)));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return e(Range.downTo((i0) obj, BoundType.a(z)));
        }

        public d(NavigableMap<i0<C>, Range<C>> navigableMap, Range<i0<C>> range) {
            this.a = navigableMap;
            this.b = new e(navigableMap);
            this.c = range;
        }
    }
}
