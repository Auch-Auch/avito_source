package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
@GwtCompatible
public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return mo147delegate().cellSet();
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        mo147delegate().clear();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c) {
        return mo147delegate().column(c);
    }

    @Override // com.google.common.collect.Table
    public Set<C> columnKeySet() {
        return mo147delegate().columnKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        return mo147delegate().columnMap();
    }

    @Override // com.google.common.collect.Table
    public boolean contains(Object obj, Object obj2) {
        return mo147delegate().contains(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(Object obj) {
        return mo147delegate().containsColumn(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(Object obj) {
        return mo147delegate().containsRow(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(Object obj) {
        return mo147delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract Table<R, C, V> mo147delegate();

    @Override // com.google.common.collect.Table
    public boolean equals(Object obj) {
        return obj == this || mo147delegate().equals(obj);
    }

    @Override // com.google.common.collect.Table
    public V get(Object obj, Object obj2) {
        return mo147delegate().get(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return mo147delegate().hashCode();
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return mo147delegate().isEmpty();
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r, C c, V v) {
        return mo147delegate().put(r, c, v);
    }

    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        mo147delegate().putAll(table);
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V remove(Object obj, Object obj2) {
        return mo147delegate().remove(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r) {
        return mo147delegate().row(r);
    }

    @Override // com.google.common.collect.Table
    /* renamed from: rowKeySet */
    public Set<R> mo128rowKeySet() {
        return mo147delegate().mo128rowKeySet();
    }

    @Override // com.google.common.collect.Table
    /* renamed from: rowMap */
    public Map<R, Map<C, V>> mo129rowMap() {
        return mo147delegate().mo129rowMap();
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return mo147delegate().size();
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        return mo147delegate().values();
    }
}
