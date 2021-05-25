package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
public class AnimatedImageCompositor {
    public final AnimatedDrawableBackend a;
    public final Callback b;
    public final Paint c;

    public interface Callback {
        CloseableReference<Bitmap> getCachedBitmap(int i);

        void onIntermediateResult(int i, Bitmap bitmap);
    }

    public enum a {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    public AnimatedImageCompositor(AnimatedDrawableBackend animatedDrawableBackend, Callback callback) {
        this.a = animatedDrawableBackend;
        this.b = callback;
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public final void a(Canvas canvas, AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        int i = animatedDrawableFrameInfo.xOffset;
        int i2 = animatedDrawableFrameInfo.yOffset;
        canvas.drawRect((float) i, (float) i2, (float) (i + animatedDrawableFrameInfo.width), (float) (i2 + animatedDrawableFrameInfo.height), this.c);
    }

    public final boolean b(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.xOffset == 0 && animatedDrawableFrameInfo.yOffset == 0 && animatedDrawableFrameInfo.width == this.a.getRenderedWidth() && animatedDrawableFrameInfo.height == this.a.getRenderedHeight();
    }

    public final boolean c(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo frameInfo = this.a.getFrameInfo(i);
        AnimatedDrawableFrameInfo frameInfo2 = this.a.getFrameInfo(i - 1);
        if (frameInfo.blendOperation == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && b(frameInfo)) {
            return true;
        }
        if (frameInfo2.disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND || !b(frameInfo2)) {
            return false;
        }
        return true;
    }

    public void renderFrame(int i, Bitmap bitmap) {
        BitmapTransformation bitmapTransformation;
        Canvas canvas = new Canvas(bitmap);
        int i2 = 0;
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (!c(i)) {
            int i3 = i - 1;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                a aVar = a.REQUIRED;
                AnimatedDrawableFrameInfo frameInfo = this.a.getFrameInfo(i3);
                AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = frameInfo.disposalMethod;
                if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
                    if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                        aVar = disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS ? a.SKIP : a.ABORT;
                    } else if (b(frameInfo)) {
                        aVar = a.NOT_REQUIRED;
                    }
                }
                int ordinal = aVar.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 1) {
                        if (ordinal == 3) {
                            break;
                        }
                        i3--;
                    } else {
                        i2 = i3 + 1;
                        break;
                    }
                } else {
                    AnimatedDrawableFrameInfo frameInfo2 = this.a.getFrameInfo(i3);
                    CloseableReference<Bitmap> cachedBitmap = this.b.getCachedBitmap(i3);
                    if (cachedBitmap != null) {
                        try {
                            canvas.drawBitmap(cachedBitmap.get(), 0.0f, 0.0f, (Paint) null);
                            if (frameInfo2.disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, frameInfo2);
                            }
                            i2 = i3 + 1;
                        } finally {
                            cachedBitmap.close();
                        }
                    } else if (c(i3)) {
                        break;
                    } else {
                        i3--;
                    }
                }
            }
            i2 = i3;
        } else {
            i2 = i;
        }
        while (i2 < i) {
            AnimatedDrawableFrameInfo frameInfo3 = this.a.getFrameInfo(i2);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod2 = frameInfo3.disposalMethod;
            if (disposalMethod2 != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (frameInfo3.blendOperation == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, frameInfo3);
                }
                this.a.renderFrame(i2, canvas);
                this.b.onIntermediateResult(i2, bitmap);
                if (disposalMethod2 == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, frameInfo3);
                }
            }
            i2++;
        }
        AnimatedDrawableFrameInfo frameInfo4 = this.a.getFrameInfo(i);
        if (frameInfo4.blendOperation == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, frameInfo4);
        }
        this.a.renderFrame(i, canvas);
        AnimatedImageResult animatedImageResult = this.a.getAnimatedImageResult();
        if (animatedImageResult != null && (bitmapTransformation = animatedImageResult.getBitmapTransformation()) != null) {
            bitmapTransformation.transform(bitmap);
        }
    }
}
