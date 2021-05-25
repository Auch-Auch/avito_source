package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(21)
public class ArtBitmapFactory extends PlatformBitmapFactory {
    public final BitmapPool a;
    public final CloseableReferenceFactory b;

    public ArtBitmapFactory(BitmapPool bitmapPool, CloseableReferenceFactory closeableReferenceFactory) {
        this.a = bitmapPool;
        this.b = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> createBitmapInternal(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap = (Bitmap) this.a.get(BitmapUtil.getSizeInByteForBitmap(i, i2, config));
        Preconditions.checkArgument(bitmap.getAllocationByteCount() >= BitmapUtil.getPixelSizeForBitmapConfig(config) * (i * i2));
        bitmap.reconfigure(i, i2, config);
        return this.b.create(bitmap, this.a);
    }
}
