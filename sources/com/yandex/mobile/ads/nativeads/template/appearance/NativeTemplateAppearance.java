package com.yandex.mobile.ads.nativeads.template.appearance;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import com.yandex.mobile.ads.impl.eg;
import com.yandex.mobile.ads.nativeads.template.HorizontalOffset;
import com.yandex.mobile.ads.nativeads.template.SizeConstraint;
import com.yandex.mobile.ads.nativeads.template.appearance.BannerAppearance;
import com.yandex.mobile.ads.nativeads.template.appearance.ButtonAppearance;
import com.yandex.mobile.ads.nativeads.template.appearance.ImageAppearance;
import com.yandex.mobile.ads.nativeads.template.appearance.RatingAppearance;
import com.yandex.mobile.ads.nativeads.template.appearance.TextAppearance;
public final class NativeTemplateAppearance implements Parcelable {
    public static final Parcelable.Creator<NativeTemplateAppearance> CREATOR = new Parcelable.Creator<NativeTemplateAppearance>() { // from class: com.yandex.mobile.ads.nativeads.template.appearance.NativeTemplateAppearance.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ NativeTemplateAppearance createFromParcel(Parcel parcel) {
            return new NativeTemplateAppearance(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ NativeTemplateAppearance[] newArray(int i2) {
            return new NativeTemplateAppearance[i2];
        }
    };
    @VisibleForTesting
    public static final int a = Color.parseColor("#7f7f7f");
    public static final int b = Color.parseColor("#ffd200");
    public static final int c = Color.parseColor("#ffd200");
    public static final int d = Color.parseColor("#f4c900");
    private final BannerAppearance e;
    private final TextAppearance f;
    private final TextAppearance g;
    private final TextAppearance h;
    private final TextAppearance i;
    private final TextAppearance j;
    private final TextAppearance k;
    private final TextAppearance l;
    private final ImageAppearance m;
    private final ImageAppearance n;
    private final ButtonAppearance o;
    private final RatingAppearance p;

    public static final class Builder {
        private BannerAppearance a = new BannerAppearance.Builder().setBackgroundColor(-1).setBorderColor(eg.a((int) ViewCompat.MEASURED_STATE_MASK, 90.0f)).setBorderWidth(1.0f).setContentPadding(new HorizontalOffset(10.0f, 10.0f)).setImageMargins(new HorizontalOffset(0.0f, 10.0f)).build();
        private TextAppearance b;
        private TextAppearance c;
        private TextAppearance d;
        private TextAppearance e;
        private TextAppearance f;
        private TextAppearance g;
        private TextAppearance h;
        private ImageAppearance i = new ImageAppearance.Builder().setWidthConstraint(new SizeConstraint(SizeConstraint.SizeConstraintType.PREFERRED_RATIO, 0.3f)).build();
        private ImageAppearance j = new ImageAppearance.Builder().setWidthConstraint(new SizeConstraint(SizeConstraint.SizeConstraintType.FIXED, 16.0f)).build();
        private ButtonAppearance k = new ButtonAppearance.Builder().setBorderColor(NativeTemplateAppearance.b).setBorderWidth(1.0f).setNormalColor(-1).setPressedColor(NativeTemplateAppearance.c).setTextAppearance(new TextAppearance.Builder().setTextColor(ViewCompat.MEASURED_STATE_MASK).setTextSize(13.0f).setFontFamilyName(null).setFontStyle(0).build()).build();
        private RatingAppearance l = new RatingAppearance.Builder().setBackgroundStarColor(-3355444).setProgressStarColor(NativeTemplateAppearance.d).build();

        public Builder() {
            TextAppearance.Builder builder = new TextAppearance.Builder();
            int i2 = NativeTemplateAppearance.a;
            this.b = builder.setTextColor(i2).setTextSize(15.0f).setFontFamilyName(null).setFontStyle(0).build();
            this.c = new TextAppearance.Builder().setTextColor(ViewCompat.MEASURED_STATE_MASK).setTextSize(13.0f).setFontFamilyName(null).setFontStyle(0).build();
            this.d = new TextAppearance.Builder().setTextColor(i2).setTextSize(13.0f).setFontFamilyName(null).setFontStyle(0).build();
            this.e = new TextAppearance.Builder().setTextColor(i2).setTextSize(13.0f).setFontFamilyName(null).setFontStyle(0).build();
            this.f = new TextAppearance.Builder().setTextColor(i2).setTextSize(11.0f).setFontFamilyName(null).setFontStyle(0).build();
            this.g = new TextAppearance.Builder().setTextColor(ViewCompat.MEASURED_STATE_MASK).setTextSize(15.0f).setFontFamilyName(null).setFontStyle(1).build();
            this.h = new TextAppearance.Builder().setTextColor(i2).setTextSize(13.0f).setFontFamilyName(null).setFontStyle(0).build();
        }

        public final NativeTemplateAppearance build() {
            return new NativeTemplateAppearance(this, (byte) 0);
        }

        public final Builder withAgeAppearance(TextAppearance textAppearance) {
            this.b = a.a(this.b, textAppearance);
            return this;
        }

        public final Builder withBannerAppearance(BannerAppearance bannerAppearance) {
            BannerAppearance bannerAppearance2 = this.a;
            if (bannerAppearance != null && !bannerAppearance2.equals(bannerAppearance)) {
                int backgroundColor = bannerAppearance.getBackgroundColor();
                int borderColor = bannerAppearance.getBorderColor();
                float borderWidth = bannerAppearance.getBorderWidth();
                HorizontalOffset imageMargins = bannerAppearance.getImageMargins();
                BannerAppearance.Builder builder = new BannerAppearance.Builder();
                if (backgroundColor == 0) {
                    backgroundColor = bannerAppearance2.getBackgroundColor();
                }
                BannerAppearance.Builder backgroundColor2 = builder.setBackgroundColor(backgroundColor);
                if (borderColor == 0) {
                    borderColor = bannerAppearance2.getBorderColor();
                }
                BannerAppearance.Builder borderColor2 = backgroundColor2.setBorderColor(borderColor);
                float f2 = 0.0f;
                if (borderWidth < 0.0f) {
                    borderWidth = bannerAppearance2.getBorderWidth();
                }
                BannerAppearance.Builder borderWidth2 = borderColor2.setBorderWidth(borderWidth);
                HorizontalOffset contentPadding = bannerAppearance2.getContentPadding();
                HorizontalOffset contentPadding2 = bannerAppearance.getContentPadding();
                if (contentPadding2 != null && !contentPadding.equals(contentPadding2)) {
                    float left = contentPadding2.getLeft() >= 0.0f ? contentPadding2.getLeft() : 0.0f;
                    if (contentPadding2.getRight() >= 0.0f) {
                        f2 = contentPadding2.getRight();
                    }
                    contentPadding = new HorizontalOffset(left, f2);
                }
                BannerAppearance.Builder contentPadding3 = borderWidth2.setContentPadding(contentPadding);
                if (imageMargins == null) {
                    imageMargins = bannerAppearance2.getImageMargins();
                }
                bannerAppearance2 = contentPadding3.setImageMargins(imageMargins).build();
            }
            this.a = bannerAppearance2;
            return this;
        }

        public final Builder withBodyAppearance(TextAppearance textAppearance) {
            this.c = a.a(this.c, textAppearance);
            return this;
        }

        public final Builder withCallToActionAppearance(ButtonAppearance buttonAppearance) {
            ButtonAppearance buttonAppearance2 = this.k;
            if (buttonAppearance != null && !buttonAppearance2.equals(buttonAppearance)) {
                TextAppearance a3 = a.a(buttonAppearance2.getTextAppearance(), buttonAppearance.getTextAppearance());
                int borderColor = buttonAppearance.getBorderColor();
                float borderWidth = buttonAppearance.getBorderWidth();
                int normalColor = buttonAppearance.getNormalColor();
                int pressedColor = buttonAppearance.getPressedColor();
                ButtonAppearance.Builder textAppearance = new ButtonAppearance.Builder().setTextAppearance(a3);
                if (borderColor == 0) {
                    borderColor = buttonAppearance2.getBorderColor();
                }
                ButtonAppearance.Builder borderColor2 = textAppearance.setBorderColor(borderColor);
                if (borderWidth < 0.0f) {
                    borderWidth = buttonAppearance2.getBorderWidth();
                }
                ButtonAppearance.Builder borderWidth2 = borderColor2.setBorderWidth(borderWidth);
                if (normalColor == 0) {
                    normalColor = buttonAppearance2.getNormalColor();
                }
                ButtonAppearance.Builder normalColor2 = borderWidth2.setNormalColor(normalColor);
                if (pressedColor == 0) {
                    pressedColor = buttonAppearance2.getPressedColor();
                }
                buttonAppearance2 = normalColor2.setPressedColor(pressedColor).build();
            }
            this.k = buttonAppearance2;
            return this;
        }

        public final Builder withDomainAppearance(TextAppearance textAppearance) {
            this.d = a.a(this.d, textAppearance);
            return this;
        }

        public final Builder withFaviconAppearance(ImageAppearance imageAppearance) {
            this.j = a.a(this.j, imageAppearance);
            return this;
        }

        public final Builder withImageAppearance(ImageAppearance imageAppearance) {
            this.i = a.a(this.i, imageAppearance);
            return this;
        }

        public final Builder withRatingAppearance(RatingAppearance ratingAppearance) {
            RatingAppearance ratingAppearance2 = this.l;
            if (ratingAppearance != null && !ratingAppearance2.equals(ratingAppearance)) {
                int backgroundStarColor = ratingAppearance.getBackgroundStarColor();
                int progressStarColor = ratingAppearance.getProgressStarColor();
                RatingAppearance.Builder builder = new RatingAppearance.Builder();
                if (backgroundStarColor == 0) {
                    backgroundStarColor = ratingAppearance2.getBackgroundStarColor();
                }
                RatingAppearance.Builder backgroundStarColor2 = builder.setBackgroundStarColor(backgroundStarColor);
                if (progressStarColor == 0) {
                    progressStarColor = ratingAppearance2.getProgressStarColor();
                }
                ratingAppearance2 = backgroundStarColor2.setProgressStarColor(progressStarColor).build();
            }
            this.l = ratingAppearance2;
            return this;
        }

        public final Builder withReviewCountAppearance(TextAppearance textAppearance) {
            this.e = a.a(this.e, textAppearance);
            return this;
        }

        public final Builder withSponsoredAppearance(TextAppearance textAppearance) {
            this.f = a.a(this.f, textAppearance);
            return this;
        }

        public final Builder withTitleAppearance(TextAppearance textAppearance) {
            this.g = a.a(this.g, textAppearance);
            return this;
        }

        public final Builder withWarningAppearance(TextAppearance textAppearance) {
            this.h = a.a(this.h, textAppearance);
            return this;
        }
    }

    public /* synthetic */ NativeTemplateAppearance(Builder builder, byte b2) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && NativeTemplateAppearance.class == obj.getClass()) {
            NativeTemplateAppearance nativeTemplateAppearance = (NativeTemplateAppearance) obj;
            BannerAppearance bannerAppearance = this.e;
            if (bannerAppearance == null ? nativeTemplateAppearance.e != null : !bannerAppearance.equals(nativeTemplateAppearance.e)) {
                return false;
            }
            TextAppearance textAppearance = this.f;
            if (textAppearance == null ? nativeTemplateAppearance.f != null : !textAppearance.equals(nativeTemplateAppearance.f)) {
                return false;
            }
            TextAppearance textAppearance2 = this.g;
            if (textAppearance2 == null ? nativeTemplateAppearance.g != null : !textAppearance2.equals(nativeTemplateAppearance.g)) {
                return false;
            }
            TextAppearance textAppearance3 = this.h;
            if (textAppearance3 == null ? nativeTemplateAppearance.h != null : !textAppearance3.equals(nativeTemplateAppearance.h)) {
                return false;
            }
            TextAppearance textAppearance4 = this.i;
            if (textAppearance4 == null ? nativeTemplateAppearance.i != null : !textAppearance4.equals(nativeTemplateAppearance.i)) {
                return false;
            }
            TextAppearance textAppearance5 = this.j;
            if (textAppearance5 == null ? nativeTemplateAppearance.j != null : !textAppearance5.equals(nativeTemplateAppearance.j)) {
                return false;
            }
            TextAppearance textAppearance6 = this.k;
            if (textAppearance6 == null ? nativeTemplateAppearance.k != null : !textAppearance6.equals(nativeTemplateAppearance.k)) {
                return false;
            }
            TextAppearance textAppearance7 = this.l;
            if (textAppearance7 == null ? nativeTemplateAppearance.l != null : !textAppearance7.equals(nativeTemplateAppearance.l)) {
                return false;
            }
            ImageAppearance imageAppearance = this.n;
            if (imageAppearance == null ? nativeTemplateAppearance.n != null : !imageAppearance.equals(nativeTemplateAppearance.n)) {
                return false;
            }
            ImageAppearance imageAppearance2 = this.m;
            if (imageAppearance2 == null ? nativeTemplateAppearance.m != null : !imageAppearance2.equals(nativeTemplateAppearance.m)) {
                return false;
            }
            ButtonAppearance buttonAppearance = this.o;
            if (buttonAppearance == null ? nativeTemplateAppearance.o != null : !buttonAppearance.equals(nativeTemplateAppearance.o)) {
                return false;
            }
            RatingAppearance ratingAppearance = this.p;
            if (ratingAppearance == null ? nativeTemplateAppearance.p == null : ratingAppearance.equals(nativeTemplateAppearance.p)) {
                return true;
            }
        }
        return false;
    }

    public final TextAppearance getAgeAppearance() {
        return this.f;
    }

    public final BannerAppearance getBannerAppearance() {
        return this.e;
    }

    public final TextAppearance getBodyAppearance() {
        return this.g;
    }

    public final ButtonAppearance getCallToActionAppearance() {
        return this.o;
    }

    public final TextAppearance getDomainAppearance() {
        return this.h;
    }

    public final ImageAppearance getFaviconAppearance() {
        return this.m;
    }

    public final ImageAppearance getImageAppearance() {
        return this.n;
    }

    public final RatingAppearance getRatingAppearance() {
        return this.p;
    }

    public final TextAppearance getReviewCountAppearance() {
        return this.i;
    }

    public final TextAppearance getSponsoredAppearance() {
        return this.j;
    }

    public final TextAppearance getTitleAppearance() {
        return this.k;
    }

    public final TextAppearance getWarningAppearance() {
        return this.l;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        BannerAppearance bannerAppearance = this.e;
        int i2 = 0;
        int hashCode = (bannerAppearance != null ? bannerAppearance.hashCode() : 0) * 31;
        TextAppearance textAppearance = this.f;
        int hashCode2 = (hashCode + (textAppearance != null ? textAppearance.hashCode() : 0)) * 31;
        TextAppearance textAppearance2 = this.g;
        int hashCode3 = (hashCode2 + (textAppearance2 != null ? textAppearance2.hashCode() : 0)) * 31;
        TextAppearance textAppearance3 = this.h;
        int hashCode4 = (hashCode3 + (textAppearance3 != null ? textAppearance3.hashCode() : 0)) * 31;
        TextAppearance textAppearance4 = this.i;
        int hashCode5 = (hashCode4 + (textAppearance4 != null ? textAppearance4.hashCode() : 0)) * 31;
        TextAppearance textAppearance5 = this.j;
        int hashCode6 = (hashCode5 + (textAppearance5 != null ? textAppearance5.hashCode() : 0)) * 31;
        TextAppearance textAppearance6 = this.k;
        int hashCode7 = (hashCode6 + (textAppearance6 != null ? textAppearance6.hashCode() : 0)) * 31;
        TextAppearance textAppearance7 = this.l;
        int hashCode8 = (hashCode7 + (textAppearance7 != null ? textAppearance7.hashCode() : 0)) * 31;
        ImageAppearance imageAppearance = this.n;
        int hashCode9 = (hashCode8 + (imageAppearance != null ? imageAppearance.hashCode() : 0)) * 31;
        ImageAppearance imageAppearance2 = this.m;
        int hashCode10 = (hashCode9 + (imageAppearance2 != null ? imageAppearance2.hashCode() : 0)) * 31;
        ButtonAppearance buttonAppearance = this.o;
        int hashCode11 = (hashCode10 + (buttonAppearance != null ? buttonAppearance.hashCode() : 0)) * 31;
        RatingAppearance ratingAppearance = this.p;
        if (ratingAppearance != null) {
            i2 = ratingAppearance.hashCode();
        }
        return hashCode11 + i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.e, i2);
        parcel.writeParcelable(this.f, i2);
        parcel.writeParcelable(this.g, i2);
        parcel.writeParcelable(this.h, i2);
        parcel.writeParcelable(this.i, i2);
        parcel.writeParcelable(this.j, i2);
        parcel.writeParcelable(this.k, i2);
        parcel.writeParcelable(this.l, i2);
        parcel.writeParcelable(this.m, i2);
        parcel.writeParcelable(this.n, i2);
        parcel.writeParcelable(this.o, i2);
        parcel.writeParcelable(this.p, i2);
    }

    private NativeTemplateAppearance(Builder builder) {
        this.e = builder.a;
        this.f = builder.b;
        this.g = builder.c;
        this.h = builder.d;
        this.i = builder.e;
        this.j = builder.f;
        this.k = builder.g;
        this.l = builder.h;
        this.n = builder.i;
        this.m = builder.j;
        this.o = builder.k;
        this.p = builder.l;
    }

    public NativeTemplateAppearance(Parcel parcel) {
        this.e = (BannerAppearance) parcel.readParcelable(BannerAppearance.class.getClassLoader());
        this.f = (TextAppearance) parcel.readParcelable(TextAppearance.class.getClassLoader());
        this.g = (TextAppearance) parcel.readParcelable(TextAppearance.class.getClassLoader());
        this.h = (TextAppearance) parcel.readParcelable(TextAppearance.class.getClassLoader());
        this.i = (TextAppearance) parcel.readParcelable(TextAppearance.class.getClassLoader());
        this.j = (TextAppearance) parcel.readParcelable(TextAppearance.class.getClassLoader());
        this.k = (TextAppearance) parcel.readParcelable(TextAppearance.class.getClassLoader());
        this.l = (TextAppearance) parcel.readParcelable(TextAppearance.class.getClassLoader());
        this.m = (ImageAppearance) parcel.readParcelable(ImageAppearance.class.getClassLoader());
        this.n = (ImageAppearance) parcel.readParcelable(ImageAppearance.class.getClassLoader());
        this.o = (ButtonAppearance) parcel.readParcelable(ButtonAppearance.class.getClassLoader());
        this.p = (RatingAppearance) parcel.readParcelable(RatingAppearance.class.getClassLoader());
    }
}
