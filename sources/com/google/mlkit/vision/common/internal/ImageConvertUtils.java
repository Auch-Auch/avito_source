package com.google.mlkit.vision.common.internal;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.mlkit_vision_common.zzn;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
@KeepForSdk
public class ImageConvertUtils {
    public static final ImageConvertUtils a = new ImageConvertUtils();

    public static Bitmap a(Bitmap bitmap, int i, int i2, int i3) {
        if (i == 0) {
            return Bitmap.createBitmap(bitmap, 0, 0, i2, i3);
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, i2, i3, matrix, true);
    }

    @VisibleForTesting
    public static ByteBuffer c(ByteBuffer byteBuffer, boolean z) {
        ByteBuffer byteBuffer2;
        int i;
        byteBuffer.rewind();
        int limit = byteBuffer.limit();
        int i2 = limit / 6;
        if (z) {
            byteBuffer2 = ByteBuffer.allocate(limit);
        } else {
            byteBuffer2 = ByteBuffer.allocateDirect(limit);
        }
        int i3 = 0;
        while (true) {
            i = i2 << 2;
            if (i3 >= i) {
                break;
            }
            byteBuffer2.put(i3, byteBuffer.get(i3));
            i3++;
        }
        for (int i4 = 0; i4 < (i2 << 1); i4++) {
            byteBuffer2.put(i + i4, byteBuffer.get((i4 / 2) + ((i4 % 2) * i2) + i));
        }
        return byteBuffer2;
    }

