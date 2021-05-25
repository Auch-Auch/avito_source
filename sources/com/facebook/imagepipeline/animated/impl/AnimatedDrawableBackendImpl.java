package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public class AnimatedDrawableBackendImpl implements AnimatedDrawableBackend {
    public final AnimatedDrawableUtil a;
    public final AnimatedImageResult b;
    public final AnimatedImage c;
    public final Rect d;
    public final int[] e;
    public final int[] f;
    public final int g;
    public final AnimatedDrawableFrameInfo[] h;
    public final Rect i = new Rect();
    public final Rect j = new Rect();
    public final boolean k;
    @GuardedBy("this")
    @Nullable
    public Bitmap l;

    public AnimatedDrawableBackendImpl(AnimatedDrawableUtil animatedDrawableUtil, AnimatedImageResult animatedImageResult, Rect rect, boolean z) {
        this.a = animatedDrawableUtil;
        this.b = animatedImageResult;
        AnimatedImage image = animatedImageResult.getImage();
        this.c = image;
        int[] frameDurations = image.getFrameDurations();
        this.e = frameDurations;
        animatedDrawableUtil.fixFrameDurations(frameDurations);
        this.g = animatedDrawableUtil.getTotalDurationFromFrameDurations(frameDurations);
        this.f = animatedDrawableUtil.getFrameTimeStampsFromDurations(frameDurations);
        this.d = b(image, rect);
        this.k = z;
        this.h = new AnimatedDrawableFrameInfo[image.getFrameCount()];
        for (int i2 = 0; i2 < this.c.getFrameCount(); i2++) {
            this.h[i2] = this.c.getFrameInfo(i2);
        }
    }

    public static Rect b(AnimatedImage animatedImage, Rect rect) {
        if (rect == null) {
            return new Rect(0, 0, animatedImage.getWidth(), animatedImage.getHeight());
        }
        return new Rect(0, 0, Math.min(rect.width(), animatedImage.getWidth()), Math.min(rect.height(), animatedImage.getHeight()));
    }

    public final synchronized void a() {
        Bitmap bitmap = this.l;
        if (bitmap != null) {
            bitmap.recycle();
            this.l = null;
        }
    }

    public final synchronized void c(int i2, int i3) {
        Bitmap bitmap = this.l;
        if (bitmap != null && (bitmap.getWidth() < i2 || this.l.getHeight() < i3)) {
            a();
        }
        if (this.l == null) {
            this.l = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
        this.l.eraseColor(0);
    }

    public final void d(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.k) {
            float max = Math.max(((float) animatedImageFrame.getWidth()) / ((float) Math.min(animatedImageFrame.getWidth(), canvas.getWidth())), ((float) animatedImageFrame.getHeight()) / ((float) Math.min(animatedImageFrame.getHeight(), canvas.getHeight())));
            i4 = (int) (((float) animatedImageFrame.getWidth()) / max);
            i3 = (int) (((float) animatedImageFrame.getHeight()) / max);
            i2 = (int) (((float) animatedImageFrame.getXOffset()) / max);
            i5 = (int) (((float) animatedImageFrame.getYOffset()) / max);
        } else {
            i4 = animatedImageFrame.getWidth();
            i3 = animatedImageFrame.getHeight();
            i2 = animatedImageFrame.getXOffset();
            i5 = animatedImageFrame.getYOffset();
        }
        synchronized (this) {
            c(i4, i3);
            animatedImageFrame.renderFrame(i4, i3, this.l);
            canvas.save();
            canvas.translate((float) i2, (float) i5);
            canvas.drawBitmap(this.l, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public synchronized void dropCaches() {
        a();
    }

    public final void e(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        double width = ((double) this.d.width()) / ((double) this.c.getWidth());
        double height = ((double) this.d.height()) / ((double) this.c.getHeight());
        int round = (int) Math.round(((double) animatedImageFrame.getWidth()) * width);
        int round2 = (int) Math.round(((double) animatedImageFrame.getHeight()) * height);
        int xOffset = (int) (((double) animatedImageFrame.getXOffset()) * width);
        int yOffset = (int) (((double) animatedImageFrame.getYOffset()) * height);
        synchronized (this) {
            int width2 = this.d.width();
            int height2 = this.d.height();
            c(width2, height2);
            animatedImageFrame.renderFrame(round, round2, this.l);
            this.i.set(0, 0, width2, height2);
            this.j.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.l, this.i, this.j, (Paint) null);
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableBackend forNewBounds(Rect rect) {
        if (b(this.c, rect).equals(this.d)) {
            return this;
        }
        return new AnimatedDrawableBackendImpl(this.a, this.b, rect, this.k);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedImageResult getAnimatedImageResult() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMs() {
        return this.g;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMsForFrame(int i2) {
        return this.e[i2];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameCount() {
        return this.c.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForPreview() {
        return this.b.getFrameForPreview();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForTimestampMs(int i2) {
        return this.a.getFrameForTimestampMs(this.f, i2);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableFrameInfo getFrameInfo(int i2) {
        return this.h[i2];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getHeight() {
        return this.c.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getLoopCount() {
        return this.c.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public synchronized int getMemoryUsage() {
        int i2;
        i2 = 0;
        Bitmap bitmap = this.l;
        if (bitmap != null) {
            i2 = 0 + this.a.getSizeOfBitmap(bitmap);
        }
        return i2 + this.c.getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public CloseableReference<Bitmap> getPreDecodedFrame(int i2) {
        return this.b.getDecodedFrame(i2);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedHeight() {
        return this.d.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedWidth() {
        return this.d.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getTimestampMsForFrame(int i2) {
        Preconditions.checkElementIndex(i2, this.f.length);
        return this.f[i2];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getWidth() {
        return this.c.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public boolean hasPreDecodedFrame(int i2) {
        return this.b.hasDecodedFrame(i2);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public void renderFrame(int i2, Canvas canvas) {
        AnimatedImageFrame frame = this.c.getFrame(i2);
        try {
            if (this.c.doesRenderSupportScaling()) {
                e(canvas, frame);
            } else {
                d(canvas, frame);
            }
        } finally {
            frame.dispose();
        }
    }
}
