package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import javax.annotation.Nullable;
public class CloseableAnimatedImage extends CloseableImage {
    public AnimatedImageResult c;
    public boolean d;

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult) {
        this(animatedImageResult, true);
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            AnimatedImageResult animatedImageResult = this.c;
            if (animatedImageResult != null) {
                this.c = null;
                animatedImageResult.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.c.getImage().getHeight();
    }

    @Nullable
    public synchronized AnimatedImage getImage() {
        return isClosed() ? null : this.c.getImage();
    }

    public synchronized AnimatedImageResult getImageResult() {
        return this.c;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.c.getImage().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.c.getImage().getWidth();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        return this.c == null;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public boolean isStateful() {
        return this.d;
    }

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult, boolean z) {
        this.c = animatedImageResult;
        this.d = z;
    }
}
