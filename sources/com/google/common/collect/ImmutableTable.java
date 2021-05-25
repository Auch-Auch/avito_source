package com.google.common.collect;

import a2.j.d.c.g3;
import a2.j.d.c.h3;
import a2.j.d.c.p3;
import a2.j.d.c.q;
import a2.j.d.c.w3;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class ImmutableTable<R, C, V> extends q<R, C, V> implements Serializable {

    public static final class Builder<R, C, V> {
        public final List<Table.Cell<R, C, V>> a = Lists.newArrayList();
        @MonotonicNonNullDecl
        public Comparator<? super R> b;
        @MonotonicNonNullDecl
        public Comparator<? super C> c;

        public ImmutableTable<R, C, V> build() {
            ImmutableSet immutableSet;
            ImmutableSet immutableSet2;
            int size = this.a.size();
            if (size == 0) {
                return ImmutableTable.of();
            }
            if (size != 1) {
                List<Table.Cell<R, C, V>> list = this.a;
                Comparator<? super R> comparator = this.b;
                Comparator<? super C> comparator2 = this.c;
                Preconditions.checkNotNull(list);
                if (!(comparator == null && comparator2 == null)) {
                    Collections.sort(list, new g3(comparator, comparator2));
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                ImmutableList copyOf = ImmutableList.copyOf((Iterable) list);
                for (T t : list) {
                    linkedHashSet.add(t.getRowKey());
                    linkedHashSet2.add(t.getColumnKey());
                }
                if (comparator == null) {
                    immutableSet = ImmutableSet.copyOf((Collection) linkedHashSet);
                } else {
                    immutableSet = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet));
                }
                if (comparator2 == null) {
                    immutableSet2 = ImmutableSet.copyOf((Collection) linkedHashSet2);
                } else {
                    immutableSet2 = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2));
                }
                return h3.l(copyOf, immutableSet, immutableSet2);
            }
            Table.Cell cell = (Table.Cell) Iterables.getOnlyElement(this.a);
            return new p3(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> orderColumnsBy(Comparator<? super C> comparator) {
            this.c = (Comparator) Preconditions.checkNotNull(comparator, "columnComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> orderRowsBy(Comparator<? super R> comparator) {
            this.b = (Comparator) Preconditions.checkNotNull(comparator, "rowComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> put(R r, C c2, V v) {
            this.a.add(ImmutableTable.e(r, c2, v));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> putAll(Table<? extends R, ? extends C, ? extends V> table) {
            for (Table.Cell<? extends R, ? extends C, ? extends V> cell : table.cellSet()) {
                put(cell);
            }
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.ImmutableTable$Builder<R, C, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<R, C, V> put(Table.Cell<? extends R, ? extends C, ? extends V> cell) {
            if (cell instanceof Tables.c) {
                Preconditions.checkNotNull(cell.getRowKey(), "row");
                Preconditions.checkNotNull(cell.getColumnKey(), "column");
                Preconditions.checkNotNull(cell.getValue(), "value");
                this.a.add(cell);
            } else {
                put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
            }
            return this;
        }
    }

    public static final class a implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] a;
        public final Object[] b;
        public final Object[] c;
        public final int[] d;
        public final int[] e;

        public a(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            this.a = objArr;
            this.b = objArr2;
            this.c = objArr3;
            this.d = iArr;
            this.e = iArr2;
        }

        public static a a(ImmutableTable<?, ?, ?> immutableTable, int[] iArr, int[] iArr2) {
            return new a(immutableTable.mo128rowKeySet().toArray(), immutableTable.columnKeySet().toArray(), immutableTable.values().toArray(), iArr, iArr2);
        }

        public Object readResolve() {
            Object[] objArr = this.c;
            if (objArr.length == 0) {
                return ImmutableTable.of();
            }
            int i = 0;
            if (objArr.length == 1) {
                return ImmutableTable.of(this.a[0], this.b[0], objArr[0]);
            }
            ImmutableList.Builder builder = new ImmutableList.Builder(objArr.length);
            while (true) {
                Object[] objArr2 = this.c;
                if (i >= objArr2.length) {
                    return h3.l(builder.build(), ImmutableSet.copyOf(this.a), ImmutableSet.copyOf(this.b));
                }
                builder.add((ImmutableList.Builder) ImmutableTable.e(this.a[this.d[i]], this.b[this.e[i]], objArr2[i]));
                i++;
            }
        }
    }

    public static <R, C, V> Builder<R, C, V> builder() {
        return new Builder<>();
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Table<? extends R, ? extends C, ? extends V> table) {
        if (table instanceof ImmutableTable) {
            return (ImmutableTable) table;
        }
        Set<Table.Cell<? extends R, ? extends C, ? extends V>> cellSet = table.cellSet();
        Builder builder = builder();
        Iterator<T> it = cellSet.iterator();
        while (it.hasNext()) {
            builder.put(it.next());
        }
        return builder.build();
    }

    public static <R, C, V> Table.Cell<R, C, V> e(R r, C c, V v) {
        return Tables.immutableCell(Preconditions.checkNotNull(r, "rowKey"), Preconditions.checkNotNull(c, "columnKey"), Preconditions.checkNotNull(v, "value"));
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) w3.g;
    }

    @Override // a2.j.d.c.q
    public Iterator a() {
        throw new AssertionError("should never be called");
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return get(obj, obj2) != null;
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@NullableDecl Object obj) {
        return super.containsColumn(obj);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@NullableDecl Object obj) {
        return super.containsRow(obj);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    @Override // a2.j.d.c.q
    public final Iterator<V> d() {
        throw new AssertionError("should never be called");
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f */
    public abstract ImmutableSet<Table.Cell<R, C, V>> b();

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Object get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.get(obj, obj2);
    }

    public abstract a h();

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public abstract ImmutableCollection<V> c();

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(R r, C c, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    @Deprecated
    public final void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        throw new UnsupportedOperationException();
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    /* renamed from: rowMap */
    public abstract ImmutableMap<R, Map<C, V>> mo129rowMap();

    @Override // a2.j.d.c.q, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public final Object writeReplace() {
        return h();
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r, C c, V v) {
        return new p3(r, c, v);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public ImmutableSet<Table.Cell<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // com.google.common.collect.Table
    public ImmutableMap<R, V> column(C c) {
        Preconditions.checkNotNull(c, "columnKey");
        return (ImmutableMap) MoreObjects.firstNonNull((ImmutableMap) columnMap().get(c), ImmutableMap.of());
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public ImmutableMap<C, V> row(R r) {
        Preconditions.checkNotNull(r, "rowKey");
        return (ImmutableMap) MoreObjects.firstNonNull((ImmutableMap) mo129rowMap().get(r), ImmutableMap.of());
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    /* renamed from: rowKeySet */
    public ImmutableSet<R> mo128rowKeySet() {
        return mo129rowMap().keySet();
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }
}
