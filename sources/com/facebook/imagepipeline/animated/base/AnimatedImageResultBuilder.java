package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import java.util.List;
import javax.annotation.Nullable;
public class AnimatedImageResultBuilder {
    public final AnimatedImage a;
    public CloseableReference<Bitmap> b;
    public List<CloseableReference<Bitmap>> c;
    public int d;
    @Nullable
    public BitmapTransformation e;

    public AnimatedImageResultBuilder(AnimatedImage animatedImage) {
        this.a = animatedImage;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>>, com.facebook.common.references.CloseableReference<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.imagepipeline.animated.base.AnimatedImageResult build() {
        /*
            r3 = this;
            r0 = 0
            com.facebook.imagepipeline.animated.base.AnimatedImageResult r1 = new com.facebook.imagepipeline.animated.base.AnimatedImageResult     // Catch:{ all -> 0x0015 }
            r1.<init>(r3)     // Catch:{ all -> 0x0015 }
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r2 = r3.b
            com.facebook.common.references.CloseableReference.closeSafely(r2)
            r3.b = r0
            java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> r2 = r3.c
            com.facebook.common.references.CloseableReference.closeSafely(r2)
            r3.c = r0
            return r1
        L_0x0015:
            r1 = move-exception
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r2 = r3.b
            com.facebook.common.references.CloseableReference.closeSafely(r2)
            r3.b = r0
            java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> r2 = r3.c
            com.facebook.common.references.CloseableReference.closeSafely(r2)
            r3.c = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder.build():com.facebook.imagepipeline.animated.base.AnimatedImageResult");
    }

    @Nullable
    public BitmapTransformation getBitmapTransformation() {
        return this.e;
    }

    public List<CloseableReference<Bitmap>> getDecodedFrames() {
        return CloseableReference.cloneOrNull(this.c);
    }

    public int getFrameForPreview() {
        return this.d;
    }

    public AnimatedImage getImage() {
        return this.a;
    }

    public CloseableReference<Bitmap> getPreviewBitmap() {
        return CloseableReference.cloneOrNull(this.b);
    }

    public AnimatedImageResultBuilder setBitmapTransformation(@Nullable BitmapTransformation bitmapTransformation) {
        this.e = bitmapTransformation;
        return this;
    }

    public AnimatedImageResultBuilder setDecodedFrames(List<CloseableReference<Bitmap>> list) {
        this.c = CloseableReference.cloneOrNull(list);
        return this;
    }

    public AnimatedImageResultBuilder setFrameForPreview(int i) {
        this.d = i;
        return this;
    }

    public AnimatedImageResultBuilder setPreviewBitmap(CloseableReference<Bitmap> closeableReference) {
        this.b = CloseableReference.cloneOrNull(closeableReference);
        return this;
    }
}
