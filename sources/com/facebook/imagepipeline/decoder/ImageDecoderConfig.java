package com.facebook.imagepipeline.decoder;

import com.facebook.imageformat.ImageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ImageDecoderConfig {
    public final Map<ImageFormat, ImageDecoder> a;
    public final List<ImageFormat.FormatChecker> b;

    public static class Builder {
        public Map<ImageFormat, ImageDecoder> a;
        public List<ImageFormat.FormatChecker> b;

        public Builder addDecodingCapability(ImageFormat imageFormat, ImageFormat.FormatChecker formatChecker, ImageDecoder imageDecoder) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(formatChecker);
            overrideDecoder(imageFormat, imageDecoder);
            return this;
        }

        public ImageDecoderConfig build() {
            return new ImageDecoderConfig(this, null);
        }

        public Builder overrideDecoder(ImageFormat imageFormat, ImageDecoder imageDecoder) {
            if (this.a == null) {
                this.a = new HashMap();
            }
            this.a.put(imageFormat, imageDecoder);
            return this;
        }
    }

    public ImageDecoderConfig(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = builder.b;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Map<ImageFormat, ImageDecoder> getCustomImageDecoders() {
        return this.a;
    }

    public List<ImageFormat.FormatChecker> getCustomImageFormats() {
        return this.b;
    }
}
