package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.filter.InPlaceRoundFilter;
import com.facebook.imagepipeline.filter.XferRoundFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;
public class RoundPostprocessor extends BasePostprocessor {
    public static final boolean d = XferRoundFilter.canUseXferRoundFilter();
    @Nullable
    public CacheKey b;
    public final boolean c;

    public RoundPostprocessor() {
        this(true);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        if (this.b == null) {
            if (d) {
                this.b = new SimpleCacheKey("XferRoundFilter");
            } else {
                this.b = new SimpleCacheKey("InPlaceRoundFilter");
            }
        }
        return this.b;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap, Bitmap bitmap2) {
        Preconditions.checkNotNull(bitmap);
        Preconditions.checkNotNull(bitmap2);
        if (d) {
            XferRoundFilter.xferRoundBitmap(bitmap, bitmap2, this.c);
        } else {
            super.process(bitmap, bitmap2);
        }
    }

    public RoundPostprocessor(boolean z) {
        this.c = z;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        InPlaceRoundFilter.roundBitmapInPlace(bitmap);
    }
}
