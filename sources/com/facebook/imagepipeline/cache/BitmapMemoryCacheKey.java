package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
public class BitmapMemoryCacheKey implements CacheKey {
    public final String a;
    @Nullable
    public final ResizeOptions b;
    public final RotationOptions c;
    public final ImageDecodeOptions d;
    @Nullable
    public final CacheKey e;
    @Nullable
    public final String f;
    public final int g;
    public final Object h;
    public final long i;

    public BitmapMemoryCacheKey(String str, @Nullable ResizeOptions resizeOptions, RotationOptions rotationOptions, ImageDecodeOptions imageDecodeOptions, @Nullable CacheKey cacheKey, @Nullable String str2, Object obj) {
        this.a = (String) Preconditions.checkNotNull(str);
        this.b = resizeOptions;
        this.c = rotationOptions;
        this.d = imageDecodeOptions;
        this.e = cacheKey;
        this.f = str2;
        this.g = HashCodeUtil.hashCode(Integer.valueOf(str.hashCode()), Integer.valueOf(resizeOptions != null ? resizeOptions.hashCode() : 0), Integer.valueOf(rotationOptions.hashCode()), imageDecodeOptions, cacheKey, str2);
        this.h = obj;
        this.i = RealtimeSinceBootClock.get().now();
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (!(obj instanceof BitmapMemoryCacheKey)) {
            return false;
        }
        BitmapMemoryCacheKey bitmapMemoryCacheKey = (BitmapMemoryCacheKey) obj;
        if (this.g != bitmapMemoryCacheKey.g || !this.a.equals(bitmapMemoryCacheKey.a) || !Objects.equal(this.b, bitmapMemoryCacheKey.b) || !Objects.equal(this.c, bitmapMemoryCacheKey.c) || !Objects.equal(this.d, bitmapMemoryCacheKey.d) || !Objects.equal(this.e, bitmapMemoryCacheKey.e) || !Objects.equal(this.f, bitmapMemoryCacheKey.f)) {
            return false;
        }
        return true;
    }

    public Object getCallerContext() {
        return this.h;
    }

    public long getInBitmapCacheSince() {
        return this.i;
    }

    @Nullable
    public String getPostprocessorName() {
        return this.f;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.g;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.a, this.b, this.c, this.d, this.e, this.f, Integer.valueOf(this.g));
    }
}
