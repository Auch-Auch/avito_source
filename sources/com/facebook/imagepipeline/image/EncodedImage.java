package com.facebook.imagepipeline.image;

import android.graphics.ColorSpace;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.BytesRange;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
public class EncodedImage implements Closeable {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    public static final int UNKNOWN_HEIGHT = -1;
    public static final int UNKNOWN_ROTATION_ANGLE = -1;
    public static final int UNKNOWN_STREAM_SIZE = -1;
    public static final int UNKNOWN_WIDTH = -1;
    @Nullable
    public final CloseableReference<PooledByteBuffer> a;
    @Nullable
    public final Supplier<FileInputStream> b;
    public ImageFormat c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    @Nullable
    public BytesRange j;
    @Nullable
    public ColorSpace k;

    public EncodedImage(CloseableReference<PooledByteBuffer> closeableReference) {
        this.c = ImageFormat.UNKNOWN;
        this.d = -1;
        this.e = 0;
        this.f = -1;
        this.g = -1;
        this.h = 1;
        this.i = -1;
        Preconditions.checkArgument(CloseableReference.isValid(closeableReference));
        this.a = closeableReference.clone();
        this.b = null;
    }

    @Nullable
    public static EncodedImage cloneOrNull(EncodedImage encodedImage) {
        if (encodedImage != null) {
            return encodedImage.cloneOrNull();
        }
        return null;
    }

    public static void closeSafely(@Nullable EncodedImage encodedImage) {
        if (encodedImage != null) {
            encodedImage.close();
        }
    }

    public static boolean isMetaDataAvailable(EncodedImage encodedImage) {
        return encodedImage.d >= 0 && encodedImage.f >= 0 && encodedImage.g >= 0;
    }

