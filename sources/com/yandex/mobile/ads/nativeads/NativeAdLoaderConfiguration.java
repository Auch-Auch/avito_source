package com.yandex.mobile.ads.nativeads;

import java.util.Arrays;
public final class NativeAdLoaderConfiguration {
    public static final String NATIVE_IMAGE_SIZE_LARGE = "large";
    public static final String NATIVE_IMAGE_SIZE_MEDIUM = "medium";
    public static final String NATIVE_IMAGE_SIZE_SMALL = "small";
    private final String a;
    private final String[] b;
    private final boolean c;

    public static final class Builder {
        private final String a;
        private final boolean b;
        private String[] c = {"small", "medium", "large"};

        public Builder(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public final NativeAdLoaderConfiguration build() {
            return new NativeAdLoaderConfiguration(this, (byte) 0);
        }

        public final Builder setImageSizes(String... strArr) {
            if (!(strArr == null || strArr.length == 0 || Arrays.asList(strArr).contains(null))) {
                this.c = strArr;
            }
            return this;
        }
    }

    public /* synthetic */ NativeAdLoaderConfiguration(Builder builder, byte b2) {
        this(builder);
    }

    public final String getBlockId() {
        return this.a;
    }

    public final String[] getImageSizes() {
        return this.b;
    }

    public final boolean shouldLoadImagesAutomatically() {
        return this.c;
    }

    private NativeAdLoaderConfiguration(Builder builder) {
        this.a = builder.a;
        this.b = builder.c;
        this.c = builder.b;
    }
}
