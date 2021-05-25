package com.google.mlkit.vision.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_common.zzcu;
import com.google.mlkit.common.sdkinternal.MLTaskInput;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.Immutable;
@Immutable
public class InputImage implements MLTaskInput {
    @KeepForSdk
    public static final int IMAGE_FORMAT_BITMAP = -1;
    public static final int IMAGE_FORMAT_NV21 = 17;
    public static final int IMAGE_FORMAT_YUV_420_888 = 35;
    public static final int IMAGE_FORMAT_YV12 = 842094169;
    @Nullable
    public volatile Bitmap a;
    @Nullable
    public volatile ByteBuffer b;
    @Nullable
    public volatile a c;
    public final int d;
    public final int e;
    public final int f;
    @ImageFormat
    public final int g;

    @Retention(RetentionPolicy.CLASS)
    public @interface ImageFormat {
    }

    public static class a {
        public final Image.Plane[] a;

        public a(Image.Plane[] planeArr) {
            this.a = planeArr;
        }
    }

    public InputImage(@NonNull ByteBuffer byteBuffer, int i, int i2, int i3, @ImageFormat int i4) {
        Preconditions.checkArgument(i4 == 842094169 || i4 == 17);
        this.b = (ByteBuffer) Preconditions.checkNotNull(byteBuffer);
        byteBuffer.rewind();
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }

    @NonNull
    public static InputImage fromBitmap(@NonNull Bitmap bitmap, int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(bitmap, i);
        zzcu.zza(-1, 1, elapsedRealtime, -1, -1, bitmap.getAllocationByteCount(), i);
        return inputImage;
    }

    @NonNull
    public static InputImage fromByteArray(@NonNull byte[] bArr, int i, int i2, int i3, @ImageFormat int i4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(ByteBuffer.wrap((byte[]) Preconditions.checkNotNull(bArr)), i, i2, i3, i4);
        zzcu.zza(i4, 2, elapsedRealtime, i2, i, bArr.length, i3);
        return inputImage;
    }

    @NonNull
    public static InputImage fromByteBuffer(@NonNull ByteBuffer byteBuffer, int i, int i2, int i3, @ImageFormat int i4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(byteBuffer, i, i2, i3, i4);
        zzcu.zza(i4, 3, elapsedRealtime, i2, i, byteBuffer.limit(), i3);
        return inputImage;
    }

    @NonNull
    public static InputImage fromFilePath(@NonNull Context context, @NonNull Uri uri) throws IOException {
        Preconditions.checkNotNull(context, "Please provide a valid Context");
        Preconditions.checkNotNull(uri, "Please provide a valid imageUri");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ImageUtils.getInstance();
        Bitmap zza = ImageUtils.zza(context.getContentResolver(), uri);
        InputImage inputImage = new InputImage(zza, 0);
        zzcu.zza(-1, 4, elapsedRealtime, -1, -1, zza.getAllocationByteCount(), 0);
        return inputImage;
    }

    @NonNull
    @RequiresApi(19)
    public static InputImage fromMediaImage(@NonNull Image image, int i) {
        InputImage inputImage;
        int limit;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Preconditions.checkNotNull(image, "Please provide a valid image");
        boolean z = true;
        Preconditions.checkArgument(i == 0 || i == 90 || i == 180 || i == 270, "Invalid rotation. Only 0, 90, 180, 270 are supported currently.");
        if (!(image.getFormat() == 256 || image.getFormat() == 35)) {
            z = false;
        }
        Preconditions.checkArgument(z, "Only JPEG and YUV_420_888 are supported now");
        Image.Plane[] planes = image.getPlanes();
        if (image.getFormat() == 256) {
            limit = image.getPlanes()[0].getBuffer().limit();
            inputImage = new InputImage(ImageConvertUtils.getInstance().convertJpegToUpRightBitmap(image, i), 0);
        } else {
            for (Image.Plane plane : planes) {
                if (plane.getBuffer() != null) {
                    plane.getBuffer().rewind();
                }
            }
            inputImage = new InputImage(planes, image.getWidth(), image.getHeight(), i);
            limit = (image.getPlanes()[0].getBuffer().limit() * 3) / 2;
        }
        zzcu.zza(image.getFormat(), 5, elapsedRealtime, image.getHeight(), image.getWidth(), limit, i);
        return inputImage;
    }

    @Nullable
    @KeepForSdk
    public Bitmap getBitmapInternal() {
        return this.a;
    }

    @Nullable
    @KeepForSdk
    public ByteBuffer getByteBuffer() {
        return this.b;
    }

    @KeepForSdk
    @ImageFormat
    public int getFormat() {
        return this.g;
    }

    @KeepForSdk
    public int getHeight() {
        return this.e;
    }

    @Nullable
    @RequiresApi(19)
    @KeepForSdk
    public Image.Plane[] getPlanes() {
        if (this.c == null) {
            return null;
        }
        return this.c.a;
    }

    @KeepForSdk
    public int getRotationDegrees() {
        return this.f;
    }

    @KeepForSdk
    public int getWidth() {
        return this.d;
    }

    public InputImage(@NonNull Image.Plane[] planeArr, int i, int i2, int i3) {
        Preconditions.checkNotNull(planeArr);
        this.c = new a(planeArr);
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = 35;
    }

    public InputImage(@NonNull Bitmap bitmap, int i) {
        this.a = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.d = bitmap.getWidth();
        this.e = bitmap.getHeight();
        this.f = i;
        this.g = -1;
    }
}
