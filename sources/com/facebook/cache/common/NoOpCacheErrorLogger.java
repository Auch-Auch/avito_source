package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
public class NoOpCacheErrorLogger implements CacheErrorLogger {
    @Nullable
    public static NoOpCacheErrorLogger a;

    public static synchronized NoOpCacheErrorLogger getInstance() {
        NoOpCacheErrorLogger noOpCacheErrorLogger;
        synchronized (NoOpCacheErrorLogger.class) {
            if (a == null) {
                a = new NoOpCacheErrorLogger();
            }
            noOpCacheErrorLogger = a;
        }
        return noOpCacheErrorLogger;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void logError(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
