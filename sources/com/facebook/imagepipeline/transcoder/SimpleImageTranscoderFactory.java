package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
public class SimpleImageTranscoderFactory implements ImageTranscoderFactory {
    public final int a;

    public SimpleImageTranscoderFactory(int i) {
        this.a = i;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z) {
        return new SimpleImageTranscoder(z, this.a);
    }
}
