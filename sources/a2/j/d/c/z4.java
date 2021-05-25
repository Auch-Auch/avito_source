package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class z4<R, C, V> extends r4 implements Table<R, C, V> {

    public class a implements Function<Map<C, V>, Map<C, V>> {
        public a() {
        }

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return new m4((Map) obj, z4.this.b);
        }
    }

    public class b implements Function<Map<R, V>, Map<R, V>> {
        public b() {
        }

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return new m4((Map) obj, z4.this.b);
        }
    }

    public z4(Table<R, C, V> table, Object obj) {
        super(table, obj);
    }

    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        u4 u4Var;
        synchronized (this.b) {
            u4Var = new u4(((Table) this.a).cellSet(), this.b);
        }
        return u4Var;
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        synchronized (this.b) {
            ((Table) this.a).clear();
        }
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(@NullableDecl C c) {
        m4 m4Var;
        synchronized (this.b) {
            m4Var = new m4(((Table) this.a).column(c), this.b);
        }
        return m4Var;
    }

    @Override // com.google.common.collect.Table
    public Set<C> columnKeySet() {
        u4 u4Var;
        synchronized (this.b) {
            u4Var = new u4(((Table) this.a).columnKeySet(), this.b);
        }
        return u4Var;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        m4 m4Var;
        synchronized (this.b) {
            m4Var = new m4(Maps.transformValues(((Table) this.a).columnMap(), new b()), this.b);
        }
        return m4Var;
    }

    @Override // com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        boolean contains;
        synchronized (this.b) {
            contains = ((Table) this.a).contains(obj, obj2);
        }
        return contains;
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object obj) {
        boolean containsColumn;
        synchronized (this.b) {
            containsColumn = ((Table) this.a).containsColumn(obj);
        }
        return containsColumn;
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object obj) {
        boolean containsRow;
        synchronized (this.b) {
            containsRow = ((Table) this.a).containsRow(obj);
        }
        return containsRow;
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        boolean containsValue;
        synchronized (this.b) {
            containsValue = ((Table) this.a).containsValue(obj);
        }
        return containsValue;
    }

    @Override // java.lang.Object, com.google.common.collect.Table
    public boolean equals(@NullableDecl Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.b) {
            equals = ((Table) this.a).equals(obj);
        }
        return equals;
    }

    @Override // com.google.common.collect.Table
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        V v;
        synchronized (this.b) {
            v = (V) ((Table) this.a).get(obj, obj2);
        }
        return v;
    }

    @Override // java.lang.Object, com.google.common.collect.Table
    public int hashCode() {
        int hashCode;
        synchronized (this.b) {
            hashCode = ((Table) this.a).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.b) {
            isEmpty = ((Table) this.a).isEmpty();
        }
        return isEmpty;
    }

    @Override // com.google.common.collect.Table
    public V put(@NullableDecl R r, @NullableDecl C c, @NullableDecl V v) {
        V v2;
        synchronized (this.b) {
            v2 = (V) ((Table) this.a).put(r, c, v);
        }
        return v2;
    }

    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        synchronized (this.b) {
            ((Table) this.a).putAll(table);
        }
    }

    @Override // com.google.common.collect.Table
    public V remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        V v;
        synchronized (this.b) {
            v = (V) ((Table) this.a).remove(obj, obj2);
        }
        return v;
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(@NullableDecl R r) {
        m4 m4Var;
        synchronized (this.b) {
            m4Var = new m4(((Table) this.a).row(r), this.b);
        }
        return m4Var;
    }

    @Override // com.google.common.collect.Table
    /* renamed from: rowKeySet */
    public Set<R> mo128rowKeySet() {
        u4 u4Var;
        synchronized (this.b) {
            u4Var = new u4(((Table) this.a).mo128rowKeySet(), this.b);
        }
        return u4Var;
    }

    @Override // com.google.common.collect.Table
    /* renamed from: rowMap */
    public Map<R, Map<C, V>> mo129rowMap() {
        m4 m4Var;
        synchronized (this.b) {
            m4Var = new m4(Maps.transformValues(((Table) this.a).mo129rowMap(), new a()), this.b);
        }
        return m4Var;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        int size;
        synchronized (this.b) {
            size = ((Table) this.a).size();
        }
        return size;
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        Collection<V> e;
        synchronized (this.b) {
            e = AppCompatDelegateImpl.i.e(((Table) this.a).values(), this.b);
        }
        return e;
    }
}
