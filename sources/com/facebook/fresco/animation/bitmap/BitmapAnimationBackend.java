package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
public class BitmapAnimationBackend implements AnimationBackend, AnimationBackendDelegateWithInactivityCheck.InactivityListener {
    public static final int FRAME_TYPE_CACHED = 0;
    public static final int FRAME_TYPE_CREATED = 2;
    public static final int FRAME_TYPE_FALLBACK = 3;
    public static final int FRAME_TYPE_REUSED = 1;
    public static final int FRAME_TYPE_UNKNOWN = -1;
    public final PlatformBitmapFactory a;
    public final BitmapFrameCache b;
    public final AnimationInformation c;
    public final BitmapFrameRenderer d;
    @Nullable
    public final BitmapFramePreparationStrategy e;
    @Nullable
    public final BitmapFramePreparer f;
    public final Paint g;
    @Nullable
    public Rect h;
    public int i;
    public int j;
    public Bitmap.Config k = Bitmap.Config.ARGB_8888;
    @Nullable
    public FrameListener l;

    public interface FrameListener {
        void onDrawFrameStart(BitmapAnimationBackend bitmapAnimationBackend, int i);

        void onFrameDrawn(BitmapAnimationBackend bitmapAnimationBackend, int i, int i2);

        void onFrameDropped(BitmapAnimationBackend bitmapAnimationBackend, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FrameType {
    }

    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, @Nullable BitmapFramePreparationStrategy bitmapFramePreparationStrategy, @Nullable BitmapFramePreparer bitmapFramePreparer) {
        this.a = platformBitmapFactory;
        this.b = bitmapFrameCache;
        this.c = animationInformation;
        this.d = bitmapFrameRenderer;
        this.e = bitmapFramePreparationStrategy;
        this.f = bitmapFramePreparer;
        this.g = new Paint(6);
        d();
    }

    public final boolean a(int i2, @Nullable CloseableReference<Bitmap> closeableReference, Canvas canvas, int i3) {
        if (!CloseableReference.isValid(closeableReference)) {
            return false;
        }
        if (this.h == null) {
            canvas.drawBitmap(closeableReference.get(), 0.0f, 0.0f, this.g);
        } else {
            canvas.drawBitmap(closeableReference.get(), (Rect) null, this.h, this.g);
        }
        if (i3 != 3) {
            this.b.onFrameRendered(i2, closeableReference, i3);
        }
        FrameListener frameListener = this.l;
        if (frameListener == null) {
            return true;
        }
        frameListener.onFrameDrawn(this, i2, i3);
        return true;
    }

    public final boolean b(Canvas canvas, int i2, int i3) {
        boolean z;
        int i4 = 3;
        boolean z2 = false;
        CloseableReference<Bitmap> closeableReference = null;
        if (i3 == 0) {
            closeableReference = this.b.getCachedFrame(i2);
            z = a(i2, closeableReference, canvas, 0);
            i4 = 1;
        } else if (i3 == 1) {
            closeableReference = this.b.getBitmapToReuseForFrame(i2, this.i, this.j);
            if (c(i2, closeableReference) && a(i2, closeableReference, canvas, 1)) {
                z2 = true;
            }
            z = z2;
            i4 = 2;
        } else if (i3 == 2) {
            try {
                closeableReference = this.a.createBitmap(this.i, this.j, this.k);
                if (c(i2, closeableReference) && a(i2, closeableReference, canvas, 2)) {
                    z2 = true;
                }
                z = z2;
            } catch (RuntimeException e2) {
                FLog.w(BitmapAnimationBackend.class, "Failed to create frame bitmap", e2);
                CloseableReference.closeSafely((CloseableReference<?>) null);
                return false;
            }
        } else if (i3 != 3) {
            CloseableReference.closeSafely((CloseableReference<?>) null);
            return false;
        } else {
            try {
                closeableReference = this.b.getFallbackFrame(i2);
                z = a(i2, closeableReference, canvas, 3);
                i4 = -1;
            } catch (Throwable th) {
                CloseableReference.closeSafely(closeableReference);
                throw th;
            }
        }
        CloseableReference.closeSafely(closeableReference);
        return (z || i4 == -1) ? z : b(canvas, i2, i4);
    }

    public final boolean c(int i2, @Nullable CloseableReference<Bitmap> closeableReference) {
        if (!CloseableReference.isValid(closeableReference)) {
            return false;
        }
        boolean renderFrame = this.d.renderFrame(i2, closeableReference.get());
        if (!renderFrame) {
            CloseableReference.closeSafely(closeableReference);
        }
        return renderFrame;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        this.b.clear();
    }

    public final void d() {
        int intrinsicWidth = this.d.getIntrinsicWidth();
        this.i = intrinsicWidth;
        int i2 = -1;
        if (intrinsicWidth == -1) {
            Rect rect = this.h;
            this.i = rect == null ? -1 : rect.width();
        }
        int intrinsicHeight = this.d.getIntrinsicHeight();
        this.j = intrinsicHeight;
        if (intrinsicHeight == -1) {
            Rect rect2 = this.h;
            if (rect2 != null) {
                i2 = rect2.height();
            }
            this.j = i2;
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i2) {
        BitmapFramePreparer bitmapFramePreparer;
        FrameListener frameListener;
        FrameListener frameListener2 = this.l;
        if (frameListener2 != null) {
            frameListener2.onDrawFrameStart(this, i2);
        }
        boolean b2 = b(canvas, i2, 0);
        if (!b2 && (frameListener = this.l) != null) {
            frameListener.onFrameDropped(this, i2);
        }
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.e;
        if (!(bitmapFramePreparationStrategy == null || (bitmapFramePreparer = this.f) == null)) {
            bitmapFramePreparationStrategy.prepareFrames(bitmapFramePreparer, this.b, this, i2);
        }
        return b2;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.c.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i2) {
        return this.c.getFrameDurationMs(i2);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        return this.j;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        return this.i;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.c.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        return this.b.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener
    public void onInactive() {
        clear();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.g.setAlpha(i2);
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.k = config;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(@Nullable Rect rect) {
        this.h = rect;
        this.d.setBounds(rect);
        d();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
    }

    public void setFrameListener(@Nullable FrameListener frameListener) {
        this.l = frameListener;
    }
}
