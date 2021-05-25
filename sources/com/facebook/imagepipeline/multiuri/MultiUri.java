package com.facebook.imagepipeline.multiuri;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
public class MultiUri {
    @Nullable
    public ImageRequest a;
    @Nullable
    public ImageRequest[] b;
    @Nullable
    public ImageRequest c;

    public static class Builder {
        @Nullable
        public ImageRequest a;
        @Nullable
        public ImageRequest b;
        @Nullable
        public ImageRequest[] c;

        public Builder() {
        }

        public MultiUri build() {
            return new MultiUri(this, null);
        }

        public Builder setHighResImageRequest(@Nullable ImageRequest imageRequest) {
            this.b = imageRequest;
            return this;
        }

        public Builder setImageRequests(@Nullable ImageRequest... imageRequestArr) {
            this.c = imageRequestArr;
            return this;
        }

        public Builder setLowResImageRequest(@Nullable ImageRequest imageRequest) {
            this.a = imageRequest;
            return this;
        }

        public Builder(a aVar) {
        }
    }

    public MultiUri(Builder builder, a aVar) {
        this.a = builder.a;
        this.c = builder.b;
        this.b = builder.c;
    }

    public static Builder create() {
        return new Builder(null);
    }

    @Nullable
    public ImageRequest getHighResImageRequest() {
        return this.c;
    }

    @Nullable
    public ImageRequest getLowResImageRequest() {
        return this.a;
    }

    @Nullable
    public ImageRequest[] getMultiImageRequests() {
        return this.b;
    }
}
