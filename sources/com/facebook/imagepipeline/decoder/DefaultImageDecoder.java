package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import java.util.Map;
import javax.annotation.Nullable;
public class DefaultImageDecoder implements ImageDecoder {
    public final ImageDecoder a;
    public final ImageDecoder b;
    public final PlatformDecoder c;
    public final ImageDecoder d;
    @Nullable
    public final Map<ImageFormat, ImageDecoder> e;

    public class a implements ImageDecoder {
        public a() {
        }

        @Override // com.facebook.imagepipeline.decoder.ImageDecoder
        public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            ImageFormat imageFormat = encodedImage.getImageFormat();
            if (imageFormat == DefaultImageFormats.JPEG) {
                return DefaultImageDecoder.this.decodeJpeg(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
            if (imageFormat == DefaultImageFormats.GIF) {
                return DefaultImageDecoder.this.decodeGif(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
            if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                return DefaultImageDecoder.this.decodeAnimatedWebp(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
            if (imageFormat != ImageFormat.UNKNOWN) {
                return DefaultImageDecoder.this.decodeStaticImage(encodedImage, imageDecodeOptions);
            }
            throw new DecodeException("unknown image format", encodedImage);
        }
    }

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder) {
        this(imageDecoder, imageDecoder2, platformDecoder, null);
    }

    public final void a(@Nullable BitmapTransformation bitmapTransformation, CloseableReference<Bitmap> closeableReference) {
        if (bitmapTransformation != null) {
            Bitmap bitmap = closeableReference.get();
            if (bitmapTransformation.modifiesTransparency()) {
                bitmap.setHasAlpha(true);
            }
            bitmapTransformation.transform(bitmap);
        }
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        ImageDecoder imageDecoder2 = imageDecodeOptions.customImageDecoder;
        if (imageDecoder2 != null) {
            return imageDecoder2.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        ImageFormat imageFormat = encodedImage.getImageFormat();
        if (imageFormat == null || imageFormat == ImageFormat.UNKNOWN) {
            imageFormat = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
            encodedImage.setImageFormat(imageFormat);
        }
        Map<ImageFormat, ImageDecoder> map = this.e;
        if (map == null || (imageDecoder = map.get(imageFormat)) == null) {
            return this.d.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    public CloseableImage decodeAnimatedWebp(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        return this.b.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    public CloseableImage decodeGif(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        if (encodedImage.getWidth() == -1 || encodedImage.getHeight() == -1) {
            throw new DecodeException("image width or height is incorrect", encodedImage);
        } else if (imageDecodeOptions.forceStaticImage || (imageDecoder = this.a) == null) {
            return decodeStaticImage(encodedImage, imageDecodeOptions);
        } else {
            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
    }

    public CloseableStaticBitmap decodeJpeg(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace = this.c.decodeJPEGFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, i, imageDecodeOptions.colorSpace);
        try {
            a(imageDecodeOptions.bitmapTransformation, decodeJPEGFromEncodedImageWithColorSpace);
            return new CloseableStaticBitmap(decodeJPEGFromEncodedImageWithColorSpace, qualityInfo, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
        } finally {
            decodeJPEGFromEncodedImageWithColorSpace.close();
        }
    }

    public CloseableStaticBitmap decodeStaticImage(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace = this.c.decodeFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, imageDecodeOptions.colorSpace);
        try {
            a(imageDecodeOptions.bitmapTransformation, decodeFromEncodedImageWithColorSpace);
            return new CloseableStaticBitmap(decodeFromEncodedImageWithColorSpace, ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
        } finally {
            decodeFromEncodedImageWithColorSpace.close();
        }
    }

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder, @Nullable Map<ImageFormat, ImageDecoder> map) {
        this.d = new a();
        this.a = imageDecoder;
        this.b = imageDecoder2;
        this.c = platformDecoder;
        this.e = map;
    }
}
