package com.yandex.mobile.ads.mediation.nativeads;

import android.support.annotation.NonNull;
public final class MediatedNativeAdMedia {
    private final float a;

    public static final class Builder {
        private final float a;

        public Builder(float f) {
            this.a = f;
        }

        @NonNull
        public final MediatedNativeAdMedia build() {
            return new MediatedNativeAdMedia(this);
        }
    }

    public final float getAspectRatio() {
        return this.a;
    }

    private MediatedNativeAdMedia(@NonNull Builder builder) {
        this.a = builder.a;
    }
}
