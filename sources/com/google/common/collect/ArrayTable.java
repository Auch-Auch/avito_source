package com.google.common.collect;

import a2.j.d.c.q;
import a2.j.d.c.s;
import a2.j.d.c.t;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtCompatible(emulated = true)
public final class ArrayTable<R, C, V> extends q<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    public final ImmutableList<R> c;
    public final ImmutableList<C> d;
    public final ImmutableMap<R, Integer> e;
    public final ImmutableMap<C, Integer> f;
    public final V[][] g;
    @MonotonicNonNullDecl
    public transient ArrayTable<R, C, V>.e h;
    @MonotonicNonNullDecl
    public transient ArrayTable<R, C, V>.g i;

    public class a extends a2.j.d.c.c<Table.Cell<R, C, V>> {
        public a(int i) {
            super(i);
        }

        @Override // a2.j.d.c.c
        public Object a(int i) {
            ArrayTable arrayTable = ArrayTable.this;
            Objects.requireNonNull(arrayTable);
            return new s(arrayTable, i);
        }
    }

    public class b extends a2.j.d.c.c<V> {
        public b(int i) {
            super(i);
        }

        @Override // a2.j.d.c.c
        public V a(int i) {
            ArrayTable arrayTable = ArrayTable.this;
            return (V) arrayTable.at(i / arrayTable.d.size(), i % arrayTable.d.size());
        }
    }

    public static abstract class c<K, V> extends Maps.p<K, V> {
        public final ImmutableMap<K, Integer> a;

        public class a extends a2.j.d.c.c<Map.Entry<K, V>> {
            public a(int i) {
                super(i);
            }

            @Override // a2.j.d.c.c
            public Object a(int i) {
                c cVar = c.this;
                Preconditions.checkElementIndex(i, cVar.size());
                return new t(cVar, i);
            }
        }

        public c(ImmutableMap immutableMap, a aVar) {
            this.a = immutableMap;
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<K, V>> a() {
            return new a(size());
        }

        public abstract String c();

        @Override // com.google.common.collect.Maps.p, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return this.a.containsKey(obj);
        }

        @NullableDecl
        public abstract V d(int i);

        @NullableDecl
        public abstract V e(int i, V v);

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@NullableDecl Object obj) {
            Integer num = this.a.get(obj);
            if (num == null) {
                return null;
            }
            return d(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Integer num = this.a.get(k);
            if (num != null) {
                return e(num.intValue(), v);
            }
            throw new IllegalArgumentException(c() + " " + ((Object) k) + " not in " + this.a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.a.size();
        }
    }

    public class d extends c<R, V> {
        public final int b;

        public d(int i) {
            super(ArrayTable.this.e, null);
            this.b = i;
        }

        @Override // com.google.common.collect.ArrayTable.c
        public String c() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.c
        public V d(int i) {
            return (V) ArrayTable.this.at(i, this.b);
        }

        @Override // com.google.common.collect.ArrayTable.c
        public V e(int i, V v) {
            return (V) ArrayTable.this.set(i, this.b, v);
        }
    }

    public class e extends c<C, Map<R, V>> {
        public e(a aVar) {
            super(ArrayTable.this.f, null);
        }

        @Override // com.google.common.collect.ArrayTable.c
        public String c() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.c
        public Object d(int i) {
            return new d(i);
        }

        @Override // com.google.common.collect.ArrayTable.c
        public Object e(int i, Object obj) {
            Map map = (Map) obj;
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.c, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Map map = (Map) obj2;
            throw new UnsupportedOperationException();
        }
    }

    public class f extends c<C, V> {
        public final int b;

        public f(int i) {
            super(ArrayTable.this.f, null);
            this.b = i;
        }

        @Override // com.google.common.collect.ArrayTable.c
        public String c() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.c
        public V d(int i) {
            return (V) ArrayTable.this.at(this.b, i);
        }

        @Override // com.google.common.collect.ArrayTable.c
        public V e(int i, V v) {
            return (V) ArrayTable.this.set(this.b, i, v);
        }
    }

    public class g extends c<R, Map<C, V>> {
        public g(a aVar) {
            super(ArrayTable.this.e, null);
        }

        @Override // com.google.common.collect.ArrayTable.c
        public String c() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.c
        public Object d(int i) {
            return new f(i);
        }

        @Override // com.google.common.collect.ArrayTable.c
        public Object e(int i, Object obj) {
            Map map = (Map) obj;
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.c, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Map map = (Map) obj2;
            throw new UnsupportedOperationException();
        }
    }

    public ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> copyOf = ImmutableList.copyOf(iterable);
        this.c = copyOf;
        ImmutableList<C> copyOf2 = ImmutableList.copyOf(iterable2);
        this.d = copyOf2;
        Preconditions.checkArgument(copyOf.isEmpty() == copyOf2.isEmpty());
        this.e = Maps.h(copyOf);
        this.f = Maps.h(copyOf2);
        int size = copyOf.size();
        int[] iArr = new int[2];
        iArr[1] = copyOf2.size();
        iArr[0] = size;
        this.g = (V[][]) ((Object[][]) Array.newInstance(Object.class, iArr));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    @Override // a2.j.d.c.q
    public Iterator<Table.Cell<R, C, V>> a() {
        return new a(size());
    }

    public V at(int i2, int i3) {
        Preconditions.checkElementIndex(i2, this.c.size());
        Preconditions.checkElementIndex(i3, this.d.size());
        return this.g[i2][i3];
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c2) {
        Preconditions.checkNotNull(c2);
        Integer num = this.f.get(c2);
        return num == null ? ImmutableMap.of() : new d(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.d;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.e eVar = this.h;
        if (eVar != null) {
            return eVar;
        }
        ArrayTable<R, C, V>.e eVar2 = new e(null);
        this.h = eVar2;
        return eVar2;
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object obj) {
        return this.f.containsKey(obj);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object obj) {
        return this.e.containsKey(obj);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        V[][] vArr = this.g;
        for (V[] vArr2 : vArr) {
            for (V v : vArr2) {
                if (com.google.common.base.Objects.equal(obj, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // a2.j.d.c.q
    public Iterator<V> d() {
        return new b(size());
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public V erase(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.e.get(obj);
        Integer num2 = this.f.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.g) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.e.get(obj);
        Integer num2 = this.f.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.c.isEmpty() || this.d.isEmpty();
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r, C c2, @NullableDecl V v) {
        Preconditions.checkNotNull(r);
        Preconditions.checkNotNull(c2);
        Integer num = this.e.get(r);
        boolean z = true;
        Preconditions.checkArgument(num != null, "Row %s not in %s", r, this.c);
        Integer num2 = this.f.get(c2);
        if (num2 == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "Column %s not in %s", c2, this.d);
        return set(num.intValue(), num2.intValue(), v);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r) {
        Preconditions.checkNotNull(r);
        Integer num = this.e.get(r);
        return num == null ? ImmutableMap.of() : new f(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.c;
    }

    @Override // com.google.common.collect.Table
    /* renamed from: rowMap */
    public Map<R, Map<C, V>> mo129rowMap() {
        ArrayTable<R, C, V>.g gVar = this.i;
        if (gVar != null) {
            return gVar;
        }
        ArrayTable<R, C, V>.g gVar2 = new g(null);
        this.i = gVar2;
        return gVar2;
    }

    @CanIgnoreReturnValue
    public V set(int i2, int i3, @NullableDecl V v) {
        Preconditions.checkElementIndex(i2, this.c.size());
        Preconditions.checkElementIndex(i3, this.d.size());
        V[][] vArr = this.g;
        V v2 = vArr[i2][i3];
        vArr[i2][i3] = v;
        return v2;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.d.size() * this.c.size();
    }

    @GwtIncompatible
    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.c.size(), this.d.size()));
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            V[][] vArr2 = this.g;
            System.arraycopy(vArr2[i2], 0, vArr[i2], 0, vArr2[i2].length);
        }
        return vArr;
    }

    @Override // a2.j.d.c.q, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table) {
        if (table instanceof ArrayTable) {
            return new ArrayTable<>((ArrayTable) table);
        }
        ArrayTable<R, C, V> arrayTable = new ArrayTable<>(table.mo128rowKeySet(), table.columnKeySet());
        arrayTable.putAll(table);
        return arrayTable;
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return this.f.keySet();
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    /* renamed from: rowKeySet */
    public ImmutableSet<R> mo128rowKeySet() {
        return this.e.keySet();
    }

    public ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.c;
        this.c = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.d;
        this.d = immutableList2;
        this.e = arrayTable.e;
        this.f = arrayTable.f;
        int size = immutableList.size();
        int[] iArr = new int[2];
        iArr[1] = immutableList2.size();
        iArr[0] = size;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance(Object.class, iArr));
        this.g = vArr;
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            V[][] vArr2 = arrayTable.g;
            System.arraycopy(vArr2[i2], 0, vArr[i2], 0, vArr2[i2].length);
        }
    }
}
