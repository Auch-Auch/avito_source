package com.facebook.fresco.animation.bitmap.wrapper;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
public class AnimatedDrawableBackendFrameRenderer implements BitmapFrameRenderer {
    public final BitmapFrameCache a;
    public AnimatedDrawableBackend b;
    public AnimatedImageCompositor c;
    public final AnimatedImageCompositor.Callback d;

    public class a implements AnimatedImageCompositor.Callback {
        public a() {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
        @Nullable
        public CloseableReference<Bitmap> getCachedBitmap(int i) {
            return AnimatedDrawableBackendFrameRenderer.this.a.getCachedFrame(i);
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
        public void onIntermediateResult(int i, Bitmap bitmap) {
        }
    }

    public AnimatedDrawableBackendFrameRenderer(BitmapFrameCache bitmapFrameCache, AnimatedDrawableBackend animatedDrawableBackend) {
        a aVar = new a();
        this.d = aVar;
        this.a = bitmapFrameCache;
        this.b = animatedDrawableBackend;
        this.c = new AnimatedImageCompositor(animatedDrawableBackend, aVar);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public int getIntrinsicHeight() {
        return this.b.getHeight();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public int getIntrinsicWidth() {
        return this.b.getWidth();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public boolean renderFrame(int i, Bitmap bitmap) {
        try {
            this.c.renderFrame(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            FLog.e(AnimatedDrawableBackendFrameRenderer.class, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public void setBounds(@Nullable Rect rect) {
        AnimatedDrawableBackend forNewBounds = this.b.forNewBounds(rect);
        if (forNewBounds != this.b) {
            this.b = forNewBounds;
            this.c = new AnimatedImageCompositor(forNewBounds, this.d);
        }
    }
}
