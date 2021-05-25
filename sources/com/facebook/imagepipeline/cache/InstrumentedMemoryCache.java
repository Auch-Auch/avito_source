package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.references.CloseableReference;
public class InstrumentedMemoryCache<K, V> implements MemoryCache<K, V> {
    public final MemoryCache<K, V> a;
    public final MemoryCacheTracker b;

    public InstrumentedMemoryCache(MemoryCache<K, V> memoryCache, MemoryCacheTracker memoryCacheTracker) {
        this.a = memoryCache;
        this.b = memoryCacheTracker;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference) {
        this.b.onCachePut(k);
        return this.a.cache(k, closeableReference);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(Predicate<K> predicate) {
        return this.a.contains((Predicate) predicate);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<V> get(K k) {
        CloseableReference<V> closeableReference = this.a.get(k);
        if (closeableReference == null) {
            this.b.onCacheMiss(k);
        } else {
            this.b.onCacheHit(k);
        }
        return closeableReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int getCount() {
        return this.a.getCount();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int getSizeInBytes() {
        return this.a.getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public void probe(K k) {
        this.a.probe(k);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate<K> predicate) {
        return this.a.removeAll(predicate);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(K k) {
        return this.a.contains((MemoryCache<K, V>) k);
    }
}
