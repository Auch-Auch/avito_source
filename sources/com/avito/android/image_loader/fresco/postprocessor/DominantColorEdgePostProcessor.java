package com.avito.android.image_loader.fresco.postprocessor;

import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.VisibleForTesting;
import androidx.palette.graphics.Palette;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.BasePostprocessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/image_loader/fresco/postprocessor/DominantColorEdgePostProcessor;", "Lcom/facebook/imagepipeline/request/BasePostprocessor;", "Landroid/graphics/Bitmap;", "bitmap", "", "process", "(Landroid/graphics/Bitmap;)V", "Lcom/facebook/cache/common/CacheKey;", "getPostprocessorCacheKey", "()Lcom/facebook/cache/common/CacheKey;", "", AuthSource.BOOKING_ORDER, "I", "getFallbackColor", "()I", "fallbackColor", "<init>", "(I)V", "image-loader-fresco_release"}, k = 1, mv = {1, 4, 2})
public final class DominantColorEdgePostProcessor extends BasePostprocessor {
    public final int b;

    public DominantColorEdgePostProcessor(@ColorInt @VisibleForTesting int i) {
        this.b = i;
    }

    public final int getFallbackColor() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey("EdgePostProcessor");
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
            Palette generate = Palette.from(bitmap).generate();
            Intrinsics.checkNotNullExpressionValue(generate, "Palette.from(bitmap).generate()");
            int dominantColor = generate.getDominantColor(this.b);
            int width = bitmap.getWidth() - 1;
            if (width >= 0) {
                int i = 0;
                while (true) {
                    bitmap.setPixel(i, 0, dominantColor);
                    bitmap.setPixel(i, bitmap.getHeight() - 1, dominantColor);
                    if (i == width) {
                        break;
                    }
                    i++;
                }
            }
            int height = bitmap.getHeight() - 1;
            if (height >= 0) {
                int i2 = 0;
                while (true) {
                    bitmap.setPixel(0, i2, dominantColor);
                    bitmap.setPixel(bitmap.getWidth() - 1, i2, dominantColor);
                    if (i2 != height) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
