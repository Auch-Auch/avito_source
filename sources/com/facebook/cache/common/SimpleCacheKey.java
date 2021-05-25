package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
public class SimpleCacheKey implements CacheKey {
    public final String a;
    public final boolean b;

    public SimpleCacheKey(String str) {
        this(str, false);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        return this.a.contains(uri.toString());
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SimpleCacheKey) {
            return this.a.equals(((SimpleCacheKey) obj).a);
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return this.b;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return this.a;
    }

    public SimpleCacheKey(String str, boolean z) {
        this.a = (String) Preconditions.checkNotNull(str);
        this.b = z;
    }
}
