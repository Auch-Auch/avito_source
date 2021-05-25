package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import com.facebook.imagepipeline.nativecode.NativeImageTranscoderFactory;
import javax.annotation.Nullable;
public class MultiImageTranscoderFactory implements ImageTranscoderFactory {
    public final int a;
    public final boolean b;
    @Nullable
    public final ImageTranscoderFactory c;
    @Nullable
    public final Integer d;
    public final boolean e;

    public MultiImageTranscoderFactory(int i, boolean z, @Nullable ImageTranscoderFactory imageTranscoderFactory, @Nullable Integer num, boolean z2) {
        this.a = i;
        this.b = z;
        this.c = imageTranscoderFactory;
        this.d = num;
        this.e = z2;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z) {
        ImageTranscoder imageTranscoder;
        ImageTranscoderFactory imageTranscoderFactory = this.c;
        ImageTranscoder imageTranscoder2 = null;
        if (imageTranscoderFactory == null) {
            imageTranscoder = null;
        } else {
            imageTranscoder = imageTranscoderFactory.createImageTranscoder(imageFormat, z);
        }
        if (imageTranscoder == null) {
            Integer num = this.d;
            if (num != null) {
                int intValue = num.intValue();
                if (intValue == 0) {
                    imageTranscoder2 = NativeImageTranscoderFactory.getNativeImageTranscoderFactory(this.a, this.b, this.e).createImageTranscoder(imageFormat, z);
                } else if (intValue == 1) {
                    imageTranscoder2 = new SimpleImageTranscoderFactory(this.a).createImageTranscoder(imageFormat, z);
                } else {
                    throw new IllegalArgumentException("Invalid ImageTranscoderType");
                }
            }
            imageTranscoder = imageTranscoder2;
        }
        if (imageTranscoder == null && NativeCodeSetup.getUseNativeCode()) {
            imageTranscoder = NativeImageTranscoderFactory.getNativeImageTranscoderFactory(this.a, this.b, this.e).createImageTranscoder(imageFormat, z);
        }
        return imageTranscoder == null ? new SimpleImageTranscoderFactory(this.a).createImageTranscoder(imageFormat, z) : imageTranscoder;
    }
}
