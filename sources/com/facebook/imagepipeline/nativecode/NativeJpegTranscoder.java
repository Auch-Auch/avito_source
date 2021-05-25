package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.transcoder.DownsampleUtil;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
@DoNotStrip
public class NativeJpegTranscoder implements ImageTranscoder {
    public static final String TAG = "NativeJpegTranscoder";
    public boolean a;
    public int b;
    public boolean c;

    public NativeJpegTranscoder(boolean z, int i, boolean z2, boolean z3) {
        this.a = z;
        this.b = i;
        this.c = z2;
        if (z3) {
            NativeJpegTranscoderSoLoader.ensure();
        }
    }

    @DoNotStrip
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @DoNotStrip
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @VisibleForTesting
    public static void transcodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        NativeJpegTranscoderSoLoader.ensure();
        boolean z = false;
        Preconditions.checkArgument(i2 >= 1);
        Preconditions.checkArgument(i2 <= 16);
        Preconditions.checkArgument(i3 >= 0);
        Preconditions.checkArgument(i3 <= 100);
        Preconditions.checkArgument(JpegTranscoderUtils.isRotationAngleAllowed(i));
        if (!(i2 == 8 && i == 0)) {
            z = true;
        }
        Preconditions.checkArgument(z, "no transformation requested");
        nativeTranscodeJpeg((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i, i2, i3);
    }

    @VisibleForTesting
    public static void transcodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        NativeJpegTranscoderSoLoader.ensure();
        boolean z = false;
        Preconditions.checkArgument(i2 >= 1);
        Preconditions.checkArgument(i2 <= 16);
        Preconditions.checkArgument(i3 >= 0);
        Preconditions.checkArgument(i3 <= 100);
        Preconditions.checkArgument(JpegTranscoderUtils.isExifOrientationAllowed(i));
        if (!(i2 == 8 && i == 1)) {
            z = true;
        }
        Preconditions.checkArgument(z, "no transformation requested");
        nativeTranscodeJpegWithExifOrientation((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i, i2, i3);
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canResize(EncodedImage encodedImage, @Nullable RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.autoRotate();
        }
        return JpegTranscoderUtils.getSoftwareNumerator(rotationOptions, resizeOptions, encodedImage, this.a) < 8;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canTranscode(ImageFormat imageFormat) {
        return imageFormat == DefaultImageFormats.JPEG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public String getIdentifier() {
        return TAG;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public ImageTranscodeResult transcode(EncodedImage encodedImage, OutputStream outputStream, @Nullable RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, @Nullable ImageFormat imageFormat, @Nullable Integer num) throws IOException {
        if (num == null) {
            num = 85;
        }
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.autoRotate();
        }
        int determineSampleSize = DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.b);
        try {
            int softwareNumerator = JpegTranscoderUtils.getSoftwareNumerator(rotationOptions, resizeOptions, encodedImage, this.a);
            int calculateDownsampleNumerator = JpegTranscoderUtils.calculateDownsampleNumerator(determineSampleSize);
            if (this.c) {
                softwareNumerator = calculateDownsampleNumerator;
            }
            InputStream inputStream = encodedImage.getInputStream();
            if (JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()))) {
                transcodeJpegWithExifOrientation(inputStream, outputStream, JpegTranscoderUtils.getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage), softwareNumerator, num.intValue());
            } else {
                transcodeJpeg(inputStream, outputStream, JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage), softwareNumerator, num.intValue());
            }
            Closeables.closeQuietly(inputStream);
            int i = 1;
            if (determineSampleSize != 1) {
                i = 0;
            }
            return new ImageTranscodeResult(i);
        } catch (Throwable th) {
            Closeables.closeQuietly((InputStream) null);
            throw th;
        }
    }
}
