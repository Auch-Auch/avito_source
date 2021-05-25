package com.google.common.collect;

import a2.j.d.c.x3;
import a2.j.d.c.y3;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(serializable = true)
public class TreeBasedTable<R, C, V> extends x3<R, C, V> {
    private static final long serialVersionUID = 0;
    public final Comparator<? super C> h;

    public class a implements Function<Map<C, V>, Iterator<C>> {
        public a(TreeBasedTable treeBasedTable) {
        }

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return ((Map) obj).keySet().iterator();
        }
    }

    public class b extends AbstractIterator<C> {
        @NullableDecl
        public C c;
        public final /* synthetic */ Iterator d;
        public final /* synthetic */ Comparator e;

        public b(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
            this.d = it;
            this.e = comparator;
        }

        @Override // com.google.common.collect.AbstractIterator
        public C computeNext() {
            boolean z;
            while (this.d.hasNext()) {
                C c2 = (C) this.d.next();
                C c3 = this.c;
                if (c3 == null || this.e.compare(c2, c3) != 0) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (!z) {
                    this.c = c2;
                    return c2;
                }
            }
            this.c = null;
            return (C) endOfData();
        }
    }

    public static class c<C, V> implements Supplier<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        public final Comparator<? super C> a;

        public c(Comparator<? super C> comparator) {
            this.a = comparator;
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            return new TreeMap(this.a);
        }
    }

    public class d extends y3<R, C, V>.g implements SortedMap<C, V> {
        @NullableDecl
        public final C d;
        @NullableDecl
        public final C e;
        @NullableDecl
        public transient SortedMap<C, V> f;

        public d(R r, @NullableDecl C c, @NullableDecl C c2) {
            super(r);
            this.d = c;
            this.e = c2;
            Preconditions.checkArgument(c == null || c2 == null || comparator().compare(c, c2) <= 0);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // a2.j.d.c.y3.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return h(obj) && super.containsKey(obj);
        }

        @Override // a2.j.d.c.y3.g
        public Map d() {
            SortedMap<C, V> i = i();
            if (i == null) {
                return null;
            }
            C c = this.d;
            if (c != null) {
                i = i.tailMap(c);
            }
            C c2 = this.e;
            return c2 != null ? i.headMap(c2) : i;
        }

        @Override // a2.j.d.c.y3.g
        public void e() {
            if (i() != null && this.f.isEmpty()) {
                TreeBasedTable.this.c.remove(this.a);
                this.f = null;
                this.b = null;
            }
        }

        /* renamed from: f */
        public SortedMap<C, V> c() {
            return (SortedMap) super.c();
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (c() != null) {
                return c().firstKey();
            }
            throw new NoSuchElementException();
        }

        public int g(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        public boolean h(@NullableDecl Object obj) {
            C c;
            C c2;
            return obj != null && ((c = this.d) == null || g(c, obj) <= 0) && ((c2 = this.e) == null || g(c2, obj) > 0);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c) {
            Preconditions.checkArgument(h(Preconditions.checkNotNull(c)));
            return new d(this.a, this.d, c);
        }

        public SortedMap<C, V> i() {
            SortedMap<C, V> sortedMap = this.f;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.c.containsKey(this.a))) {
                this.f = (SortedMap) TreeBasedTable.this.c.get(this.a);
            }
            return this.f;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set keySet() {
            return new Maps.v(this);
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (c() != null) {
                return c().lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // a2.j.d.c.y3.g, java.util.AbstractMap, java.util.Map
        public V put(C c, V v) {
            Preconditions.checkArgument(h(Preconditions.checkNotNull(c)));
            return (V) super.put(c, v);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c, C c2) {
            Preconditions.checkArgument(h(Preconditions.checkNotNull(c)) && h(Preconditions.checkNotNull(c2)));
            return new d(this.a, c, c2);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c) {
            Preconditions.checkArgument(h(Preconditions.checkNotNull(c)));
            return new d(this.a, c, this.e);
        }
    }

    public TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new c(comparator2));
        this.h = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.y3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.h;
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // a2.j.d.c.y3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@NullableDecl Object obj) {
        return super.containsColumn(obj);
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@NullableDecl Object obj) {
        return super.containsRow(obj);
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object obj) {
        return super.containsValue(obj);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // a2.j.d.c.y3
    public Iterator<C> f() {
        Comparator<? super C> columnComparator = columnComparator();
        return new b(this, Iterators.mergeSorted(Iterables.transform(this.c.values(), new a(this)), columnComparator), columnComparator);
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Object get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void putAll(Table table) {
        super.putAll(table);
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        return mo128rowKeySet().comparator();
    }

    @Override // a2.j.d.c.y3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // a2.j.d.c.q, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Override // a2.j.d.c.y3, com.google.common.collect.Table
    public SortedMap<C, V> row(R r) {
        return new d(r, null, null);
    }

    @Override // a2.j.d.c.x3, a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    /* renamed from: rowKeySet */
    public SortedSet<R> mo128rowKeySet() {
        return super.mo128rowKeySet();
    }

    @Override // a2.j.d.c.x3, a2.j.d.c.y3, com.google.common.collect.Table
    /* renamed from: rowMap */
    public SortedMap<R, Map<C, V>> mo129rowMap() {
        return super.mo129rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}
