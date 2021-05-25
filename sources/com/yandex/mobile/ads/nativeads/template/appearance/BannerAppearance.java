package com.yandex.mobile.ads.nativeads.template.appearance;

import android.os.Parcel;
import android.os.Parcelable;
import com.yandex.mobile.ads.nativeads.template.HorizontalOffset;
public final class BannerAppearance implements Parcelable {
    public static final Parcelable.Creator<BannerAppearance> CREATOR = new Parcelable.Creator<BannerAppearance>() { // from class: com.yandex.mobile.ads.nativeads.template.appearance.BannerAppearance.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BannerAppearance createFromParcel(Parcel parcel) {
            return new BannerAppearance(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BannerAppearance[] newArray(int i) {
            return new BannerAppearance[i];
        }
    };
    private final int a;
    private final int b;
    private final float c;
    private final HorizontalOffset d;
    private final HorizontalOffset e;

    public static final class Builder {
        private int a;
        private int b;
        private float c;
        private HorizontalOffset d;
        private HorizontalOffset e;

        public final BannerAppearance build() {
            return new BannerAppearance(this, (byte) 0);
        }

        public final Builder setBackgroundColor(int i) {
            this.a = i;
            return this;
        }

        public final Builder setBorderColor(int i) {
            this.b = i;
            return this;
        }

        public final Builder setBorderWidth(float f) {
            this.c = f;
            return this;
        }

        public final Builder setContentPadding(HorizontalOffset horizontalOffset) {
            this.d = horizontalOffset;
            return this;
        }

        public final Builder setImageMargins(HorizontalOffset horizontalOffset) {
            this.e = horizontalOffset;
            return this;
        }
    }

    public /* synthetic */ BannerAppearance(Builder builder, byte b2) {
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
        if (obj == null || BannerAppearance.class != obj.getClass()) {
            return false;
        }
        BannerAppearance bannerAppearance = (BannerAppearance) obj;
        if (this.a != bannerAppearance.a || this.b != bannerAppearance.b || Float.compare(bannerAppearance.c, this.c) != 0) {
            return false;
        }
        HorizontalOffset horizontalOffset = this.d;
        if (horizontalOffset == null ? bannerAppearance.d != null : !horizontalOffset.equals(bannerAppearance.d)) {
            return false;
        }
        HorizontalOffset horizontalOffset2 = this.e;
        HorizontalOffset horizontalOffset3 = bannerAppearance.e;
        return horizontalOffset2 == null ? horizontalOffset3 == null : horizontalOffset2.equals(horizontalOffset3);
    }

    public final int getBackgroundColor() {
        return this.a;
    }

    public final int getBorderColor() {
        return this.b;
    }

    public final float getBorderWidth() {
        return this.c;
    }

    public final HorizontalOffset getContentPadding() {
        return this.d;
    }

    public final HorizontalOffset getImageMargins() {
        return this.e;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int i = ((this.a * 31) + this.b) * 31;
        float f = this.c;
        int i2 = 0;
        int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        HorizontalOffset horizontalOffset = this.d;
        int hashCode = (floatToIntBits + (horizontalOffset != null ? horizontalOffset.hashCode() : 0)) * 31;
        HorizontalOffset horizontalOffset2 = this.e;
        if (horizontalOffset2 != null) {
            i2 = horizontalOffset2.hashCode();
        }
        return hashCode + i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeFloat(this.c);
        parcel.writeParcelable(this.d, 0);
        parcel.writeParcelable(this.e, 0);
    }

    private BannerAppearance(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    public BannerAppearance(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readFloat();
        this.d = (HorizontalOffset) parcel.readParcelable(HorizontalOffset.class.getClassLoader());
        this.e = (HorizontalOffset) parcel.readParcelable(HorizontalOffset.class.getClassLoader());
    }
}
