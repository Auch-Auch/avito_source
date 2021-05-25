package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class ForwardingMultimap<K, V> extends ForwardingObject implements Multimap<K, V> {
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Map<K, Collection<V>> asMap() {
        return mo147delegate().asMap();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        mo147delegate().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return mo147delegate().containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return mo147delegate().containsKey(obj);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(@NullableDecl Object obj) {
        return mo147delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract Multimap<K, V> mo147delegate();

    @Override // com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        return mo147delegate().entries();
    }

    @Override // com.google.common.collect.Multimap, java.lang.Object, com.google.common.collect.ListMultimap
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || mo147delegate().equals(obj);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public Collection<V> mo118get(@NullableDecl K k) {
        return mo147delegate().mo118get(k);
    }

    @Override // com.google.common.collect.Multimap
    public int hashCode() {
        return mo147delegate().hashCode();
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        return mo147delegate().isEmpty();
    }

    @Override // com.google.common.collect.Multimap
    public Set<K> keySet() {
        return mo147delegate().keySet();
    }

    @Override // com.google.common.collect.Multimap
    public Multiset<K> keys() {
        return mo147delegate().keys();
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(K k, V v) {
        return mo147delegate().put(k, v);
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        return mo147delegate().putAll(k, iterable);
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return mo147delegate().remove(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: removeAll */
    public Collection<V> mo119removeAll(@NullableDecl Object obj) {
        return mo147delegate().mo119removeAll(obj);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: replaceValues */
    public Collection<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
        return mo147delegate().mo120replaceValues(k, iterable);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return mo147delegate().size();
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> values() {
        return mo147delegate().values();
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        return mo147delegate().putAll(multimap);
    }
}
