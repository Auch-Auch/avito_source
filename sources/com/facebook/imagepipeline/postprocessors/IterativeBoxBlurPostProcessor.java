package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;
public class IterativeBoxBlurPostProcessor extends BasePostprocessor {
    public final int b;
    public final int c;
    public CacheKey d;

    public IterativeBoxBlurPostProcessor(int i) {
        this(3, i);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        if (this.d == null) {
            this.d = new SimpleCacheKey(String.format(null, "i%dr%d", Integer.valueOf(this.b), Integer.valueOf(this.c)));
        }
        return this.d;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        NativeBlurFilter.iterativeBoxBlur(bitmap, this.b, this.c);
    }

    public IterativeBoxBlurPostProcessor(int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 <= 0 ? false : z);
        this.b = i;
        this.c = i2;
    }
}
