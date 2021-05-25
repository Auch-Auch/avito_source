package com.google.common.collect;

import a2.j.d.c.y3;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(serializable = true)
public class HashBasedTable<R, C, V> extends y3<R, C, V> {
    private static final long serialVersionUID = 0;

    public static class a<C, V> implements Supplier<Map<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        public final int a;

        public a(int i) {
            this.a = i;
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            return Maps.newLinkedHashMapWithExpectedSize(this.a);
        }
    }

    public HashBasedTable(Map<R, Map<C, V>> map, a<C, V> aVar) {
        super(map, aVar);
    }

    public static <R, C, V> HashBasedTable<R, C, V> create() {
        return new HashBasedTable<>(new LinkedHashMap(), new a(0));
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

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // a2.j.d.c.y3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object obj) {
        return super.containsColumn(obj);
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object obj) {
        return super.containsRow(obj);
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        return super.containsValue(obj);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return (V) super.get(obj, obj2);
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
    public V remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return (V) super.remove(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.y3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return super.row(obj);
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    /* renamed from: rowKeySet */
    public /* bridge */ /* synthetic */ Set mo128rowKeySet() {
        return super.mo128rowKeySet();
    }

    @Override // a2.j.d.c.y3, com.google.common.collect.Table
    /* renamed from: rowMap */
    public /* bridge */ /* synthetic */ Map mo129rowMap() {
        return super.mo129rowMap();
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

    public static <R, C, V> HashBasedTable<R, C, V> create(int i, int i2) {
        AppCompatDelegateImpl.i.z(i2, "expectedCellsPerRow");
        return new HashBasedTable<>(Maps.newLinkedHashMapWithExpectedSize(i), new a(i2));
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(Table<? extends R, ? extends C, ? extends V> table) {
        HashBasedTable<R, C, V> create = create();
        create.putAll(table);
        return create;
    }
}
