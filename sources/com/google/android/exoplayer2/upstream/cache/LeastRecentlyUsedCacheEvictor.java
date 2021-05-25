package com.google.android.exoplayer2.upstream.cache;

import a2.j.b.b.d1.i.b;
import java.util.TreeSet;
public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {
    public final long a;
    public final TreeSet<CacheSpan> b = new TreeSet<>(b.a);
    public long c;

    public LeastRecentlyUsedCacheEvictor(long j) {
        this.a = j;
    }

    public final void a(Cache cache, long j) {
        while (this.c + j > this.a && !this.b.isEmpty()) {
            cache.removeSpan(this.b.first());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onCacheInitialized() {
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        this.b.add(cacheSpan);
        this.c += cacheSpan.length;
        a(cache, 0);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        this.b.remove(cacheSpan);
        this.c -= cacheSpan.length;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        onSpanRemoved(cache, cacheSpan);
        onSpanAdded(cache, cacheSpan2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onStartFile(Cache cache, String str, long j, long j2) {
        if (j2 != -1) {
            a(cache, j2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public boolean requiresCacheSpanTouches() {
        return true;
    }
}
