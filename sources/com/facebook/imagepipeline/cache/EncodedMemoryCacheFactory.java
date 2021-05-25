package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
public class EncodedMemoryCacheFactory {

    public static class a implements MemoryCacheTracker<CacheKey> {
        public final /* synthetic */ ImageCacheStatsTracker a;

        public a(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.a = imageCacheStatsTracker;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
        public void onCacheHit(CacheKey cacheKey) {
            this.a.onMemoryCacheHit(cacheKey);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
        public void onCacheMiss(CacheKey cacheKey) {
            this.a.onMemoryCacheMiss(cacheKey);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
        public void onCachePut(CacheKey cacheKey) {
            this.a.onMemoryCachePut(cacheKey);
        }
    }

    public static InstrumentedMemoryCache<CacheKey, PooledByteBuffer> get(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.registerEncodedMemoryCache(memoryCache);
        return new InstrumentedMemoryCache<>(memoryCache, new a(imageCacheStatsTracker));
    }
}
