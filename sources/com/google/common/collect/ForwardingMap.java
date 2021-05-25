package com.google.common.collect;

import a2.j.d.c.g2;
import a2.j.d.c.h2;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {

    @Beta
    public abstract class StandardEntrySet extends Maps.i<K, V> {
        public StandardEntrySet() {
        }

        @Override // com.google.common.collect.Maps.i
        public Map<K, V> d() {
            return ForwardingMap.this;
        }
    }

    @Beta
    public class StandardKeySet extends Maps.q<K, V> {
        public StandardKeySet(ForwardingMap forwardingMap) {
            super(forwardingMap);
        }
    }

    @Beta
    public class StandardValues extends Maps.f0<K, V> {
        public StandardValues(ForwardingMap forwardingMap) {
            super(forwardingMap);
        }
    }

    @Override // java.util.Map
    public void clear() {
        mo147delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return mo147delegate().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return mo147delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract Map<K, V> mo147delegate();

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return mo147delegate().entrySet();
    }

    @Override // java.util.Map, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || mo147delegate().equals(obj);
    }

    @Override // java.util.Map
    public V get(@NullableDecl Object obj) {
        return mo147delegate().get(obj);
    }

    @Override // java.util.Map, java.lang.Object
    public int hashCode() {
        return mo147delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return mo147delegate().isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return mo147delegate().keySet();
    }

    @Override // java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V put(K k, V v) {
        return mo147delegate().put(k, v);
    }

    @Override // java.util.Map, com.google.common.collect.BiMap
    public void putAll(Map<? extends K, ? extends V> map) {
        mo147delegate().putAll(map);
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V remove(Object obj) {
        return mo147delegate().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return mo147delegate().size();
    }

    public void standardClear() {
        Iterators.b(entrySet().iterator());
    }

    @Beta
    public boolean standardContainsKey(@NullableDecl Object obj) {
        return Iterators.contains(new g2(entrySet().iterator()), obj);
    }

    public boolean standardContainsValue(@NullableDecl Object obj) {
        return Iterators.contains(new h2(entrySet().iterator()), obj);
    }

    public boolean standardEquals(@NullableDecl Object obj) {
        return Maps.g(this, obj);
    }

    public int standardHashCode() {
        return Sets.b(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.ForwardingMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public void standardPutAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Beta
    public V standardRemove(@NullableDecl Object obj) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (Objects.equal(next.getKey(), obj)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    public String standardToString() {
        return Maps.m(this);
    }

    @Override // java.util.Map, com.google.common.collect.BiMap
    public Collection<V> values() {
        return mo147delegate().values();
    }
}
