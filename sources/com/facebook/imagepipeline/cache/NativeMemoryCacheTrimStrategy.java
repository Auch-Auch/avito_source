package com.facebook.imagepipeline.cache;

import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.imagepipeline.cache.MemoryCache;
public class NativeMemoryCacheTrimStrategy implements MemoryCache.CacheTrimStrategy {
    @Override // com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy
    public double getTrimRatio(MemoryTrimType memoryTrimType) {
        int ordinal = memoryTrimType.ordinal();
        if (ordinal == 0) {
            return 0.0d;
        }
        if (ordinal == 1 || ordinal == 2 || ordinal == 3 || ordinal == 4) {
            return 1.0d;
        }
        FLog.wtf("NativeMemoryCacheTrimStrategy", "unknown trim type: %s", memoryTrimType);
        return 0.0d;
    }
}
