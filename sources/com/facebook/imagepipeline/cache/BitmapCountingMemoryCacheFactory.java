package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;
public class BitmapCountingMemoryCacheFactory {

    public static class a implements ValueDescriptor<CloseableImage> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.imagepipeline.cache.ValueDescriptor
        public int getSizeInBytes(CloseableImage closeableImage) {
            return closeableImage.getSizeInBytes();
        }
    }

    public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry, @Nullable CountingMemoryCache.EntryStateObserver<CacheKey> entryStateObserver) {
        return get(supplier, memoryTrimmableRegistry, new BitmapMemoryCacheTrimStrategy(), entryStateObserver);
    }

    public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry, MemoryCache.CacheTrimStrategy cacheTrimStrategy, @Nullable CountingMemoryCache.EntryStateObserver<CacheKey> entryStateObserver) {
        CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache = new CountingMemoryCache<>(new a(), cacheTrimStrategy, supplier, entryStateObserver);
        memoryTrimmableRegistry.registerMemoryTrimmable(countingMemoryCache);
        return countingMemoryCache;
    }
}
