package com.my.target.nativeads.banners;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.cg;
import com.my.target.ch;
import com.my.target.common.models.ImageData;
import java.util.ArrayList;
import java.util.List;
public class NativePromoBanner extends NativeBanner {
    public boolean l;
    @Nullable
    public String m;
    @Nullable
    public String n;
    @Nullable
    public ImageData o;
    @NonNull
    public ArrayList<NativePromoCard> p = new ArrayList<>();

    public static final class Builder {
        @NonNull
        public String a = "web";
        @Nullable
        public String b;
        @Nullable
        public String c;
        @Nullable
        public String d;
        @Nullable
        public String e;
        @Nullable
        public ImageData f;
        @Nullable
        public String g;
        @Nullable
        public String h;
        @Nullable
        public String i;
        @Nullable
        public ImageData j;
        public float k;
        public int l;
        public boolean m;

        @NonNull
        public static Builder createBuilder() {
            return new Builder();
        }

        @NonNull
        public NativePromoBanner build() {
            return new NativePromoBanner(this.b, this.c, this.d, this.e, this.f, this.k, this.g, this.h, this.l, this.a, this.m, this.i, this.j, null);
        }

        @NonNull
        public Builder setAdvertisingLabel(@Nullable String str) {
            this.e = str;
            return this;
        }

        @NonNull
        public Builder setAgeRestrictions(@Nullable String str) {
            this.g = str;
            return this;
        }

        @NonNull
        public Builder setCtaText(@Nullable String str) {
            this.c = str;
            return this;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.i = str;
            return this;
        }

        @NonNull
        public Builder setDisclaimer(@Nullable String str) {
            this.h = str;
            return this;
        }

        @NonNull
        public Builder setDomain(@Nullable String str) {
            this.d = str;
            return this;
        }

        @NonNull
        public Builder setHasVideo(boolean z) {
            this.m = z;
            return this;
        }

        @NonNull
        public Builder setIcon(@Nullable ImageData imageData) {
            this.f = imageData;
            return this;
        }

        @NonNull
        public Builder setImage(@Nullable ImageData imageData) {
            this.j = imageData;
            return this;
        }

        @NonNull
        public Builder setNavigationType(@NonNull String str) {
            if ("web".equals(str) || "store".equals(str)) {
                this.a = str;
            }
            return this;
        }

        @NonNull
        public Builder setRating(float f2) {
            this.k = f2;
            return this;
        }

        @NonNull
        public Builder setTitle(String str) {
            this.b = str;
            return this;
        }

        @NonNull
        public Builder setVotes(int i2) {
            this.l = i2;
            return this;
        }
    }

    public NativePromoBanner(@NonNull cg cgVar) {
        super(cgVar);
        this.l = cgVar.getVideoBanner() != null;
        String category = cgVar.getCategory();
        String str = null;
        this.m = TextUtils.isEmpty(category) ? null : category;
        String subCategory = cgVar.getSubCategory();
        this.n = !TextUtils.isEmpty(subCategory) ? subCategory : str;
        this.o = cgVar.getImage();
        if (!this.l) {
            List<ch> nativeAdCards = cgVar.getNativeAdCards();
            if (!nativeAdCards.isEmpty()) {
                for (ch chVar : nativeAdCards) {
                    this.p.add(new NativePromoCard(chVar));
                }
            }
        }
    }

    @NonNull
    public static NativePromoBanner newBanner(@NonNull cg cgVar) {
        return new NativePromoBanner(cgVar);
    }

    @NonNull
    public ArrayList<NativePromoCard> getCards() {
        return this.p;
    }

    @Nullable
    public String getCategory() {
        return this.m;
    }

    @Nullable
    public ImageData getImage() {
        return this.o;
    }

    @Nullable
    public String getSubCategory() {
        return this.n;
    }

    public boolean hasVideo() {
        return this.l;
    }

    public NativePromoBanner(String str, String str2, String str3, String str4, ImageData imageData, float f, String str5, String str6, int i, String str7, boolean z, String str8, ImageData imageData2, a aVar) {
        super(str, str2, str8, str3, str4, imageData, f, str5, str6, i, str7);
        this.l = z;
        this.o = imageData2;
    }
}
