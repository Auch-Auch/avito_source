package com.facebook.imagepipeline.transcoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;
public class DownsampleUtil {
    public static final int DEFAULT_SAMPLE_SIZE = 1;

    @VisibleForTesting
    public static float determineDownsampleRatio(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage) {
        int i;
        Preconditions.checkArgument(EncodedImage.isMetaDataAvailable(encodedImage));
        if (resizeOptions == null || resizeOptions.height <= 0 || resizeOptions.width <= 0 || encodedImage.getWidth() == 0 || encodedImage.getHeight() == 0) {
            return 1.0f;
        }
        if (!rotationOptions.useImageMetadata()) {
            i = 0;
        } else {
            i = encodedImage.getRotationAngle();
            Preconditions.checkArgument(i == 0 || i == 90 || i == 180 || i == 270);
        }
        boolean z = i == 90 || i == 270;
        int height = z ? encodedImage.getHeight() : encodedImage.getWidth();
        int width = z ? encodedImage.getWidth() : encodedImage.getHeight();
        float f = ((float) resizeOptions.width) / ((float) height);
        float f2 = ((float) resizeOptions.height) / ((float) width);
        float max = Math.max(f, f2);
        FLog.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", Integer.valueOf(resizeOptions.width), Integer.valueOf(resizeOptions.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max));
        return max;
    }

    public static int determineSampleSize(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage, int i) {
        int i2;
        if (!EncodedImage.isMetaDataAvailable(encodedImage)) {
            return 1;
        }
        float determineDownsampleRatio = determineDownsampleRatio(rotationOptions, resizeOptions, encodedImage);
        if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
            i2 = ratioToSampleSizeJPEG(determineDownsampleRatio);
        } else {
            i2 = ratioToSampleSize(determineDownsampleRatio);
        }
        int max = Math.max(encodedImage.getHeight(), encodedImage.getWidth());
        float f = resizeOptions != null ? resizeOptions.maxBitmapSize : (float) i;
        while (((float) (max / i2)) > f) {
            i2 = encodedImage.getImageFormat() == DefaultImageFormats.JPEG ? i2 * 2 : i2 + 1;
        }
        return i2;
    }

    public static int determineSampleSizeJPEG(EncodedImage encodedImage, int i, int i2) {
        int sampleSize = encodedImage.getSampleSize();
        while ((((encodedImage.getHeight() * encodedImage.getWidth()) * i) / sampleSize) / sampleSize > i2) {
            sampleSize *= 2;
        }
        return sampleSize;
    }

    @VisibleForTesting
    public static int ratioToSampleSize(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            double d = (double) i;
            if (((1.0d / (Math.pow(d, 2.0d) - d)) * 0.3333333432674408d) + (1.0d / d) <= ((double) f)) {
                return i - 1;
            }
            i++;
        }
    }

    @VisibleForTesting
    public static int ratioToSampleSizeJPEG(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            int i2 = i * 2;
            double d = 1.0d / ((double) i2);
            if ((0.3333333432674408d * d) + d <= ((double) f)) {
                return i;
            }
            i = i2;
        }
    }

    @VisibleForTesting
    public static int roundToPowerOfTwo(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 *= 2;
        }
        return i2;
    }
}
