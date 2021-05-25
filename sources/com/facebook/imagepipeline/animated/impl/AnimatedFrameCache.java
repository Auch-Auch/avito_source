package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public class AnimatedFrameCache {
    public final CacheKey a;
    public final CountingMemoryCache<CacheKey, CloseableImage> b;
    public final CountingMemoryCache.EntryStateObserver<CacheKey> c = new a();
    @GuardedBy("this")
    public final LinkedHashSet<CacheKey> d = new LinkedHashSet<>();

    public class a implements CountingMemoryCache.EntryStateObserver<CacheKey> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, boolean] */
        @Override // com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver
        public void onExclusivityChanged(CacheKey cacheKey, boolean z) {
            AnimatedFrameCache.this.onReusabilityChange(cacheKey, z);
        }
    }

    @VisibleForTesting
    public static class b implements CacheKey {
        public final CacheKey a;
        public final int b;

        public b(CacheKey cacheKey, int i) {
            this.a = cacheKey;
            this.b = i;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean containsUri(Uri uri) {
            return this.a.containsUri(uri);
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b != bVar.b || !this.a.equals(bVar.a)) {
                return false;
            }
            return true;
        }

        @Override // com.facebook.cache.common.CacheKey
        @Nullable
        public String getUriString() {
            return null;
        }

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            return (this.a.hashCode() * 1013) + this.b;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean isResourceIdForDebugging() {
            return false;
        }

        @Override // com.facebook.cache.common.CacheKey
        public String toString() {
            return Objects.toStringHelper(this).add("imageCacheKey", this.a).add("frameIndex", this.b).toString();
        }
    }

    public AnimatedFrameCache(CacheKey cacheKey, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache) {
        this.a = cacheKey;
        this.b = countingMemoryCache;
    }

    @Nullable
    public CloseableReference<CloseableImage> cache(int i, CloseableReference<CloseableImage> closeableReference) {
        return this.b.cache(new b(this.a, i), closeableReference, this.c);
    }

    public boolean contains(int i) {
        return this.b.contains((CountingMemoryCache<CacheKey, CloseableImage>) new b(this.a, i));
    }

    @Nullable
    public CloseableReference<CloseableImage> get(int i) {
        return this.b.get(new b(this.a, i));
    }

    @Nullable
    public CloseableReference<CloseableImage> getForReuse() {
        CacheKey cacheKey;
        CloseableReference<CloseableImage> reuse;
        do {
            synchronized (this) {
                Iterator<CacheKey> it = this.d.iterator();
                if (it.hasNext()) {
                    cacheKey = it.next();
                    it.remove();
                } else {
                    cacheKey = null;
                }
            }
            if (cacheKey == null) {
                return null;
            }
            reuse = this.b.reuse(cacheKey);
        } while (reuse == null);
        return reuse;
    }

    public synchronized void onReusabilityChange(CacheKey cacheKey, boolean z) {
        if (z) {
            this.d.add(cacheKey);
        } else {
            this.d.remove(cacheKey);
        }
    }
}
