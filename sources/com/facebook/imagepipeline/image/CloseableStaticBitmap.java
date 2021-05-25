package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.HasBitmap;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public class CloseableStaticBitmap extends CloseableBitmap implements HasBitmap {
    @GuardedBy("this")
    public CloseableReference<Bitmap> c;
    public volatile Bitmap d;
    public final QualityInfo e;
    public final int f;
    public final int g;

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i) {
        this(bitmap, resourceReleaser, qualityInfo, i, 0);
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> cloneUnderlyingBitmapReference() {
        return CloseableReference.cloneOrNull(this.c);
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference<Bitmap> closeableReference;
        synchronized (this) {
            closeableReference = this.c;
            this.c = null;
            this.d = null;
        }
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    public synchronized CloseableReference<Bitmap> convertToBitmapReference() {
        CloseableReference<Bitmap> closeableReference;
        Preconditions.checkNotNull(this.c, "Cannot convert a closed static bitmap");
        synchronized (this) {
            closeableReference = this.c;
            this.c = null;
            this.d = null;
        }
        return closeableReference;
        return closeableReference;
    }

    public int getExifOrientation() {
        return this.g;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        int i;
        if (this.f % 180 != 0 || (i = this.g) == 5 || i == 7) {
            Bitmap bitmap = this.d;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getWidth();
        }
        Bitmap bitmap2 = this.d;
        if (bitmap2 == null) {
            return 0;
        }
        return bitmap2.getHeight();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public QualityInfo getQualityInfo() {
        return this.e;
    }

    public int getRotationAngle() {
        return this.f;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public int getSizeInBytes() {
        return BitmapUtil.getSizeInBytes(this.d);
    }

    @Override // com.facebook.imagepipeline.image.CloseableBitmap
    public Bitmap getUnderlyingBitmap() {
        return this.d;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        int i;
        if (this.f % 180 != 0 || (i = this.g) == 5 || i == 7) {
            Bitmap bitmap = this.d;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight();
        }
        Bitmap bitmap2 = this.d;
        if (bitmap2 == null) {
            return 0;
        }
        return bitmap2.getWidth();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        return this.c == null;
    }

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i, int i2) {
        this.d = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.c = CloseableReference.of(this.d, (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser));
        this.e = qualityInfo;
        this.f = i;
        this.g = i2;
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i) {
        this(closeableReference, qualityInfo, i, 0);
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i, int i2) {
        CloseableReference<Bitmap> closeableReference2 = (CloseableReference) Preconditions.checkNotNull(closeableReference.cloneOrNull());
        this.c = closeableReference2;
        this.d = closeableReference2.get();
        this.e = qualityInfo;
        this.f = i;
        this.g = i2;
    }
}
