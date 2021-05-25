package com.yandex.mobile.ads.mediation.nativeads;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class MediatedNativeAdImage {
    private final int a;
    private final int b;
    @NonNull
    private final String c;
    @Nullable
    private final Drawable d;

    public static final class Builder {
        private int a;
        private int b;
        @NonNull
        private final String c;
        @Nullable
        private Drawable d;

        public Builder(@NonNull String str) {
            this.c = str;
        }

        @NonNull
        public final MediatedNativeAdImage build() {
            return new MediatedNativeAdImage(this);
        }

        @NonNull
        public final Builder setDrawable(@Nullable Drawable drawable) {
            this.d = drawable;
            return this;
        }

        @NonNull
        public final Builder setHeight(int i) {
            this.b = i;
            return this;
        }

        @NonNull
        public final Builder setWidth(int i) {
            this.a = i;
            return this;
        }
    }

    @Nullable
    public final Drawable getDrawable() {
        return this.d;
    }

    public final int getHeight() {
        return this.b;
    }

    @NonNull
    public final String getUrl() {
        return this.c;
    }

    public final int getWidth() {
        return this.a;
    }

    private MediatedNativeAdImage(@NonNull Builder builder) {
        this.c = builder.c;
        this.a = builder.a;
        this.b = builder.b;
        this.d = builder.d;
    }
}
