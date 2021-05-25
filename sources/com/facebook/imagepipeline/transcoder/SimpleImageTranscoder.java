package com.facebook.imagepipeline.transcoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.OutputStream;
import javax.annotation.Nullable;
public class SimpleImageTranscoder implements ImageTranscoder {
    public final boolean a;
    public final int b;

    public SimpleImageTranscoder(boolean z, int i) {
        this.a = z;
        this.b = i;
    }

    public static Bitmap.CompressFormat a(@Nullable ImageFormat imageFormat) {
        if (imageFormat == null) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (imageFormat == DefaultImageFormats.JPEG) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (imageFormat == DefaultImageFormats.PNG) {
            return Bitmap.CompressFormat.PNG;
        }
        if (DefaultImageFormats.isStaticWebpFormat(imageFormat)) {
            return Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canResize(EncodedImage encodedImage, @Nullable RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.autoRotate();
        }
        if (!this.a || DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.b) <= 1) {
            return false;
        }
        return true;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canTranscode(ImageFormat imageFormat) {
        return imageFormat == DefaultImageFormats.HEIF || imageFormat == DefaultImageFormats.JPEG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public String getIdentifier() {
        return "SimpleImageTranscoder";
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public ImageTranscodeResult transcode(EncodedImage encodedImage, OutputStream outputStream, @Nullable RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, @Nullable ImageFormat imageFormat, @Nullable Integer num) {
        int i;
        Bitmap bitmap;
        Throwable th;
        OutOfMemoryError e;
        Integer num2 = num == null ? 85 : num;
        RotationOptions autoRotate = rotationOptions == null ? RotationOptions.autoRotate() : rotationOptions;
        int i2 = 1;
        if (!this.a) {
            i = 1;
        } else {
            i = DownsampleUtil.determineSampleSize(autoRotate, resizeOptions, encodedImage, this.b);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
            if (decodeStream == null) {
                FLog.e("SimpleImageTranscoder", "Couldn't decode the EncodedImage InputStream ! ");
                return new ImageTranscodeResult(2);
            }
            Matrix transformationMatrix = JpegTranscoderUtils.getTransformationMatrix(encodedImage, autoRotate);
            if (transformationMatrix != null) {
                try {
                    bitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), transformationMatrix, false);
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    bitmap = decodeStream;
                    try {
                        FLog.e("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                        ImageTranscodeResult imageTranscodeResult = new ImageTranscodeResult(2);
                        bitmap.recycle();
                        decodeStream.recycle();
                        return imageTranscodeResult;
                    } catch (Throwable th2) {
                        th = th2;
                        bitmap.recycle();
                        decodeStream.recycle();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bitmap = decodeStream;
                    bitmap.recycle();
                    decodeStream.recycle();
                    throw th;
                }
            } else {
                bitmap = decodeStream;
            }
            try {
                bitmap.compress(a(imageFormat), num2.intValue(), outputStream);
                if (i > 1) {
                    i2 = 0;
                }
                ImageTranscodeResult imageTranscodeResult2 = new ImageTranscodeResult(i2);
                bitmap.recycle();
                decodeStream.recycle();
                return imageTranscodeResult2;
            } catch (OutOfMemoryError e3) {
                e = e3;
                FLog.e("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                ImageTranscodeResult imageTranscodeResult = new ImageTranscodeResult(2);
                bitmap.recycle();
                decodeStream.recycle();
                return imageTranscodeResult;
            }
        } catch (OutOfMemoryError e4) {
            FLog.e("SimpleImageTranscoder", "Out-Of-Memory during transcode", e4);
            return new ImageTranscodeResult(2);
        }
    }
}
