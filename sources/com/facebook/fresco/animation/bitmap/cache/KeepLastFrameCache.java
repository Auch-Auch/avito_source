package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public class KeepLastFrameCache implements BitmapFrameCache {
    public int a = -1;
    @Nullable
    public BitmapFrameCache.FrameCacheListener b;
    @GuardedBy("this")
    @Nullable
    public CloseableReference<Bitmap> c;

    public final synchronized void a() {
        int i;
        BitmapFrameCache.FrameCacheListener frameCacheListener = this.b;
        if (!(frameCacheListener == null || (i = this.a) == -1)) {
            frameCacheListener.onFrameEvicted(this, i);
        }
        CloseableReference.closeSafely(this.c);
        this.c = null;
        this.a = -1;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void clear() {
        a();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized boolean contains(int i) {
        return i == this.a && CloseableReference.isValid(this.c);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3) {
        try {
        } finally {
            a();
        }
        return CloseableReference.cloneOrNull(this.c);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getCachedFrame(int i) {
        if (this.a != i) {
            return null;
        }
        return CloseableReference.cloneOrNull(this.c);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i) {
        return CloseableReference.cloneOrNull(this.c);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized int getSizeInBytes() {
        CloseableReference<Bitmap> closeableReference;
        closeableReference = this.c;
        return closeableReference == null ? 0 : BitmapUtil.getSizeInBytes(closeableReference.get());
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2) {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        int i3;
        if (closeableReference != null) {
            if (this.c != null && closeableReference.get().equals(this.c.get())) {
                return;
            }
        }
        CloseableReference.closeSafely(this.c);
        BitmapFrameCache.FrameCacheListener frameCacheListener = this.b;
        if (!(frameCacheListener == null || (i3 = this.a) == -1)) {
            frameCacheListener.onFrameEvicted(this, i3);
        }
        this.c = CloseableReference.cloneOrNull(closeableReference);
        BitmapFrameCache.FrameCacheListener frameCacheListener2 = this.b;
        if (frameCacheListener2 != null) {
            frameCacheListener2.onFrameCached(this, i);
        }
        this.a = i;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
        this.b = frameCacheListener;
    }
}
