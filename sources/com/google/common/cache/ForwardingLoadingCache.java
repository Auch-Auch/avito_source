package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;
@GwtIncompatible
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {
    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public V apply(K k) {
        return mo147delegate().apply(k);
    }

    @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract LoadingCache<K, V> mo147delegate();

    @Override // com.google.common.cache.LoadingCache
    public V get(K k) throws ExecutionException {
        return mo147delegate().get(k);
    }

    @Override // com.google.common.cache.LoadingCache
    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        return mo147delegate().getAll(iterable);
    }

    @Override // com.google.common.cache.LoadingCache
    public V getUnchecked(K k) {
        return mo147delegate().getUnchecked(k);
    }

    @Override // com.google.common.cache.LoadingCache
    public void refresh(K k) {
        mo147delegate().refresh(k);
    }

    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {
        public final LoadingCache<K, V> a;

        public SimpleForwardingLoadingCache(LoadingCache<K, V> loadingCache) {
            this.a = (LoadingCache) Preconditions.checkNotNull(loadingCache);
        }

        @Override // com.google.common.cache.ForwardingLoadingCache, com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public final LoadingCache<K, V> mo147delegate() {
            return this.a;
        }
    }
}
