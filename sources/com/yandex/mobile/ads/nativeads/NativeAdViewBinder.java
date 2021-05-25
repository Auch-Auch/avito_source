package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public final class NativeAdViewBinder {
    @NonNull
    private final View a;
    @Nullable
    private final TextView b;
    @Nullable
    private final TextView c;
    @Nullable
    private final Button d;
    @Nullable
    private final TextView e;
    @Nullable
    private final ImageView f;
    @Nullable
    private final Button g;
    @Nullable
    private final ImageView h;
    @Nullable
    private final ImageView i;
    @Nullable
    private final MediaView j;
    @Nullable
    private final TextView k;
    @Nullable
    private final View l;
    @Nullable
    private final TextView m;
    @Nullable
    private final TextView n;
    @Nullable
    private final TextView o;
    @Nullable
    private final TextView p;

    @Nullable
    public final TextView getAgeView() {
        return this.b;
    }

    @Nullable
    public final TextView getBodyView() {
        return this.c;
    }

    @Nullable
    public final Button getCallToActionView() {
        return this.d;
    }

    @Nullable
    public final TextView getDomainView() {
        return this.e;
    }

    @Nullable
    public final ImageView getFaviconView() {
        return this.f;
    }

    @Nullable
    public final Button getFeedbackView() {
        return this.g;
    }

    @Nullable
    public final ImageView getIconView() {
        return this.h;
    }

    @Nullable
    public final ImageView getImageView() {
        return this.i;
    }

    @Nullable
    public final MediaView getMediaView() {
        return this.j;
    }

    @NonNull
    public final View getNativeAdView() {
        return this.a;
    }

    @Nullable
    public final TextView getPriceView() {
        return this.k;
    }

    @Nullable
    public final View getRatingView() {
        return this.l;
    }

    @Nullable
    public final TextView getReviewCountView() {
        return this.m;
    }

    @Nullable
    public final TextView getSponsoredView() {
        return this.n;
    }

    @Nullable
    public final TextView getTitleView() {
        return this.o;
    }

    @Nullable
    public final TextView getWarningView() {
        return this.p;
    }

    public static final class Builder {
        @NonNull
        private final View a;
        @Nullable
        private TextView b;
        @Nullable
        private TextView c;
        @Nullable
        private Button d;
        @Nullable
        private TextView e;
        @Nullable
        private ImageView f;
        @Nullable
        private Button g;
        @Nullable
        private ImageView h;
        @Nullable
        private ImageView i;
        @Nullable
        private MediaView j;
        @Nullable
        private TextView k;
        @Nullable
        private View l;
        @Nullable
        private TextView m;
        @Nullable
        private TextView n;
        @Nullable
        private TextView o;
        @Nullable
        private TextView p;

        @Deprecated
        public Builder(@NonNull View view) {
            this.a = view;
        }

        @NonNull
        public final NativeAdViewBinder build() {
            return new NativeAdViewBinder(this);
        }

        @NonNull
        public final Builder setAgeView(@Nullable TextView textView) {
            this.b = textView;
            return this;
        }

        @NonNull
        public final Builder setBodyView(@Nullable TextView textView) {
            this.c = textView;
            return this;
        }

        @NonNull
        public final Builder setCallToActionView(@Nullable Button button) {
            this.d = button;
            return this;
        }

        @NonNull
        public final Builder setDomainView(@Nullable TextView textView) {
            this.e = textView;
            return this;
        }

        @NonNull
        public final Builder setFaviconView(@Nullable ImageView imageView) {
            this.f = imageView;
            return this;
        }

        @NonNull
        public final Builder setFeedbackView(@Nullable Button button) {
            this.g = button;
            return this;
        }

        @NonNull
        public final Builder setIconView(@Nullable ImageView imageView) {
            this.h = imageView;
            return this;
        }

        @NonNull
        public final Builder setImageView(@Nullable ImageView imageView) {
            this.i = imageView;
            return this;
        }

        @NonNull
        public final Builder setMediaView(@Nullable MediaView mediaView) {
            this.j = mediaView;
            return this;
        }

        @NonNull
        public final Builder setPriceView(@Nullable TextView textView) {
            this.k = textView;
            return this;
        }

        @NonNull
        public final <T extends View & Rating> Builder setRatingView(@Nullable T t) {
            this.l = t;
            return this;
        }

        @NonNull
        public final Builder setReviewCountView(@Nullable TextView textView) {
            this.m = textView;
            return this;
        }

        @NonNull
        public final Builder setSponsoredView(@Nullable TextView textView) {
            this.n = textView;
            return this;
        }

        @NonNull
        public final Builder setTitleView(@Nullable TextView textView) {
            this.o = textView;
            return this;
        }

        @NonNull
        public final Builder setWarningView(@Nullable TextView textView) {
            this.p = textView;
            return this;
        }

        public Builder(@NonNull NativeAdView nativeAdView) {
            this.a = nativeAdView;
        }
    }

    private NativeAdViewBinder(@NonNull Builder builder) {
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
        this.o = builder.o;
        this.p = builder.p;
    }
}
