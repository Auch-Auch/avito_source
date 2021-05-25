package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.CloseableImage;
public class BitmapMemoryCacheFactory {

    public static class a implements MemoryCacheTracker<CacheKey> {
        public final /* synthetic */ ImageCacheStatsTracker a;

        public a(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.a = imageCacheStatsTracker;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
        public void onCacheHit(CacheKey cacheKey) {
            this.a.onBitmapCacheHit(cacheKey);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
        public void onCacheMiss(CacheKey cacheKey) {
            this.a.onBitmapCacheMiss(cacheKey);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
        public void onCachePut(CacheKey cacheKey) {
            this.a.onBitmapCachePut(cacheKey);
        }
    }

    public static InstrumentedMemoryCache<CacheKey, CloseableImage> get(MemoryCache<CacheKey, CloseableImage> memoryCache, ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.registerBitmapMemoryCache(memoryCache);
        return new InstrumentedMemoryCache<>(memoryCache, new a(imageCacheStatsTracker));
    }
}
