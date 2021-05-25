package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public class FrescoFrameCache implements BitmapFrameCache {
    public final AnimatedFrameCache a;
    public final boolean b;
    @GuardedBy("this")
    public final SparseArray<CloseableReference<CloseableImage>> c = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    public CloseableReference<CloseableImage> d;

    public FrescoFrameCache(AnimatedFrameCache animatedFrameCache, boolean z) {
        this.a = animatedFrameCache;
        this.b = z;
    }

    @VisibleForTesting
    @Nullable
    public static CloseableReference<Bitmap> a(@Nullable CloseableReference<CloseableImage> closeableReference) {
        CloseableStaticBitmap closeableStaticBitmap;
        try {
            if (CloseableReference.isValid(closeableReference) && (closeableReference.get() instanceof CloseableStaticBitmap) && (closeableStaticBitmap = (CloseableStaticBitmap) closeableReference.get()) != null) {
                return closeableStaticBitmap.cloneUnderlyingBitmapReference();
            }
            CloseableReference.closeSafely(closeableReference);
            return null;
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public static int b(@Nullable CloseableReference<CloseableImage> closeableReference) {
        if (!CloseableReference.isValid(closeableReference)) {
            return 0;
        }
        CloseableImage closeableImage = closeableReference.get();
        if (!(closeableImage instanceof CloseableBitmap)) {
            return 0;
        }
        return BitmapUtil.getSizeInBytes(((CloseableBitmap) closeableImage).getUnderlyingBitmap());
    }

    public final synchronized void c(int i) {
        CloseableReference<CloseableImage> closeableReference = this.c.get(i);
        if (closeableReference != null) {
            this.c.delete(i);
            CloseableReference.closeSafely(closeableReference);
            FLog.v(FrescoFrameCache.class, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.c);
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void clear() {
        CloseableReference.closeSafely(this.d);
        this.d = null;
        for (int i = 0; i < this.c.size(); i++) {
            CloseableReference.closeSafely(this.c.valueAt(i));
        }
        this.c.clear();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized boolean contains(int i) {
        return this.a.contains(i);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3) {
        if (!this.b) {
            return null;
        }
        return a(this.a.getForReuse());
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getCachedFrame(int i) {
        return a(this.a.get(i));
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i) {
        return a(CloseableReference.cloneOrNull(this.d));
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized int getSizeInBytes() {
        int i;
        int b2 = b(this.d);
        synchronized (this) {
            i = 0;
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                i += b(this.c.valueAt(i2));
            }
        }
        return b2 + i;
        return b2 + i;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        Preconditions.checkNotNull(closeableReference);
        CloseableReference<CloseableImage> closeableReference2 = null;
        try {
            closeableReference2 = CloseableReference.of(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.FULL_QUALITY, 0));
            if (closeableReference2 != null) {
                CloseableReference<CloseableImage> cache = this.a.cache(i, closeableReference2);
                if (CloseableReference.isValid(cache)) {
                    CloseableReference.closeSafely(this.c.get(i));
                    this.c.put(i, cache);
                    FLog.v(FrescoFrameCache.class, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.c);
                }
                CloseableReference.closeSafely(closeableReference2);
            }
        } finally {
            CloseableReference.closeSafely(closeableReference2);
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        Preconditions.checkNotNull(closeableReference);
        c(i);
        try {
            CloseableReference<CloseableImage> of = CloseableReference.of(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.FULL_QUALITY, 0));
            if (of != null) {
                CloseableReference.closeSafely(this.d);
                this.d = this.a.cache(i, of);
            }
            CloseableReference.closeSafely(of);
        } catch (Throwable th) {
            CloseableReference.closeSafely((CloseableReference<?>) null);
            throw th;
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
    }
}
