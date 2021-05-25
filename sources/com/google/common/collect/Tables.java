package com.google.common.collect;

import a2.j.d.c.a5;
import a2.j.d.c.q;
import a2.j.d.c.y3;
import a2.j.d.c.z4;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class Tables {
    public static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> a = new a();

    public static class a implements Function<Map<Object, Object>, Map<Object, Object>> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Function
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    public static abstract class b<R, C, V> implements Table.Cell<R, C, V> {
        @Override // com.google.common.collect.Table.Cell
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            if (!Objects.equal(getRowKey(), cell.getRowKey()) || !Objects.equal(getColumnKey(), cell.getColumnKey()) || !Objects.equal(getValue(), cell.getValue())) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.Table.Cell
        public int hashCode() {
            return Objects.hashCode(getRowKey(), getColumnKey(), getValue());
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("(");
            L.append((Object) getRowKey());
            L.append(",");
            L.append((Object) getColumnKey());
            L.append(")=");
            L.append((Object) getValue());
            return L.toString();
        }
    }

    public static final class c<R, C, V> extends b<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        @NullableDecl
        public final R a;
        @NullableDecl
        public final C b;
        @NullableDecl
        public final V c;

        public c(@NullableDecl R r, @NullableDecl C c2, @NullableDecl V v) {
            this.a = r;
            this.b = c2;
            this.c = v;
        }

        @Override // com.google.common.collect.Table.Cell
        public C getColumnKey() {
            return this.b;
        }

        @Override // com.google.common.collect.Table.Cell
        public R getRowKey() {
            return this.a;
        }

        @Override // com.google.common.collect.Table.Cell
        public V getValue() {
            return this.c;
        }
    }

    public static class d<R, C, V1, V2> extends q<R, C, V2> {
        public final Table<R, C, V1> c;
        public final Function<? super V1, V2> d;

        public class a implements Function<Map<C, V1>, Map<C, V2>> {
            public a() {
            }

            @Override // com.google.common.base.Function
            public Object apply(Object obj) {
                return Maps.transformValues((Map) obj, d.this.d);
            }
        }

        public class b implements Function<Map<R, V1>, Map<R, V2>> {
            public b() {
            }

            @Override // com.google.common.base.Function
            public Object apply(Object obj) {
                return Maps.transformValues((Map) obj, d.this.d);
            }
        }

        public d(Table<R, C, V1> table, Function<? super V1, V2> function) {
            this.c = (Table) Preconditions.checkNotNull(table);
            this.d = (Function) Preconditions.checkNotNull(function);
        }

        @Override // a2.j.d.c.q
        public Iterator<Table.Cell<R, C, V2>> a() {
            return Iterators.transform(this.c.cellSet().iterator(), new a5(this));
        }

        @Override // a2.j.d.c.q
        public Collection<V2> c() {
            return Collections2.transform(this.c.values(), this.d);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public void clear() {
            this.c.clear();
        }

        @Override // com.google.common.collect.Table
        public Map<R, V2> column(C c2) {
            return Maps.transformValues(this.c.column(c2), this.d);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public Set<C> columnKeySet() {
            return this.c.columnKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map<C, Map<R, V2>> columnMap() {
            return Maps.transformValues(this.c.columnMap(), new b());
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public boolean contains(Object obj, Object obj2) {
            return this.c.contains(obj, obj2);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public V2 get(Object obj, Object obj2) {
            if (this.c.contains(obj, obj2)) {
                return this.d.apply(this.c.get(obj, obj2));
            }
            return null;
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public V2 put(R r, C c2, V2 v2) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V2> table) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public V2 remove(Object obj, Object obj2) {
            if (this.c.contains(obj, obj2)) {
                return this.d.apply(this.c.remove(obj, obj2));
            }
            return null;
        }

        @Override // com.google.common.collect.Table
        public Map<C, V2> row(R r) {
            return Maps.transformValues(this.c.row(r), this.d);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        /* renamed from: rowKeySet */
        public Set<R> mo128rowKeySet() {
            return this.c.mo128rowKeySet();
        }

        @Override // com.google.common.collect.Table
        /* renamed from: rowMap */
        public Map<R, Map<C, V2>> mo129rowMap() {
            return Maps.transformValues(this.c.mo129rowMap(), new a());
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.c.size();
        }
    }

    public static class e<C, R, V> extends q<C, R, V> {
        public static final Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> d = new a();
        public final Table<R, C, V> c;

        public static class a implements Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.base.Function
            public Table.Cell<?, ?, ?> apply(Table.Cell<?, ?, ?> cell) {
                Table.Cell<?, ?, ?> cell2 = cell;
                return Tables.immutableCell(cell2.getColumnKey(), cell2.getRowKey(), cell2.getValue());
            }
        }

        public e(Table<R, C, V> table) {
            this.c = (Table) Preconditions.checkNotNull(table);
        }

        @Override // a2.j.d.c.q
        public Iterator<Table.Cell<C, R, V>> a() {
            return Iterators.transform(this.c.cellSet().iterator(), d);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public void clear() {
            this.c.clear();
        }

        @Override // com.google.common.collect.Table
        public Map<C, V> column(R r) {
            return this.c.row(r);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public Set<R> columnKeySet() {
            return this.c.mo128rowKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map<R, Map<C, V>> columnMap() {
            return this.c.mo129rowMap();
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
            return this.c.contains(obj2, obj);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public boolean containsColumn(@NullableDecl Object obj) {
            return this.c.containsRow(obj);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public boolean containsRow(@NullableDecl Object obj) {
            return this.c.containsColumn(obj);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public boolean containsValue(@NullableDecl Object obj) {
            return this.c.containsValue(obj);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
            return this.c.get(obj2, obj);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public V put(C c2, R r, V v) {
            return this.c.put(r, c2, v);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public void putAll(Table<? extends C, ? extends R, ? extends V> table) {
            this.c.putAll(Tables.transpose(table));
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public V remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
            return this.c.remove(obj2, obj);
        }

        @Override // com.google.common.collect.Table
        public Map<R, V> row(C c2) {
            return this.c.column(c2);
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        /* renamed from: rowKeySet */
        public Set<C> mo128rowKeySet() {
            return this.c.columnKeySet();
        }

        @Override // com.google.common.collect.Table
        /* renamed from: rowMap */
        public Map<C, Map<R, V>> mo129rowMap() {
            return this.c.columnMap();
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.c.size();
        }

        @Override // a2.j.d.c.q, com.google.common.collect.Table
        public Collection<V> values() {
            return this.c.values();
        }
    }

    public static class g<R, C, V> extends ForwardingTable<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        public final Table<? extends R, ? extends C, ? extends V> a;

        public g(Table<? extends R, ? extends C, ? extends V> table) {
            this.a = (Table) Preconditions.checkNotNull(table);
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set<Table.Cell<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<R, V> column(@NullableDecl C c) {
            return Collections.unmodifiableMap(super.column(c));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<C, Map<R, V>> columnMap() {
            return Collections.unmodifiableMap(Maps.transformValues(super.columnMap(), Tables.a));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public V put(@NullableDecl R r, @NullableDecl C c, @NullableDecl V v) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public V remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<C, V> row(@NullableDecl R r) {
            return Collections.unmodifiableMap(super.row(r));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        /* renamed from: rowKeySet */
        public Set<R> mo128rowKeySet() {
            return Collections.unmodifiableSet(super.mo128rowKeySet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        /* renamed from: rowMap */
        public Map<R, Map<C, V>> mo129rowMap() {
            return Collections.unmodifiableMap(Maps.transformValues(super.mo129rowMap(), Tables.a));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: com.google.common.collect.Table<? extends R, ? extends C, ? extends V>, com.google.common.collect.Table<R, C, V> */
        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Table<R, C, V> mo147delegate() {
            return (Table<? extends R, ? extends C, ? extends V>) this.a;
        }
    }

    public static <R, C, V> Table.Cell<R, C, V> immutableCell(@NullableDecl R r, @NullableDecl C c2, @NullableDecl V v) {
        return new c(r, c2, v);
    }

    @Beta
    public static <R, C, V> Table<R, C, V> newCustomTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkNotNull(supplier);
        return new y3(map, supplier);
    }

    public static <R, C, V> Table<R, C, V> synchronizedTable(Table<R, C, V> table) {
        return new z4(table, null);
    }

    @Beta
    public static <R, C, V1, V2> Table<R, C, V2> transformValues(Table<R, C, V1> table, Function<? super V1, V2> function) {
        return new d(table, function);
    }

    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: com.google.common.collect.Table<R, C, V>, com.google.common.collect.Table<C, R, V> */
    public static <R, C, V> Table<C, R, V> transpose(Table<R, C, V> table) {
        return table instanceof e ? (Table<R, C, V>) ((e) table).c : new e(table);
    }

    @Beta
    public static <R, C, V> RowSortedTable<R, C, V> unmodifiableRowSortedTable(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
        return new f(rowSortedTable);
    }

    public static <R, C, V> Table<R, C, V> unmodifiableTable(Table<? extends R, ? extends C, ? extends V> table) {
        return new g(table);
    }

    public static final class f<R, C, V> extends g<R, C, V> implements RowSortedTable<R, C, V> {
        private static final long serialVersionUID = 0;

        public f(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
            super(rowSortedTable);
        }

        @Override // com.google.common.collect.Tables.g, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Table mo147delegate() {
            return (RowSortedTable) this.a;
        }

        @Override // com.google.common.collect.Tables.g, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        /* renamed from: rowKeySet */
        public Set mo128rowKeySet() {
            return Collections.unmodifiableSortedSet(((RowSortedTable) this.a).mo128rowKeySet());
        }

        @Override // com.google.common.collect.Tables.g, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        /* renamed from: rowMap */
        public Map mo129rowMap() {
            return Collections.unmodifiableSortedMap(Maps.transformValues((SortedMap) ((RowSortedTable) this.a).mo129rowMap(), (Function) Tables.a));
        }

        @Override // com.google.common.collect.Tables.g, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Object mo147delegate() {
            return (RowSortedTable) this.a;
        }

        @Override // com.google.common.collect.Tables.g, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        /* renamed from: rowKeySet  reason: collision with other method in class */
        public SortedSet<R> mo128rowKeySet() {
            return Collections.unmodifiableSortedSet(((RowSortedTable) this.a).mo128rowKeySet());
        }

        @Override // com.google.common.collect.Tables.g, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        /* renamed from: rowMap  reason: collision with other method in class */
        public SortedMap<R, Map<C, V>> mo129rowMap() {
            return Collections.unmodifiableSortedMap(Maps.transformValues((SortedMap) ((RowSortedTable) this.a).mo129rowMap(), (Function) Tables.a));
        }
    }
}
