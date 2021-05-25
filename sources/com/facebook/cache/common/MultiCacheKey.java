package com.facebook.cache.common;

import a2.b.a.a.a;
import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import java.util.List;
public class MultiCacheKey implements CacheKey {
    public final List<CacheKey> a;

    public MultiCacheKey(List<CacheKey> list) {
        this.a = (List) Preconditions.checkNotNull(list);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        for (int i = 0; i < this.a.size(); i++) {
            if (this.a.get(i).containsUri(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiCacheKey) {
            return this.a.equals(((MultiCacheKey) obj).a);
        }
        return false;
    }

    public List<CacheKey> getCacheKeys() {
        return this.a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.a.get(0).getUriString();
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        StringBuilder L = a.L("MultiCacheKey:");
        L.append(this.a.toString());
        return L.toString();
    }
}
