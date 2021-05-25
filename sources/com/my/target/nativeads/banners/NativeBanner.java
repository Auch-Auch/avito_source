package com.my.target.nativeads.banners;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.cg;
import com.my.target.common.models.ImageData;
public class NativeBanner {
    @NonNull
    public String a = "web";
    public float b;
    public int c;
    @Nullable
    public String d;
    @Nullable
    public String e;
    @Nullable
    public String f;
    @Nullable
    public String g;
    @Nullable
    public String h;
    @Nullable
    public String i;
    @Nullable
    public String j;
    @Nullable
    public ImageData k;

    public static final class Builder {
        @NonNull
        public final NativeBanner banner = new NativeBanner();

        @NonNull
        public static Builder createBuilder() {
            return new Builder();
        }

        public NativeBanner build() {
            return this.banner;
        }

        @NonNull
        public Builder setAdvertisingLabel(@Nullable String str) {
            this.banner.j = str;
            return this;
        }

        @NonNull
        public Builder setAgeRestrictions(@Nullable String str) {
            this.banner.h = str;
            return this;
        }

        @NonNull
        public Builder setCtaText(@Nullable String str) {
            this.banner.e = str;
            return this;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.banner.f = str;
            return this;
        }

        @NonNull
        public Builder setDisclaimer(@Nullable String str) {
            this.banner.g = str;
            return this;
        }

        @NonNull
        public Builder setDomain(@Nullable String str) {
            this.banner.i = str;
            return this;
        }

        @NonNull
        public Builder setIcon(@Nullable ImageData imageData) {
            this.banner.k = imageData;
            return this;
        }

        @NonNull
        public Builder setNavigationType(@NonNull String str) {
            if ("web".equals(str) || "store".equals(str)) {
                this.banner.a = str;
            }
            return this;
        }

        @NonNull
        public Builder setRating(float f) {
            this.banner.b = f;
            return this;
        }

        @NonNull
        public Builder setTitle(String str) {
            this.banner.d = str;
            return this;
        }

        @NonNull
        public Builder setVotes(int i) {
            this.banner.c = i;
            return this;
        }
    }

    public NativeBanner() {
    }

    public NativeBanner(@NonNull cg cgVar) {
        this.a = cgVar.getNavigationType();
        this.b = cgVar.getRating();
        this.c = cgVar.getVotes();
        String title = cgVar.getTitle();
        String str = null;
        this.d = TextUtils.isEmpty(title) ? null : title;
        String ctaText = cgVar.getCtaText();
        this.e = TextUtils.isEmpty(ctaText) ? null : ctaText;
        String description = cgVar.getDescription();
        this.f = TextUtils.isEmpty(description) ? null : description;
        String disclaimer = cgVar.getDisclaimer();
        this.g = TextUtils.isEmpty(disclaimer) ? null : disclaimer;
        String ageRestrictions = cgVar.getAgeRestrictions();
        this.h = TextUtils.isEmpty(ageRestrictions) ? null : ageRestrictions;
        String domain = cgVar.getDomain();
        this.i = TextUtils.isEmpty(domain) ? null : domain;
        String advertisingLabel = cgVar.getAdvertisingLabel();
        this.j = !TextUtils.isEmpty(advertisingLabel) ? advertisingLabel : str;
        this.k = cgVar.getIcon();
    }

    public NativeBanner(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable ImageData imageData, float f2, @Nullable String str6, @Nullable String str7, int i2, @NonNull String str8) {
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.i = str4;
        this.j = str5;
        this.k = imageData;
        this.b = f2;
        this.h = str6;
        this.g = str7;
        this.c = i2;
        this.a = str8;
    }

    @NonNull
    public static NativeBanner newBanner(@NonNull cg cgVar) {
        return new NativeBanner(cgVar);
    }

    @Nullable
    public String getAdvertisingLabel() {
        return this.j;
    }

    @Nullable
    public String getAgeRestrictions() {
        return this.h;
    }

    @Nullable
    public String getCtaText() {
        return this.e;
    }

    @Nullable
    public String getDescription() {
        return this.f;
    }

    @Nullable
    public String getDisclaimer() {
        return this.g;
    }

    @Nullable
    public String getDomain() {
        return this.i;
    }

    @Nullable
    public ImageData getIcon() {
        return this.k;
    }

    @NonNull
    public String getNavigationType() {
        return this.a;
    }

    public float getRating() {
        return this.b;
    }

    @Nullable
    public String getTitle() {
        return this.d;
    }

    public int getVotes() {
        return this.c;
    }
}
