package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import java.util.List;
import javax.annotation.Nullable;
public class AnimatedImageResult {
    public final AnimatedImage a;
    public final int b;
    @Nullable
    public CloseableReference<Bitmap> c;
    @Nullable
    public List<CloseableReference<Bitmap>> d;
    @Nullable
    public BitmapTransformation e;

    public AnimatedImageResult(AnimatedImageResultBuilder animatedImageResultBuilder) {
        this.a = (AnimatedImage) Preconditions.checkNotNull(animatedImageResultBuilder.getImage());
        this.b = animatedImageResultBuilder.getFrameForPreview();
        this.c = animatedImageResultBuilder.getPreviewBitmap();
        this.d = animatedImageResultBuilder.getDecodedFrames();
        this.e = animatedImageResultBuilder.getBitmapTransformation();
    }

    public static AnimatedImageResult forAnimatedImage(AnimatedImage animatedImage) {
        return new AnimatedImageResult(animatedImage);
    }

    public static AnimatedImageResultBuilder newBuilder(AnimatedImage animatedImage) {
        return new AnimatedImageResultBuilder(animatedImage);
    }

    public synchronized void dispose() {
        CloseableReference.closeSafely(this.c);
        this.c = null;
        CloseableReference.closeSafely(this.d);
        this.d = null;
    }

    @Nullable
    public BitmapTransformation getBitmapTransformation() {
        return this.e;
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> getDecodedFrame(int i) {
        List<CloseableReference<Bitmap>> list = this.d;
        if (list == null) {
            return null;
        }
        return CloseableReference.cloneOrNull(list.get(i));
    }

    public int getFrameForPreview() {
        return this.b;
    }

    public AnimatedImage getImage() {
        return this.a;
    }

    public synchronized CloseableReference<Bitmap> getPreviewBitmap() {
        return CloseableReference.cloneOrNull(this.c);
    }

    public synchronized boolean hasDecodedFrame(int i) {
        List<CloseableReference<Bitmap>> list;
        list = this.d;
        return (list == null || list.get(i) == null) ? false : true;
    }

    public AnimatedImageResult(AnimatedImage animatedImage) {
        this.a = (AnimatedImage) Preconditions.checkNotNull(animatedImage);
        this.b = 0;
    }
}
