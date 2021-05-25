package com.google.common.collect;

import a2.j.d.c.z2;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {

    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public Builder() {
        }

        public Builder(int i) {
            super(i);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> build() {
            if (this.c == 0) {
                return ImmutableBiMap.of();
            }
            b();
            this.d = true;
            return new z2(this.b, this.c);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            super.orderEntriesByValue((Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            super.put((Builder<K, V>) k, (K) v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll((Map) map);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }
    }

    public static class a extends ImmutableMap.d {
        private static final long serialVersionUID = 0;

        public a(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.d
        public Object readResolve() {
            return a(new Builder());
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    @Beta
    public static <K, V> Builder<K, V> builderWithExpectedSize(int i) {
        AppCompatDelegateImpl.i.z(i, "expectedSize");
        return new Builder<>(i);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.h()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return z2.k;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection d() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @Deprecated
    public V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.BiMap
    /* renamed from: inverse */
    public abstract ImmutableBiMap<V, K> mo35inverse();

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new a(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v) {
        AppCompatDelegateImpl.i.s(k, v);
        return new z2(new Object[]{k, v}, 1);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2) {
        AppCompatDelegateImpl.i.s(k, v);
        AppCompatDelegateImpl.i.s(k2, v2);
        return new z2(new Object[]{k, v, k2, v2}, 2);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public ImmutableSet<V> values() {
        return mo35inverse().keySet();
    }

    @Beta
    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4).putAll((Iterable) iterable).build();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        AppCompatDelegateImpl.i.s(k, v);
        AppCompatDelegateImpl.i.s(k2, v2);
        AppCompatDelegateImpl.i.s(k3, v3);
        return new z2(new Object[]{k, v, k2, v2, k3, v3}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        AppCompatDelegateImpl.i.s(k, v);
        AppCompatDelegateImpl.i.s(k2, v2);
        AppCompatDelegateImpl.i.s(k3, v3);
        AppCompatDelegateImpl.i.s(k4, v4);
        return new z2(new Object[]{k, v, k2, v2, k3, v3, k4, v4}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        AppCompatDelegateImpl.i.s(k, v);
        AppCompatDelegateImpl.i.s(k2, v2);
        AppCompatDelegateImpl.i.s(k3, v3);
        AppCompatDelegateImpl.i.s(k4, v4);
        AppCompatDelegateImpl.i.s(k5, v5);
        return new z2(new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5}, 5);
    }
}
