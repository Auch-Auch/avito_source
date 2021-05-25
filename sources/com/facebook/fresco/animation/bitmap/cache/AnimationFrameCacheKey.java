package com.facebook.fresco.animation.bitmap.cache;

import a2.b.a.a.a;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
public class AnimationFrameCacheKey implements CacheKey {
    public final String a;

    public AnimationFrameCacheKey(int i) {
        this.a = a.M2("anim://", i);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        return uri.toString().startsWith(this.a);
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return false;
    }
}
