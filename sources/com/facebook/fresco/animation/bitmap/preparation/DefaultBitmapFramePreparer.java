package com.facebook.fresco.animation.bitmap.preparation;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.concurrent.ExecutorService;
public class DefaultBitmapFramePreparer implements BitmapFramePreparer {
    public final PlatformBitmapFactory a;
    public final BitmapFrameRenderer b;
    public final Bitmap.Config c;
    public final ExecutorService d;
    public final SparseArray<Runnable> e = new SparseArray<>();

    public class a implements Runnable {
        public final BitmapFrameCache a;
        public final AnimationBackend b;
        public final int c;
        public final int d;

        public a(AnimationBackend animationBackend, BitmapFrameCache bitmapFrameCache, int i, int i2) {
            this.b = animationBackend;
            this.a = bitmapFrameCache;
            this.c = i;
            this.d = i2;
        }

        public final boolean a(int i, int i2) {
            CloseableReference<Bitmap> closeableReference;
            int i3 = 2;
            if (i2 == 1) {
                closeableReference = this.a.getBitmapToReuseForFrame(i, this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight());
            } else if (i2 != 2) {
                CloseableReference.closeSafely((CloseableReference<?>) null);
                return false;
            } else {
                try {
                    closeableReference = DefaultBitmapFramePreparer.this.a.createBitmap(this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight(), DefaultBitmapFramePreparer.this.c);
                    i3 = -1;
                } catch (RuntimeException e2) {
                    FLog.w(DefaultBitmapFramePreparer.class, "Failed to create frame bitmap", e2);
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    return false;
                } catch (Throwable th) {
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    throw th;
                }
            }
            boolean b2 = b(i, closeableReference, i2);
            CloseableReference.closeSafely(closeableReference);
            return (b2 || i3 == -1) ? b2 : a(i, i3);
        }

        public final boolean b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
            if (!CloseableReference.isValid(closeableReference) || !DefaultBitmapFramePreparer.this.b.renderFrame(i, closeableReference.get())) {
                return false;
            }
            FLog.v(DefaultBitmapFramePreparer.class, "Frame %d ready.", Integer.valueOf(this.c));
            synchronized (DefaultBitmapFramePreparer.this.e) {
                this.a.onFramePrepared(this.c, closeableReference, i2);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.a.contains(this.c)) {
                    FLog.v(DefaultBitmapFramePreparer.class, "Frame %d is cached already.", Integer.valueOf(this.c));
                    synchronized (DefaultBitmapFramePreparer.this.e) {
                        DefaultBitmapFramePreparer.this.e.remove(this.d);
                    }
                    return;
                }
                if (a(this.c, 1)) {
                    FLog.v(DefaultBitmapFramePreparer.class, "Prepared frame frame %d.", Integer.valueOf(this.c));
                } else {
                    FLog.e(DefaultBitmapFramePreparer.class, "Could not prepare frame %d.", Integer.valueOf(this.c));
                }
                synchronized (DefaultBitmapFramePreparer.this.e) {
                    DefaultBitmapFramePreparer.this.e.remove(this.d);
                }
            } catch (Throwable th) {
                synchronized (DefaultBitmapFramePreparer.this.e) {
                    DefaultBitmapFramePreparer.this.e.remove(this.d);
                    throw th;
                }
            }
        }
    }

    public DefaultBitmapFramePreparer(PlatformBitmapFactory platformBitmapFactory, BitmapFrameRenderer bitmapFrameRenderer, Bitmap.Config config, ExecutorService executorService) {
        this.a = platformBitmapFactory;
        this.b = bitmapFrameRenderer;
        this.c = config;
        this.d = executorService;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer
    public boolean prepareFrame(BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i) {
        int hashCode = (animationBackend.hashCode() * 31) + i;
        synchronized (this.e) {
            if (this.e.get(hashCode) != null) {
                FLog.v(DefaultBitmapFramePreparer.class, "Already scheduled decode job for frame %d", Integer.valueOf(i));
                return true;
            } else if (bitmapFrameCache.contains(i)) {
                FLog.v(DefaultBitmapFramePreparer.class, "Frame %d is cached already.", Integer.valueOf(i));
                return true;
            } else {
                a aVar = new a(animationBackend, bitmapFrameCache, i, hashCode);
                this.e.put(hashCode, aVar);
                this.d.execute(aVar);
                return true;
            }
        }
    }
}
