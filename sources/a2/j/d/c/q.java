package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class q<R, C, V> implements Table<R, C, V> {
    @MonotonicNonNullDecl
    public transient Set<Table.Cell<R, C, V>> a;
    @MonotonicNonNullDecl
    public transient Collection<V> b;

    public class a extends b5<Table.Cell<R, C, V>, V> {
        public a(q qVar, Iterator it) {
            super(it);
        }

        @Override // a2.j.d.c.b5
        public Object a(Object obj) {
            return ((Table.Cell) obj).getValue();
        }
    }

    public class b extends AbstractSet<Table.Cell<R, C, V>> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            q.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Map map = (Map) Maps.l(q.this.mo129rowMap(), cell.getRowKey());
            if (map == null || !Collections2.e(map.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue()))) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Table.Cell<R, C, V>> iterator() {
            return q.this.a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            boolean z;
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Map map = (Map) Maps.l(q.this.mo129rowMap(), cell.getRowKey());
            if (map == null) {
                return false;
            }
            Set entrySet = map.entrySet();
            Map.Entry immutableEntry = Maps.immutableEntry(cell.getColumnKey(), cell.getValue());
            Preconditions.checkNotNull(entrySet);
            try {
                z = entrySet.remove(immutableEntry);
            } catch (ClassCastException | NullPointerException unused) {
                z = false;
            }
            if (z) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return q.this.size();
        }
    }

    public class c extends AbstractCollection<V> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            q.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return q.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return q.this.d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return q.this.size();
        }
    }

    public abstract Iterator<Table.Cell<R, C, V>> a();

    public Set<Table.Cell<R, C, V>> b() {
        return new b();
    }

    public Collection<V> c() {
        return new c();
    }

    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        Set<Table.Cell<R, C, V>> set = this.a;
        if (set != null) {
            return set;
        }
        Set<Table.Cell<R, C, V>> b2 = b();
        this.a = b2;
        return b2;
    }

    @Override // com.google.common.collect.Table
    public abstract void clear();

    @Override // com.google.common.collect.Table
    public abstract Set<C> columnKeySet();

    @Override // com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Map map = (Map) Maps.l(mo129rowMap(), obj);
        return map != null && Maps.k(map, obj2);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object obj) {
        return Maps.k(columnMap(), obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object obj) {
        return Maps.k(mo129rowMap(), obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        for (Map<C, V> map : mo129rowMap().values()) {
            if (map.containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<V> d() {
        return new a(this, cellSet().iterator());
    }

    @Override // com.google.common.collect.Table
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Table) {
            return cellSet().equals(((Table) obj).cellSet());
        }
        return false;
    }

    @Override // com.google.common.collect.Table
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Map map = (Map) Maps.l(mo129rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.l(map, obj2);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return cellSet().hashCode();
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public abstract V put(R r, C c2, V v);

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: a2.j.d.c.q<R, C, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        for (Table.Cell<? extends R, ? extends C, ? extends V> cell : table.cellSet()) {
            put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public abstract V remove(@NullableDecl Object obj, @NullableDecl Object obj2);

    @Override // com.google.common.collect.Table
    /* renamed from: rowKeySet */
    public abstract Set<R> mo128rowKeySet();

    @Override // java.lang.Object
    public String toString() {
        return mo129rowMap().toString();
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        Collection<V> collection = this.b;
        if (collection != null) {
            return collection;
        }
        Collection<V> c2 = c();
        this.b = c2;
        return c2;
    }
}
