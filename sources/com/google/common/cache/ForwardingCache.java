package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {

    public static abstract class SimpleForwardingCache<K, V> extends ForwardingCache<K, V> {
        public final Cache<K, V> a;

        public SimpleForwardingCache(Cache<K, V> cache) {
            this.a = (Cache) Preconditions.checkNotNull(cache);
        }

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public final Cache<K, V> mo147delegate() {
            return this.a;
        }
    }

    @Override // com.google.common.cache.Cache
    public ConcurrentMap<K, V> asMap() {
        return mo147delegate().asMap();
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
        mo147delegate().cleanUp();
    }

    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract Cache<K, V> mo147delegate();

    @Override // com.google.common.cache.Cache
    public V get(K k, Callable<? extends V> callable) throws ExecutionException {
        return mo147delegate().get(k, callable);
    }

    @Override // com.google.common.cache.Cache
    public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        return mo147delegate().getAllPresent(iterable);
    }

    @Override // com.google.common.cache.Cache
    @NullableDecl
    public V getIfPresent(Object obj) {
        return mo147delegate().getIfPresent(obj);
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(Object obj) {
        mo147delegate().invalidate(obj);
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(Iterable<?> iterable) {
        mo147delegate().invalidateAll(iterable);
    }

    @Override // com.google.common.cache.Cache
    public void put(K k, V v) {
        mo147delegate().put(k, v);
    }

    @Override // com.google.common.cache.Cache
    public void putAll(Map<? extends K, ? extends V> map) {
        mo147delegate().putAll(map);
    }

    @Override // com.google.common.cache.Cache
    public long size() {
        return mo147delegate().size();
    }

    @Override // com.google.common.cache.Cache
    public CacheStats stats() {
        return mo147delegate().stats();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll() {
        mo147delegate().invalidateAll();
    }
}
