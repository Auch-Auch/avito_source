package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.EncodedImage;
public class DecodeException extends RuntimeException {
    public final EncodedImage a;

    public DecodeException(String str, EncodedImage encodedImage) {
        super(str);
        this.a = encodedImage;
    }

    public EncodedImage getEncodedImage() {
        return this.a;
    }

    public DecodeException(String str, Throwable th, EncodedImage encodedImage) {
        super(str, th);
        this.a = encodedImage;
    }
}
