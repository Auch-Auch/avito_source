package com.yandex.mobile.ads.nativeads.template.appearance;

import android.os.Parcel;
import android.os.Parcelable;
import com.yandex.mobile.ads.nativeads.template.SizeConstraint;
public final class ImageAppearance implements Parcelable {
    public static final Parcelable.Creator<ImageAppearance> CREATOR = new Parcelable.Creator<ImageAppearance>() { // from class: com.yandex.mobile.ads.nativeads.template.appearance.ImageAppearance.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ImageAppearance createFromParcel(Parcel parcel) {
            return new ImageAppearance(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ImageAppearance[] newArray(int i) {
            return new ImageAppearance[i];
        }
    };
    private final SizeConstraint a;

    public static final class Builder {
        private SizeConstraint a;

        public final ImageAppearance build() {
            return new ImageAppearance(this, (byte) 0);
        }

        public final Builder setWidthConstraint(SizeConstraint sizeConstraint) {
            this.a = sizeConstraint;
            return this;
        }
    }

    public /* synthetic */ ImageAppearance(Builder builder, byte b) {
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
        if (obj != null && ImageAppearance.class == obj.getClass()) {
            ImageAppearance imageAppearance = (ImageAppearance) obj;
            SizeConstraint sizeConstraint = this.a;
            if (sizeConstraint == null ? imageAppearance.a == null : sizeConstraint.equals(imageAppearance.a)) {
                return true;
            }
        }
        return false;
    }

    public final SizeConstraint getWidthConstraint() {
        return this.a;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        SizeConstraint sizeConstraint = this.a;
        if (sizeConstraint != null) {
            return sizeConstraint.hashCode();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
    }

    private ImageAppearance(Builder builder) {
        this.a = builder.a;
    }

    public ImageAppearance(Parcel parcel) {
        this.a = (SizeConstraint) parcel.readParcelable(SizeConstraint.class.getClassLoader());
    }
}
