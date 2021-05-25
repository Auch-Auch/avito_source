package com.google.android.exoplayer2.upstream.cache;

import a2.j.b.b.d1.i.a;
import com.google.android.exoplayer2.upstream.DataSpec;
public interface CacheKeyFactory {
    public static final CacheKeyFactory DEFAULT = a.a;

    String buildCacheKey(DataSpec dataSpec);
}