    public final void a() {
        if (this.f < 0 || this.g < 0) {
            parseMetaData();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference.closeSafely(this.a);
    }

    public void copyMetaDataFrom(EncodedImage encodedImage) {
        this.c = encodedImage.getImageFormat();
        this.f = encodedImage.getWidth();
        this.g = encodedImage.getHeight();
        this.d = encodedImage.getRotationAngle();
        this.e = encodedImage.getExifOrientation();
        this.h = encodedImage.getSampleSize();
        this.i = encodedImage.getSize();
        this.j = encodedImage.getBytesRange();
        this.k = encodedImage.getColorSpace();
    }

    public CloseableReference<PooledByteBuffer> getByteBufferRef() {
        return CloseableReference.cloneOrNull(this.a);
    }

    @Nullable
    public BytesRange getBytesRange() {
        return this.j;
    }

    @Nullable
    public ColorSpace getColorSpace() {
        a();
        return this.k;
    }

    public int getExifOrientation() {
        a();
        return this.e;
    }

    public String getFirstBytesAsHexString(int i2) {
        CloseableReference<PooledByteBuffer> byteBufferRef = getByteBufferRef();
        if (byteBufferRef == null) {
            return "";
        }
        int min = Math.min(getSize(), i2);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.read(0, bArr, 0, min);
            byteBufferRef.close();
            StringBuilder sb = new StringBuilder(min * 2);
            for (int i3 = 0; i3 < min; i3++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i3])));
            }
            return sb.toString();
        } finally {
            byteBufferRef.close();
        }
    }

    public int getHeight() {
        a();
        return this.g;
    }

    public ImageFormat getImageFormat() {
        a();
        return this.c;
    }

    @Nullable
    public InputStream getInputStream() {
        Supplier<FileInputStream> supplier = this.b;
        if (supplier != null) {
            return supplier.get();
        }
        CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.a);
        if (cloneOrNull == null) {
            return null;
        }
        try {
            return new PooledByteBufferInputStream((PooledByteBuffer) cloneOrNull.get());
        } finally {
            CloseableReference.closeSafely(cloneOrNull);
        }
    }

    public int getRotationAngle() {
        a();
        return this.d;
    }

    public int getSampleSize() {
        return this.h;
    }

    public int getSize() {
        CloseableReference<PooledByteBuffer> closeableReference = this.a;
        if (closeableReference == null || closeableReference.get() == null) {
            return this.i;
        }
        return this.a.get().size();
    }

    @VisibleForTesting
    @Nullable
    public synchronized SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly() {
        CloseableReference<PooledByteBuffer> closeableReference;
        closeableReference = this.a;
        return closeableReference != null ? closeableReference.getUnderlyingReferenceTestOnly() : null;
    }

    public int getWidth() {
        a();
        return this.f;
    }

    public boolean isCompleteAt(int i2) {
        ImageFormat imageFormat = this.c;
        if ((imageFormat != DefaultImageFormats.JPEG && imageFormat != DefaultImageFormats.DNG) || this.b != null) {
            return true;
        }
        Preconditions.checkNotNull(this.a);
        PooledByteBuffer pooledByteBuffer = this.a.get();
        if (pooledByteBuffer.read(i2 - 2) == -1 && pooledByteBuffer.read(i2 - 1) == -39) {
            return true;
        }
        return false;
    }

    public synchronized boolean isValid() {
        return CloseableReference.isValid(this.a) || this.b != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3 A[SYNTHETIC, Splitter:B:34:0x00a3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseMetaData() {
        /*
            r5 = this;
            java.io.InputStream r0 = r5.getInputStream()
            com.facebook.imageformat.ImageFormat r0 = com.facebook.imageformat.ImageFormatChecker.getImageFormat_WrapIOException(r0)
            r5.c = r0
            boolean r1 = com.facebook.imageformat.DefaultImageFormats.isWebpFormat(r0)
            if (r1 == 0) goto L_0x002f
            java.io.InputStream r1 = r5.getInputStream()
            android.util.Pair r1 = com.facebook.imageutils.WebpUtil.getSize(r1)
            if (r1 == 0) goto L_0x0060
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r5.f = r2
            java.lang.Object r2 = r1.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r5.g = r2
            goto L_0x0060
        L_0x002f:
            java.io.InputStream r1 = r5.getInputStream()     // Catch:{ all -> 0x009f }
            com.facebook.imageutils.ImageMetaData r2 = com.facebook.imageutils.BitmapUtil.decodeDimensionsAndColorSpace(r1)     // Catch:{ all -> 0x009d }
            android.graphics.ColorSpace r3 = r2.getColorSpace()     // Catch:{ all -> 0x009d }
            r5.k = r3     // Catch:{ all -> 0x009d }
            android.util.Pair r3 = r2.getDimensions()     // Catch:{ all -> 0x009d }
            if (r3 == 0) goto L_0x0057
            java.lang.Object r4 = r3.first     // Catch:{ all -> 0x009d }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x009d }
            int r4 = r4.intValue()     // Catch:{ all -> 0x009d }
            r5.f = r4     // Catch:{ all -> 0x009d }
            java.lang.Object r3 = r3.second     // Catch:{ all -> 0x009d }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x009d }
            int r3 = r3.intValue()     // Catch:{ all -> 0x009d }
            r5.g = r3     // Catch:{ all -> 0x009d }
        L_0x0057:
            if (r1 == 0) goto L_0x005c
            r1.close()     // Catch:{ IOException -> 0x005c }
        L_0x005c:
            android.util.Pair r1 = r2.getDimensions()
        L_0x0060:
            com.facebook.imageformat.ImageFormat r2 = com.facebook.imageformat.DefaultImageFormats.JPEG
            r3 = -1
            if (r0 != r2) goto L_0x007c
            int r2 = r5.d
            if (r2 != r3) goto L_0x007c
            if (r1 == 0) goto L_0x009c
            java.io.InputStream r0 = r5.getInputStream()
            int r0 = com.facebook.imageutils.JfifUtil.getOrientation(r0)
            r5.e = r0
            int r0 = com.facebook.imageutils.JfifUtil.getAutoRotateAngleFromOrientation(r0)
            r5.d = r0
            goto L_0x009c
        L_0x007c:
            com.facebook.imageformat.ImageFormat r1 = com.facebook.imageformat.DefaultImageFormats.HEIF
            if (r0 != r1) goto L_0x0095
            int r0 = r5.d
            if (r0 != r3) goto L_0x0095
            java.io.InputStream r0 = r5.getInputStream()
            int r0 = com.facebook.imageutils.HeifExifUtil.getOrientation(r0)
            r5.e = r0
            int r0 = com.facebook.imageutils.JfifUtil.getAutoRotateAngleFromOrientation(r0)
            r5.d = r0
            goto L_0x009c
        L_0x0095:
            int r0 = r5.d
            if (r0 != r3) goto L_0x009c
            r0 = 0
            r5.d = r0
        L_0x009c:
            return
        L_0x009d:
            r0 = move-exception
            goto L_0x00a1
        L_0x009f:
            r0 = move-exception
            r1 = 0
        L_0x00a1:
            if (r1 == 0) goto L_0x00a6
            r1.close()     // Catch:{ IOException -> 0x00a6 }
        L_0x00a6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.image.EncodedImage.parseMetaData():void");
    }

    public void setBytesRange(@Nullable BytesRange bytesRange) {
        this.j = bytesRange;
    }

    public void setExifOrientation(int i2) {
        this.e = i2;
    }

    public void setHeight(int i2) {
        this.g = i2;
    }

    public void setImageFormat(ImageFormat imageFormat) {
        this.c = imageFormat;
    }

    public void setRotationAngle(int i2) {
        this.d = i2;
    }

    public void setSampleSize(int i2) {
        this.h = i2;
    }

    public void setStreamSize(int i2) {
        this.i = i2;
    }

    public void setWidth(int i2) {
        this.f = i2;
    }

    public static boolean isValid(@Nullable EncodedImage encodedImage) {
        return encodedImage != null && encodedImage.isValid();
    }

    @Nullable
    public EncodedImage cloneOrNull() {
        EncodedImage encodedImage;
        Supplier<FileInputStream> supplier = this.b;
        if (supplier != null) {
            encodedImage = new EncodedImage(supplier, this.i);
        } else {
            CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.a);
            if (cloneOrNull == null) {
                encodedImage = null;
            } else {
                try {
                    encodedImage = new EncodedImage(cloneOrNull);
                } catch (Throwable th) {
                    CloseableReference.closeSafely(cloneOrNull);
                    throw th;
                }
            }
            CloseableReference.closeSafely(cloneOrNull);
        }
        if (encodedImage != null) {
            encodedImage.copyMetaDataFrom(this);
        }
        return encodedImage;
    }

    public EncodedImage(Supplier<FileInputStream> supplier) {
        this.c = ImageFormat.UNKNOWN;
        this.d = -1;
        this.e = 0;
        this.f = -1;
        this.g = -1;
        this.h = 1;
        this.i = -1;
        Preconditions.checkNotNull(supplier);
        this.a = null;
        this.b = supplier;
    }

    public EncodedImage(Supplier<FileInputStream> supplier, int i2) {
        this(supplier);
        this.i = i2;
    }
}