    @VisibleForTesting
    @RequiresApi(19)
    public static ByteBuffer d(Image.Plane[] planeArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr = new byte[(((i3 / 4) * 2) + i3)];
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int position = buffer2.position();
        int limit = buffer.limit();
        buffer2.position(position + 1);
        buffer.limit(limit - 1);
        int i4 = (i3 * 2) / 4;
        boolean z = buffer2.remaining() == i4 + -2 && buffer2.compareTo(buffer) == 0;
        buffer2.position(position);
        buffer.limit(limit);
        if (z) {
            planeArr[0].getBuffer().get(bArr, 0, i3);
            ByteBuffer buffer3 = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i3, 1);
            buffer3.get(bArr, i3 + 1, i4 - 1);
        } else {
            e(planeArr[0], i, i2, bArr, 0, 1);
            e(planeArr[1], i, i2, bArr, i3 + 1, 2);
            e(planeArr[2], i, i2, bArr, i3, 2);
        }
        return ByteBuffer.wrap(bArr);
    }

    @TargetApi(19)
    public static void e(Image.Plane plane, int i, int i2, byte[] bArr, int i3, int i4) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int rowStride = ((plane.getRowStride() + buffer.limit()) - 1) / plane.getRowStride();
        if (rowStride != 0) {
            int i5 = i / (i2 / rowStride);
            int i6 = 0;
            for (int i7 = 0; i7 < rowStride; i7++) {
                int i8 = i6;
                for (int i9 = 0; i9 < i5; i9++) {
                    bArr[i3] = buffer.get(i8);
                    i3 += i4;
                    i8 += plane.getPixelStride();
                }
                i6 += plane.getRowStride();
            }
        }
    }

    public static byte[] f(@NonNull byte[] bArr, int i, int i2) {
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (IOException unused) {
                    return byteArray;
                }
            } catch (Throwable th) {
                zzn.zza(th, th);
            }
            throw th;
        } catch (IOException unused2) {
            return null;
        }
    }

    @KeepForSdk
    public static ImageConvertUtils getInstance() {
        return a;
    }

    public final Bitmap b(ByteBuffer byteBuffer, int i, int i2, int i3) {
        byte[] f = f(byteBufferToByteArray(byteBuffer), i, i2);
        return a(BitmapFactory.decodeByteArray(f, 0, f.length), i3, i, i2);
    }

    @KeepForSdk
    public byte[] byteBufferToByteArray(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return byteBuffer.array();
        }
        byteBuffer.rewind();
        int limit = byteBuffer.limit();
        byte[] bArr = new byte[limit];
        byteBuffer.get(bArr, 0, limit);
        return bArr;
    }

    @KeepForSdk
    public ByteBuffer cloneByteBuffer(@NonNull ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
        byteBuffer.rewind();
        allocate.put(byteBuffer);
        byteBuffer.rewind();
        allocate.flip();
        return allocate;
    }

    @NonNull
    @RequiresApi(19)
    @KeepForSdk
    public Bitmap convertJpegToUpRightBitmap(@NonNull Image image, int i) {
        Preconditions.checkArgument(image.getFormat() == 256, "Only JPEG and YUV_420_888 are supported now");
        Image.Plane[] planes = image.getPlanes();
        if (planes == null || planes.length != 1) {
            throw new IllegalArgumentException("Unexpected image format, JPEG should have exactly 1 image plane");
        }
        ByteBuffer buffer = planes[0].getBuffer();
        buffer.rewind();
        int remaining = buffer.remaining();
        byte[] bArr = new byte[remaining];
        buffer.get(bArr);
        return a(BitmapFactory.decodeByteArray(bArr, 0, remaining), i, image.getWidth(), image.getHeight());
    }

    @NonNull
    @KeepForSdk
    public ByteBuffer convertToNv21Buffer(@NonNull InputImage inputImage, boolean z) throws MlKitException {
        ByteBuffer byteBuffer;
        int i;
        int i2;
        int i3;
        int i4;
        int format = inputImage.getFormat();
        if (format == -1) {
            Bitmap bitmapInternal = inputImage.getBitmapInternal();
            int width = bitmapInternal.getWidth();
            int height = bitmapInternal.getHeight();
            int i5 = width * height;
            int[] iArr = new int[i5];
            bitmapInternal.getPixels(iArr, 0, width, 0, 0, width, height);
            int ceil = (((int) Math.ceil(((double) height) / 2.0d)) * 2 * ((int) Math.ceil(((double) width) / 2.0d))) + i5;
            if (z) {
                byteBuffer = ByteBuffer.allocate(ceil);
            } else {
                byteBuffer = ByteBuffer.allocateDirect(ceil);
            }
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < height; i8++) {
                int i9 = 0;
                while (i9 < width) {
                    int i10 = (iArr[i6] >> 16) & 255;
                    int i11 = (iArr[i6] >> 8) & 255;
                    int i12 = iArr[i6] & 255;
                    int c2 = (a.c2(i12, 25, (i11 * 129) + (i10 * 66), 128) >> 8) + 16;
                    int c22 = (a.c2(i12, 112, (i10 * -38) - (i11 * 74), 128) >> 8) + 128;
                    int i13 = (((((i10 * 112) - (i11 * 94)) - (i12 * 18)) + 128) >> 8) + 128;
                    int i14 = i7 + 1;
                    if (c2 < 0) {
                        i = 0;
                    } else {
                        i = Math.min(255, c2);
                    }
                    byteBuffer.put(i7, (byte) i);
                    if (i8 % 2 == 0 && i6 % 2 == 0) {
                        int i15 = i5 + 1;
                        if (i13 < 0) {
                            i3 = 0;
                            i2 = 255;
                        } else {
                            i2 = 255;
                            i3 = Math.min(255, i13);
                        }
                        byteBuffer.put(i5, (byte) i3);
                        i5 = i15 + 1;
                        if (c22 < 0) {
                            i4 = 0;
                        } else {
                            i4 = Math.min(i2, c22);
                        }
                        byteBuffer.put(i15, (byte) i4);
                    }
                    i6++;
                    i9++;
                    i7 = i14;
                }
            }
            return byteBuffer;
        } else if (format != 17) {
            if (format == 35) {
                return d(inputImage.getPlanes(), inputImage.getWidth(), inputImage.getHeight());
            }
            if (format == 842094169) {
                return c(inputImage.getByteBuffer(), z);
            }
            throw new MlKitException("Unsupported image format", 13);
        } else if (!z) {
            return inputImage.getByteBuffer();
        } else {
            ByteBuffer byteBuffer2 = inputImage.getByteBuffer();
            if (byteBuffer2.hasArray()) {
                return byteBuffer2;
            }
            byteBuffer2.rewind();
            byte[] bArr = new byte[byteBuffer2.limit()];
            byteBuffer2.get(bArr);
            return ByteBuffer.wrap(bArr);
        }
    }

    @NonNull
    @KeepForSdk
    public Bitmap convertToUpRightBitmap(@NonNull InputImage inputImage) throws MlKitException {
        int format = inputImage.getFormat();
        if (format == -1) {
            return a(inputImage.getBitmapInternal(), inputImage.getRotationDegrees(), inputImage.getWidth(), inputImage.getHeight());
        }
        if (format == 17) {
            return b(inputImage.getByteBuffer(), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees());
        }
        if (format == 35) {
            return b(d(inputImage.getPlanes(), inputImage.getWidth(), inputImage.getHeight()), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees());
        }
        if (format == 842094169) {
            ByteBuffer byteBuffer = inputImage.getByteBuffer();
            int width = inputImage.getWidth();
            int height = inputImage.getHeight();
            int rotationDegrees = inputImage.getRotationDegrees();
            byte[] f = f(c(byteBuffer, true).array(), width, height);
            return a(BitmapFactory.decodeByteArray(f, 0, f.length), rotationDegrees, width, height);
        }
        throw new MlKitException("Unsupported image format", 13);
    }

    @NonNull
    @KeepForSdk
    public Bitmap getUpRightBitmap(@NonNull InputImage inputImage) throws MlKitException {
        if (inputImage.getBitmapInternal() != null) {
            return a(inputImage.getBitmapInternal(), inputImage.getRotationDegrees(), inputImage.getWidth(), inputImage.getHeight());
        }
        return convertToUpRightBitmap(inputImage);
    }
}
