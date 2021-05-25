package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;
public class RoundAsCirclePostprocessor extends BasePostprocessor {
    @Nullable
    public CacheKey b;
    public final boolean c;

    public RoundAsCirclePostprocessor() {
        this(true);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        if (this.b == null) {
            if (this.c) {
                this.b = new SimpleCacheKey("RoundAsCirclePostprocessor#AntiAliased");
            } else {
                this.b = new SimpleCacheKey("RoundAsCirclePostprocessor");
            }
        }
        return this.b;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        NativeRoundingFilter.toCircleFast(bitmap, this.c);
    }

    public RoundAsCirclePostprocessor(boolean z) {
        this.c = z;
    }
}
