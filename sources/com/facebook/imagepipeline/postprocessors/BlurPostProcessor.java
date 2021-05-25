package com.facebook.imagepipeline.postprocessors;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.filter.IterativeBoxBlurFilter;
import com.facebook.imagepipeline.filter.RenderScriptBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;
public class BlurPostProcessor extends BasePostprocessor {
    public static final boolean f = RenderScriptBlurFilter.canUseRenderScript();
    public final int b;
    public final Context c;
    public final int d;
    public CacheKey e;

    public BlurPostProcessor(int i, Context context, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i > 0 && i <= 25);
        Preconditions.checkArgument(i2 <= 0 ? false : z);
        Preconditions.checkNotNull(context);
        this.b = i2;
        this.d = i;
        this.c = context;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        String str;
        if (this.e == null) {
            if (f) {
                str = String.format(null, "IntrinsicBlur;%d", Integer.valueOf(this.d));
            } else {
                str = String.format(null, "IterativeBoxBlur;%d;%d", Integer.valueOf(this.b), Integer.valueOf(this.d));
            }
            this.e = new SimpleCacheKey(str);
        }
        return this.e;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap, Bitmap bitmap2) {
        if (f) {
            RenderScriptBlurFilter.blurBitmap(bitmap, bitmap2, this.c, this.d);
        } else {
            super.process(bitmap, bitmap2);
        }
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        IterativeBoxBlurFilter.boxBlurBitmapInPlace(bitmap, this.b, this.d);
    }

    public BlurPostProcessor(int i, Context context) {
        this(i, context, 3);
    }
}
