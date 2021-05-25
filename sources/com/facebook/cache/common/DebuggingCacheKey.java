package com.facebook.cache.common;

import android.net.Uri;
import javax.annotation.Nullable;
public class DebuggingCacheKey extends SimpleCacheKey {
    @Nullable
    public final Object c;
    public final Uri d;

    public DebuggingCacheKey(String str, @Nullable Object obj, Uri uri) {
        super(str);
        this.c = obj;
        this.d = uri;
    }

    @Nullable
    public Object getCallerContext() {
        return this.c;
    }

    public Uri getSourceUri() {
        return this.d;
    }
}
