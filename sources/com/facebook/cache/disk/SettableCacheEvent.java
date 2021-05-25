package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEvent;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
import javax.annotation.Nullable;
public class SettableCacheEvent implements CacheEvent {
    public static final Object i = new Object();
    public static SettableCacheEvent j;
    public static int k;
    public CacheKey a;
    public String b;
    public long c;
    public long d;
    public long e;
    public IOException f;
    public CacheEventListener.EvictionReason g;
    public SettableCacheEvent h;

    @ReturnsOwnership
    public static SettableCacheEvent obtain() {
        synchronized (i) {
            SettableCacheEvent settableCacheEvent = j;
            if (settableCacheEvent == null) {
                return new SettableCacheEvent();
            }
            j = settableCacheEvent.h;
            settableCacheEvent.h = null;
            k--;
            return settableCacheEvent;
        }
    }

    @Override // com.facebook.cache.common.CacheEvent
    @Nullable
    public CacheKey getCacheKey() {
        return this.a;
    }

    @Override // com.facebook.cache.common.CacheEvent
    public long getCacheLimit() {
        return this.d;
    }

    @Override // com.facebook.cache.common.CacheEvent
    public long getCacheSize() {
        return this.e;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @Nullable
    public CacheEventListener.EvictionReason getEvictionReason() {
        return this.g;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @Nullable
    public IOException getException() {
        return this.f;
    }

    @Override // com.facebook.cache.common.CacheEvent
    public long getItemSize() {
        return this.c;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @Nullable
    public String getResourceId() {
        return this.b;
    }

    public void recycle() {
        synchronized (i) {
            int i2 = k;
            if (i2 < 5) {
                this.a = null;
                this.b = null;
                this.c = 0;
                this.d = 0;
                this.e = 0;
                this.f = null;
                this.g = null;
                k = i2 + 1;
                SettableCacheEvent settableCacheEvent = j;
                if (settableCacheEvent != null) {
                    this.h = settableCacheEvent;
                }
                j = this;
            }
        }
    }

    public SettableCacheEvent setCacheKey(CacheKey cacheKey) {
        this.a = cacheKey;
        return this;
    }

    public SettableCacheEvent setCacheLimit(long j2) {
        this.d = j2;
        return this;
    }

    public SettableCacheEvent setCacheSize(long j2) {
        this.e = j2;
        return this;
    }

    public SettableCacheEvent setEvictionReason(CacheEventListener.EvictionReason evictionReason) {
        this.g = evictionReason;
        return this;
    }

    public SettableCacheEvent setException(IOException iOException) {
        this.f = iOException;
        return this;
    }

    public SettableCacheEvent setItemSize(long j2) {
        this.c = j2;
        return this;
    }

    public SettableCacheEvent setResourceId(String str) {
        this.b = str;
        return this;
    }
}
