package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(11)
public class HoneycombBitmapFactory extends PlatformBitmapFactory {
    public final EmptyJpegGenerator a;
    public final PlatformDecoder b;
    public final CloseableReferenceFactory c;
    public boolean d;

    public HoneycombBitmapFactory(EmptyJpegGenerator emptyJpegGenerator, PlatformDecoder platformDecoder, CloseableReferenceFactory closeableReferenceFactory) {
        this.a = emptyJpegGenerator;
        this.b = platformDecoder;
        this.c = closeableReferenceFactory;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    @TargetApi(12)
    public CloseableReference<Bitmap> createBitmapInternal(int i, int i2, Bitmap.Config config) {
        if (this.d) {
            return this.c.create(Bitmap.createBitmap(i, i2, config), SimpleBitmapReleaser.getInstance());
        }
        CloseableReference<PooledByteBuffer> generate = this.a.generate((short) i, (short) i2);
        try {
            EncodedImage encodedImage = new EncodedImage(generate);
            encodedImage.setImageFormat(DefaultImageFormats.JPEG);
            try {
                CloseableReference<Bitmap> decodeJPEGFromEncodedImage = this.b.decodeJPEGFromEncodedImage(encodedImage, config, null, generate.get().size());
                if (!decodeJPEGFromEncodedImage.get().isMutable()) {
                    CloseableReference.closeSafely(decodeJPEGFromEncodedImage);
                    this.d = true;
                    FLog.wtf("HoneycombBitmapFactory", "Immutable bitmap returned by decoder");
                    CloseableReference<Bitmap> create = this.c.create(Bitmap.createBitmap(i, i2, config), SimpleBitmapReleaser.getInstance());
                    EncodedImage.closeSafely(encodedImage);
                    return create;
                }
                decodeJPEGFromEncodedImage.get().setHasAlpha(true);
                decodeJPEGFromEncodedImage.get().eraseColor(0);
                EncodedImage.closeSafely(encodedImage);
                generate.close();
                return decodeJPEGFromEncodedImage;
            } catch (Throwable th) {
                EncodedImage.closeSafely(encodedImage);
                throw th;
            }
        } finally {
            generate.close();
        }
    }
}
