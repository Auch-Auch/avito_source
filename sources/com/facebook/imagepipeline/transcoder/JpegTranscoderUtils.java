package com.facebook.imagepipeline.transcoder;

import android.graphics.Matrix;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;
public class JpegTranscoderUtils {
    @VisibleForTesting
    public static final int DEFAULT_JPEG_QUALITY = 85;
    public static final ImmutableList<Integer> INVERTED_EXIF_ORIENTATIONS = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    public static final int MAX_QUALITY = 100;
    public static final int MAX_SCALE_NUMERATOR = 16;
    public static final int MIN_QUALITY = 0;
    public static final int MIN_SCALE_NUMERATOR = 1;
    public static final int SCALE_DENOMINATOR = 8;

    @VisibleForTesting
    public static int calculateDownsampleNumerator(int i) {
        return Math.max(1, 8 / i);
    }

    @VisibleForTesting
    public static float determineResizeRatio(ResizeOptions resizeOptions, int i, int i2) {
        if (resizeOptions == null) {
            return 1.0f;
        }
        float f = (float) i;
        float f2 = (float) i2;
        float max = Math.max(((float) resizeOptions.width) / f, ((float) resizeOptions.height) / f2);
        float f3 = resizeOptions.maxBitmapSize;
        if (f * max > f3) {
            max = f3 / f;
        }
        return f2 * max > f3 ? f3 / f2 : max;
    }

    public static int getForceRotatedInvertedExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        int exifOrientation = encodedImage.getExifOrientation();
        ImmutableList<Integer> immutableList = INVERTED_EXIF_ORIENTATIONS;
        int indexOf = immutableList.indexOf(Integer.valueOf(exifOrientation));
        if (indexOf >= 0) {
            int i = 0;
            if (!rotationOptions.useImageMetadata()) {
                i = rotationOptions.getForcedAngle();
            }
            return immutableList.get(((i / 90) + indexOf) % immutableList.size()).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    public static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        int i = 0;
        if (!rotationOptions.rotationEnabled()) {
            return 0;
        }
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) {
            i = encodedImage.getRotationAngle();
        }
        if (rotationOptions.useImageMetadata()) {
            return i;
        }
        return (rotationOptions.getForcedAngle() + i) % 360;
    }

    public static int getSoftwareNumerator(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage, boolean z) {
        if (!z || resizeOptions == null) {
            return 8;
        }
        int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
        boolean z2 = false;
        int forceRotatedInvertedExifOrientation = INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation())) ? getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage) : 0;
        if (rotationAngle == 90 || rotationAngle == 270 || forceRotatedInvertedExifOrientation == 5 || forceRotatedInvertedExifOrientation == 7) {
            z2 = true;
        }
        int roundNumerator = roundNumerator(determineResizeRatio(resizeOptions, z2 ? encodedImage.getHeight() : encodedImage.getWidth(), z2 ? encodedImage.getWidth() : encodedImage.getHeight()), resizeOptions.roundUpFraction);
        if (roundNumerator > 8) {
            return 8;
        }
        if (roundNumerator < 1) {
            return 1;
        }
        return roundNumerator;
    }

    @Nullable
    public static Matrix getTransformationMatrix(EncodedImage encodedImage, RotationOptions rotationOptions) {
        if (INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()))) {
            int forceRotatedInvertedExifOrientation = getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage);
            Matrix matrix = new Matrix();
            if (forceRotatedInvertedExifOrientation == 2) {
                matrix.setScale(-1.0f, 1.0f);
            } else if (forceRotatedInvertedExifOrientation == 7) {
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
            } else if (forceRotatedInvertedExifOrientation == 4) {
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
            } else if (forceRotatedInvertedExifOrientation != 5) {
                return null;
            } else {
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
            }
            return matrix;
        }
        int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
        if (rotationAngle == 0) {
            return null;
        }
        Matrix matrix2 = new Matrix();
        matrix2.setRotate((float) rotationAngle);
        return matrix2;
    }

    public static boolean isExifOrientationAllowed(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static boolean isRotationAngleAllowed(int i) {
        return i >= 0 && i <= 270 && i % 90 == 0;
    }

    @VisibleForTesting
    public static int roundNumerator(float f, float f2) {
        return (int) ((f * 8.0f) + f2);
    }
}
