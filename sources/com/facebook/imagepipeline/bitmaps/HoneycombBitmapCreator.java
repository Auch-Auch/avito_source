package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;
public class HoneycombBitmapCreator implements BitmapCreator {
    public final EmptyJpegGenerator a;
    public final FlexByteArrayPool b;

    public HoneycombBitmapCreator(PoolFactory poolFactory) {
        this.b = poolFactory.getFlexByteArrayPool();
        this.a = new EmptyJpegGenerator(poolFactory.getPooledByteBufferFactory());
    }

    @Override // com.facebook.common.webp.BitmapCreator
    @TargetApi(12)
    public Bitmap createNakedBitmap(int i, int i2, Bitmap.Config config) {
        Throwable th;
        EncodedImage encodedImage;
        CloseableReference<PooledByteBuffer> generate = this.a.generate((short) i, (short) i2);
        CloseableReference<byte[]> closeableReference = null;
        try {
            encodedImage = new EncodedImage(generate);
            try {
                encodedImage.setImageFormat(DefaultImageFormats.JPEG);
                int sampleSize = encodedImage.getSampleSize();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inDither = true;
                options.inPreferredConfig = config;
                options.inPurgeable = true;
                options.inInputShareable = true;
                options.inSampleSize = sampleSize;
                options.inMutable = true;
                int size = generate.get().size();
                closeableReference = this.b.get(size + 2);
                byte[] bArr = closeableReference.get();
                generate.get().read(0, bArr, 0, size);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, size, options);
                decodeByteArray.setHasAlpha(true);
                decodeByteArray.eraseColor(0);
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(generate);
                return decodeByteArray;
            } catch (Throwable th2) {
                th = th2;
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(generate);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            encodedImage = null;
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
            EncodedImage.closeSafely(encodedImage);
            CloseableReference.closeSafely(generate);
            throw th;
        }
    }
}
