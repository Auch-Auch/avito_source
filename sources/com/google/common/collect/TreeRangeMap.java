package com.google.common.collect;

import a2.j.d.c.g;
import a2.j.d.c.i0;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {
    public static final RangeMap b = new a();
    public final NavigableMap<i0<K>, c<K, V>> a = Maps.newTreeMap();

    public static class a implements RangeMap {
        @Override // com.google.common.collect.RangeMap
        public Map<Range, Object> asDescendingMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range, Object> asMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // com.google.common.collect.RangeMap
        public void clear() {
        }

        @Override // com.google.common.collect.RangeMap
        @NullableDecl
        public Object get(Comparable comparable) {
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        @NullableDecl
        public Map.Entry<Range, Object> getEntry(Comparable comparable) {
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        public void put(Range range, Object obj) {
            Preconditions.checkNotNull(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(RangeMap rangeMap) {
            if (!rangeMap.asMapOfRanges().isEmpty()) {
                throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
            }
        }

        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(Range range, Object obj) {
            Preconditions.checkNotNull(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        @Override // com.google.common.collect.RangeMap
        public void remove(Range range) {
            Preconditions.checkNotNull(range);
        }

        @Override // com.google.common.collect.RangeMap
        public Range span() {
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.RangeMap
        public RangeMap subRangeMap(Range range) {
            Preconditions.checkNotNull(range);
            return this;
        }
    }

    public final class b extends Maps.p<Range<K>, V> {
        public final Iterable<Map.Entry<Range<K>, V>> a;

        public b(Iterable<c<K, V>> iterable) {
            this.a = iterable;
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Iterator<java.util.Map$Entry<com.google.common.collect.Range<K>, V>>, java.util.Iterator<java.util.Map$Entry<com.google.common.collect.Range<K extends java.lang.Comparable>, V>> */
        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<Range<K>, V>> a() {
            return (Iterator<Map.Entry<Range<K>, V>>) this.a.iterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@NullableDecl Object obj) {
            if (!(obj instanceof Range)) {
                return null;
            }
            Range range = (Range) obj;
            c cVar = (c) TreeRangeMap.this.a.get(range.a);
            if (cVar == null || !cVar.a.equals(range)) {
                return null;
            }
            return cVar.b;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return TreeRangeMap.this.a.size();
        }
    }

    public class d implements RangeMap<K, V> {
        public final Range<K> a;

        public class a extends TreeRangeMap<K, V>.d.b {

            /* renamed from: com.google.common.collect.TreeRangeMap$d$a$a  reason: collision with other inner class name */
            public class C0287a extends AbstractIterator<Map.Entry<Range<K>, V>> {
                public final /* synthetic */ Iterator c;

                public C0287a(Iterator it) {
                    this.c = it;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.google.common.collect.Range<K extends java.lang.Comparable> */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.AbstractIterator
                public Object computeNext() {
                    if (!this.c.hasNext()) {
                        return (Map.Entry) endOfData();
                    }
                    c cVar = (c) this.c.next();
                    if (cVar.a.b.compareTo(d.this.a.a) <= 0) {
                        return (Map.Entry) endOfData();
                    }
                    return Maps.immutableEntry(cVar.a.intersection(d.this.a), cVar.b);
                }
            }

            public a() {
                super();
            }

            @Override // com.google.common.collect.TreeRangeMap.d.b
            public Iterator<Map.Entry<Range<K>, V>> c() {
                if (d.this.a.isEmpty()) {
                    return Iterators.j.e;
                }
                d dVar = d.this;
                return new C0287a(TreeRangeMap.this.a.headMap(dVar.a.b, false).descendingMap().values().iterator());
            }
        }

        public class b extends AbstractMap<Range<K>, V> {

            public class a extends Maps.q<Range<K>, V> {
                public a(Map map) {
                    super(map);
                }

                @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(@NullableDecl Object obj) {
                    return b.this.remove(obj) != null;
                }

                @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return b.a(b.this, Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.h.KEY));
                }
            }

            /* renamed from: com.google.common.collect.TreeRangeMap$d$b$b  reason: collision with other inner class name */
            public class C0288b extends Maps.i<Range<K>, V> {
                public C0288b() {
                }

                @Override // com.google.common.collect.Maps.i
                public Map<Range<K>, V> d() {
                    return b.this;
                }

                @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean isEmpty() {
                    return !iterator().hasNext();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
                public Iterator<Map.Entry<Range<K>, V>> iterator() {
                    return b.this.c();
                }

                @Override // com.google.common.collect.Maps.i, com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return b.a(b.this, Predicates.not(Predicates.in(collection)));
                }

                @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Iterators.size(iterator());
                }
            }

            public class c extends AbstractIterator<Map.Entry<Range<K>, V>> {
                public final /* synthetic */ Iterator c;

                public c(Iterator it) {
                    this.c = it;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.google.common.collect.Range<K extends java.lang.Comparable> */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.AbstractIterator
                public Object computeNext() {
                    while (this.c.hasNext()) {
                        c cVar = (c) this.c.next();
                        if (cVar.a.a.compareTo(d.this.a.b) >= 0) {
                            return (Map.Entry) endOfData();
                        }
                        if (cVar.a.b.compareTo(d.this.a.a) > 0) {
                            return Maps.immutableEntry(cVar.a.intersection(d.this.a), cVar.b);
                        }
                    }
                    return (Map.Entry) endOfData();
                }
            }

            /* renamed from: com.google.common.collect.TreeRangeMap$d$b$d  reason: collision with other inner class name */
            public class C0289d extends Maps.f0<Range<K>, V> {
                public C0289d(Map map) {
                    super(map);
                }

                @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection<?> collection) {
                    return b.a(b.this, Predicates.compose(Predicates.in(collection), Maps.h.VALUE));
                }

                @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
                public boolean retainAll(Collection<?> collection) {
                    return b.a(b.this, Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.h.VALUE));
                }
            }

            public b() {
            }

            public static boolean a(b bVar, Predicate predicate) {
                Objects.requireNonNull(bVar);
                ArrayList<Range<K>> newArrayList = Lists.newArrayList();
                Iterator<Map.Entry<Range<K>, V>> it = new C0288b().iterator();
                while (it.hasNext()) {
                    Map.Entry<Range<K>, V> next = it.next();
                    if (predicate.apply(next)) {
                        newArrayList.add(next.getKey());
                    }
                }
                for (Range<K> range : newArrayList) {
                    TreeRangeMap.this.remove(range);
                }
                return !newArrayList.isEmpty();
            }

            public Iterator<Map.Entry<Range<K>, V>> c() {
                if (d.this.a.isEmpty()) {
                    return Iterators.j.e;
                }
                d dVar = d.this;
                return new c(TreeRangeMap.this.a.tailMap((i0) MoreObjects.firstNonNull(TreeRangeMap.this.a.floorKey(dVar.a.a), d.this.a.a), true).values().iterator());
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.TreeRangeMap */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractMap, java.util.Map
            public void clear() {
                d dVar = d.this;
                TreeRangeMap.this.remove(dVar.a);
            }

            @Override // java.util.AbstractMap, java.util.Map
            public boolean containsKey(Object obj) {
                return get(obj) != null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Map.Entry<Range<K>, V>> entrySet() {
                return new C0288b();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.google.common.collect.Range<K extends java.lang.Comparable> */
            /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.google.common.collect.Range<K extends java.lang.Comparable> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractMap, java.util.Map
            public V get(Object obj) {
                c<K, V> cVar;
                try {
                    if (obj instanceof Range) {
                        Range range = (Range) obj;
                        if (d.this.a.encloses(range)) {
                            if (!range.isEmpty()) {
                                if (range.a.compareTo(d.this.a.a) == 0) {
                                    Map.Entry<i0<K>, c<K, V>> floorEntry = TreeRangeMap.this.a.floorEntry(range.a);
                                    cVar = floorEntry != null ? floorEntry.getValue() : null;
                                } else {
                                    cVar = (c) TreeRangeMap.this.a.get(range.a);
                                }
                                if (cVar != null && cVar.a.isConnected(d.this.a) && cVar.a.intersection(d.this.a).equals(range)) {
                                    return cVar.b;
                                }
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Range<K>> keySet() {
                return new a(this);
            }

            @Override // java.util.AbstractMap, java.util.Map
            public V remove(Object obj) {
                V v = (V) get(obj);
                if (v == null) {
                    return null;
                }
                TreeRangeMap.this.remove((Range) obj);
                return v;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Collection<V> values() {
                return new C0289d(this);
            }
        }

        public d(Range<K> range) {
            this.a = range;
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<K>, V> asDescendingMapOfRanges() {
            return new a();
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<K>, V> asMapOfRanges() {
            return new b();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.TreeRangeMap */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.RangeMap
        public void clear() {
            TreeRangeMap.this.remove(this.a);
        }

        @Override // com.google.common.collect.RangeMap, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof RangeMap) {
                return new b().equals(((RangeMap) obj).asMapOfRanges());
            }
            return false;
        }

        @Override // com.google.common.collect.RangeMap
        @NullableDecl
        public V get(K k) {
            if (this.a.contains(k)) {
                return (V) TreeRangeMap.this.get(k);
            }
            return null;
        }

        /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: com.google.common.collect.Range<K>, com.google.common.collect.Range<K extends java.lang.Comparable> */
        @Override // com.google.common.collect.RangeMap
        @NullableDecl
        public Map.Entry<Range<K>, V> getEntry(K k) {
            Map.Entry<Range<K>, V> entry;
            if (!this.a.contains(k) || (entry = TreeRangeMap.this.getEntry(k)) == null) {
                return null;
            }
            return Maps.immutableEntry(entry.getKey().intersection((Range<K>) this.a), entry.getValue());
        }

        @Override // com.google.common.collect.RangeMap, java.lang.Object
        public int hashCode() {
            return new b().hashCode();
        }

        @Override // com.google.common.collect.RangeMap
        public void put(Range<K> range, V v) {
            Preconditions.checkArgument(this.a.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.a);
            TreeRangeMap.this.put(range, v);
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(RangeMap<K, V> rangeMap) {
            if (!rangeMap.asMapOfRanges().isEmpty()) {
                Range<K> span = rangeMap.span();
                Preconditions.checkArgument(this.a.encloses(span), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", span, this.a);
                TreeRangeMap.this.putAll(rangeMap);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.google.common.collect.TreeRangeMap */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(Range<K> range, V v) {
            if (TreeRangeMap.this.a.isEmpty() || range.isEmpty() || !this.a.encloses(range)) {
                Preconditions.checkArgument(this.a.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.a);
                TreeRangeMap.this.put(range, v);
                return;
            }
            Range<K> intersection = TreeRangeMap.this.b(range, Preconditions.checkNotNull(v)).intersection(this.a);
            Preconditions.checkArgument(this.a.encloses(intersection), "Cannot put range %s into a subRangeMap(%s)", intersection, this.a);
            TreeRangeMap.this.put(intersection, v);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.Range<K extends java.lang.Comparable> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.RangeMap
        public void remove(Range<K> range) {
            if (range.isConnected(this.a)) {
                TreeRangeMap.this.remove(range.intersection(this.a));
            }
        }

        @Override // com.google.common.collect.RangeMap
        public Range<K> span() {
            i0<K> i0Var;
            i0<C> i0Var2;
            Map.Entry<i0<K>, c<K, V>> floorEntry = TreeRangeMap.this.a.floorEntry(this.a.a);
            if (floorEntry == null || floorEntry.getValue().a.b.compareTo(this.a.a) <= 0) {
                i0Var = TreeRangeMap.this.a.ceilingKey(this.a.a);
                if (i0Var == null || i0Var.compareTo(this.a.b) >= 0) {
                    throw new NoSuchElementException();
                }
            } else {
                i0Var = this.a.a;
            }
            Map.Entry<i0<K>, c<K, V>> lowerEntry = TreeRangeMap.this.a.lowerEntry(this.a.b);
            if (lowerEntry != null) {
                if (lowerEntry.getValue().a.b.compareTo(this.a.b) >= 0) {
                    i0Var2 = this.a.b;
                } else {
                    i0Var2 = lowerEntry.getValue().a.b;
                }
                return new Range<>(i0Var, i0Var2);
            }
            throw new NoSuchElementException();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.Range<K extends java.lang.Comparable> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.RangeMap
        public RangeMap<K, V> subRangeMap(Range<K> range) {
            if (range.isConnected(this.a)) {
                return TreeRangeMap.this.subRangeMap(range.intersection(this.a));
            }
            Objects.requireNonNull(TreeRangeMap.this);
            return TreeRangeMap.b;
        }

        @Override // com.google.common.collect.RangeMap, java.lang.Object
        public String toString() {
            return new b().toString();
        }
    }

    public static <K extends Comparable, V> Range<K> a(Range<K> range, V v, @NullableDecl Map.Entry<i0<K>, c<K, V>> entry) {
        return (entry == null || !entry.getValue().a.isConnected(range) || !entry.getValue().b.equals(v)) ? range : range.span(entry.getValue().a);
    }

    public static <K extends Comparable, V> TreeRangeMap<K, V> create() {
        return new TreeRangeMap<>();
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asDescendingMapOfRanges() {
        return new b(this.a.descendingMap().values());
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asMapOfRanges() {
        return new b(this.a.values());
    }

    public final Range<K> b(Range<K> range, V v) {
        return a(a(range, v, this.a.lowerEntry(range.a)), v, this.a.floorEntry(range.b));
    }

    public final void c(i0<K> i0Var, i0<K> i0Var2, V v) {
        this.a.put(i0Var, new c(i0Var, i0Var2, v));
    }

    @Override // com.google.common.collect.RangeMap
    public void clear() {
        this.a.clear();
    }

    @Override // com.google.common.collect.RangeMap, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.RangeMap
    @NullableDecl
    public V get(K k) {
        Map.Entry<Range<K>, V> entry = getEntry(k);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    @NullableDecl
    public Map.Entry<Range<K>, V> getEntry(K k) {
        Map.Entry<i0<K>, c<K, V>> floorEntry = this.a.floorEntry(new i0.d(k));
        if (floorEntry == null || !floorEntry.getValue().a.contains(k)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // com.google.common.collect.RangeMap, java.lang.Object
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    public void put(Range<K> range, V v) {
        if (!range.isEmpty()) {
            Preconditions.checkNotNull(v);
            remove(range);
            this.a.put(range.a, new c(range, v));
        }
    }

    @Override // com.google.common.collect.RangeMap
    public void putAll(RangeMap<K, V> rangeMap) {
        for (Map.Entry<Range<K>, V> entry : rangeMap.asMapOfRanges().entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.TreeRangeMap<K extends java.lang.Comparable, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeMap
    public void putCoalescing(Range<K> range, V v) {
        if (this.a.isEmpty()) {
            put(range, v);
        } else {
            put(b(range, Preconditions.checkNotNull(v)), v);
        }
    }

    @Override // com.google.common.collect.RangeMap
    public void remove(Range<K> range) {
        if (!range.isEmpty()) {
            Map.Entry<i0<K>, c<K, V>> lowerEntry = this.a.lowerEntry(range.a);
            if (lowerEntry != null) {
                c<K, V> value = lowerEntry.getValue();
                if (value.a.b.compareTo(range.a) > 0) {
                    if (value.a.b.compareTo(range.b) > 0) {
                        c(range.b, value.a.b, lowerEntry.getValue().b);
                    }
                    c(value.a.a, range.a, lowerEntry.getValue().b);
                }
            }
            Map.Entry<i0<K>, c<K, V>> lowerEntry2 = this.a.lowerEntry(range.b);
            if (lowerEntry2 != null) {
                c<K, V> value2 = lowerEntry2.getValue();
                if (value2.a.b.compareTo(range.b) > 0) {
                    c(range.b, value2.a.b, lowerEntry2.getValue().b);
                }
            }
            this.a.subMap(range.a, range.b).clear();
        }
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        Map.Entry<i0<K>, c<K, V>> firstEntry = this.a.firstEntry();
        Map.Entry<i0<K>, c<K, V>> lastEntry = this.a.lastEntry();
        if (firstEntry != null) {
            return new Range<>(firstEntry.getValue().a.a, lastEntry.getValue().a.b);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeMap
    public RangeMap<K, V> subRangeMap(Range<K> range) {
        if (range.equals(Range.all())) {
            return this;
        }
        return new d(range);
    }

    @Override // com.google.common.collect.RangeMap, java.lang.Object
    public String toString() {
        return this.a.values().toString();
    }

    public static final class c<K extends Comparable, V> extends g<Range<K>, V> {
        public final Range<K> a;
        public final V b;

        public c(Range<K> range, V v) {
            this.a = range;
            this.b = v;
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public Object getKey() {
            return this.a;
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        public c(i0<K> i0Var, i0<K> i0Var2, V v) {
            this.a = new Range<>(i0Var, i0Var2);
            this.b = v;
        }
    }
}
