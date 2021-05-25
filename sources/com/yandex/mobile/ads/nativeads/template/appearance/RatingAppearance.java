package com.yandex.mobile.ads.nativeads.template.appearance;

import android.os.Parcel;
import android.os.Parcelable;
public final class RatingAppearance implements Parcelable {
    public static final Parcelable.Creator<RatingAppearance> CREATOR = new Parcelable.Creator<RatingAppearance>() { // from class: com.yandex.mobile.ads.nativeads.template.appearance.RatingAppearance.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RatingAppearance createFromParcel(Parcel parcel) {
            return new RatingAppearance(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RatingAppearance[] newArray(int i) {
            return new RatingAppearance[i];
        }
    };
    private final int a;
    private final int b;

    public static final class Builder {
        private int a;
        private int b;

        public final RatingAppearance build() {
            return new RatingAppearance(this, (byte) 0);
        }

        public final Builder setBackgroundStarColor(int i) {
            this.a = i;
            return this;
        }

        public final Builder setProgressStarColor(int i) {
            this.b = i;
            return this;
        }
    }

    public /* synthetic */ RatingAppearance(Builder builder, byte b2) {
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
        if (obj != null && RatingAppearance.class == obj.getClass()) {
            RatingAppearance ratingAppearance = (RatingAppearance) obj;
            if (this.a == ratingAppearance.a && this.b == ratingAppearance.b) {
                return true;
            }
        }
        return false;
    }

    public final int getBackgroundStarColor() {
        return this.a;
    }

    public final int getProgressStarColor() {
        return this.b;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
    }

    private RatingAppearance(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
    }

    public RatingAppearance(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
    }
}
