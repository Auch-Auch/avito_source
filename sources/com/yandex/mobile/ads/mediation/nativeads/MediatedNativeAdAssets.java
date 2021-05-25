package com.yandex.mobile.ads.mediation.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class MediatedNativeAdAssets {
    @Nullable
    private final String a;
    @Nullable
    private final String b;
    @Nullable
    private final String c;
    @Nullable
    private final String d;
    @Nullable
    private final MediatedNativeAdImage e;
    @Nullable
    private final MediatedNativeAdImage f;
    @Nullable
    private final MediatedNativeAdImage g;
    @Nullable
    private final MediatedNativeAdMedia h;
    @Nullable
    private final String i;
    @Nullable
    private final String j;
    @Nullable
    private final String k;
    @Nullable
    private final String l;
    @Nullable
    private final String m;
    @Nullable
    private final String n;

    public static final class Builder {
        @Nullable
        private String a;
        @Nullable
        private String b;
        @Nullable
        private String c;
        @Nullable
        private String d;
        @Nullable
        private MediatedNativeAdImage e;
        @Nullable
        private MediatedNativeAdImage f;
        @Nullable
        private MediatedNativeAdImage g;
        @Nullable
        private MediatedNativeAdMedia h;
        @Nullable
        private String i;
        @Nullable
        private String j;
        @Nullable
        private String k;
        @Nullable
        private String l;
        @Nullable
        private String m;
        @Nullable
        private String n;

        @NonNull
        public final MediatedNativeAdAssets build() {
            return new MediatedNativeAdAssets(this);
        }

        @NonNull
        public final Builder setAge(@Nullable String str) {
            this.a = str;
            return this;
        }

        @NonNull
        public final Builder setBody(@Nullable String str) {
            this.b = str;
            return this;
        }

        @NonNull
        public final Builder setCallToAction(@Nullable String str) {
            this.c = str;
            return this;
        }

        @NonNull
        public final Builder setDomain(@Nullable String str) {
            this.d = str;
            return this;
        }

        @NonNull
        public final Builder setFavicon(@Nullable MediatedNativeAdImage mediatedNativeAdImage) {
            this.e = mediatedNativeAdImage;
            return this;
        }

        @NonNull
        public final Builder setIcon(@Nullable MediatedNativeAdImage mediatedNativeAdImage) {
            this.f = mediatedNativeAdImage;
            return this;
        }

        @NonNull
        public final Builder setImage(@Nullable MediatedNativeAdImage mediatedNativeAdImage) {
            this.g = mediatedNativeAdImage;
            return this;
        }

        @NonNull
        public final Builder setMedia(@Nullable MediatedNativeAdMedia mediatedNativeAdMedia) {
            this.h = mediatedNativeAdMedia;
            return this;
        }

        @NonNull
        public final Builder setPrice(@Nullable String str) {
            this.i = str;
            return this;
        }

        @NonNull
        public final Builder setRating(@Nullable String str) {
            this.j = str;
            return this;
        }

        @NonNull
        public final Builder setReviewCount(@Nullable String str) {
            this.k = str;
            return this;
        }

        @NonNull
        public final Builder setSponsored(@Nullable String str) {
            this.l = str;
            return this;
        }

        @NonNull
        public final Builder setTitle(@Nullable String str) {
            this.m = str;
            return this;
        }

        @NonNull
        public final Builder setWarning(@Nullable String str) {
            this.n = str;
            return this;
        }
    }

    @Nullable
    public final String getAge() {
        return this.a;
    }

    @Nullable
    public final String getBody() {
        return this.b;
    }

    @Nullable
    public final String getCallToAction() {
        return this.c;
    }

    @Nullable
    public final String getDomain() {
        return this.d;
    }

    @Nullable
    public final MediatedNativeAdImage getFavicon() {
        return this.e;
    }

    @Nullable
    public final MediatedNativeAdImage getIcon() {
        return this.f;
    }

    @Nullable
    public final MediatedNativeAdImage getImage() {
        return this.g;
    }

    @Nullable
    public final MediatedNativeAdMedia getMedia() {
        return this.h;
    }

    @Nullable
    public final String getPrice() {
        return this.i;
    }

    @Nullable
    public final String getRating() {
        return this.j;
    }

    @Nullable
    public final String getReviewCount() {
        return this.k;
    }

    @Nullable
    public final String getSponsored() {
        return this.l;
    }

    @Nullable
    public final String getTitle() {
        return this.m;
    }

    @Nullable
    public final String getWarning() {
        return this.n;
    }

    private MediatedNativeAdAssets(@NonNull Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.n = builder.n;
    }
}
